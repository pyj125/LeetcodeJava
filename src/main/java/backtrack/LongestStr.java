package backtrack;

public class LongestStr {


    public static void main(String[] args) {

    }

    public static String longestParlidStr(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] arr = s.toCharArray();
        int len = arr.length;
        boolean[][] flag = new boolean[len][len];
        // dp[i] 表示 [i,len-1]的长度
        int[] dp = new int[len];
        //
        int index = -1;
        int max = -1;

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                //如果[i,j]
                if (arr[i] == arr[j] && (j - i <= 1 || flag[i + 1][j - 1])) {
                    flag[i][j] = true;
                    dp[i] = dp[j] + i-j;
                    if (max > dp[i]) {
                        max = dp[i];
                        index = i;
                    }
                }
            }
        }
        return s.substring(index, index + max);

    }

}
