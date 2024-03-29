package com.yanliang.algo.sort;

import java.util.Random;
import java.util.Stack;

/**
 * 快速排序
 *
 * <p>给你一个整数数组 nums，请你将该数组升序排列。
 *
 * <p>示例 1：
 *
 * <p>输入：nums = [5,2,3,1] 输出：[1,2,3,5] 示例 2：
 *
 * <p>输入：nums = [5,1,1,2,0,0] 输出：[0,0,1,1,2,5]
 *
 * <p>提示：
 *
 * <p>1 <= nums.length <= 50000 -50000 <= nums[i] <= 50000
 *
 * @author yanliang
 */
public class QuickSort {

    private static Random random = new Random();

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        int[] nums1 = {5, 1, 1, 2, 0, 0};

        quickSort(nums, 0, 3);
        quickSort(nums1, 0, 5);

        print(nums);
        print(nums1);
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int index = partition(nums, l, r);
            if (l == index && r == index) return;
            quickSort(nums, l, index - 1);
            quickSort(nums, index + 1, r);
        }
    }

    public static int partition(int[] nums, int l, int r) {
        int index = random.nextInt(r - l) + l;
        swap(nums, index, r);

        int tmp = nums[r];
        int j = l - 1;
        for (int i = l; i < r; i++) {
            if (nums[i] <= tmp) {
                ++j;
                swap(nums, i, j);
            }
        }
        swap(nums, ++j, r);
        return j;
    }

    public static void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }


    // ---------------- 非递归实现
    public int[] sortArray(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        Stack<Integer> stack = new Stack<>();
        if(start <  end)
        {
            stack.push(end);
            stack.push(start);
            while(!stack.isEmpty())
            {
                int l = stack.pop();
                int r = stack.pop();
                int index = partition_(nums,l,r);
                if(l < index-1)
                {
                    stack.push(index-1);
                    stack.push(l);
                }
                if(r > index+1)
                {
                    stack.push(r);
                    stack.push(index+1);
                }
            }
        }
        return nums;
    }

    private int partition_(int[] a,int start,int end)
    {
        int point = a[start];
        while(start < end)
        {
            while(start < end && a[end] >= point)
                end--;
            a[start] = a[end];
            while(start < end && a[start] <= point)
                start++;
            a[end] = a[start];
        }
        a[start] = point;
        return start;
    }

}
