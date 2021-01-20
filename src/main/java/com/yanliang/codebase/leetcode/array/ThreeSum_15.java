package com.yanliang.codebase.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。

 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * @author yanliang
 * @date 11/19/2020 9:37 AM
 */
public class ThreeSum_15 {

	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		int[] nums1 = {0,0,0,0};

		List<List<Integer>> lists = threeSum(nums1);
		for (int i = 0; i < lists.size(); i++) {
			List<Integer> integers = lists.get(i);
			for (int j = 0; j < integers.size(); j++) {
				System.out.print(integers.get(j) + " ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums.length < 3) {
			return ans;
		}

		Arrays.sort(nums);

		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int left = i + 1;
			int right = len - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum == 0){
					ans.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
					while (left < right && nums[left] == nums[left + 1]) left ++;
					while (right > left && nums[right] == nums[right - 1]) right --;
					left ++;
					right --;
				} else if (sum > 0) {
					right --;
				} else {
					left ++;
				}
			}
		}
		return ans;
	}

}
