package com.mail_register.demo;

import com.mail_register.service.ImailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    /***
     * 注入发送邮件接口
     */
    @Autowired
    private ImailService imailService;

    @Test
    public void sendmail() {
        imailService.sendSimpleMail("1787593244@qq.com", "主题：肖鹏", "内容：哈哈哈哈");
    }

    @Test
    public void sendmailHtml() {
        imailService.sendHtmlMail("1787593244@qq.com", "主题：你好html邮件", "<h1>内容：我是喻根全</h1>");
    }

}
