package demo04.bx_cha.Optional;

/**
 * @author bx_cha
 * @version 1.0
 */

import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * - Optional.of(T t) 创建一个Optional实例 t必须非空
 * - Optional.empty() 创建一个空的Optional实例
 * - Optional.ofNullable(T t)t可以为null
 */

// Optional 是 Java 中的一个类，用于处理可能为null的值，以避免空指针异常
public class demo01_Optional {

    // 创建
    @Test
    public void test() {
        Girl girl = new Girl();
        girl = null;

        // Optional.of(T t) 创建一个Optional实例 t必须非空
        Optional<Girl> optionalGirl = Optional.of(girl);
    }

    @Test
    public void test2() {
        Girl girl = new Girl();
        girl = null;

        // Optional.ofNullable(T t)t可以为null
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
    }

    // 普通方法，返回女孩名字
    public String getGirlName(Boy boy) {
        return boy.getGirl().getName();
    }

    @Test
    public void test3() {

        Boy boy = new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    // 优化普通方法，返回女孩名字
    public String getGirlName2(Boy boy) {
        if (boy != null && boy.getGirl() != null) {
            return boy.getGirl().getName();
        }
        return null;
    }

    @Test
    public void test4() {

        Boy boy = new Boy();
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }


    // 使用Optional 优化普通方法，返回女孩名字
    public String getGirlName3(Boy boy) {
        // T orElse(T other) 如果有值就将其返回，否则返回指定的other对象

        Optional<Boy> optionalBoy = Optional.ofNullable(boy);
        Boy boy1 = optionalBoy.orElse(new Boy(new Girl("xiaoFang")));// 此时boy1一定非空

        Girl girl1 = boy1.getGirl();

        Optional<Girl> optionalGirl = Optional.ofNullable(girl1);
        Girl girl2 = optionalGirl.orElse(new Girl("xiaoMei"));// 此时girl2一定非空
        return girl2.getName();
    }

    @Test
    public void test5() {

        Boy boy = new Boy();//Boy的Girl是null
        String girlName = getGirlName3(boy);
        System.out.println(girlName);


        Boy boy2 = new Boy(new Girl("xiaoHua"));//Boy的Girl不为null
        String girlName2 = getGirlName3(boy2);
        System.out.println(girlName2);
    }
}
