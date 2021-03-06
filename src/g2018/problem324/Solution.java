package g2018.problem324;

import java.util.Random;

// Did not fully understand virtual index. Did not write on my own.
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length, m = (n + 1) >> 1;
        int median = kthSmallestNumber(nums, m);

        for (int i = 0, j = 0, k = n - 1; j <= k;) {
            if (nums[A(j, n)] > median) {
                swap(nums, A(i++, n), A(j++, n));
            } else if (nums[A(j, n)] < median) {
                swap(nums, A(j, n), A(k--, n));
            } else {
                j++;
            }
        }
    }

    private int kthSmallestNumber(int[] nums, int k) {
        Random random = new Random();

        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, i, random.nextInt(i + 1));
        }

        int l = 0, r = nums.length - 1;
        k--;

        while (l < r) {
            int m = getMiddle(nums, l, r);

            if (m < k) {
                l = m + 1;
            } else if (m > k) {
                r = m - 1;
            } else {
                break;
            }
        }

        return nums[k];
    }

    private int getMiddle(int[] nums, int l, int r) {
        int i = l;

        for (int j = l + 1; j <= r; j++) {
            if (nums[j] < nums[l]) swap(nums, ++i, j);
        }

        swap(nums, l, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private int A(int i, int n) {
        return (2 * i + 1) % (n | 1);
    }
}