-- REPORT 1 : TOP 10 MOST BORROWED BOOKS --

SELECT 
    bh.Book_id,
    COUNT(bh.Book_id) AS borrow_count
FROM 
    Borrowing_History bh
WHERE 
    YEAR(bh.Borrow_date) = ? -- specified year
    AND MONTH(bh.Borrow_date) = ? -- specified month
GROUP BY 
    bh.Book_id
ORDER BY 
    borrow_count DESC
LIMIT 10;

-- REPORT 2 : NEWLY ACQUIRED BOOKS --

SELECT 
    ba.acquisition_id,
    bd.title,
    bd.author_last_name,
    bd.author_first_name,
    ba.acquisition_date
FROM 
    Book_Acquisitions ba
JOIN 
    Book_Details bd ON ba.isbn = bd.isbn
WHERE 
    ba.branch_delivered = ? -- specified branch_id
    AND (
        (YEAR(ba.acquisition_date) = ? AND MONTH(ba.acquisition_date) = ?) -- specified year and month
        OR
        (YEAR(ba.acquisition_date) = ? AND MONTH(ba.acquisition_date) = ?) -- specified year and month for the second year
    )
ORDER BY 
    ba.acquisition_date DESC;


-- REPORT 3 : PATRON ACTIVITY --
SELECT 
    p.patron_id, 
    p.first_name, 
    p.last_name, 
    p.status, 
    COUNT(DISTINCT bh.borrow_id) AS total_borrows, 
    COALESCE(SUM(bf.fine_amount), 0) AS total_fines, 
    SUM(CASE WHEN bh.date_due < bh.date_returned THEN 1 ELSE 0 END) AS books_overdue, 
    AVG(DATEDIFF(bh.date_returned, bh.date_due)) AS avg_days_to_return 
FROM 
    Patrons p 
LEFT JOIN 
    Borrowing_History bh ON p.patron_id = bh.patron_id 
LEFT JOIN 
    Borrowing_Fines bf ON bh.borrow_id = bf.borrow_id 
WHERE 
    (MONTH(bh.date_borrowed) = ? AND YEAR(bh.date_borrowed) = ?) 
    OR 
    (MONTH(bf.payment_date) = ? AND YEAR(bf.payment_date) = ?) 
GROUP BY 
    p.patron_id, 
    p.first_name, 
    p.last_name, 
    p.status 
ORDER BY 
    p.last_name, 
    p.first_name;

-- REPORT 4 : BOOK RATING --

SELECT 
    br.isbn, 
    bd.title, 
    CONCAT(bd.author_first_name, ' ', bd.author_last_name) AS author, 
    AVG(br.rating_score) AS avg_rating, 
    COUNT(br.rating_id) AS total_ratings 
FROM 
    Book_Rating br 
JOIN 
    Borrowing_History bh ON br.borrow_id = bh.borrow_id 
JOIN 
    Book_Details bd ON bh.book_id = bd.isbn 
WHERE 
    (YEAR(br.rating_date) = ? AND MONTH(br.rating_date) = ?) 
    OR 
    (YEAR(br.rating_date) = ? AND MONTH(br.rating_date) = ?) 
GROUP BY 
    br.isbn, 
    bd.title, 
    author 
ORDER BY 
    avg_rating DESC;