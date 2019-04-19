package com.mail_register.controller;

import com.mail_register.model.ItripUser;
import com.mail_register.service.ImailService;
import com.mail_register.service.ItripUserService;
import com.mail_register.utils.PhoneUtil;
import com.mail_register.utils.RegisterUUID;
import com.mail_register.utils.SoutUtils;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Resource
    private ItripUserService itripUserService;
    @Resource
    private ImailService imailService;

    /***
     * 跳转到注册页面
     * @return
     */
    @RequestMapping("/registerHtml")
    public String registerHtml() {
        return "user/register";
    }

    /***
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/loginHtml")
    public String loginHtml(){
        return "user/login";
    }

    /***
     * 手机号注册
     * @param session
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/registerByPhone")
    public String registerByPhone(HttpSession session, HttpServletRequest request) {
        String userPhone = request.getParameter("usercode"); //手机号
        String userPassword = request.getParameter("userPassword"); //密码
        if(userPhone==""||userPassword==""){
            return "00"; //手机或密码为null
        }else {
            boolean b = itripUserService.registerAllUser(userPhone, userPhone,1, userPassword);
            if (b) {
                return "1"; //注册成功
            } else {
                return "0"; //注册失败
            }
        }
    }

    /***
     * 邮箱注册
     * @param session
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/registerByEmail")
    public String registerUser(HttpSession session, HttpServletRequest request) {
        String userEmail = request.getParameter("usercode"); //邮箱
        String userPassword = request.getParameter("userPassword"); //密码
        if(userEmail==""||userPassword==""){
            return "00"; //邮箱或密码为null
        }else {
            boolean b = itripUserService.registerAllUser(userEmail, userEmail,1, userPassword);
            if (b) {
                return "1"; //注册成功
            } else {
                return "0"; //注册失败
            }
        }
    }

    /***
     * 发送邮件
     * @param session
     * @param request
     * @param userEmail
     * @return
     */
    @ResponseBody
    @RequestMapping("/getEmailUUID")
    public String getEmailUUID(HttpSession session, HttpServletRequest request,
                          @RequestParam(value = "usercode", required = false) String userEmail) {
        String uuid = RegisterUUID.getEmailUUID(); //获取状态码
        boolean bool = imailService.sendHtmlMail(userEmail, "主题:来自喻根全公司的激活邮件", "尊敬的用户:您的注册激活码是:" + uuid + "感谢使用本公司系统哦!");
        if (bool == true) {
            return uuid;
        } else {
            return null;
        }
    }

    @ResponseBody
    @RequestMapping("/getPhoneUUID")
    public String getPhoneUUID(HttpSession session,HttpServletRequest request,
                               @RequestParam(value = "usercode", required = false) String userPhone){
        Integer phone = RegisterUUID.getPhoneUUID();
        String phoneUUID=phone.toString();
        HttpResponse phoneUtils = PhoneUtil.getPhoneUtils(userPhone, phoneUUID);
        if(phoneUtils.toString()!=""){
            return phoneUUID;
        }else {
            return "";
        }
    }

    /****
     * 一个邮箱或者手机号只能注册一个用户
     * @param session
     * @param usercode
     * @return
     */
    @ResponseBody
    @RequestMapping("/AddFormByAjax")
    public boolean AddFormByAjax(HttpSession session,
                                 @RequestParam(value = "usercode", required = false) String usercode) {
        return itripUserService.findByUserCode(usercode);
    }


    @ResponseBody
    @RequestMapping("user/login")
    public String login(HttpServletRequest request,HttpSession session){
        String usercode = request.getParameter("usercode"); //邮箱
        String userPassword = request.getParameter("userPassword"); //密码
        if(usercode==""||userPassword==""){
            return "00";
        }else{
            ItripUser login = itripUserService.login(usercode, userPassword);
            if(login!=null){
                session.setAttribute("User",login);
                return "1";
            }else {
                return "0";
            }
        }
    }
}
