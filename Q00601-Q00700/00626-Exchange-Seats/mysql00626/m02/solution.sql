-- Runtime: 279 ms, faster than 35.81% of MySQL online submissions for Exchange Seats.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Exchange Seats.
SELECT a.id, ifnull(b.student, a.student) AS student
FROM seat a
	LEFT JOIN seat b ON a.id = (b.id + 1) ^ 1 - 1
ORDER BY id;