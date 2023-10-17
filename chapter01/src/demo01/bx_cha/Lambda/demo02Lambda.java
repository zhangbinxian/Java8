package demo01.bx_cha.Lambda;

/**
 * @author bx_cha
 * @version 1.0
 */

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * (o1,o2)->Integer.compare(o1,o2)
 * (参数) -> 表达式
 * 参数：可以是零个或多个参数，用于传递给 Lambda 表达式的函数
 * ->：箭头符号，用于将参数和表达式主体分隔开
 * 表达式：包含在 Lambda 表达式中的功能代码
 */
public class demo02Lambda {

    @Test
    // 无参 无返回值
    public void test1() {
        Runnable runnable = () -> System.out.println("test1");
        runnable.run();
    }

    @Test
    // 需要一个参数，但是没有返回值
    public void test2() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("hello");
    }

    @Test
    public void test3() {
        Consumer<String> consumer1 = (String s) -> System.out.println(s);
        consumer1.accept("java");
    }

    @Test
    // 数据类新可以省略，因为编译器可推断出，称为“类型推断“
    public void test4() {
        // 前面泛型是String,编译器可以推断出参数s也是String
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept("hello world");
    }

    @Test
    // 只需要一个参数时，参数的小括号可以省略
    public void test5() {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("hello world");
    }

    @Test
    // 需要2个或以上参数时,多条执行语句，并且可以有返回值时，以下写法
    public void test6() {
        Comparator<Integer> comparator = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1, o2);
        };
        int i = comparator.compare(10, 20);
        System.out.println(i);
    }

    @Test
    // 只包含一个语句,Lambda表达式不需要显式使用大括号 {} 来包裹操作,return 也省略
    public void test7() {
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);

        int i = comparator.compare(10, 20);
        System.out.println(i);
    }

}
