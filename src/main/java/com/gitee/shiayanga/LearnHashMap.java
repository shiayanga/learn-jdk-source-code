package com.gitee.shiayanga;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author LiYang
 */
public class LearnHashMap {
    public static void main(String[] args) throws Exception {
        HashMap<String, Object> map = new HashMap<String, Object>();
        // 获取阈值，HashMap不包含获取threshold的方法，所以使用getDeclaredField获取阈值
        Field tableField = map.getClass().getDeclaredField("table");
        tableField.setAccessible(true);
        System.out.println(tableField.get(map));

        // 获取阈值，HashMap不包含获取threshold的方法，所以使用getDeclaredField获取阈值
        Field thresholdField = map.getClass().getDeclaredField("threshold");
        thresholdField.setAccessible(true);

        // 获取容量,因为HashMap中包含capacity方法，所以可以用getDeclaredMethod获取
        Method capacityMethod = map.getClass().getDeclaredMethod("capacity");
        capacityMethod.setAccessible(true);

        // 初始化时未指定HashMap的大小，此时初始化为：容量16，阈值0 的HashMap
        System.out.println("容量：" + capacityMethod.invoke(map) + "\t\t阈值：" + thresholdField.get(map) + "\t\t元素数量：" + map.size());
        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < 15; i++) {
            // 当put进第一个元素时，因为此时节点长度是0，所以会先resize，然后再newNode
            map.put("a" + i, i);
            System.out.println("容量：" + capacityMethod.invoke(map) + "\t\t阈值：" + thresholdField.get(map) + "\t\t元素数量：" + map.size());
        }

        System.out.println("---------------------------------------------------------");
        System.out.println("容量：" + capacityMethod.invoke(map) + "\t\t阈值：" + thresholdField.get(map) + "\t\t元素数量：" + map.size());

    }
}
