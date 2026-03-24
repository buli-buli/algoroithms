package coding.dynamic.medium;

/**
 * @author yzw
 * @Description 96、不同的二叉搜索树
 * @createTime 2026年03月24日
 */
public class NumTrees {
    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }

    static int numTrees(int n) {
        int [] dp = new int[n + 1];

        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++){
            for (int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }
}
