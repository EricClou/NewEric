package SwordToOffer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 返回和最大的连续子数组的值
 */
public class No_30_连续子数组的最大和 {

    public static void main ( String[] args ) {
        int[] temp = new int[]{2,8,1,5,9};
        System.out.println(new No_30_连续子数组的最大和().FindGreatestSumOfSubArray(temp));
    }

    public int FindGreatestSumOfSubArray ( int[] array ) {

//        boolean plus = false;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] > 0) {
//                plus = true;
//            }
//        }
//        if (plus == false) {
//            Arrays.sort(array);
//            return array[array.length - 1];
//        }

        ArrayList <Integer> help = new ArrayList <>();

        for (int i = 0; i < array.length; i++) help.add(array[i]);

        ArrayList <List <Integer>> list = new ArrayList <>();

        for (int i = 0; i < array.length; i++) {

            for (int j = i+1; j <= array.length; j++) {
                list.add(help.subList(i, j));
            }
        }


        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {

            for (int j = 0; j < list.get(i).size(); j++) {

                res[i] += list.get(i).get(j);
            }
        }
        Arrays.sort(res);


        return res[res.length - 1];

    }
}
