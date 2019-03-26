package Exercise;

import java.util.ArrayList;
import java.util.Scanner;

//给定一个字符串str，和一个字母ch，请实现相应的代码求出一个数组，
//        使数组中每个数字表示该位置与字母ch之间的最短距离。
//        比如str=”lexinfintech”  ch=”i”
//        则输出为：[3,2,1,0,1,1,0,1,2,3,4,5]
public class 字符串距离 {
    public static void main ( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String c = scanner.nextLine();
        int[] res = getDistance(str, c.charAt(0));
        int i = 0;
        System.out.print("[");
        for (i = 0; i < res.length - 1; i++) {
            System.out.print(res[i] + ",");
        }
        System.out.print(res[i] + "]");

    }

    public static int[] getDistance ( String str, char ch ) {
        if(str.length()==0){
            return null;
        }
        //所查字符在原字符串中的序号以及个数
        ArrayList <Integer> inx = new ArrayList <>();

        char[] res = str.toCharArray();

        for (int i = 0; i < res.length; i++) {
            if (res[i] == ch) {
                inx.add(i);
            }
        }

        //距离，选择近的那个
        ArrayList <Integer> ans = new ArrayList <>();

        //出现次数
        int times = inx.size();
        int num = 0;
        int temp = Integer.MAX_VALUE;

        while (num < res.length) {
            for (int i = 0; i < times; i++) {
                temp = Math.min(Math.abs(inx.get(i) - num), Math.abs(inx.get(++i) - num));

            }
            num++;
            ans.add(temp);
        }
        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

}
