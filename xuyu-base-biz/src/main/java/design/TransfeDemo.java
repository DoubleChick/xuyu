package design;

import java.math.BigDecimal;

/**
 * 转账demo
 *
 * @author zhaojinfeng
 * @create 2019-01-08 11:20 PM
 */
public class TransfeDemo {

    public static void main(String[] args) {
        BigDecimal value = new BigDecimal("210.54");
        System.out.println(value);

        BigDecimal value2 = new BigDecimal("100");

        System.out.println(value.subtract(value2));
    }
}
