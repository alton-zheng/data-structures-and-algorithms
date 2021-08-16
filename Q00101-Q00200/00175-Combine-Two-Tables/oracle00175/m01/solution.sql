/* Write your PL/SQL query statement below */
-- Runtime: 575 ms, faster than 85.48% of Oracle online submissions for Combine Two Tables.
-- Memory Usage: 0B, less than 100.00% of Oracle online submissions for Combine Two Tables.
select a.FirstName, a.LastName, b.City, b.State
from Person a left join Address b
                        on a.PersonId = b.PersonId;