package 剑指offer;

/**
 * 题目：输入数字n，按顺序打印出从1到最大n位十进制数。比如输入3，则打印1、2、3，一直到最大到3位数999
 * <p>
 * 思路：
 * 要注意大数问题，当n很大到时候，我们即使使用int型或者是long型都可能会溢出
 * 大数问题的最常用思路是用字符串或者数组来表示大数
 */
public class No_17打印从1到最大到n位数 {

    public static void main ( String[] args ) {

        printToMaxOfDigits(-10);
        printToMaxOfDigits(0);
        printToMaxOfDigits2(3);
//        printToMaxOfDigits(100);

    }

    public static void printToMaxOfDigits ( int n ) {


        if (n <= 0) return;


        //声明字符数组，用来存放一个大数
        char[] number = new char[n];
        for (int i = 0; i < number.length; ++i) { //放字符0进行初始化
            number[i] = '0';

        }

        while (!incrementNumber(number)) { //如果大数自加，直到自溢退出
            printNumber(number);
        }
    }


    //实现了在表示数字的字符串number上增加1
    public static boolean incrementNumber ( char[] number ) {
        boolean isOverflow = false; //判断是否溢出
        int nTakeOver = 0;   //判断是否进位

        //大数的长度
        int nLength = number.length;


        //这里+'0',-'0'的目的是将字符与数字相互转换
        for (int i = nLength - 1; i >= 0; --i) {
            int nSum = number[i] - '0' + nTakeOver;//取到第i位的字符转换为数字 +进位符
            if (i == nLength - 1) {//末尾自加1，这是个位伤的情况
                ++nSum;
            }

            if (nSum >= 10) { //一旦进位

                //如果到了最高位，则说明已经溢出
                if (i == 0) isOverflow = true;

                    //没有溢出，增加进位，清空nSum
                else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) ('0' + nSum);
                }
            }
            //没有进位
            else {
                number[i] = (char) (nSum + '0');
                break;
            }
        }

        return isOverflow;

    }

    //打印数字

    private static void printNumber ( char[] number ) {

        //显然098不符合阅读习惯，这里设置开头是否为0
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; ++i) {

            //只碰到第一个非0字符才开始打印
            if (isBeginning0 && number[i] != '0') {
                isBeginning0 = false;
            }
            if (!isBeginning0) System.out.print(number[i]);

        }
        //换行
        System.out.println();
    }


    //主方法，把数字的每一位从0到9排一遍
    public static void printToMaxOfDigits2 ( int n ) {
        if (n <= 0) return;

        char number[] = new char[n];

        for (int i = 0; i < number.length; ++i) {
            number[i] = '0';

        }

        for (int i = 0; i < 10; ++i) {
            number[0] = (char) (i + '0');
            printToMaxOfNDigitsRecursively(number, n, 0);
        }
    }


    //利用递归实现1到最大到n位数的全排列

    public static void printToMaxOfNDigitsRecursively ( char[] number, int n, int index ) {
        if (index == n - 1) {
            printNumber(number);
            return;
        }

        for (int i = 0; i < 10; ++i) {
            number[index + 1] = (char) (i + '0');
            printToMaxOfNDigitsRecursively(number, n, index + 1);
        }
    }
}
