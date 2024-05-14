import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedDeque;

class JavaCollection {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>(2);
        list.add("apple");
        list.add("hello");
        list.add("bule");
        System.out.println(list);

        LinkedList<String> list2=new LinkedList<>(list);
        list2.addFirst("new");
        System.out.println(list2);

        Vector<String> vector=new Vector<>(1);
        vector.addAll(list2);
        System.out.println(vector.firstElement());
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());

        // 在多线程环境中使用 synchronizedList
        // 注意：在迭代时需要手动进行同步操作
        synchronized (synchronizedList) {
            synchronizedList.add("Apple");
            synchronizedList.add("Banana");
            synchronizedList.add("Orange");

            // 迭代时需要使用 synchronized 同步
            synchronized (synchronizedList) {
                for (String fruit : synchronizedList) {
                    System.out.println(fruit);
                }
            }
        }
        HashSet<String> hashset = new HashSet<>();

        // 添加元素到 HashSet
        hashset.add("Apple");
        hashset.add("Banana");
        hashset.add("Orange");

        // 遍历输出 HashSet 中的元素
        for (String item : hashset) {
            System.out.println(item);
        } 
        TreeSet<String> treeset = new TreeSet<>();

        // 添加元素到 TreeSet
        treeset.add("Orange");
        treeset.add("Banana");
        treeset.add("Apple");

        // 遍历输出 TreeSet 中的元素（按照自然顺序排序）
        for (String item : treeset) {
            System.out.println(item);
        }

        LinkedHashSet<String> linkedhashset = new LinkedHashSet<>();

        // 添加元素到 LinkedHashSet
        linkedhashset.add("Apple");
        linkedhashset.add("Banana");
        linkedhashset.add("Orange");

        // 遍历输出 LinkedHashSet 中的元素
        for (String item : linkedhashset) {
            System.out.println(item);
        }
        TreeSet<Integer> treeSet1 = new TreeSet<>();
        treeSet1.add(5);
        treeSet1.add(2);
        treeSet1.add(8);
        System.out.println("TreeSet1 (Natural Ordering): " + treeSet1); // 输出：[2, 5, 8]

        // 创建一个 TreeSet，使用自定义比较器（逆序）
        TreeSet<Integer> treeSet2 = new TreeSet<>((a, b) -> b.compareTo(a)); // 逆序比较器
        treeSet2.add(5);
        treeSet2.add(2);
        treeSet2.add(8);
        System.out.println("TreeSet2 (Custom Ordering): " + treeSet2); // 输出：[8, 5, 2]



        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // 向优先级队列中添加元素
        priorityQueue.add(5);
        priorityQueue.add(2);
        priorityQueue.add(8);

        // 输出优先级队列中的元素（按顺序排列）
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll()); // 每次弹出最小元素
        }

        Deque<String> deque = new ArrayDeque<>();

        // 在队列尾部插入元素
        deque.addLast("one");
        deque.addLast("two");
        deque.addLast("three");

        // 在队列头部插入元素
        deque.addFirst("zero");

        // 输出双端队列中的元素（按插入顺序输出）
        while (!deque.isEmpty()) {
            System.out.println(deque.removeFirst()); // 每次移除并返回队列头部的元素
        }
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 添加键值对到 HashMap
        hashMap.put("apple", 10);
        hashMap.put("banana", 20);
        hashMap.put("orange", 15);

        // 获取键对应的值
        System.out.println("Number of apples: " + hashMap.get("apple"));

        // 遍历 HashMap 的键值对
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        // 添加键值对到 Hashtable
        hashtable.put("apple", 10);
        hashtable.put("banana", 20);
        hashtable.put("orange", 15);

        // 获取键对应的值
        System.out.println("Number of apples: " + hashtable.get("apple"));

        // 遍历 Hashtable 的键值对
        for (Map.Entry<String, Integer> entry : hashtable.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // 添加键值对到 LinkedHashMap
        linkedHashMap.put("apple", 10);
        linkedHashMap.put("banana", 20);
        linkedHashMap.put("orange", 15);

        // 获取键对应的值
        System.out.println("Number of apples: " + linkedHashMap.get("apple"));

        // 遍历 LinkedHashMap 的键值对（按照插入顺序）
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        // 添加键值对到 TreeMap
        treeMap.put("apple", 10);
        treeMap.put("banana", 20);
        treeMap.put("orange", 15);

        // 获取键对应的值
        System.out.println("Number of apples: " + treeMap.get("apple"));

        // 遍历 TreeMap 的键值对（按照键的顺序）
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


    }


}