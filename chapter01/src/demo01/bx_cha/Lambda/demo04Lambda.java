package demo01.bx_cha.Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author bx_cha
 * @version 1.0
 * java 内置的函数式接口
 * Consumer、Supplier、Function、Predicate
 * <p>
 * `Consumer` 消费性接口
 * `Supplier` 供给型接口
 * `Function` 函数式接口
 * `Predicate` 断定型接口
 */
public class demo04Lambda {
    @Test
    public void test1() {
        happyTime(200, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("happyTime1 花费了" + aDouble);
            }
        });
    }

    @Test
    public void test2() {
        happyTime(200, money -> System.out.println("happyTime2 花费了" + money));
    }

    @Test
    public void test3() {

        List<String> list = Arrays.asList(null, "abc", "12", "hello", "world", "我爱学java");
        // List<String> list = new ArrayList<String>();
        // list.add(null);
        // list.add("abc");
        // list.add("12");
        // list.add("hello");
        // list.add("world");
        // list.add("我爱学java");

        List<String> fliterList = fliterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s != null && s.length() > 4;
            }
        });
        System.out.println(fliterList);
    }

    @Test
    public void test4() {
        List<String> list = Arrays.asList(null, "abc", "12", "hello", "world", "我爱学java");

        List<String> fliterString = fliterString(list, s -> s != null && s.length() > 4);
        System.out.println(fliterString);
    }

    public void happyTime(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    // 过滤字符串 使用Predicate断定型接口，
    public List<String> fliterString(List<String> list, Predicate<String> predicate) {
        // 过滤字符串list
        ArrayList<String> fliterList = new ArrayList<String>();

        for (String s : list) {
            // 对原先list遍历，使用predicate.test()方法，判断，如果成立，fliterList.add(s)
            if (predicate.test(s)) {// test()具体规则，看接口实现类是如何写的
                fliterList.add(s);
            }
        }
        // 返回fliterList
        return fliterList;
    }
}
