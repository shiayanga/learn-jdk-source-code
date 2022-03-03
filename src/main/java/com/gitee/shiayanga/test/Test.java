package com.gitee.shiayanga.test;

import java.util.HashMap;

public class Test {
    private static final Integer MAXIMUM_CAPACITY = Integer.MAX_VALUE;
    private static final Integer DEFAULT_INITIAL_CAPACITY = 1 << 4;
    private static final Float DEFAULT_LOAD_FACTOR = 0.75f;
    private static Integer threshold = 12;

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        // 计算原有HashMap的容量
        int oldCap = 0;
        // 阈值
        int oldThr = threshold;
        // 设置新的容量和阈值为 0
        int newCap = 0, newThr = 0;
        if (oldCap > 0) {
            // 如果原有HashMap的容量大于最大容量
            if (oldCap >= MAXIMUM_CAPACITY) {
                // 将阈值设置为Integer类型的最大值，即 0x7fffffff
                threshold = Integer.MAX_VALUE;
                // 将原有的HashMap返回
            } else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY) {
                // double threshold
                // 先将容量扩大两倍，如果扩容后容量仍小于最大容量，同时原有HashMap容量大于等于默认初始容量
                // 将阈值设为原先的两倍（仍然等于容量*负载因子）
                newThr = oldThr << 1;
            }
        } else if (oldThr > 0) {
            // 如果原有HashMap的阈值大于0
            // initial capacity was placed in threshold
            newCap = oldThr;
        } else {               // zero initial threshold signifies using defaults
            // 如果原有的
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int) (DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        System.out.println(newCap+ " " + newThr + " " + threshold);
    }
}
