package Exercise;

//输入一个字符串，请找出该字符串的包含的最长回文子字符串
//        比如，输入babcd，输出bab
//        输入abbc，输出bb

import java.util.Scanner;

public class 寻找字符串最长回文 {


    public static void main ( String[] args ) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(longestPalindrome2(str));


    }


    /**
     * 暴力求解，O3的复杂度
     * <p>
     * 1）从最长的子串开始，遍历所有该原字符串的子串；
     * <p>
     * 2）每找出一个字符串，就判断该字符串是否为回文；
     * <p>
     * 3）子串为回文时，则找到了最长的回文子串，因此结束；反之，则继续遍历
     *
     * @param s
     * @return
     */
    public static String longestPalindrome ( String s ) {
        if (s.length() <= 1)
            return s;
        for (int i = s.length(); i > 0; i--) {//子串长度
            for (int j = 0; j <= s.length() - i; j++) {
                String sub = s.substring(j, i + j);//子串位置，第一遍是最长子串
                int count = 0;//计数，用来判断是否对称
                for (int k = 0; k < sub.length() / 2; k++) {//左右对称判断
                    if (sub.charAt(k) == sub.charAt(sub.length() - k - 1))
                        count++;
                }
                if (count == sub.length() / 2)
                    return sub;
            }
        }
        return "";//表示字符串中无回文子串

    }


    /**
     * 1）将子串分为单核和双核的情况，单核即指子串长度为奇数，双核则为偶数；
     * <p>
     * 2）遍历每个除最后一个位置的字符index(字符位置)，单核：初始low = 初始high = index，low和high均不超过原字符串的下限和上限；判断low和high处的字符是否相等，相等则low++、high++（双核：初始high = 初始low+1 = index + 1）；
     * <p>
     * 3）每次low与high处的字符相等时，都将当前最长的回文子串长度与high-low+1比较。后者大时，将最长的回文子串改为low与high之间的；
     * <p>
     * 4）重复执行2）、3），直至high-low+1 等于原字符串长度或者遍历到最后一个字符，取当前截取到的回文子串，该子串即为最长的回文子串。
     */


    private static int maxLen = 0;

    private static String sub = "";


    public static String longestPalindrome2 ( String s ) {
        if (s.length() <= 1)
            return s;

        for (int i = 0; i < s.length() - 1; i++) {

            findLongestPalindrome(s, i, i);//单核回文

            findLongestPalindrome(s, i, i + 1);//双核回文
        }
        return sub;
    }

    public static void findLongestPalindrome ( String s, int low, int high ) {
        while (low >= 0 && high <= s.length() - 1) {
            if (s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > maxLen) {
                    maxLen = high - low + 1;
                    sub = s.substring(low, high + 1);
                }
                low--;//向两边扩散找当前字符为中心的最大回文子串
                high++;
            } else
                break;
        }

    }
}