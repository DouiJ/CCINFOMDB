-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema library
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `library` ;

-- -----------------------------------------------------
-- Schema library
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `library` DEFAULT CHARACTER SET utf8 ;
USE `library` ;

-- -----------------------------------------------------
-- Table `library`.`Book_Details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Book_Details` ;

CREATE TABLE IF NOT EXISTS `library`.`Book_Details` (
  `isbn` VARCHAR(13) NOT NULL,
  `title` VARCHAR(50) NOT NULL,
  `price` DECIMAL(6,2) NOT NULL,
  `author_last_name` VARCHAR(45) NOT NULL,
  `author_first_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`isbn`),
  UNIQUE INDEX `isbn_UNIQUE` (`isbn` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Patrons`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Patrons` ;

CREATE TABLE IF NOT EXISTS `library`.`Patrons` (
  `patron_id` VARCHAR(6) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `age` TINYINT NOT NULL,
  `gender` ENUM("M", "F") NOT NULL,
  `phone_no` VARCHAR(13) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`patron_id`),
  UNIQUE INDEX `patron_id_UNIQUE` (`patron_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Branches`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Branches` ;

CREATE TABLE IF NOT EXISTS `library`.`Branches` (
  `branch_id` VARCHAR(6) NOT NULL,
  `full_address` VARCHAR(100) NOT NULL,
  `phone_no` VARCHAR(13) NOT NULL,
  PRIMARY KEY (`branch_id`, `full_address`),
  UNIQUE INDEX `branch_id_UNIQUE` (`branch_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Employees`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Employees` ;

CREATE TABLE IF NOT EXISTS `library`.`Employees` (
  `employee_id` VARCHAR(6) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `age` TINYINT NOT NULL,
  `phone_no` VARCHAR(13) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `job_title` ENUM("M", "A", "C") NOT NULL COMMENT 'M = manager\nA = archivist\nC = clerk',
  `hire_date` DATE NOT NULL,
  `full_address` VARCHAR(100) NOT NULL,
  `branch_id` VARCHAR(6) NOT NULL,
  PRIMARY KEY (`employee_id`, `job_title`, `full_address`),
  INDEX `fk_Employees_Branches_idx` (`branch_id` ASC) VISIBLE,
  UNIQUE INDEX `employee_no_UNIQUE` (`employee_id` ASC) VISIBLE,
  CONSTRAINT `fk_Employees_Branches`
    FOREIGN KEY (`branch_id`)
    REFERENCES `library`.`Branches` (`branch_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Book_Acquisitions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Book_Acquisitions` ;

CREATE TABLE IF NOT EXISTS `library`.`Book_Acquisitions` (
  `acquisition_id` VARCHAR(6) NOT NULL,
  `acquisition_date` DATE NOT NULL,
  `supplier_name` VARCHAR(50) NOT NULL,
  `acquisitions_price` DECIMAL(6,2) NOT NULL,
  `copies_acquired` INT NOT NULL,
  `archivist_id` VARCHAR(6) NOT NULL,
  `isbn` VARCHAR(13) NOT NULL,
  `branch_delivered` VARCHAR(10) NOT NULL,
  `status` ENUM('A', 'C') NOT NULL,
  PRIMARY KEY (`acquisition_id`, `isbn`, `branch_delivered`),
  INDEX `fk_Book Acquisitions_Employees1_idx` (`archivist_id` ASC) VISIBLE,
  INDEX `fk_Book Acquisitions_Book Details1_idx` (`isbn` ASC) VISIBLE,
  UNIQUE INDEX `acquisition_id_UNIQUE` (`acquisition_id` ASC) VISIBLE,
  CONSTRAINT `fk_Book_Acquisitions_Employees`
    FOREIGN KEY (`archivist_id`)
    REFERENCES `library`.`Employees` (`employee_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Book_Acquisitions_Book_Details`
    FOREIGN KEY (`isbn`)
    REFERENCES `library`.`Book_Details` (`isbn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Book_Acquisitions_Branch`
    FOREIGN KEY (`branch_delivered`)
    REFERENCES `library`.`Branches` (`branch_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Books_Inventory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Books_Inventory` ;

CREATE TABLE IF NOT EXISTS `library`.`Books_Inventory` (
  `inventory_id` VARCHAR(6) NOT NULL,
  `isbn` VARCHAR(13) NOT NULL,
  `branch_id` VARCHAR(45) NOT NULL,
  `acquisition_id` VARCHAR(6) NOT NULL,
  PRIMARY KEY (`inventory_id`, `branch_id`, `isbn`),
  INDEX `fk_Book Inventory_Branches1_idx` (`branch_id` ASC) VISIBLE,
  INDEX `fk_Book Inventory_Book Details1_idx` (`isbn` ASC) VISIBLE,
  UNIQUE INDEX `inventory_id_UNIQUE` (`inventory_id` ASC) VISIBLE,
  INDEX `fk_Book_Inventory_Acquisition_idx` (`acquisition_id` ASC) VISIBLE,
  CONSTRAINT `fk_Book_Inventory_Branches`
    FOREIGN KEY (`branch_id`)
    REFERENCES `library`.`Branches` (`branch_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Book_Inventory_Book Details`
    FOREIGN KEY (`isbn`)
    REFERENCES `library`.`Book_Details` (`isbn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Book_Inventory_Acquisition`
    FOREIGN KEY (`acquisition_id`)
    REFERENCES `library`.`Book_Acquisitions` (`acquisition_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Borrowing_History`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Borrowing_History` ;

CREATE TABLE IF NOT EXISTS `library`.`Borrowing_History` (
  `borrow_id` VARCHAR(6) NOT NULL,
  `date_borrowed` DATE NOT NULL,
  `date_due` DATE NOT NULL,
  `date_returned` DATE NULL,
  `borrow_status` ENUM("B", "O", "L", "R") NOT NULL COMMENT 'B = Borrowed\nO = Overdue\nL = Lost\nR = Returned',
  `book_id` VARCHAR(6) NOT NULL COMMENT '(Inventory_id)',
  `patron_id` VARCHAR(6) NOT NULL,
  `clerk_id` VARCHAR(6) NOT NULL,
  `status` ENUM('A', 'C') NOT NULL,
  PRIMARY KEY (`borrow_id`),
  INDEX `fk_Book Borrowing_Patrons1_idx` (`patron_id` ASC) VISIBLE,
  INDEX `fk_ Borrowing History_Employees1_idx` (`clerk_id` ASC) VISIBLE,
  UNIQUE INDEX `borrow_id_UNIQUE` (`borrow_id` ASC) VISIBLE,
  INDEX `fk_ Borrowing_History_Books_Inventory_idx` (`book_id` ASC) VISIBLE,
  CONSTRAINT `fk_Borrowing_History_Patrons`
    FOREIGN KEY (`patron_id`)
    REFERENCES `library`.`Patrons` (`patron_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ Borrowing_History_Employees`
    FOREIGN KEY (`clerk_id`)
    REFERENCES `library`.`Employees` (`employee_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ Borrowing_History_Books_Inventory`
    FOREIGN KEY (`book_id`)
    REFERENCES `library`.`Books_Inventory` (`inventory_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Book_Rating`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Book_Rating` ;

CREATE TABLE IF NOT EXISTS `library`.`Book_Rating` (
  `rating_id` VARCHAR(6) NOT NULL,
  `rating_date` DATE NOT NULL,
  `rating_score` DECIMAL(2,1) NOT NULL COMMENT 'Rating ranges from 1-5',
  `rating_comment` VARCHAR(200) NOT NULL,
  `borrow_id` VARCHAR(6) NOT NULL,
  `status` ENUM('A', 'C') NOT NULL,
  PRIMARY KEY (`rating_id`),
  UNIQUE INDEX `rating_id_UNIQUE` (`rating_id` ASC) VISIBLE,
  INDEX `fk_Book Rating_ Borrowing History1_idx` (`borrow_id` ASC) VISIBLE,
  CONSTRAINT `fk_Book Rating_ Borrowing History`
    FOREIGN KEY (`borrow_id`)
    REFERENCES `library`.`Borrowing_History` (`borrow_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library`.`Borrowing_Fines`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `library`.`Borrowing_Fines` ;

CREATE TABLE IF NOT EXISTS `library`.`Borrowing_Fines` (
  `fine_id` VARCHAR(6) NOT NULL,
  `fine_amount` DECIMAL(6,2) NOT NULL,
  `payment_date` DATE NULL,
  `borrow_id` VARCHAR(6) NOT NULL,
  `clerk_id` VARCHAR(6) NOT NULL,
  `status` ENUM('A', 'C') NOT NULL,
  PRIMARY KEY (`fine_id`),
  INDEX `fk_Overdue Fines_Employees1_idx` (`clerk_id` ASC) VISIBLE,
  UNIQUE INDEX `fine_id_UNIQUE` (`fine_id` ASC) VISIBLE,
  INDEX `fk_Overdue/Lost_Fines_borrow_no_idx` (`borrow_id` ASC) VISIBLE,
  CONSTRAINT `fk_Borrowing_Fines_Employees1`
    FOREIGN KEY (`clerk_id`)
    REFERENCES `library`.`Employees` (`employee_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Borrowing_Fines_Borrowing_History`
    FOREIGN KEY (`borrow_id`)
    REFERENCES `library`.`Borrowing_History` (`borrow_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

DELIMITER 

CREATE TRIGGER update_borrowing_status
BEFORE UPDATE ON Borrowing_History
FOR EACH ROW
BEGIN
    -- Check if the book is not already returned
    IF NEW.date_returned IS NULL THEN
        -- Check if past due date
        IF CURRENT_DATE > OLD.date_due THEN
            -- Set status to Overdue if within 30 days of due date
            IF DATEDIFF(CURRENT_DATE, OLD.date_due) <= 30 THEN
                SET NEW.borrow_status = 'O';
            -- Set status to Lost if more than 30 days past due date
            ELSE
                SET NEW.borrow_status = 'L';
            END IF;
        END IF;
    END IF;
END;

DELIMITER ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
