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

