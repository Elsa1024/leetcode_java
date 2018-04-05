class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, lMax = height[0], rMax = height[height.length - 1];
        int maxArea = Math.min(lMax, rMax) * (height.length - 1);
        while (left < right) {
            if (lMax <= rMax) {
                left++;
                if (height[left] > lMax) {
                    lMax = height[left];
                    maxArea = Math.max(maxArea, Math.min(lMax, rMax) * (right - left));
                }
            } else {
                right--;
                if (height[right] > rMax) {
                    rMax = height[right];
                    maxArea = Math.max(maxArea, Math.min(lMax, rMax) * (right - left));
                }
            }
        }

        return maxArea;
    }
}
