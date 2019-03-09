package cn.alycat.leetcode.MedianofTwoSortedArrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {2, 2,2};
        int[] nums2 = {2,2};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sum = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < sum.length) {
            if(i >= nums1.length){
                sum[k] = nums2[j];
                j++;
                k++;
                continue;
            }
            if(j >= nums2.length){
                sum[k] = nums1[i];
                i++;
                k++;
                continue;
            }
            if (nums1[i] > nums2[j]) {
                sum[k] = nums2[j];
                j++;

            } else {
                sum[k] = nums1[i];
                i++;
            }

            k++;
        }
        if (k % 2 == 0) {
            return (double) (sum[k / 2] + sum[(k / 2) - 1]) / 2;
        } else {
            return sum[k / 2];
        }
    }
}
