package demo01.bx_cha.Lambda;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author bx_cha
 * @version 1.0
 * 简单入门lambda
 */
public class demo01 {

    @Test
    // 使用Runnable 对象调用run()方法
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("test1");
            }
        };
        runnable.run();
    }

    @Test
    // 使用Runnable 对象调用run()方法 使用lambda
    public void test2() {
        Runnable runnable = () -> System.out.println("test2");

        runnable.run();
    }

    @Test
    // 使用Comparator 对象调用compare()方法
    public void test3() {
        Comparator<Integer> comparator = new Comparator<>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare = comparator.compare(10, 20);
        System.out.println(compare);
    }
    @Test
    // 使用Comparator 对象调用compare()方法 使用lambda
    public void test4(){
        Comparator<Integer> comparator=(o1,o2)->Integer.compare(o1,o2);
        int compare = comparator.compare(10, 20);
        System.out.println(compare);
    }

    @Test
    // 使用Comparator 对象调用compare()方法 使用方法引用
    public void test5(){
        Comparator<Integer> comparator=Integer::compareTo;
        int compare = comparator.compare(10, 20);
        System.out.println(compare);
    }
}
