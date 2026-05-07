class Solution {
    /*public boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = cleaned.length() - 1;

        while (left < right) {
            // Compare characters (ignoring case)
            if (Character.toLowerCase(cleaned.charAt(left)) != Character.toLowerCase(cleaned.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }*/

    public boolean isPalindrome(String s) {
        StringBuilder cleaned = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        int left = 0, right = cleaned.length() - 1;

        while (left < right) {
            // Compare characters (ignoring case)
            if (Character.toLowerCase(cleaned.charAt(left)) != Character.toLowerCase(cleaned.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
