package com.gowtham;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSums {

	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {

			if (i > 0 && nums[i] == nums[i - 1]) {

				continue;

			}

			int j = i + 1;
			int k = nums.length - 1;
			int target = -nums[i];

			while (j < k) {

				if (nums[j] + nums[k] == target) {

					ArrayList<Integer> temp = new ArrayList<Integer>();

					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(nums[k]);

					result.add(temp);

					j++;
					k--;

					while (j < k && nums[j] == nums[j - 1])
						j++;
					while (j < k && nums[k] == nums[k + 1])
						k--;

				}

				else if (nums[j] + nums[k] > target) {

					k--;

				}

				else {

					j++;

				}

			}

		}

		return result;

	}

}
