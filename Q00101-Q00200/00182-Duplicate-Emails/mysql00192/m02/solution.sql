# Write your MySQL query statement below

-- Create table If Not Exists Person (Id int, Email varchar(255))
-- Truncate table Person
-- insert into Person (Id, Email) values ('1', 'a@b.com')
-- insert into Person (Id, Email) values ('2', 'c@d.com')
-- insert into Person (Id, Email) values ('3', 'a@b.com')


-- Write a SQL query to find all duplicate emails in a table named Person.

-- +----+---------+
-- | Id | Email   |
-- +----+---------+
-- | 1  | a@b.com |
-- | 2  | c@d.com |
-- | 3  | a@b.com |
-- +----+---------+
-- For example, your query should return the following for the above table:
--
-- +---------+
-- | Email   |
-- +---------+
-- | a@b.com |
-- +---------+
-- Note: All emails are in lowercase.
-- Runtime: 259 ms, faster than 98.07% of MySQL online submissions for Duplicate Emails.
-- Memory Usage: 0B, less than 100.00% of MySQL online submissions for Duplicate Emails.
select distinct a.Email from Person a, Person b where a.Id != b.Id and a.Email = b.Email;