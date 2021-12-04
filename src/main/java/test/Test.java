package test;

public class Test {

    public static void main(String[] args) {
        int[] weight = new int[]{1,3,4};
        int[] value = new int[]{2,1,3};
        int totalWeight = 10;
        int maxValue = 0;

        //dp[i][j] 背包数量是j，现在有i个物品去取
        //dp[i][j] 如果不取第i物品，dp[i-1][j]
        //dp[i][j] 如果取第i物品 vaule[i]+dp[i-1][j-weight[i]] (j>weight[i]]
        //dp[i][j] = Max(dp[i-1][j],vaule[i]+dp[i-1][j-weight[i]])
//        int[][] dp = new int[3][totalWeight];
//        for(){
//
//        }
        Integer a = 125,b=125;
        System.out.println(a==b);

        Integer a1 = 150,b1=150;
        System.out.println(a1==b1);

//        String s = "/test/con";
//        int lastIndex = s.lastIndexOf('/');
//        String fatherPath = s.substring(0, lastIndex);
//        System.out.println(fatherPath);



    }
}
