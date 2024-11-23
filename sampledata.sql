use library;

INSERT INTO branches (branch_id, full_address, phone_no)
VALUES
    ('L0001', '123 Main St, City1, Province1, 10001', '1234567890123'),    -- Address 1
    ('L0002', '456 Elm St, City2, Province2, 10002', '1234567890124'),    -- Address 2
    ('L0003', '789 Oak St, City3, Province3, 10003', '1234567890125'),    -- Address 3
    ('L0004', '101 Pine St, City4, Province4, 10004', '1234567890126'),   -- Address 4
    ('L0005', '202 Maple St, City5, Province5, 10005', '1234567890127');  -- Address 5

INSERT INTO employees (employee_id, last_name, first_name, age, phone_no, email, job_title, hire_date, full_address, branch_id)
VALUES
    -- Branch L0001
    ('E0001', 'Smith', 'John',   45, '9876543210123', 'john.smith@example.com',    'A', '2020-01-01', '123 Main St, City1, Province1, 10001', 'L0001'),
    ('E0006', 'Davis', 'Alice',  30, '9876543210128', 'alice.davis@example.com',   'C', '2021-03-10', '111 Birch St, City1, Province1, 10001', 'L0001'),
    ('E0011', 'Wilson', 'George', 50, '9876543210133', 'george.wilson@example.com', 'M', '2018-07-15', '121 Birch St, City1, Province1, 10001', 'L0001'),

    -- Branch L0002
    ('E0002', 'Valdez', 'Pulvert',  38, '9876543210124', 'jane.doe@example.com',  'A', '2021-05-15', '456 Elm St, City2, Province2, 10002', 'L0002'),
    ('E0007', 'Harris', 'Tom',   27, '9876543210129', 'tom.harris@example.com',    'C', '2022-02-18', '222 Cedar St, City2, Province2, 10002', 'L0002'),
    ('E0012', 'King', 'Martha',  42, '9876543210134', 'martha.king@example.com',   'M', '2019-03-25', '221 Cedar St, City2, Province2, 10002', 'L0002'),

    -- Branch L0003
    ('E0003', 'Almin', 'Neo',  29, '9876543210125', 'emily.brown@example.com',   'A', '2022-09-10', '789 Oak St, City3, Province3, 10003', 'L0003'),
    ('E0008', 'Martin', 'Sophia',32, '9876543210130', 'sophia.martin@example.com', 'C', '2023-01-12', '333 Spruce St, City3, Province3, 10003', 'L0003'),
    ('E0013', 'Adams', 'Peter',  48, '9876543210135', 'peter.adams@example.com',   'M', '2017-10-05', '331 Spruce St, City3, Province3, 10003', 'L0003'),

    -- Branch L0004
    ('E0004', 'Cariaga', 'Josh', 33, '9876543210126', 'james.taylor@example.com',  'A', '2023-03-20', '101 Pine St, City4, Province4, 10004', 'L0004'),
    ('E0009', 'Clark', 'Olivia', 28, '9876543210131', 'olivia.clark@example.com',  'C', '2021-09-05', '444 Fir St, City4, Province4, 10004', 'L0004'),
    ('E0014', 'Carter', 'Nathan', 39, '9876543210136', 'nathan.carter@example.com', 'M', '2020-04-15', '441 Fir St, City4, Province4, 10004', 'L0004'),

    -- Branch L0005
    ('E0005', 'Borja', 'Stephen',     40, '9876543210127', 'anna.lee@example.com',      'A', '2019-11-30', '202 Maple St, City5, Province5, 10005', 'L0005'),
    ('E0010', 'White', 'Ethan',  35, '9876543210132', 'ethan.white@example.com',   'C', '2020-06-23', '555 Willow St, City5, Province5, 10005', 'L0005'),
    ('E0015', 'Evans', 'Laura',  43, '9876543210137', 'laura.evans@example.com',   'M', '2016-08-30', '552 Willow St, City5, Province5, 10005', 'L0005');

INSERT INTO patrons (patron_id, last_name, first_name, age, gender, phone_no, email)
VALUES
    ('P0001', 'Wilson', 'Chris', 30, 'M', '1234567890128', 'chris.wilson@example.com'),
    ('P0002', 'Clark', 'Lisa', 25, 'F', '1234567890129', 'lisa.clark@example.com'),
    ('P0003', 'Hall', 'Kevin', 34, 'M', '1234567890130', 'kevin.hall@example.com'),
    ('P0004', 'Adams', 'Laura', 28, 'F', '1234567890131', 'laura.adams@example.com'),
    ('P0005', 'Baker', 'Sophia', 40, 'F', '1234567890132', 'sophia.baker@example.com');
    
INSERT INTO book_details (isbn, title, price, author_last_name, author_first_name)
VALUES
    ('9781234567890', 'Book A', 10.99, 'Smith', 'John'),
    ('9782345678901', 'Book B', 12.50, 'Doe', 'Jane'),
    ('9783456789012', 'Book C', 15.75, 'Brown', 'Alice'),
    ('9784567890123', 'Book D', 9.99, 'Johnson', 'Mark'),
    ('9785678901234', 'Book E', 14.99, 'Lee', 'Emily');

INSERT INTO book_acquisitions (acquisition_id, acquisition_date, supplier_name, acquisitions_price, copies_acquired, archivist_id, isbn, branch_delivered, status)
VALUES
    ('Q0001', '2020-01-01', 'Supplier A', 500.00, 1, 'E0001', '9781234567890', 'L0001', 'A'),
    ('Q0002', '2020-05-05', 'Supplier B', 600.00, 1, 'E0001', '9782345678901', 'L0001', 'A'),
    ('Q0003', '2021-02-01', 'Supplier C', 450.00, 1, 'E0001', '9783456789012', 'L0001', 'A'),
    ('Q0004', '2021-02-10', 'Supplier D', 750.00, 1, 'E0001', '9784567890123', 'L0001', 'A'),
    ('Q0005', '2022-03-01', 'Supplier E', 520.00, 1, 'E0001', '9785678901234', 'L0001', 'A'),
    ('Q0006', '2022-03-10', 'Supplier F', 480.00, 1, 'E0001', '9781234567890', 'L0001', 'A'),
    ('Q0007', '2023-03-20', 'Supplier G', 820.00, 1, 'E0001', '9782345678901', 'L0001', 'A'),
    ('Q0008', '2023-04-01', 'Supplier H', 390.00, 1, 'E0001', '9783456789012', 'L0001', 'A'),
    ('Q0009', '2023-04-10', 'Supplier I', 610.00, 1, 'E0001', '9784567890123', 'L0001', 'A'),
    ('Q0010', '2024-04-20', 'Supplier J', 700.00, 1, 'E0001', '9785678901234', 'L0001', 'A');

INSERT INTO books_inventory (inventory_id, isbn, branch_id, acquisition_id)
VALUES
    ('I0001', '9781234567890', 'L0001', 'Q0001'),
    ('I0002', '9782345678901', 'L0001', 'Q0002'),
    ('I0003', '9783456789012', 'L0001', 'Q0003'),
    ('I0004', '9784567890123', 'L0001', 'Q0004'),
    ('I0005', '9785678901234', 'L0001', 'Q0005'),
    ('I0006', '9781234567890', 'L0001', 'Q0006'),
    ('I0007', '9782345678901', 'L0001', 'Q0007'),
    ('I0008', '9783456789012', 'L0001', 'Q0008'),
    ('I0009', '9784567890123', 'L0001', 'Q0009'),
    ('I0010', '9785678901234', 'L0001', 'Q0010');

INSERT INTO borrowing_history (borrow_id, date_borrowed, date_due, date_returned, borrow_status, book_id, patron_id, clerk_id, status)
VALUES
    ('B0001', '2020-05-05', '2020-05-29', '2020-05-22', 'R', 'I0005', 'P0005', 'E0006', 'A'),
    ('B0002', '2020-05-14', '2020-06-07', '2020-06-10', 'O', 'I0003', 'P0003', 'E0006', 'A'), 
    ('B0003', '2021-05-01', '2021-05-24', '2021-05-15', 'R', 'I0001', 'P0001', 'E0006', 'A'),
    ('B0004', '2021-05-16', '2021-06-09', NULL,         'L', 'I0006', 'P0001', 'E0006', 'C'),
    ('B0005', '2022-05-10', '2022-06-03', '2022-05-28', 'R', 'I0010', 'P0005', 'E0006', 'A'),
    ('B0006', '2022-05-03', '2022-05-27', '2022-05-20', 'R', 'I0003', 'P0003', 'E0006', 'A'),
    ('B0007', '2023-05-15', '2023-06-08', NULL,         'L', 'I0004', 'P0004', 'E0006', 'C'),
    ('B0008', '2023-05-09', '2023-05-31', '2023-05-24', 'R', 'I0009', 'P0004', 'E0006', 'A'),
    ('B0009', '2023-05-12', '2023-06-05', '2023-06-10', 'O', 'I0005', 'P0005', 'E0006', 'A'),
    ('B0010', '2023-05-07', '2023-05-31', '2023-05-30', 'R', 'I0007', 'P0002', 'E0006', 'A'),
    ('B0011', '2023-05-02', '2023-05-26', '2023-05-17', 'R', 'I0002', 'P0002', 'E0006', 'A'),
    ('B0012', '2023-05-08', '2023-05-22', '2023-05-23', 'R', 'I0008', 'P0003', 'E0006', 'A'),
    ('B0013', '2023-05-11', '2023-05-25', '2023-05-25', 'R', 'I0005', 'P0005', 'E0006', 'A'),
    ('B0014', '2023-05-06', '2023-05-20', '2023-05-20', 'O', 'I0006', 'P0001', 'E0006', 'A'),
    ('B0015', '2023-05-19', '2023-06-02', NULL,         'O', 'I0007', 'P0002', 'E0006', 'A'),
    ('B0016', '2023-05-20', '2023-06-03', '2023-06-05', 'R', 'I0010', 'P0005', 'E0006', 'A');

    
INSERT INTO borrowing_fines (fine_id, borrow_id, clerk_id, fine_amount, payment_date, status)
VALUES
    ('F0001', 'B0002', 'E0003', 1500.00, '2020-06-10', 'A'),
    ('F0002', 'B0004', 'E0003', 1510.99, '2021-06-10', 'A'),
    ('F0003', 'B0007', 'E0003', 1500.00, NULL, 'C'),
    ('F0004', 'B0009', 'E0003', 1000.00, '2023-06-10', 'A'),
    ('F0005', 'B0005', 'E0003', 800.00,  '2022-05-28', 'A'),
    ('F0006', 'B0003', 'E0003', 500.00,  '2021-05-15', 'A'),
    ('F0007', 'B0008', 'E0003', 500.00,  '2023-05-24', 'A'),
    ('F0008', 'B0013', 'E0003', 1300.00, '2023-05-30', 'A'),
    ('F0009', 'B0014', 'E0003', 500.00,  '2023-05-17', 'A'),
    ('F0010', 'B0016', 'E0003', 750.00,  '2023-06-05', 'A'); 

INSERT INTO book_rating (rating_id, rating_date, rating_score, rating_comment, borrow_id, status)
VALUES
    ('R0001', '2024-05-22', 4, 'Great book, very informative.',             'B0001', 'A'),
    ('R0002', '2024-05-20', 5, 'Loved it! Highly recommend it.',            'B0006', 'A'),
    ('R0003', '2024-05-15', 3, 'It was good, but could be better.',         'B0003', 'A'),
    ('R0004', '2024-05-17', 2, 'Not my type of book, disappointing.',       'B0004', 'A'),
    ('R0005', '2024-05-28', 5, 'Amazing read, captivating from start.',     'B0005', 'A'),
    ('R0006', '2024-05-20', 4, 'Enjoyed it, a solid story overall.',        'B0006', 'A'),
    ('R0007', '2024-05-26', 1, 'Did not like it, too slow and boring.',     'B0007', 'A'),
    ('R0008', '2024-05-24', 4, 'Great plot, characters could be better.',   'B0008', 'A'),
    ('R0009', '2024-05-18', 3, 'It was okay, but not very engaging.',       'B0010', 'A'),
    ('R0010', '2024-05-18', 2, 'Too predictable and not very exciting.',    'B0010', 'A');

























