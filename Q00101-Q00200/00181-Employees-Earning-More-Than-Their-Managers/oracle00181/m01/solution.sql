-- Runtime: 647 ms, faster than 47.29% of Oracle online submissions for Employees Earning More Than Their Managers.
-- Memory Usage: 0B, less than 100.00% of Oracle online submissions for Employees Earning More Than Their Managers.

/* Write your PL/SQL query statement below */
select a.name as "Employee"
from Employee a, Employee b
where a.ManagerId = b.id
  and a.Salary > b.Salary;