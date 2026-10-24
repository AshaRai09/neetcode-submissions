class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            freq[s.charAt(right) - 'A']++;

            maxFreq = Math.max(
                maxFreq,
                freq[s.charAt(right) - 'A']
            );

            int windowSize = right - left + 1;

            while (windowSize - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
                windowSize = right - left + 1;
            }

            maxLength = Math.max(maxLength, windowSize);
        }

        return maxLength;
    }
}
