package 剑指offer;

/**
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如，输入"We are happy."，则输出
 * "We%20are%20happy."。
 * 思路：有几种解决方法：
 * 1、调用JAVA的API，但是显然笔试不可能这么写。
 * 2、将str拆分成char数组并保存，遍历char数组元素，遇到空格则替换成%20。时间复杂度为O(n)，这是创建了一个新的字符串。
 * 3、考虑在原字符串的位置上修改：首先统计字符串上有多少个空格。扩展出新长度的字符串。设定两个指针，一个指向扩展后的尾巴，一个
 * 指向扩展前的尾巴。然后两个指针从后向前遍历，遇到空格就填上"%20"，不是空格自动向后移。
 */
public class No_4替换空格 {

    public static void main ( String[] args ) {
        System.out.println(replaceSpace1("We are happy."));
        System.out.println(replaceSpace2("We are happy."));
        System.out.println(replaceSpace3(new StringBuffer("We are happy.")));


    }

    public static String replaceSpace1 ( String str ) {
        return str.replace(" ", "%20");
    }

    public static String replaceSpace2 ( String str ) {
        char[] temp = str.toCharArray();
        String result = "";
        for (int i = 0; i < temp.length; i++) {
            if (String.valueOf(temp[i]).equals(" ")) {
                result += "%20";
            } else result += temp[i];
        }
        return result;
    }

    public static StringBuffer replaceSpace3 ( StringBuffer str ) {
        int count = 0;
        //计算有多少个空格
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') count++;
        }
        //调整后的数组应该具有的容量。
        int old_index = str.length() - 1;
        int new_index = old_index + count * 2;

        //这个扩展长度是StringBuffer独有，String没有的
        str.setLength(new_index + 1);

        //这个setCharAt方法只有StringBuffer有，String是没有的，现在你知道为什么冒出个StringBuffer了把
        while (old_index >= 0 && new_index > old_index) {
            if (str.charAt(old_index) == ' ') {
                str.setCharAt(new_index--, '0');
                str.setCharAt(new_index--, '2');
                str.setCharAt(new_index--, '%');
            } else {
                str.setCharAt(new_index--, str.charAt(old_index));
            }
            old_index--;
        }
        return str;
    }
}
