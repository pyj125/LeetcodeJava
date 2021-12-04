//package test;
//
//public class Test0810 {
//
//    // 在线面试平台。将链接分享给你的朋友以加入相同的房间。
//// Author: tdzl2003<dengyun@meideng.net>
///*
//bool IsBinaryTree(int n, const std::vector<std::pair<int, int>>& edges) (C++)
//def is_binary_tree(n, edges) (Python)
//
//n: ｎ个节点
//[(a,b)..]
//(a,b) ===> a--> b
//true/false
//Sample Input:
//3
//[(2,0), (1,2)]
//1 ==> 2 ==> 0
//Sample Output:
//true
//
//circle
//connected
//
//
//*/
//[(1,0), (0,2)]
//    class Node{
//        int val;
//        List<Node> childList = new ArrayList();
//        List<Node> parentList = new ArrayList();
//
//        Node(int val){
//            this.val = val;
//        }
//
//    }
//
//    bool IsBinaryTree(int[][] arr,int n){
//        int[] fa = new int[n]{-1,};
//
//        Node[] result = new Node[n];
//
//        for(int i=0;i<arr.length;i++){
//            int start = arr[i][0];
//            int end = arr[i][1];
//            fa[end] = start;
//            result[start].val = start;
//            result[end].val = end;
//
//            result[start].childList.add(node2);
//            result[end].parentList.add(node1);
//            //result[start]=node1;
//        }
//
//        int[] visited = new int[n];
//        Set<Integer> res = new HashSet();
//        for(int i=0;i<n;i++){
//            while(fa[i] != 0 && visited[i] == false){
//                i = fa[i];
//                visited[i]=true;
//            }
//            res.add(i);
//        }
//        if(res.size()>1 || res.size==0){
//            return false;
//        }
//
//        int root = res.get(0);
//        //从根节点开始搜索
//        return dfs(root);
//
//    }
//
//
//    public boolean dfs(Node root){
//        if(root == null){
//            return true;
//        }
//        if(root.childList.size()>2){
//            return false;
//        }
//        if(root.parentList.size()>=2){
//            return false;
//        }
//
//        boolean res = false;
//        for(int i=0;i<root.childList.size();i++){
//            res = dfs(root.childList.get(i));
//            if(!res){
//                return false;
//            }
//        }
//
//        return true;
//
//
//    }
//
//
//
//}
