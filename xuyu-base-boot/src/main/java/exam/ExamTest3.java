package exam;


import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个标准缓存类，支持定吋刷新、缓存列表先逬先出
 * @author zhaojinfeng
 * @create 2019-01-09 8:55 PM
 */
public class ExamTest3 {

    public static ListNode head = null;

    public static long lastFlushTime = System.currentTimeMillis();

    /**
     * 定时刷新数据源
     */
    public static List<Object> dataSource = new ArrayList<Object>();

    /**
     * 链表节点
     */
    static class ListNode{
        Object value;
        ListNode next;
        ListNode(Object param){
            value = param;
        }
    }

    public static void main(String[] args) {
        // 定时刷新
        Thread thread = new Thread(new Runnable() {
            public void run() {
                while(true){
                    long time = System.currentTimeMillis();
                    if(time - lastFlushTime > 3000000){
                        // 每五分钟刷新一次缓存
                        for(Object obj : dataSource){
                            put(obj);
                        }
                        // 刷新时间清零
                        lastFlushTime = time;
                    }
                }
            }
        });
        thread.start();
    }

    /**
     * 使用链表数据结构，依次往后存，取的时候从头取
     * @param param
     * @return
     */
    public static boolean put(Object param) {
        ListNode temp;
        if (head == null) {
            head = new ListNode(param);
            return true;
        } else {
            while (true) {
                temp = head;
                if (temp.next == null) {
                    head.next = new ListNode(param);
                }
            }
        }
    }

    /**
     * 取值时从头开始取，实现先进先出
     * @return
     */
    private Object get(){
        if(head == null){
            return null;
        } else{
            ListNode temp = head;
            head = head.next;
            return temp;
        }
    }
}
