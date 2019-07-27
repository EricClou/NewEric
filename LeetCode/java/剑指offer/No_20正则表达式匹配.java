package 剑指offer;

/**
 * 题目：请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包括0次）。
 * <p>
 * 例子：'aaa'与'a.a'与'ab*ac*a'匹配。但是'aa.a'与'ab*ac*a'均不匹配。
 * <p>
 * 思路：已经默认了待匹配待字符串是常规字符串，那么正则表达式只可能比其长度长，不可能比其长度短
 */
public class No_20正则表达式匹配 {


    public static void main ( String[] args ) {

    }


    public static boolean match ( char[] str, char[] pattern, int strIndex, int patternIndex ) {
        if (str == null || pattern == null) return false;
        return true;

    }


    public static boolean matchCore ( char[] str, int strIndex, char[] pattern, int patternIndex ) {

        //有效性检验：两者都到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length)
            return true;


        //pattern先到尾，匹配失败
        if (strIndex != str.length && patternIndex == pattern.length)
            return false;


        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
                return matchCore(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex);//*匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

}
