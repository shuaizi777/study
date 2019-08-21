package study.excel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/8/20 10:36
 */
@RestController
public class ExcelTest {

    @GetMapping("/readExcel")
    public String readExcel() throws Exception {
        InputStream inputStream = new FileInputStream("E:\\test.xlsx");
        List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 0));
        inputStream.close();
        return data.toString();
    }

    @GetMapping("/getUserWithExcel")
    public Boolean getUserWithExcel() {
        // 文件输出位置
        OutputStream out = null;
        try {
            out = new FileOutputStream("E:\\test.xlsx");
            ExcelWriter writer = EasyExcelFactory.getWriter(out);

            // 写仅有一个 Sheet 的 Excel 文件, 此场景较为通用
            Sheet sheet1 = new Sheet(1, 0, UserDTO.class);

            // 第一个 sheet 名称
            sheet1.setSheetName("第一个sheet");

            // 写数据到 Writer 上下文中
            // 入参1: 数据库查询的数据list集合
            // 入参2: 要写入的目标 sheet
            writer.write(getAllUser(), sheet1);
            // 将上下文中的最终 outputStream 写入到指定文件中
            writer.finish();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                // 关闭流
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Boolean.TRUE;
    }


    public List<UserDTO> getAllUser(){
        List<UserDTO> userList = new ArrayList<>();
        for (int i=0;i<100;i++){
            UserDTO userDTO = new UserDTO();
            userDTO.setName("陈帅"+i);
            userDTO.setPassword("123456");
            userDTO.setAge(22);
            userList.add(userDTO);
        }
        return userList;
    }

}
