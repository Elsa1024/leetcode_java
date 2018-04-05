class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        if (!((numerator > 0 && denominator > 0) || (numerator < 0 && denominator < 0))) {
            sb.append("-");
        }
        long numeratorL = Math.abs(Long.valueOf(numerator));
        long denominatorL = Math.abs(Long.valueOf(denominator));
        long quotient = numeratorL / denominatorL, remainder = numeratorL % denominatorL;

        sb.append(quotient);
        if (remainder > 0) {
            sb.append(".");
            long decDividend = remainder, decQuotient = 0;
            Map<Long, Integer> dividendToIndex = new HashMap();
            while (decDividend > 0) {
                dividendToIndex.put(decDividend, sb.length());
                decDividend *= 10;
                while (decDividend < denominatorL) {
                    dividendToIndex.put(decDividend, sb.length() + 1);
                    decDividend *= 10;
                    sb.append("0");
                }
                decQuotient = decDividend / denominatorL;
                sb.append(decQuotient);
                decDividend = decDividend % denominatorL;
                if (dividendToIndex.get(decDividend) != null) {
                    sb.insert(dividendToIndex.get(decDividend), "(");
                    sb.append(")");
                    break;
                }
            }
        }
        return sb.toString();
    }
}
