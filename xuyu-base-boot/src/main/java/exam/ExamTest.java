package exam;


/**
 * @author zhaojinfeng
 * @create 2019-01-09 8:27 PM
 * 1：实现两个线程，使之交替打印1-100,如：两个线程分别为：Printer1和Printer2,最后输出结果为： Printer1 — 1 Printer2 一 2 Printer1 一 3 Printer2 一 4
 */
public class ExamTest {

    public static volatile int num = 1;

    public static int state = 1;

    public static void main(String[] args) {
        Thread Printer1 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    if (num < 101) {
                        if (state == 1) {
                            System.out.println("Printer1 - " + num);
                            num++;
                            state = 2;
                        }
                    }
                }
            }
        });
        Printer1.start();

        Thread Printer2 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    if (num < 101) {
                        if (state == 2) {
                            System.out.println("Printer2 - " + num);
                            num++;
                            state = 1;
                        }
                    }
                }
            }
        });
        Printer2.start();
    }
}
