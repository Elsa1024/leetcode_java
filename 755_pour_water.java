class Solution {
    public int locateLeft(int[] heights, int K) {
        if (K == 0)
            return K;
        int left = K;
        while (left > 0 && heights[left] >= heights[left-1])
            left--;
        while (left < K && heights[left+1] == heights[left])
            left++;
        return left;
    }

    public int locateRight(int[] heights, int K) {
        if (K == heights.length - 1)
            return K;
        int right = K;
        while (right < heights.length - 1 && heights[right] >= heights[right+1])
            right++;
        while (right > K && heights[right] == heights[right-1])
            right--;
        return right;
    }

    public int[] pourWater(int[] heights, int V, int K) {
        int left = K, right = K, droplet = V;
        int counter = 0;

        left = locateLeft(heights, K);
        right = locateRight(heights, K);
        
        while (droplet > 0) {
            counter++;
            droplet--;
            if (left < K) {
                heights[left]++;
                left = locateLeft(heights, K); 
            } else if (right > K) {
                heights[right]++;
                right = locateRight(heights, K); 
            } else {
                heights[K]++;
            }

            left = locateLeft(heights, K); 
            right = locateRight(heights, K);
        }
        
        return heights;
    }
}
