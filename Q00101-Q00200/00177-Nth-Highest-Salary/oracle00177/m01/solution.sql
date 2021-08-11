-- Runtime: 587 ms, faster than 86.09% of Oracle online submissions for Nth Highest Salary.
-- Memory Usage: 0B, less than 100.00% of Oracle online submissions for Nth Highest Salary.
create function getNthHighestSalary(N in number) return number is
result number;
begin
  select nvl(salary, null)
    into result
    from (
        select distinct salary, dense_rank() over (order by salary desc) rank
          from employee
    )
    where rank = N;
    return result;
end;