package study.io;

import java.io.*;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/4/8 16:23
 */
public class IOTest {

    public static void main(String[] args) throws IOException {

        File file = new File("E://hh//kk.txt");
        File file2 = new File("E:\\hh\\a.txt");
        PrintWriter writer = new PrintWriter(file2);
        writer.print(3345345);
        writer.flush();
        writer.close();
        //OutputStream outputStream = new FileOutputStream(file);
        //OutputStream outputStream = new FileOutputStream("E:\\mm\\ss.txt");
        //InputStream inputStream = new FileInputStream(file);

    }

    protected String t1() {
        return "hhhh";
    }
}
