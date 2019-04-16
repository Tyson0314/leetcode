package leetcode;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid != 0 && nums[mid - 1] > nums[mid]) {
                right = mid - 1;
            } else if (mid != nums.length - 1 && nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}