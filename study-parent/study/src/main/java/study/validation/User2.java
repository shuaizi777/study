package study.validation;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/8/30 15:22
 */
public class User2 {

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
