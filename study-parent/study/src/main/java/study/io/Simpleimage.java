package study.io;

import com.alibaba.simpleimage.ImageWrapper;
import com.alibaba.simpleimage.util.ImageReadHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/8/29 10:13
 */
public class Simpleimage {

    public static void main(String[] args) throws Exception {
        File image = new File("C:\\Users\\Administrator\\Desktop\\图片\\2.jpg");
        FileInputStream inputStream = new FileInputStream(image);
        File tragetimage = new File("C:\\Users\\Administrator\\Desktop\\图片\\222.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(tragetimage);


        ImageWrapper imageWrapper = ImageReadHelper.read(inputStream);

        int width = imageWrapper.getWidth();
        int height = imageWrapper.getHeight();

        System.out.println("width:"+width);
        System.out.println("height:"+height);

    }

}
