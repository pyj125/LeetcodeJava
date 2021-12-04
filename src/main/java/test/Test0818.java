//package test;
//
//public class Test0818 {
//    // 在线面试平台。将链接分享给你的朋友以加入相同的房间。
//// Author: tdzl2003<dengyun@meideng.net>
//
//
//
//
//
//    给一个长度为N的字符串，其中有些子串恰有k个不同字符，求：这些子串长度的最大值。
//
//
//    abccd, k = 2, -> bcc or ccd
//
//
//    滑动窗口：
//            [left,right] 出现字符种类数<=k,
//    加字符，当窗口类的种类少于K right++
//    当新增一个字符时，种类数超过的话，就要left++
//
//    hashMap
//
//
//
//    int left = -1,right = -1;
//
//    abccd
//    a  left = -1, i=0
//    ab   					 i=1
//    abc
//    int getMaxResult(String s){
//        if(s == null || s.length()==0){
//            return 0;
//        }
//
//        char[] arr = s.toCharArray();
//        int left = -1;
//        //int right = -1;
//
//        Map<Character,Integer> map = new HashMap<Character,Integer>();
//
//        int i = 0;
//        int res = -1;
//        while(i<arr.length){
//            //加入map
//            char c = arr[i];
//            map.put(c,map.getDefault(c,0)+1);
//
//            //如果窗口内种类大于k,那么左边缩小
//            while(map.size()>k){
//                char ch = arr[left+1];
//                map.put(ch,map.getDefault(c,0)-1);
//                if(map.get(ch)<=0){
//                    map.remove(ch);
//                }
//                left++;
//            }
//            res = Math.max(res,i-left);
//            i++;
//        }
//
//        return res;
//
//    }
//
////    给定一个n*m的二维格点地图, 每个位置要么是字符’.’表示空地, 要么是’@’表示有敌人在这里.
////            规定给定一个d(1 <= d <= min(m, n)), 如果一个d*d的区域内没有任何敌人, 则认为这片区域是安全的. 问给定的地图中有多少个这样安全的区域.
////
////
////. . . @
////. . . @ , d = 2, ans = 2
////
////
////            (x, y) -> (x + d, y + d)
////
////    F(x, y) =
////            //(x,y)
////
////            (x-d+1,y-d+1)
////            (
////
////
////
////            if(a[x][y]='@']
////
////
////
////    F(Z) = z
////    F(Y) = y
////    F(W) = w
////    F(X) = ?
////            . . .
////            . Z Y
////     . W X
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
