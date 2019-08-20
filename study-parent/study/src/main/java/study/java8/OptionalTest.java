package study.java8;

import java.util.Optional;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/6/1 17:49
 */
public class OptionalTest
{
    private String name;
    private String phone;


    public static void main(String[] args) {
        OptionalTest optionalTest = new OptionalTest();
        optionalTest.setName("zhongzhen");
        optionalTest.setPhone("123456");
        optionalTest = null;
        Optional<OptionalTest> optional = Optional.ofNullable(optionalTest);
        String name = optional.flatMap(opti -> Optional.ofNullable(opti.getName())).orElse("hhhh");
        System.out.println(name);

    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
