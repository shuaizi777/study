package study.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/8/20 10:32
 */
public class UserDTO extends BaseRowModel {

    @ExcelProperty(value = "姓名",index = 0)
    private String name;

    @ExcelProperty(value = "密码",index = 1)
    private String password;

    @ExcelProperty(value = "年龄",index = 2)
    private Integer age;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
