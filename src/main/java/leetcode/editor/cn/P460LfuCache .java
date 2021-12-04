//请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。 
//
// 实现 LFUCache 类： 
//
// 
// LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象 
// int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。 
// void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之
//前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。 
// 
//
// 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。 
//
// 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。 
//
// 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。 
//
// 
//
// 示例： 
//
// 
//输入：
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "g
//et"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//输出：
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//解释：
//// cnt(x) = 键 x 的使用计数
//// cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
//LFUCache lFUCache = new LFUCache(2);
//lFUCache.put(1, 1);   // cache=[1,_], cnt(1)=1
//lFUCache.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lFUCache.get(1);      // 返回 1
//                      // cache=[1,2], cnt(2)=1, cnt(1)=2
//lFUCache.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
//                      // cache=[3,1], cnt(3)=1, cnt(1)=2
//lFUCache.get(2);      // 返回 -1（未找到）
//lFUCache.get(3);      // 返回 3
//                      // cache=[3,1], cnt(3)=2, cnt(1)=2
//lFUCache.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
//                      // cache=[4,3], cnt(4)=1, cnt(3)=2
//lFUCache.get(1);      // 返回 -1（未找到）
//lFUCache.get(3);      // 返回 3
//                      // cache=[3,4], cnt(4)=1, cnt(3)=3
//lFUCache.get(4);      // 返回 4
//                      // cache=[3,4], cnt(4)=2, cnt(3)=3 
//
// 
//
// 提示： 
//
// 
// 0 <= capacity, key, value <= 104 
// 最多调用 105 次 get 和 put 方法 
// 
//
// 
//
// 进阶：你可以为这两种操作设计时间复杂度为 O(1) 的实现吗？ 
// Related Topics 设计 
// 👍 385 👎 0


package leetcode.editor.cn;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

//Java：LFU 缓存
class P460LfuCache {
    public static void main(String[] args) {
        LFUCache solution = new P460LfuCache().new LFUCache(2);
        // TO TEST
        solution.put(1,1);
        solution.put(2,2);
        solution.get(1);
        solution.put(3,3);
        solution.get(2);
        solution.get(3);
        solution.put(4,4);
        solution.get(1);
        solution.get(3);
        solution.get(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {

        class DLinkNode {
            int key;
            int value;
            int freq = 1;
            DLinkNode pre;
            DLinkNode next;

            DLinkNode() {
            }

            DLinkNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        class DLinkNodeList {
            DLinkNode head;
            DLinkNode tail;

            public DLinkNodeList() {
                head = new DLinkNode();
                tail = new DLinkNode();
                head.next = tail;
                tail.pre = head;
            }


            //一个新节点加入 添加到表头
            public void addToHead(DLinkNode node) {
                node.next = head.next;
                head.next.pre = node;
                head.next = node;
                node.pre = head;
            }

            //删除一个节点
            public void removeNode(DLinkNode node) {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }

            //删除最后一个节点
            public DLinkNode removeTail() {
                DLinkNode node = tail.pre;
                removeNode(node);
                return node;
            }

            //将一个节点从链表中删除，并移动到表头
            public void moveToHead(DLinkNode node) {
                removeNode(node);
                addToHead(node);
            }

        }

        private int size;
        private int capacity;
        private int min_freq;
        private Map<Integer, DLinkNode> map = new HashMap<>();
        private Map<Integer, DLinkNodeList> freqMap = new HashMap<>();

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;

        }

        public int get(int key) {
            DLinkNode node = map.get(key);
            if (node == null) {
                //当前元素不存在
                return -1;
            }
            freqInc(node);
            return node.value;
        }

        private void freqInc(DLinkNode node) {
            //node 从freq的list中去除，加入到freq+1的list
            int freq = node.freq;
            DLinkNodeList list = freqMap.get(freq);
            list.removeNode(node);
            //从旧的频次列表中删除后，原来的频次最小，并且链表中没有元素的话 更新最小频次数据
            if (freq == min_freq && list.head.next == list.tail) {
                min_freq = freq + 1;
            }
            node.freq++;
            list = freqMap.get(freq + 1);
            if (list == null) {
                list = new DLinkNodeList();
                freqMap.put(node.freq, list);
            }
            //加入到头部
            list.addToHead(node);
        }

        //新增元素 size++ freq++
        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            DLinkNode node = map.get(key);
            if (node == null) {
                //这个元素不存在
                // 元素已经超出范围了
                if (size == capacity) {
                    //获取最小频次的数据list
                    DLinkNodeList list = freqMap.get(min_freq);
                    //删除频次最小的list中最后一个的数据
                    map.remove(list.tail.pre.key);
                    list.removeTail();
                    size--;
                }
                node = new DLinkNode(key, value);
                map.put(key, node);
                DLinkNodeList temp = freqMap.get(1);
                if (temp == null) {
                    temp = new DLinkNodeList();
                    freqMap.put(1, temp);
                }
                temp.addToHead(node);
                size++;
                min_freq = 1;

            } else {
                //这个元素已经存在 那么更新这个元素，并把频率最低的那个元素删除
                node.value = value;
                freqInc(node);
            }

        }


    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
