package com.atguigu.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //������ʶ��HelloWorld��Ϊ����������springmvc����handler����������������
public class HelloWorld {
    /**
     * 1��ʹ��@RequestMappingע����ӳ�������URL
     * 2������ֵ��ͨ����ͼ����������Ϊʵ�ʵ�������ͼ:����InternalResourceViewResolver��ͼ���������������½�����
     *    ͨ��prefix+returnvel+��׺�����ķ�ʽ�õ�ʵ�ʵ�������ͼ��Ȼ��ת��
     *    /WEB-INF/pages/success.jsp
     * @return
     */
    @RequestMapping("/helloworld")
    public String hello() {
        System.out.println("HelloWorld");
        return "success";
    }
}