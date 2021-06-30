-- 196. Delete Duplicate Emails #163
-- Write a SQL query to delete all duplicate email entries in a table named Person, keeping only unique emails based on its smallest Id.
--
-- +----+------------------+
-- | Id | Email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- | 3  | john@example.com |
-- +----+------------------+
-- Id is the primary key column for this table.
-- For example, after running your query, the above Person table should have the following rows:
--
-- +----+------------------+
-- | Id | Email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- +----+------------------+
-- Note:
--
-- Your output is the whole Person table after executing your sql. Use delete statement.

delete from Person
-- 排除最小 id
 where Id not in
 (select t.Id
    from (
    -- 此行 sql ， 找出最新id
    select Email, min(Id) as Id from Person group by Email
    ) t
);