package demo02.bx_cha.MethodReference;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author bx_cha
 * @version 1.0
 * 方法接口的使用
 */

/**
 * 类::静态方法 (类::静态方法)
 */
public class demo02_MethodReference2 {


    @Test
    // labda表达式
    public void test1() {
        /**
         * 类型相似 参数和返回值类型
         * Comparator int compare(T t1,T t2)
         * Integer int compare(T t1,T t2)
         */
        Comparator<Integer> comparator = (i1, i2) -> Integer.compare(i1, i2);

        int compare = comparator.compare(10, 20);
        System.out.println(compare);
    }

    @Test
    // 方法引用
    public void test2() {
        /**
         * 类型相似 参数和返回值类型
         * Comparator int compare(T t1,T t2)
         * Integer int compare(T t1,T t2)
         */
        Comparator<Integer> comparator = Integer::compare;

        int compare = comparator.compare(10, 20);
        System.out.println(compare);
    }

    @Test
    // labda表达式
    public void test3() {
        /**
         * 类型相似，泛型返回值和泛型参数
         * Function R apply(T t)
         * Math Long round(Double d)
         */
        Function<Double, Long> function = (d) -> Math.round(d);
        System.out.println(function.apply(10.4));
    }

    @Test
    // 方法引用
    public void test4() {
        /**
         * 类型相似，泛型返回值和泛型参数
         * Function R apply(T t)
         * Math Long round(Double d)
         */
        Function<Double, Long> function = Math::round;
        System.out.println(function.apply(11.5));
    }

}
