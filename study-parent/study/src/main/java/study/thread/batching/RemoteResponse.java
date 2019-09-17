package study.thread.batching;

import java.io.Serializable;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/9/15 09:07
 */
public class RemoteResponse implements Serializable {

    private static final long serialVersionUID = -6688055690804654081L;

    String name;

    String password;

    @Override
    public String toString() {
        return "RemoteResponse{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                '}';
    }

    String serialNumber;


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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
