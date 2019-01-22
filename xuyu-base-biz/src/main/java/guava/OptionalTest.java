package guava;


import com.google.common.base.Optional;

/**
 * @author zhaojinfeng
 * @create 2019-01-08 9:59 AM
 */
public class OptionalTest {

    public static void main(String[] args) {
        // 感觉没啥用啊
        Integer value1 = null;
        Integer value2 = 10;
        Optional<Integer> a = Optional.fromNullable(value1);
        Optional<Integer> b = Optional.of(value2);
        System.out.println(a.isPresent());
        System.out.println(b.isPresent());
    }
}
