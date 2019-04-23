package NewCoder.Lesson2;


//        编写一个程序，将输入字符串中的字符按如下规则排序。
//
//        规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
//
//        如，输入： Type   输出： epTy
//
//        规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
//
//        如，输入： BabA   输出： aABb
//
//        规则 3 ：非英文字母的其它字符保持原来的位置。
//
//        如，输入： By?e   输出： Be?y
//                样例：
//
//                输入：
//
//                A Famous Saying: Much Ado About Nothing(2012/8).
//
//                输出：
//
//                A aaAAbc dFgghh: iimM nNn oooos Sttuuuy(2012/8).


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 课后练习2 {
        public static void main(String[] args)throws IOException{
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            String str;
            while((str=bf.readLine()) != null){
                StringBuffer sb = new StringBuffer();

                //这边的算法时间复杂度是O(n2)
                //从A-Z、a-z直接记录字母，循环26次是把所有的字母全部考虑进去
                for(int i=0; i<26; i++){

                    //从a-z
                    char c = (char)(i+'A');//遍历循环从A开始不分大小写，将字母部分依次写进去
                    for(int j=0; j<str.length(); j++){

                        //从头到尾遍历取
                        char sc = str.charAt(j);

                        //当前判断是否是某字母，这个if判断就使得大写与小写都放进字符串吧
                        if(c == sc || c == sc -32)
                            sb.append(sc);
                    }
                }
                //然后记录非字母字符
                for(int i=0; i<str.length(); i++){
                    char c = str.charAt(i);
                    if(!(c >= 'a' && c <='z') && !(c >= 'A' && c <= 'Z'))
                        sb.insert(i,c);
                }
                System.out.println(sb.toString());
            }
            bf.close();
        }
    }
