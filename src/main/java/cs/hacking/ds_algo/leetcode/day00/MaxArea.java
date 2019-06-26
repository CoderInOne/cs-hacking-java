package cs.hacking.ds_algo.leetcode.day00;

/**
 * Container with most water
 */
public class MaxArea {
	// brutal
	public int maxArea(int height[]) {
		int max = 0;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i; j < height.length; j++) {
				int area = height[i] < height[j] ?
						height[i] * (j - i) :
						height[j] * (j - i);
				if (area > max) {
					max = area;
				}
			}
		}
		return max;
	}

	public int maxArea1(int height[]) {
		int max = 0;
		int low = 0;
		int high = height.length - 1;
		while (low < high) {
			max = Math.max(max, Math.min(height[low], height[high]) * (high - low));
			if (height[low] < height[high]) {
				low++;
			}
			else {
				high--;
			}
		}
		return max;
	}
}
