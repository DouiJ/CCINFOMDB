use library;

INSERT INTO ref_address (address_id, address_line_1, address_line_2, city, province, region, zip_code)
VALUES
    ('A0001', 'Street 1', 'Building A', 'City1', 'Province1', 'Region1', '10001'),
    ('A0002', 'Street 2', 'Building B', 'City2', 'Province2', 'Region2', '10002'),
    ('A0003', 'Street 3', 'Building C', 'City3', 'Province3', 'Region3', '10003'),
    ('A0004', 'Street 4', 'Building D', 'City4', 'Province4', 'Region4', '10004'),
    ('A0005', 'Street 5', 'Building E', 'City5', 'Province5', 'Region5', '10005');

INSERT INTO branches (branch_id, address_id, phone_no)
VALUES
    ('L0001', 'A0001', '1234567890123'),
    ('L0002', 'A0002', '1234567890124'),
    ('L0003', 'A0003', '1234567890125'),
    ('L0004', 'A0004', '1234567890126'),
    ('L0005', 'A0005', '1234567890127');

INSERT INTO employees (employee_id, last_name, first_name, job_id, age, phone_no, email, hire_date, address_id, branch_id)
VALUES
    ('E0001', 'Smith', 'John',   'M', 45, '9876543210123', 'john.smith@example.com',    '2020-01-01', 'A0001', 'L0001'),
    ('E0002', 'Doe', 'Jane',     'A', 38, '9876543210124', 'jane.doe@example.com',      '2021-05-15', 'A0002', 'L0002'),
    ('E0003', 'Brown', 'Emily',  'C', 29, '9876543210125', 'emily.brown@example.com',   '2022-09-10', 'A0003', 'L0003'),
    ('E0004', 'Taylor', 'James', 'T', 33, '9876543210126', 'james.taylor@example.com',  '2023-03-20', 'A0004', 'L0004'),
    ('E0005', 'Lee', 'Anna',     'S', 40, '9876543210127', 'anna.lee@example.com',      '2019-11-30', 'A0005', 'L0005');

INSERT INTO patrons (patron_id, last_name, first_name, age, gender, phone_no, email, status)
VALUES
    ('P0001', 'Wilson', 'Chris', 30, 'M', '1234567890128', 'chris.wilson@example.com', 'A'),
    ('P0002', 'Clark', 'Lisa', 25, 'F', '1234567890129', 'lisa.clark@example.com', 'A'),
    ('P0003', 'Hall', 'Kevin', 34, 'M', '1234567890130', 'kevin.hall@example.com', 'A'),
    ('P0004', 'Adams', 'Laura', 28, 'F', '1234567890131', 'laura.adams@example.com', 'C'),
    ('P0005', 'Baker', 'Sophia', 40, 'F', '1234567890132', 'sophia.baker@example.com', 'A');

INSERT INTO book_details (isbn, title, price, author_last_name, author_first_name)
VALUES
    ('9781234567890', 'Book A', 10.99, 'Smith', 'John'),
    ('9782345678901', 'Book B', 12.50, 'Doe', 'Jane'),
    ('9783456789012', 'Book C', 15.75, 'Brown', 'Alice'),
    ('9784567890123', 'Book D', 9.99, 'Johnson', 'Mark'),
    ('9785678901234', 'Book E', 14.99, 'Lee', 'Emily');

INSERT INTO book_acquisitions (acquisition_id, acquisition_date, supplier_name, acquisitions_price, copies_acquired, archivist_id, isbn, branch_delivered)
VALUES
    ('Q0001', '2020-01-01', 'Supplier A', 500.00, 1, 'E0002', '9781234567890', 'L0001'),
    ('Q0002', '2020-05-05', 'Supplier B', 600.00, 1, 'E0002', '9782345678901', 'L0002'),
    ('Q0003', '2021-02-01', 'Supplier C', 450.00, 1, 'E0002', '9783456789012', 'L0003'),
    ('Q0004', '2021-02-10', 'Supplier D', 750.00, 1, 'E0002', '9784567890123', 'L0004'),
    ('Q0005', '2022-03-01', 'Supplier E', 520.00, 1, 'E0002', '9785678901234', 'L0005'),
    ('Q0006', '2022-03-10', 'Supplier F', 480.00, 1, 'E0002', '9781234567890', 'L0001'),
    ('Q0007', '2023-03-20', 'Supplier G', 820.00, 1, 'E0002', '9782345678901', 'L0002'),
    ('Q0008', '2023-04-01', 'Supplier H', 390.00, 1, 'E0002', '9783456789012', 'L0003'),
    ('Q0009', '2023-04-10', 'Supplier I', 610.00, 1, 'E0002', '9784567890123', 'L0004'),
    ('Q0010', '2024-04-20', 'Supplier J', 700.00, 1, 'E0002', '9785678901234', 'L0005');

INSERT INTO books_inventory (inventory_id, isbn, branch_id, acquisition_id)
VALUES
    ('I0001', '9781234567890', 'L0001', 'Q0001'),
    ('I0002', '9782345678901', 'L0002', 'Q0002'),
    ('I0003', '9783456789012', 'L0003', 'Q0003'),
    ('I0004', '9784567890123', 'L0004', 'Q0004'),
    ('I0005', '9785678901234', 'L0005', 'Q0005'),
    ('I0006', '9781234567890', 'L0001', 'Q0006'),
    ('I0007', '9782345678901', 'L0002', 'Q0007'),
    ('I0008', '9783456789012', 'L0003', 'Q0008'),
    ('I0009', '9784567890123', 'L0004', 'Q0009'),
    ('I0010', '9785678901234', 'L0005', 'Q0010');

INSERT INTO borrowing_history (borrow_id, date_borrowed, date_due, date_returned, borrow_status, book_id, patron_id, clerk_id, status)
VALUES
    ('B0001', '2020-05-05', '2020-05-15', '2020-05-22', 'R', 'I0005', 'P0005', 'E0003', 'A'),
    ('B0002', '2020-05-14', '2020-05-24', NULL,         'O', 'I0003', 'P0003', 'E0003', 'A'),
    ('B0003', '2021-05-01', '2021-05-10', '2021-05-15', 'R', 'I0001', 'P0001', 'E0003', 'A'),
    ('B0004', '2021-05-16', '2021-05-26', NULL,         'L', 'I0006', 'P0001', 'E0003', 'A'),
    ('B0005', '2022-05-10', '2022-05-20', '2022-05-28', 'R', 'I0010', 'P0005', 'E0003', 'A'),
    ('B0006', '2022-05-03', '2022-05-13', '2022-05-20', 'R', 'I0003', 'P0003', 'E0003', 'A'),
    ('B0007', '2023-05-15', '2023-05-25', NULL,         'L', 'I0004', 'P0004', 'E0003', 'A'),
    ('B0008', '2023-05-09', '2023-05-19', '2023-05-24', 'R', 'I0009', 'P0004', 'E0003', 'A'),
    ('B0009', '2023-05-12', '2023-05-22', NULL,         'L', 'I0005', 'P0005', 'E0003', 'A'),
    ('B0010', '2023-05-04', '2023-05-14', '2023-05-18', 'R', 'I0004', 'P0004', 'E0003', 'A'),
    ('B0011', '2023-05-18', '2023-05-28', NULL,         'O', 'I0006', 'P0001', 'E0003', 'A'),
    ('B0012', '2023-05-13', '2023-05-23', NULL,         'O', 'I0002', 'P0002', 'E0003', 'A'),
    ('B0013', '2023-05-07', '2023-05-17', '2023-05-30', 'R', 'I0007', 'P0002', 'E0003', 'A'),
    ('B0014', '2023-05-02', '2023-05-12', '2023-05-17', 'R', 'I0002', 'P0002', 'E0003', 'A'),
    ('B0015', '2023-05-11', '2023-05-21', NULL,         'L', 'I0010', 'P0005', 'E0003', 'A'),
    ('B0016', '2023-05-08', '2023-05-18', '2023-05-23', 'R', 'I0008', 'P0003', 'E0003', 'A'),
    ('B0017', '2023-05-11', '2023-05-21', '2023-05-25', 'R', 'I0005', 'P0005', 'E0003', 'A'),
    ('B0018', '2023-05-06', '2023-05-16', NULL,         'O', 'I0006', 'P0001', 'E0003', 'A'),
    ('B0019', '2023-05-19', '2023-05-29', NULL,         'O', 'I0007', 'P0002', 'E0003', 'A'),
    ('B0020', '2023-05-20', '2023-05-30', '2023-06-05', 'R', 'I0010', 'P0005', 'E0003', 'A');


INSERT INTO borrowing_fines (fine_id, borrow_id, clerk_id, fine_amount, payment_date, status)
VALUES
    ('F0001', 'B0002', 'E0003', 1500.00, '2020-06-10', 'A'), -- 30 days overdue, $1 per day * 50 PHP
    ('F0002', 'B0004', 'E0003', 1000.00, '2021-06-10', 'A'), -- 20 days overdue, $1 per day * 50 PHP
    ('F0003', 'B0007', 'E0003', 1000.00, '2023-06-10', 'A'), -- 20 days overdue, $1 per day * 50 PHP
    ('F0004', 'B0009', 'E0003', 1000.00, '2023-06-10', 'A'), -- 20 days overdue, $1 per day * 50 PHP
    ('F0005', 'B0005', 'E0003', 800.00,  '2022-05-28', 'A'), -- 16 days overdue, $1 per day * 50 PHP
    ('F0006', 'B0003', 'E0003', 500.00,  '2021-05-15', 'A'), -- 10 days overdue, $1 per day * 50 PHP
    ('F0007', 'B0008', 'E0003', 500.00,  '2023-05-24', 'A'), -- 10 days overdue, $1 per day * 50 PHP
    ('F0008', 'B0013', 'E0003', 1300.00, '2023-05-30', 'A'), -- 26 days overdue, $1 per day * 50 PHP
    ('F0009', 'B0014', 'E0003', 500.00,  '2023-05-17', 'A'), -- 10 days overdue, $1 per day * 50 PHP
    ('F0010', 'B0017', 'E0003', 400.00,  '2023-05-25', 'A'); -- 8 days overdue, $1 per day * 50 PHP

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

























