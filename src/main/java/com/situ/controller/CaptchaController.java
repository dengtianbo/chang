package com.situ.controller;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.captcha.ArithmeticCaptcha;

@Controller
public class CaptchaController {
    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	 
    	 HttpSession session = request.getSession();
    	// 算术类型
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(130, 48);
        captcha.setLen(3);  // 几位数运算，默认是两位
        captcha.getArithmeticString();  // 获取运算的公式：4-9+1=?
        String text = captcha.text();// 获取运算的结果：-4
        
        session.setAttribute("captcha", text);
        BufferedImage bi = new BufferedImage(100, 40, BufferedImage.TYPE_BYTE_GRAY);
        System.out.println("计算结果为："+text);
        // 输出验证码
        ServletOutputStream out = response.getOutputStream();
       captcha.out(out);
        // 写入到输出流
       ImageIO.write(bi, "jpg", out);
       try {
           out.flush();
       } finally {
           out.close();// 关闭
       }
    }
	
}
