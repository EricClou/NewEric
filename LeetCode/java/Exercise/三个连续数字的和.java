package Exercise;


public class 三个连续数字的和 {

    public static void main ( String[] args ) {
        int[] arr = {1, 1, 1, 10};
        System.out.println(new 三个连续数字的和().getNWords(arr));
    }

    public char getNWords ( int[] arr ) {
        String ans = "";
        int index = arr[3];
        int res = 0;
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        ans = ans + a + b + c;

        while (ans.length() < index) {
            res = a + b + c;
            ans += res;
            a = Integer.valueOf(ans.charAt(ans.length()-3))-48;
            b = Integer.valueOf(ans.charAt(ans.length()-2))-48;
            c = Integer.valueOf(ans.charAt(ans.length())-1)-48;
        }
        char[] answer = ans.toCharArray();
        return answer[index - 1];

    }
}
