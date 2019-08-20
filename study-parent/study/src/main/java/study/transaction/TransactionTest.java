package study.transaction;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/8/19 15:26
 */
@Transactional
@RestController
public class TransactionTest {

    @Resource
    AccountInfoMapper accountInfoMapper;

    @RequestMapping("/save")
    public String save() {
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccount(9502);
        accountInfo.setMoney(1000);
        Integer affectedRows = accountInfoMapper.insert(accountInfo);
        int a = 4/0;
        return affectedRows.toString();
    }

}
