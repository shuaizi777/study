package study.thread;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/8/14 08:51
 */
public class Student {


    public static void main(String[] args) {
        Object []obj=(Object[])null;
        System.out.println(obj);
    }

    private String age;

    private String name;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
