class LongestPalindromicSubString {
    public static void main(String[] args){
        System.out.println(longestPalindrome("caba"));
    }
    public static String longestPalindrome(String s) {
        int longestPalindromeLen = 0;
        String longestPalindrome = "";
        char[] charArray = s.toCharArray();
        for(double x=0;x<s.length();x+=.5){
            int currentLen = 0;
            if((x/.5) % 2 == 0){
                currentLen = 1;
                int leftPointer = (int)x;
                int rightPointer = (int)x;
                while(leftPointer -1 >= 0 && rightPointer + 1 < s.length() && charArray[leftPointer-1] == charArray[rightPointer+1]){
                    currentLen+=2;
                    leftPointer--;
                    rightPointer++;
                }
                if(currentLen > longestPalindromeLen){
                    longestPalindromeLen = currentLen;
                    if(rightPointer+1 >= s.length()){
                        return s.substring(leftPointer);
                    }
                    longestPalindrome = s.substring(leftPointer,rightPointer+1);
                }
            }else{
                int leftPointer = (int)Math.floor(x);
                int rightPointer = (int)Math.ceil(x);
                boolean keepLooping = true;
                while(leftPointer>=0 && rightPointer < charArray.length && keepLooping){
                    if(charArray[leftPointer] == charArray[rightPointer]){
                        currentLen = currentLen + 2;
                        leftPointer--;
                        rightPointer++;
                    }else{
                        keepLooping = false;
                    }
                }
                if(currentLen > longestPalindromeLen){
                    longestPalindromeLen = currentLen;
                    if(rightPointer >= s.length()){
                        return s.substring(leftPointer+1);
                    }
                    longestPalindrome = s.substring(leftPointer+1,rightPointer);
                }
            }
        }
        return longestPalindrome;
    }
}