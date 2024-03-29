package com.yanliang.algo.leetcode.lru;

/** @author yanliang */
public class Main {
    public static void main(String[] args) {
        /* 缓存容量为 2 */
        LruCacheLC146 cache = new LruCacheLC146(2);
        // 你可以把 cache 理解成一个队列
        // 假设左边是队头，右边是队尾
        // 最近使用的排在队头，久未使用的排在队尾
        // 圆括号表示键值对 (key, val)

        cache.put(1, 1);
        // cache = [(1, 1)]

        cache.put(2, 2);
        // cache = [(2, 2), (1, 1)]

        cache.get(1); // 返回 1
        // cache = [(1, 1), (2, 2)]
        // 解释：因为最近访问了键 1，所以提前至队头
        // 返回键 1 对应的值 1

        cache.put(3, 3);
        // cache = [(3, 3), (1, 1)]
        // 解释：缓存容量已满，需要删除内容空出位置
        // 优先删除久未使用的数据，也就是队尾的数据
        // 然后把新的数据插入队头

        cache.get(2); // 返回 -1 (未找到)
        // cache = [(3, 3), (1, 1)]
        // 解释：cache 中不存在键为 2 的数据

        cache.put(1, 4);
        // cache = [(1, 4), (3, 3)]
        // 解释：键 1 已存在，把原始值 1 覆盖为 4
        // 不要忘了也要将键值对提前到队头
    }
}
