## leetcode

| 题目                                                         | 题解                                                         |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [环形链表II](https://leetcode-cn.com/problems/linked-list-cycle-ii/) | [DetectCycle](https://github.com/Tyson0314/leetcode/blob/master/src/leetcode/DetectCycle.java) |
| [重排链表](https://leetcode-cn.com/problems/reorder-list/)   | [ReorderList](https://github.com/Tyson0314/leetcode/blob/master/src/leetcode/ReorderList.java) |
| [乘积最大子序列](https://leetcode-cn.com/problems/maximum-product-subarray/) | [MaxProduct](https://github.com/Tyson0314/leetcode/blob/master/src/leetcode/MaxProduct.java) |
| [版本比较](https://leetcode-cn.com/problems/compare-version-numbers/) | [CompareVersion](https://github.com/Tyson0314/leetcode/blob/master/src/leetcode/CompareVersion.java) |
| [最大数](https://leetcode-cn.com/problems/largest-number/)   | [LargestNumber](https://github.com/Tyson0314/leetcode/blob/master/src/leetcode/LargestNumber.java) |
| [最大正方形](https://leetcode-cn.com/problems/maximal-square/) | [MaximalSquare](https://github.com/Tyson0314/leetcode/blob/master/src/leetcode/MaximalSquare.java) |



## 整数反转

注意 int32 位溢出、正负号问题。

解法一：

```java
class Solution {
    public int reverse(int x) {
        long out = 0;

        while (x != 0) {
            out = out * 10 + x % 10;
            x /= 10;
            if (out > Integer.MAX_VALUE || out < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int)out;
    }
}
```

解法二：

```java
class Solution {
    public int reverse(int x) {
        int out = 0;

        while (x != 0) {
            int tmp = x % 10;
            //先判断再做运算，防止溢出；注意正负号
            if (out > Integer.MAX_VALUE / 10 || (out == Integer.MAX_VALUE / 10 &&  tmp > Integer.MAX_VALUE % 10)) {
                return 0;
            } else if (out < Integer.MIN_VALUE / 10 || (out == Integer.MIN_VALUE / 10 && tmp < Integer.MIN_VALUE % 10 )) {
                return 0;
            }
            out = out * 10 + tmp;
            x /= 10;
        }

        return out;
    }
}
```



## 字符串反转整数

注意边界，空格，int 32位最大值最小值。

```java
class Solution {
    public int myAtoi(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        str = str.trim();
        if (str.charAt(0) != '-' && str.charAt(0) != '+' &&
            !Character.isDigit(str.charAt(0))) {
                return 0;
        }
        boolean positive = str.charAt(0) == '-' ? false : true;
        int i = Character.isDigit(str.charAt(0)) ? 0 : 1;
        long out = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            out = out * 10 + (str.charAt(i++) - '0');
            if (positive && out > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (!positive && out > 1L + Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return positive ? (int)out : (int)(-1 * out);
    }
}
```



## 回文数

将数字后半段反转，跟数字前半段相比即可。

```java
class Solution {
    public boolean isPalindrome(int x) {
        //排除负数和整十的数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reverseNum = 0;
        //反转x的后半段数字，再做比较即可
        while(x > reverseNum) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }

        //x为奇数位时，转换后reverseNum会比x多一位
        //如x为1234321，转换后reverseNum为1234，x为123
        return x == reverseNum || x == reverseNum / 10;
    }
}
```



## 盛最多水的容器

![1586272990587](.\img\1586272990587.png)

左右指针，数字小的指针往数字大的指针移动，面积才有可能变大。注意左右指针数字相同的情况。

```java
class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        
        while(left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if(height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        
        return maxArea;
    }
}
```



## 三数之和

先排序，双指针。注意去除重复三元组。

![1586533893125](.\img\1586533893125.png)

![1586534003083](.\img\1586534003083.png)

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) { //去重复
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;//去重复
                    }
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;//去重复
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }
}
```



## 电话号码的组合

回溯是一种通过穷举所有可能情况来找到所有解的算法。如果一个候选解最后被发现并不是可行解，回溯算法会舍弃它，并在前面的一些步骤做出一些修改，并重新尝试找到可行解。

时间复杂度n3

```java
class Solution {
    private List<String> ans = new ArrayList<>();
    private String[] strs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        StringBuilder sb = new StringBuilder("");
        letterCombinationsHelper(sb, digits, 0);

        return ans;
    }

    private void letterCombinationsHelper(StringBuilder sb, String digits, int index) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        int num = digits.charAt(index) - '0' - 2;//数字2到9，对应strs下标0到7
        for (int i = 0; i < strs[num].length(); i++) {
            sb.append(strs[num].charAt(i));
            letterCombinationsHelper(sb, digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);//function forgot，剪枝
        } 
    }
}
```



## 四数之和

时间复杂度n3

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        int len = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // forgot, 去重复
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {//j大于i+1才去重复
                    continue;
                }
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;//去重复
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;//去重复
                        }
                        left++;//forgot
                        right--;//forgot
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return ans;
    }
}
```



## 删除链表倒数第n个节点

使用快慢指针，快指针先走n步。

```java
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp = new ListNode(0); //技巧
        tmp.next = head;

        ListNode fast = tmp;
        ListNode slow = tmp;

        while (n-- > 0) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return tmp.next;
    }
}
```



## 有效的括号

使用栈实现。

```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push(')');//存进相反符号
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty() || s.charAt(i) != stack.pop()) {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}
```



## 括号生成

使用深度优先算法。

```java
class Solution {
    private List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return ans;
        }
        dfs("", n, n);

        return ans;
    }

    //left左括号剩下可用数目，right右括号剩下可用数目
    private void dfs(String s, int left, int right) {
        if (left > right || left < 0 || right < 0) {//右括号剩下的少，说明组合无效
            return;
        }

        if (left == 0 && right == 0) {
            ans.add(s);
        }

        dfs(s + "(", left - 1, right);
        dfs(s + ")", left, right - 1);
    }
}
```



## 两两交换链表中的节点

使用递归实现。

```java
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;

        if (right == null) {
            right = left;
        } else {
            left.next = swapPairs(right.next);
            right.next = left;
        }

        return right;
    }
}
```



## 合并两个有序列表

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode tmp = ans;

        while (l1 != null && l2!= null) {
            if (l1.val > l2.val) {
                tmp.next = l2; //tmp.next = new ListNode(l2.val); 没必要这么做
                l2 = l2.next;
            } else {
                tmp.next = l1;
                l1 = l1.next;
            }
            tmp = tmp.next;
        }

        tmp.next = l1 == null ? l2 : l1;

        return ans.next;
    }
}
```



## 删除排序数组的重复项

使用快慢指针。

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }
}
```



## 两数相除

Integer.MIN_VALUE 转为正数会溢出，故将 dividend 和 divisor 都转化为负数。**两个负数相加溢出会大于0。**

```java
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) { //不加上会超时
            return dividend;
        }
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;
        if (a > b) {
            return 0;
        }
        int ans = divideHelper(a, b);

        return sign > 0 ? ans : -ans;
    }

    private int divideHelper(int a, int b) {
        if (a > b) {
            return 0;
        }

        int count = 1;
        int tmp = b;
        while (tmp + tmp >= a && tmp + tmp < 0) { //两个负数相加溢出会大于0
            tmp += tmp;
            count += count;
        }

        return count + divideHelper(a - tmp, b);
    }
}
```



## 下一个排列

1、找到a[i-1] < a[i]；

2、找到a[j] > a[i - 1]> a[j - 1];

3、调换a[i - 1] 和 a[j] 位置；

4、翻转a[i]以后的数组；

特殊情况：数组降序排列，返回升序的数组。

![1586876929532](.\img\nextPermutation.png)

```java
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {//注意等号
            i--;
        }
        if (i == 0) {
            reverse(nums, 0);
            return;
        }
        int j = i;
        for (; j < nums.length; j++) {
            if (nums[i - 1] >= nums[j]) {//注意等号
                break;
            }
        }
        j--;//取前一个元素
        swap(nums, i - 1, j);
        reverse(nums, i);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
```



## 在排序数组查找第一个和最后一个位置

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = searchRangeHelper(nums, target);
        int right = searchRangeHelper(nums, target + 1);//复用代码
        
        if (left == nums.length || nums[left] != target) {//left==nums.length数组元素比target小
            return new int[]{-1, -1};
        }
        return new int[]{left, right - 1};
    }

    private int searchRangeHelper(int[] nums, int target) {
        int left = 0;
        int right = nums.length;//特殊情况[1] 1
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
```



## 组合总和

数组元素可能重复。使用回溯算法。

剪枝：

![1587051935261](.\img\1587051935261.png)

去重复组合：

![1587050948930](.\img\1587050948930.png)

```java
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);//排序方便回溯剪枝
        Deque<Integer> path = new ArrayDeque<>();//作为栈来使用，效率高于Stack；也可以作为队列来使用，效率高于LinkedList；线程不安全
        combinationSum2Helper(candidates, target, 0, path);
        return ans;
    }

    public void combinationSum2Helper(int[] arr, int target, int start, Deque<Integer> path) {
        if (target == 0) {
            ans.add(new ArrayList(path));
        }

        for (int i = start; i < arr.length; i++) {
            if (target < arr[i]) {//剪枝
                return;
            }
            if (i > start && arr[i] == arr[i - 1]) {//在一个层级，会产生重复
                continue;
            }
            path.addLast(arr[i]);
            combinationSum2Helper(arr, target - arr[i], i + 1, path);
            path.removeLast();
        }
    }
}
```



## 移除元素

前后双指针。

```java
class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] == val) {
                nums[start] = nums[end];
                end--;
            } else {
                start++;
            }
        }
        return nums[start] == val ? start : start + 1;//需判断start处元素
    }
}
```



## 字符串相乘

参考自：https://leetcode-cn.com/problems/multiply-strings/solution/you-hua-ban-shu-shi-da-bai-994-by-breezean/

![1587226241610](.\img\1587226241610.png)

```java
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) { //乘0
            return "0";
        }
        int[] arr = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int m = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n = num2.charAt(j) - '0';
                int sum = arr[i + j + 1] + m * n;
                arr[i + j + 1] = sum % 10;
                arr[i + j] += sum / 10; //+=，不能忘了原先的数
            }
        }

        StringBuilder ans = new StringBuilder("");
        if (arr[0] != 0) {
            ans.append(arr[0]);
        }
        for (int i = 1; i < arr.length; i++) {
            ans.append(arr[i]);
        }
        
        return ans.toString();
    }
}
```



## 有效的数独

关键在于找到子数独的规律：`box_index = (row / 3) * 3 + columns / 3`

![1587260486363](.\img\1587260486363.png)

```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9]; //二维数组初始化
        int[][] column = new int[9][9];
        int[][] box = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '1';//数字1-9对应下标0-8
                int boxIndex = (i/3)*3 + j/3;

                if (row[i][num] > 0 || column[j][num] > 0 || box[boxIndex][num] > 0) {
                    return false;
                }

                row[i][num] = 1;
                column[j][num] = 1;
                box[boxIndex][num] = 1;

            }
        }

        return true;
    }
}
```



## 全排列

回溯。注意与组合总和的区别（数字有无顺序）。

```java
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        ArrayDeque<Integer> path = new ArrayDeque<>();
        permuteHelper(nums, flag, path);

        return ans;
    }

    private void permuteHelper(int[] nums, boolean[] flag, ArrayDeque<Integer> path) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i]) {
                continue;//继续循环
            }
            path.addLast(nums[i]);
            flag[i] = true;
            permuteHelper(nums, flag, path);
            path.removeLast();
            flag[i] = false;
        }
    }
}
```



## 全排列II

给定一个可包含重复数字的序列，返回所有不重复的全排列。注意与组合总和的区别。

1、排序；2、同一层级相同元素剪枝。参考自：https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/

![1587518213329](C:\Users\Tyson\AppData\Roaming\Typora\typora-user-images\1587518213329.png)

```java
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ans;
        }
        ArrayDeque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);//切记
        dps(nums, used, path);

        return ans;
    }

    private void dps(int[] nums, boolean[] used, ArrayDeque<Integer> path) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if ((i > 0 && nums[i] == nums[i - 1]) && !used[i - 1]) {//同一层相同的元素，剪枝
                continue;//继续循环，不是return退出循环
            }
            path.addLast(nums[i]);
            used[i] = true;
            dps(nums, used, path);
            path.removeLast();
            used[i] = false;
        }
    }
}
```



## 实现 strStr()

kmp算法，参考自：https://leetcode-cn.com/problems/implement-strstr/solution/kmp-suan-fa-xiang-jie-by-labuladong/

```java
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int len = needle.length();
        int[][] next = new int[len][256];
        next[0][needle.charAt(0)] = 1;
        int X = 0;
        //构建状态转移图
        for (int i = 1; i < len; i++) {
            for (int c = 0; c < 256; c++) {
                if (needle.charAt(i) == c) {
                    next[i][c] = i + 1;//推进状态
                } else {
                    next[i][c] = next[X][c];
                }
            }
            X = next[X][needle.charAt(i)];//更新影子状态
        }

        int m = 0;//needle初始态
        for (int i = 0; i < haystack.length(); i++) {
            m = next[m][haystack.charAt(i)];//计算needle下一状态
            //到达终止态
            if (m == len) {
                return i - len + 1;
            }
        }

        return -1;
    }
}
```



