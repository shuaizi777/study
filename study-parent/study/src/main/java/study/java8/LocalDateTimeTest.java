package study.java8;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/8/16 15:43
 */
public class LocalDateTimeTest {

    public  void test(Object t) {

    }

    public static void main(String[] args) {

        Date date = new Date(System.currentTimeMillis());

        System.out.println("******************************");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        LocalDateTime arrivalDate  = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        try {
               DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            arrivalDate = LocalDateTime.parse("2019-02-03 13:12:23", format);
                String landing = arrivalDate.format(format);
                System.out.println(arrivalDate);
            }catch (DateTimeException ex) {
                System.out.printf("%s can't be formatted!%n", arrivalDate);
                ex.printStackTrace();
            }
    }
}
