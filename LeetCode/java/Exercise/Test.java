package Exercise;

import java.io.UnsupportedEncodingException;

public class Test {
    public static void main ( String[] args ) {
        B test = new B("你好",1000);
        String temp = "";
        try {
            temp=new String(temp.getBytes("ISO-8859-1"),"GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace(e.getMessage());
        }
    }
}
