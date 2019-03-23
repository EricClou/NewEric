package SwordToOffer;


//请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如
//当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

public class No_2_替换空格 {

    public static void main ( String[] args ) {
        StringBuffer tar = new StringBuffer("We Are Happy ");
        System.out.println(new No_2_替换空格().replaceSpace(tar));
    }

    /**
     * 不能使用普通的JAVA分词方法split，这是因为如果空格出现在字符串的头部或者尾部，此时将不会计入。
     * @param str
     * @return
     */
    public String replaceSpace ( StringBuffer str ) {
        String tar = str.toString();
        char[] res = tar.toCharArray();
        String ans = new String();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == ' ') {
                ans += "%20";
            } else ans += res[i];
        }
        return ans;
    }
}