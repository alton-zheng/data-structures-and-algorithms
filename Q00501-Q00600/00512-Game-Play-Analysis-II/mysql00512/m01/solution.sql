# Write your MySQL query statement below
select a.player_id, a.device_id
from activity a
         join (select t.player_id, min(t.event_date) as event_date from activity t group by t.player_id) b
              on a.player_id = b.player_id
             and a.event_date = b.event_date;