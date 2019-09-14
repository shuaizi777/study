package study.validation;

import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/8/30 14:09
 */

@Valid
public  class ValidationTest {


    public static void main(String[] args) {
        ValidationTest validationTest = new ValidationTest();
        User user = new User();
        // t1(user);
        User2 user2 = new User2();
        validationTest.t1(user2);
    }

    public  void t1(@Valid User2 user2) {

    }


    public static class User {

        @NotBlank(message = "name不能为空")
        @Length(min = 1, max = 10)
        private String name;

        @NotBlank
        @Length(min = 6, max = 16)
        private String password;

        @NotNull
        private Short age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Short getAge() {
            return age;
        }

        public void setAge(Short age) {
            this.age = age;
        }
    }

}
