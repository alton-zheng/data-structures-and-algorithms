176. Second Highest Salary
Easy

SQL Schema
Write a SQL query to get the second highest salary from the Employee table.

    +----+--------+
    | Id | Salary |
    +----+--------+
    | 1  | 100    |
    | 2  | 200    |
    | 3  | 300    |
    +----+--------+
    For example, given the above Employee table, the query should return 200 as the second highest salary. If there is no second highest salary, then the query should return null.

    +---------------------+
    | SecondHighestSalary |
    +---------------------+
    | 200                 |
    +---------------------+

-- Runtime: 170 ms, faster than 82.08% of MySQL online submissions for Second Highest Salary.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Second Highest Salary.
# Write your MySQL query statement below
SELECT
    ifnull(
            (select distinct Salary
             from Employee
             order by Salary desc
             limit 1 offset 1),
            null) AS SecondHighestSalary;