// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We expand around every character to find the longest palindrome centered at each index.If the length of the
expanded palindrome is greater than the current max length, we update it and also the start,end points of
that substring.For even length of string, we check if consecutive characters are equal and then use the same
function to compute the max length.Finally, we return the substring using the start and end indices which
map to the largest length.
 */
class Solution {
    int n;
    int start, end;
    int max;
    public String longestPalindrome(String s) {
        this.n = s.length();
        this.start = 0;
        this.end = 0;
        this.max = Integer.MIN_VALUE;

        for(int i = 0 ; i < n ; i++) {
            findPalindromicSubstring(s, i, i);

            //even length
            if(i > 0 && s.charAt(i - 1) == s.charAt(i))
                findPalindromicSubstring(s, i - 1, i);
        }
        return s.substring(start, end + 1);
    }

    private void findPalindromicSubstring(String s, int left, int right) {
        while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        left++;
        right--;

        if(max < right - left + 1) {
            max = right -left + 1;
            start = left;
            end = right;
        }
    }
}