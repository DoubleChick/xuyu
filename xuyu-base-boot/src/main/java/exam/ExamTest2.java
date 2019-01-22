package exam;

import java.util.ArrayList;
import java.util.List;

/**
 * 2.实现函数,给定一个字符串数组,求该数组的   连续   非空子集，分別打印出来各子集 ，举例数组为[abc]，输出[a],[b],[c],[ab],[bc],[abc]
 *
 * @author zhaojinfeng
 * @create 2019-01-09 8:46 PM
 */
public class ExamTest2 {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        childCollection1(stringList);
    }

    public static void childCollection1(List<String> param) {
        int childCollectionSize = 1;
        while (childCollectionSize < param.size() + 1) {
            List<String> temp = new ArrayList<String>();
            for (int i = 0; i < param.size(); i++) {
                for (int j = 0; j < childCollectionSize; j++) {
                    if ((i + j) < param.size()) {
                        temp.add(param.get(i + j));
                    }
                }
                if (temp.size() == childCollectionSize) {
                    printList(temp);
                }
                temp = new ArrayList<String>();
            }
            childCollectionSize++;
        }
    }

    public static void printList(List<String> param) {
        StringBuilder sb = new StringBuilder();
        for (String s : param) {
            sb.append(s);
        }
        System.out.println(sb.toString());
    }
}
