# Write your MySQL query statement below
-- Runtime: 522 ms, faster than 69.09% of MySQL online submissions for Department Highest Salary.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Department Highest Salary.
select c.name as Department,
       a.Name as Employee,
       a.Salary
  from Employee a join
      (select DepartmentId, max(Salary) as Salary from Employee group by DepartmentId) b
      join Department c
    on a.DepartmentId = b.DepartmentId
   and a.Salary = b.Salary
   and a.DepartmentId = c.Id;