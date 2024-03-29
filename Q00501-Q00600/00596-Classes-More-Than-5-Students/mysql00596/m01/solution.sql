/*
596. Classes More Than 5 Students

SQL Schema
There is a table courses with columns: student and class

Please list out all classes which have more than or equal to 5 students.

For example, the table:

+---------+------------+
| student | class      |
+---------+------------+
| A       | Math       |
| B       | English    |
| C       | Math       |
| D       | Biology    |
| E       | Math       |
| F       | Computer   |
| G       | Math       |
| H       | Math       |
| I       | Math       |
+---------+------------+
Should output:

+---------+
| class   |
+---------+
| Math    |
+---------+


Note:
The students should not be counted duplicate in each course.
*/
# Write your MySQL query statement below
select t.class
from (select class, count(distinct student) cnt from courses group by class) t
where t.cnt >= 5;