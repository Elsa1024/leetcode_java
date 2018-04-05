class Solution {
    private int maxPrimeFactor(int n) {
        int primeFactor = 0;
        int factor = 2;    

        while (factor <= Math.sqrt(n)) {
            if (n % factor == 0)
                primeFactor = Math.max(primeFactor, Math.max(factor, n / factor));
            
            factor++;
        }
        
        return primeFactor;
    }
    
    public int minSteps(int n) {
        int counter = 0;
        int maxPrimeFactor = maxPrimeFactor(n);
        while (maxPrimeFactor > 0) {
            counter += n / maxPrimeFactor;
            n = maxPrimeFactor;
            maxPrimeFactor = maxPrimeFactor(n);
        }
        counter += n > 1 ? n : 0;
        
        return counter;
    }
}
