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

