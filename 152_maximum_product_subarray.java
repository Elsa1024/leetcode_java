class Solution {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return nums[0];
        int maxProduct = Integer.MIN_VALUE, product = 1;
        int[][] productMatrix = new int[length][length];
        for (int j = 0; j < length; j++) {
            product *= nums[j];
            productMatrix[0][j] = product;
            maxProduct = Math.max(product, maxProduct);
        }
        
        for (int i = 1; i < length; i++) {
            int num = productMatrix[i-1][i-1];
            if (num != 0) {
                for (int j = i; j < length; j++) {
                    product = productMatrix[i-1][j] / num;
                    productMatrix[i][j] = product;
                    maxProduct = Math.max(maxProduct, product);
                }
            } else {
                product = 1;
                for (int j = i; j < length; j++) {
                    product *= nums[j];
                    productMatrix[i][j] = product;
                    maxProduct = Math.max(maxProduct, product);
                }
            }
        }
        return maxProduct;
    }
}

// maximum
