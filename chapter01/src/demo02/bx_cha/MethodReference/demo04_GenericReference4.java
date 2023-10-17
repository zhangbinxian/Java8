package demo02.bx_cha.MethodReference;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author bx_cha
 * @version 1.0
 * 方法接口的使用
 */

/**
 * 数组引用
 */
public class demo04_GenericReference4 {

    // 数组引用
    // Function R apply()
    @Test
    public void test1() {
        Function<Integer, String[]> function = length -> new String[length];
        String[] strings = function.apply(10);
        System.out.println(Arrays.toString(strings));
    }

    // Function R apply()
    @Test
    public void test2() {
        Function<Integer, String[]> function = String[]::new;
        String[] strings = function.apply(10);
        System.out.println(Arrays.toString(strings));
    }
}