<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [上升的温度](#%E4%B8%8A%E5%8D%87%E7%9A%84%E6%B8%A9%E5%BA%A6)
- [球队的得分](#%E7%90%83%E9%98%9F%E7%9A%84%E5%BE%97%E5%88%86)
- [查询所有门课程都不小于90分的学生](#%E6%9F%A5%E8%AF%A2%E6%89%80%E6%9C%89%E9%97%A8%E8%AF%BE%E7%A8%8B%E9%83%BD%E4%B8%8D%E5%B0%8F%E4%BA%8E90%E5%88%86%E7%9A%84%E5%AD%A6%E7%94%9F)
- [观看视频数量前三名](#%E8%A7%82%E7%9C%8B%E8%A7%86%E9%A2%91%E6%95%B0%E9%87%8F%E5%89%8D%E4%B8%89%E5%90%8D)
- [语文合格数学不合格](#%E8%AF%AD%E6%96%87%E5%90%88%E6%A0%BC%E6%95%B0%E5%AD%A6%E4%B8%8D%E5%90%88%E6%A0%BC)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## 上升的温度

找出所有当天温度比前一天高的日期的id。

DATEDIFF 返回两个日期的差值：

```sql
DATEDIFF('2007-12-31','2007-12-30');   # 1
DATEDIFF('2010-12-30','2010-12-31');   # -1
```

+---------+------------------+------------------+
| Id(INT) | RecordDate(DATE) | Temperature(INT) |
+---------+------------------+------------------+
|       1 |       2015-01-01 |               10 |
|       2 |       2015-01-02 |               25 |
|       3 |       2015-01-03 |               20 |
|       4 |       2015-01-04 |               30 |
+---------+------------------+------------------+

```sql
SELECT b.id
FROM Weather a, Weather b
WHERE a.Temperature < b.Temperature and DATEDIFF(a.RecordDate, b.RecordDate) = -1
```



## 球队的得分

```mysql
SELECT game.mdate,
  team1, SUM(CASE WHEN goal.teamid = team1 THEN 1 ELSE 0 END) score1,
  team2, SUM(CASE WHEN goal.teamid = team2 THEN 1 ELSE 0 END) score2
FROM game LEFT OUTER JOIN goal #LEFT OUTER JOIN 可能双方都没得分
ON game.id = goal.matchid
GROUP BY game.mdate, game.team1, game.team2
```



## 查询所有门课程都不小于90分的学生

最小分数大于90。

```mysql
select st.id
from student st
join score sc
on st.id = sc.sid
group by st.id
having min(sc.score) >= 90
```

先扫描表，查出有成绩小于80的人的姓名，然后再次扫描表，用not in 或not exists 方法。

```mysql
select id
from student
where id not in(
select id
from student st
join score sc
on st.id = sc.sid
where sc.score < 90)

select id
from student st
where not exists(
select 1
from score sc
where sc.sid = st.id
and sc.score < 90)
```



## 观看视频数量前三名

[牛客题目](https://www.nowcoder.com/discuss/459561)

一个video表，里面有三个字段user_id、video_id、start_time
表里面的一行记录表示的是某个user在在某个time看了某个video
要求：今天看不同视频数量超过100个的用户id的前三名

```mysql
select user_id, count(distinct(video_id)) as c
from video
where start_time = '2020-8-9'
group by user_id
having c > 100
order by c desc
limit 0, 3
```



## 语文合格数学不合格

`id`, `sno`, `subject`, `score`

1	1001	语文	60
2	1001	数学	40
3	1002	语文	90
4	1002	数学	80

```mysql
select s1.sno
from student s1, student s2
where s1.sno = s2.sno
and s1.subject = '语文'
and s1.score >= 60
and s2.subject = '数学'
and s2.score < 60
```

