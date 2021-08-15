626. Exchange Seats
Medium
Share
SQL Schema
Mary is a teacher in a middle school and she has a table seat storing students' names and their corresponding seat ids.

The column id is continuous increment.

Mary wants to change seats for the adjacent students.

Can you write a SQL query to output the result for Mary?



+---------+---------+
|    id   | student |
+---------+---------+
|    1    | Abbot   |
|    2    | Doris   |
|    3    | Emerson |
|    4    | Green   |
|    5    | Jeames  |
+---------+---------+
For the sample input, the output is:

+---------+---------+
|    id   | student |
+---------+---------+
|    1    | Doris   |
|    2    | Abbot   |
|    3    | Green   |
|    4    | Emerson |
|    5    | Jeames  |
+---------+---------+
Note:

If the number of students is odd, there is no need to change the last one's seat.
-- Runtime: 238 ms, faster than 70.74% of MySQL online submissions for Exchange Seats.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Exchange Seats.
SELECT CASE
		WHEN mod(a.id, 2) = 1
		AND a.id != (
			SELECT COUNT(1) AS cnt
			FROM seat
		) THEN a.id + 1
		WHEN mod(a.id, 2) = 1
		AND a.id = (
			SELECT COUNT(1) AS cnt
			FROM seat
		) THEN a.id
		ELSE id - 1
	END AS id, a.student
FROM seat a
ORDER BY id;
