package backtrack;

public class LeetCode10 {

    /**
     * 是否正则匹配上
     * 有一处没有匹配上就退出 认为不匹配
     * @param s 输入串
     * @param p 模式串
     * @return
     */
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int m = s.length();
        int n = p.length();
        //两个指针都指到最后才退出
        while (i < m && j < n) {
            //当 s 中第i 个字符与 p中第j个字符相同 或 p[j]为通配符 .时 认为相等 两个指针都移动
            if(s.charAt(i)== p.charAt(j) || p.charAt(j) == '.' ){
                ++i;
                ++j;
            }else{
                return false;
            }
        }
        return i==j;
    }

    public static void main(String[] args) {
        LeetCode10 s = new LeetCode10();
        String a = "aaa";
        String b = "a*";
        boolean res = s.isMatch(a, b);
        System.out.println(res);
    }
}
