package Leet;

public class No_923_3SumWithMultiplicity {
    public int threeSumMulti(int[] A, int target) {
        int MOD = 1_000_000_007; // 因为最大数为10^9+7

        // 计算数组中不同元素出现的个数   因为 0 <= A[i] <=100
        long[] c = new long[101]; // 定义成long，在计算中不用转换
        for (int a : A) c[a]++;

        long ans = 0;
        for (int i = 0; i <= target; i++) {
            for (int j = i; j <= target; j++) {
                int k = target - i - j;
                if (k < 0 || k >= c.length || k < j) continue;
                if (c[i] == 0 || c[j] == 0 || c[k] == 0) continue;
                if (i ==j && j == k) {
                    ans += (c[i] - 2) * (c[i] - 1) * c[i] / 6;
                } else if (i ==j && j != k) {
                    ans += c[i] * (c[i] - 1) / 2 * c[k];
                } else if (i != j && j == k) {
                    ans += c[i] * (c[j] - 1) * c[j] / 2;
                } else {
                    ans += c[i] * c[j] * c[k];
                }
                ans %= MOD;
            }
        }
        return (int)ans;
    }

    public static void main ( String[] args ) {
        int[] A = {1, 1, 1, 1, 1};
        System.out.println(new No_16_3SumClosest().threeSumClosest(A, 3));
    }


}
