--  Write your MySQL query statement below
-- Runtime: 727 ms, faster than 50.56% of MySQL online submissions for Department Top Three Salaries.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Department Top Three Salaries.
select b.name Department, a.name Employee, a.salary
from (select departmentId, name, salary, dense_rank() over (partition by DepartmentId order by salary desc) r
      from Employee) a,
     Department b
where a.departmentId = b.id
  and a.r < 4;

