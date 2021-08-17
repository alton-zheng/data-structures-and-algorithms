# Write your MySQL query statement below
-- Runtime: 406 ms, faster than 66.67% of MySQL online submissions for Rising Temperature.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Rising Temperature.
select a.id
from weather a
         inner join weather b
                    on datediff(a.recordDate, b.recorddate) = 1
where a.temperature > b.temperature;