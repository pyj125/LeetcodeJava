//package com.yujpeng.design;
//
//import java.util.Deque;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Map;
//
//class StockPrice {
//
//    //(1,10) (2,5) (1,3) (4,2)
//
//    Map<Integer, Integer> map = new HashMap<>();
//
//    class Node {
//        int timeStamp;
//        int price;
//        Node next;
//        Node pre;
//
//        public Node(int timeStamp, int price) {
//            this.timeStamp = timeStamp;
//            this.price = price;
//        }
//
//        public Node(){
//
//        }
//    }
//
//    Node head = new Node();
//    Node tail = new Node();
//    public StockPrice() {
//
//    }
//
//    private Node findPrice(Node cur){
//
//    }
//
//    public void update(int timestamp, int price) {
//        //覆盖之前的结果
//        if (map.containsKey(timestamp)) {
//            map.put(timestamp, price);
//        } else {
//            Node node = new Node(timestamp,price);
//
//
//        }
//    }
//
//    // 按照时间戳排序
//    public int current() {
//
//    }
//
//    //按照价格排序
//    public int maximum() {
//
//    }
//
//    public int minimum() {
//
//    }
//}
//
///**
// * Your StockPrice object will be instantiated and called as such:
// * StockPrice obj = new StockPrice();
// * obj.update(timestamp,price);
// * int param_2 = obj.current();
// * int param_3 = obj.maximum();
// * int param_4 = obj.minimum();
// */
