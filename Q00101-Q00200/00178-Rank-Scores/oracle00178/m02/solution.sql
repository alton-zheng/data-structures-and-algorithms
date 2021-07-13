-- Runtime: 891 ms, faster than 5.75% of Oracle online submissions for Rank Scores.
-- Memory Usage: 0B, less than 100.00% of Oracle online submissions for Rank Scores.
select a.Score as Score,
       (select count(distinct b.Score) from Scores b where b.Score >= a.Score) as Rank
from Scores a
order by a.Score DESC;