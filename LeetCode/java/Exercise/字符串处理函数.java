package Exercise;

//输入原始的字符串，如 "abcaba"
//输入处理后的字符串，如 "aaabcb"


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 字符串处理函数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch[] = sc.nextLine().toCharArray();
        System.out.println(drawChar(ch));
    }

    public static char[] drawChar ( char[] text ) {
        HashMap <Character, Integer> map = new HashMap <>();
        for (int i = 0; i < text.length; i++) {
            map.put(text[i], map.getOrDefault(text[i], 0) + 1);
        }

        int maxValue = 0;
        for (int i = 0; i < text.length; i++) {
            maxValue = Math.max(maxValue, map.get(text[i]));
        }
        char tar = getKey(map, maxValue);

        ArrayList <Character> ans = new ArrayList <>();
        for (int i = 0; i < text.length; i++) {
            ans.add(text[i]);
        }

        int times = maxValue;
        while (times > 0) {
            ans.remove(Character.valueOf(tar));
            times--;
        }

        String result = "";
        for (int i = 0; i < maxValue; i++) {
            result+=tar;
        }
        for (int i=0;i<ans.size();i++){
            result+=ans.get(i);
        }
        return result.toCharArray();

    }

    private static char getKey ( Map <Character, Integer> map, int value ) {
        Character key = null;
        for (Map.Entry <Character, Integer> entry : map.entrySet()) {
            if (value == (entry.getValue())) {
                key = entry.getKey();
            }
        }
        return key;
    }
}
