# Write your MySQL query statement below
-- Runtime: 522 ms, faster than 69.09% of MySQL online submissions for Department Highest Salary.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Department Highest Salary.
SELECT Department.name AS 'Department',
       Employee.name   AS 'Employee',
       Salary
FROM Employee
         JOIN Department ON Employee.DepartmentId = Department.Id
WHERE (Employee.DepartmentId, Salary) IN
      (SELECT DepartmentId,
              MAX(Salary)
       FROM Employee
       GROUP BY DepartmentId
      );