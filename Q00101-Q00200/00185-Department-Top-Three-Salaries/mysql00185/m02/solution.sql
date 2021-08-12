-- Runtime: 1225 ms, faster than 6.41% of MySQL online submissions for Department Top Three Salaries.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Department Top Three Salaries.

-- Write your MySQL query statement below
select de.name as department, e.name as employee, e.salary
from employee e join department de
                     on e.departmentId = de.id
where (
          select count(distinct t.salary)
          from employee t
          where t.salary > e.salary
            and e.departmentId = t.departmentId
      ) < 3;