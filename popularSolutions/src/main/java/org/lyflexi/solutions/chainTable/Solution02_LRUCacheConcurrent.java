package org.lyflexi.solutions.chainTable;

import org.lyflexi.solutions.chainTable.structDef.NodeLRU;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: ly
 * @Date: 2024/2/10 13:47
 */
public class Solution02_LRUCacheConcurrent {
    public static void main(String[] args) {
        Solution02_LRUCacheConcurrent instance = getInstance(3);
    }


    private final NodeLRU dummy;
    private final int capacity;
    private int count;

    //使用ConcurrentHashMap
    ConcurrentHashMap<Integer, NodeLRU> mapToNode;
    //引入读写锁ReentrantReadWriteLock
    private static ReentrantLock lock;



    // Spring的单实例对象能够保证引用的本地锁的唯一性
    // 不用框架的情况下，用户往往会通过new方式创建服务对象，此时我们自己需要引入单例模式，保证多个使用者拿到的Solution07_LRUCacheConcurrent都是唯一的，这样内部的lock和mapToNode才都是唯一的
    private static volatile Solution02_LRUCacheConcurrent solution07LruCacheConcurrent;

    public static Solution02_LRUCacheConcurrent getInstance(int capacity) {
        if (solution07LruCacheConcurrent == null) {

            synchronized (Solution02_LRUCacheConcurrent.class){
                //双重锁校验
                if (solution07LruCacheConcurrent == null) {
                    solution07LruCacheConcurrent = new Solution02_LRUCacheConcurrent(capacity);
                }
            }

        }
        return solution07LruCacheConcurrent;
    }

    public Solution02_LRUCacheConcurrent(int capacity) {
        dummy = new NodeLRU(0, 0);
        dummy.next = dummy;//初始化傀儡节点的后继指向自身
        dummy.pre = dummy;//初始化傀儡节点的前驱指向自身
        this.capacity = capacity;

        this.mapToNode = new ConcurrentHashMap<>();
        lock  = new ReentrantLock();
    }

    public int get(int key) {
        lock.lock();//因为get操作也包括了对链表的修改，所以没必要使用读写锁
        try {
            NodeLRU cache = mapToNode.get(key);
            if (cache != null) {
                moveToTail(cache);
                return cache.getValue();
            }
            //缓存为空
            return -1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void put(int key, int value) {
        lock.lock();
        try {
            NodeLRU cache = mapToNode.get(key);
            if (cache != null) {
                cache.setValue(value);
                mapToNode.put(key, cache);
                moveToTail(cache);
                return;
            }
            //缓存为null
            count++;
            if (count > capacity) {
                //淘汰策略
                mapToNode.remove(dummy.next.getKey());
                delHead();
                count--;
            }

            NodeLRU node = new NodeLRU(key, value);
            addToTail(node);
            mapToNode.put(key, node);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }


    private void moveToTail(NodeLRU node) {

        //删除当前节点
        node.pre.next = node.next;
        node.next.pre = node.pre;


        //尾部新增
        addToTail(node);

    }

    private void addToTail(NodeLRU node) {
        //先安置新节点自身的前驱与后继指针
        node.next = dummy;
        node.pre = dummy.pre;

        dummy.pre.next = node;
        dummy.pre = node;
    }

    private void delHead() {
        dummy.next.next.pre = dummy;
        dummy.next = dummy.next.next;
    }
}
