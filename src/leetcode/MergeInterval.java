/**
 * Copyright (C), 2018-2018
 * FileName: MergeInterval
 * Author:   Tyson
 * Date:     2018/12/3/0003 20:36
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Tyson
 * @create 2018/12/3/0003 20:36
 * @since 1.0.0
 */
public class MergeInterval {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        for(int i = 0; i < intervals.size() - 1; i++) {
            for(int j = i + 1; j < intervals.size(); j++) {
                if(intervals.get(i).start == intervals.get(j).start ||
                        intervals.get(i).end >= intervals.get(j).start) {
                    mergeCore(intervals, i, j);
                    i = -1;
                    break;
                }
            }
        }

        return intervals;
    }

    public void mergeCore(List<Interval> intervals, int i, int j) {
        Interval i1 = intervals.get(i);
        Interval i2 = intervals.get(j);

        intervals.remove(i);

        i2.start = i1.start;

        if(i1.end > i2.end) {
            i2.end = i1.end;
        }
    }

    public static void main(String[] args) {
        MergeInterval mi = new MergeInterval();
        List<Interval> intervals = new ArrayList<>();

        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(0, 2));
        intervals.add(new Interval(3, 5));

        //intervals.add(new Interval(1, 3));
        //intervals.add(new Interval(2, 6));
        //intervals.add(new Interval(8, 10));
        //intervals.add(new Interval(15, 18));

        mi.merge(intervals);

        intervals.forEach(i -> System.out.println(i));
    }
}

class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval i1, Interval i2) {
        if(i1.start > i2.start) {
            return 1;
        } else if(i1.start < i2.start) {
            return -1;
        } else {
            if(i1.end > i2.end) {
                return 1;
            } else if(i1.end < i2.end) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

class Interval {
    int start;
    int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }

    @Override
    public String toString() {
        return "[ " + start + ", " + end + " ]";
    }
}