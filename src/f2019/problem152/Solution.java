package f2019.problem152;

class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int min = nums[0];
        int max = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            min = Math.min(nums[i], min*nums[i]);
            max = Math.max(nums[i], max*nums[i]);
            res = Math.max(res, max);
        }

        return res;
    }
}