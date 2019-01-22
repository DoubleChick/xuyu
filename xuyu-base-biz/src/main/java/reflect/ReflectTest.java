package reflect;


import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * 反射练习题
 *
 * @author zhaojinfeng
 * @create 2019-01-08 7:07 PM
 */
public class ReflectTest {

    public Integer age = 0;

    private Integer privateAge = 12;


    ReflectTest() {

    }

    public Integer getAge() {
        return age;
    }

    private Integer getPrivateAge() {
        return privateAge;
    }

    /**
     * 判断一个对象的类
     *
     * @param obj
     * @return
     */
    public static Class judgeObjectClass(Object obj) throws Exception {
        Class clazz = obj.getClass();
        String clazzName = clazz.getName();
        return Class.forName(clazzName);
    }

    /**
     * 构造一个类的对象
     *
     * @param clazz
     * @return
     */
    public static ReflectTest buildReflectTest(Class<ReflectTest> clazz) throws Exception{
        ReflectTest reflectTest = clazz.newInstance();
        System.out.println(reflectTest.getAge());
        return reflectTest;
    }

    /**
     * 打印出一个类的所有成员变量和方法
     *
     * @param clazz
     */
    public static void soutFieldsAndMethods(Class clazz){
        Field[] fieldArray = clazz.getDeclaredFields();
        // 成员变量
        for(Field field : fieldArray){
            System.out.println(String.format("fieldType:%s,fieldName:%s",field.getType().getName()
            ,field.getName()));
        }

        // 方法
        Method[] methodArray = clazz.getDeclaredMethods();
        for(Method method : methodArray){
            System.out.println(String.format("methodName:%s,methodAccess:%s,methodArgs;%s"
            ,method.getName()
            ,method.isAccessible()
            ,method.getParameters().toString()));
        }

    }

    /**
     * 调用对象的任意方法
     * @param obj
     * @throws Exception
     */
    public static void invokeMethod(Object obj) throws Exception{
        //  修改私有变量值
        Field field = obj.getClass().getDeclaredField("privateAge");
        field.setAccessible(true);
        field.set(obj,13);
        // 调用私有方法
        Method method = obj.getClass().getDeclaredMethod("getPrivateAge",null);
        method.setAccessible(true);
        System.out.println(method.isAccessible());
        Integer result = (Integer) method.invoke(obj,null);
        System.out.println(result);
    }

    /**
     * 获取父类信息
     *
     * @param obj
     */
    public static void getParentClassInfo(Object obj){
        // 获取父类信息
        Class clazz = obj.getClass().getSuperclass();
        System.out.println(clazz);
    }


    public static void main(String[] args) throws Exception {
//        System.out.println(judgeObjectClass(new ReflectTest()));
//        buildReflectTest(ReflectTest.class);
//        soutFieldsAndMethods(ReflectTest.class);
//        invokeMethod(new ReflectTest());
        getParentClassInfo(new ReflectTest());
    }
}
