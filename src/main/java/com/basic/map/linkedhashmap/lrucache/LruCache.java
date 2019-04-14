package com.basic.map.linkedhashmap.lrucache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU缓存
 * @author haodong.zhao
 * @version 1.0. Added Time:2019/4/13 17:16
 */
public class LruCache<K, V> extends LinkedHashMap<K, V> {

    /**
     * Map默认初始容量
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**
     * 默认负载因子
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 默认最大容量
     */
    private static final int DEFAULT_MAX_CAPACITY = 200;

    /**
     * 缓存最大容量
     */
    private int maxCapacity;

    public LruCache() {
        this(DEFAULT_MAX_CAPACITY);
    }

    public LruCache(int maxCapacity) {
        super(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, true);
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    /**
     * 重写的父类方法，用于在新增一个Entry时判断是否需要删除最老的数据
     * @param eldest 最老的节点
     * @return 是否需要删除
     * @see LinkedHashMap#addEntry
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return super.size() > maxCapacity;
    }
}
