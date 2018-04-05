class Solution {
    public long divideL(long dividend, long divisor) {
        // System.out.println("dividend: " + dividend + ", divisor: " + divisor);
        if (divisor > dividend)
            return 0;
        long quotientL = 1;
        long sum = divisor;
        while (sum + sum <= dividend) {
            quotientL *= 2;
            sum *= 2;
            // System.out.println("quotientL: " + quotientL + ", sum: " + sum);
        }
        return quotientL + divideL(dividend - sum, divisor);
    }  
    public int divide(int dividend, int divisor) {
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long dividendL = Math.abs(Long.valueOf(dividend));
        long divisorL = Math.abs(Long.valueOf(divisor));

        long quotientL = divideL(dividendL, divisorL);
        // System.out.println("outer quotientL: " + quotientL);

        if (sign*quotientL < Long.valueOf(Integer.MIN_VALUE) || sign*quotientL > Long.valueOf(Integer.MAX_VALUE))
            return Integer.MAX_VALUE;
        
        return Long.valueOf(sign*quotientL).intValue();
    }
}

// passed but a little slow
