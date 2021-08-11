-- Runtime: 302 ms, faster than 56.90% of MySQL online submissions for Nth Highest Salary.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Nth Highest Salary.
create function getNthHighestSalary(N int) returns int
begin
set N = N - 1;
 return (
     -- write your mysql query statement below
   select distinct salary
     from employee
     order by salary desc
     limit N,1
 );
 end;