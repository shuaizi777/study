package study.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/4/8 16:23
 */
public class IOTest {

    public static void main(String[] args) throws IOException {
        File file = new File("E://hh//kk.txt");
        File file2 = new File("E:\\hh\\kk.txt");
        OutputStream outputStream = new FileOutputStream(file);
        //OutputStream outputStream = new FileOutputStream("E:\\mm\\ss.txt");
        //InputStream inputStream = new FileInputStream(file);

    }

    protected String t1() {
        return "hhhh";
    }
}
