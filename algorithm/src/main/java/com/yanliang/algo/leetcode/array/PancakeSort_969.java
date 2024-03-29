package com.yanliang.algo.leetcode.array;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 969. 煎饼排序 给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。
 *
 * <p>一次煎饼翻转的执行过程如下：
 *
 * <p>选择一个整数 k ，1 <= k <= arr.length 反转子数组 arr[0...k-1]（下标从 0 开始） 例如，arr = [3,2,1,4] ，选择 k = 3
 * 进行一次煎饼翻转，反转子数组 [3,2,1] ，得到 arr = [1,2,3,4] 。
 *
 * <p>以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * arr.length 范围内的有效答案都将被判断为正确。
 *
 * <p>示例 1：
 *
 * <p>输入：[3,2,4,1] 输出：[4,2,4,3] 解释： 我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。 初始状态 arr = [3, 2, 4, 1] 第一次翻转后（k
 * = 4）：arr = [1, 4, 2, 3] 第二次翻转后（k = 2）：arr = [4, 1, 2, 3] 第三次翻转后（k = 4）：arr = [3, 2, 1, 4]
 * 第四次翻转后（k = 3）：arr = [1, 2, 3, 4]，此时已完成排序。 示例 2：
 *
 * <p>输入：[1,2,3] 输出：[] 解释： 输入已经排序，因此不需要翻转任何内容。 请注意，其他可能的答案，如 [3，3] ，也将被判断为正确。
 *
 * <p>提示：
 *
 * <p>1 <= arr.length <= 100 1 <= arr[i] <= arr.length arr 中的所有整数互不相同（即，arr 是从 1 到 arr.length
 * 整数的一个排列）
 *
 * @author yanliang
 */
public class PancakeSort_969 {

    // 记录反转操作序列
    static LinkedList<Integer> res = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = 2;
        while (times-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(pancakeSort(nums).toString());
        }
    }

    public static List<Integer> pancakeSort(int[] arr) {
        sort(arr, arr.length);
        return res;
    }

    public static void sort(int[] arr, int n) {
        if (n == 1) return;

        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        // 1. 找到最大的饼
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        // 2. 将最大的饼翻到最上面
        res.add(maxIndex + 1);
        swap(arr, 0, maxIndex);

        // 3. 将最大的饼从，最上面翻到最下面
        res.add(n);
        swap(arr, 0, n - 1);

        sort(arr, n - 1);
    }

    public static void swap(int[] arr, int l, int r) {
        while (l < r) {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
    }

    //    static List<Integer> pancakeSort(int[] cakes) {
    //        sort(cakes, cakes.length);
    //        return res;
    //    }
    //
    //    static void sort(int[] cakes, int n) {
    //        // base case
    //        if (n == 1) return;
    //
    //        // 寻找最大饼的索引
    //        int maxCake = 0;
    //        int maxCakeIndex = 0;
    //        for (int i = 0; i < n; i++)
    //            if (cakes[i] > maxCake) {
    //                maxCakeIndex = i;
    //                maxCake = cakes[i];
    //            }
    //
    //        // 第一次翻转，将最大饼翻到最上面
    //        reverse(cakes, 0, maxCakeIndex);
    //        res.add(maxCakeIndex + 1);
    //        // 第二次翻转，将最大饼翻到最下面
    //        reverse(cakes, 0, n - 1);
    //        res.add(n);
    //
    //        // 递归调用
    //        sort(cakes, n - 1);
    //    }
    //
    //    static void  reverse(int[] arr, int i, int j) {
    //        while (i < j) {
    //            int temp = arr[i];
    //            arr[i] = arr[j];
    //            arr[j] = temp;
    //            i++; j--;
    //        }
    //    }

}
