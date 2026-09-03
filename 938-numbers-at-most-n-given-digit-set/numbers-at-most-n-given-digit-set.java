class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        int L = s.length();
        int K = digits.length;
        int count = 0;

        // 1. Count numbers with length strictly less than L
        for (int i = 1; i < L; i++) {
            count += Math.pow(K, i);
        }

        // 2. Count numbers with length equal to L
        for (int i = 0; i < L; i++) {
            char c = s.charAt(i);
            boolean sameDigitFound = false;

            for (String d : digits) {
                if (d.charAt(0) < c) {
                    count += Math.pow(K, L - 1 - i);
                } else if (d.charAt(0) == c) {
                    sameDigitFound = true;
                    break;
                } else {
                    // Since digits array is sorted, remaining digits will also be larger
                    break;
                }
            }

            // If current digit of 'n' is not in 'digits', we cannot continue forming same-length prefix
            if (!sameDigitFound) {
                return count;
            }
        }

        // 3. If we can form 'n' itself
        return count + 1;
    }
}