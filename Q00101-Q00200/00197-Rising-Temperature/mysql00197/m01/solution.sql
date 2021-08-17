# Write your MySQL query statement below
select id
from weather t
where t.temperature > (select temperature from weather where DATEDIFF(t.recordDate, weather.recordDate) = 1);