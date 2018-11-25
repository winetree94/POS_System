package com.pos.system.service.impl;

import com.pos.system.dto.Service_Account_DTO;
import com.pos.system.dto.Service_Email_DTO;
import com.pos.system.mapper.Service_Account_Create_Mapper;
import com.pos.system.mapper.Service_Account_Delete_Mapper;
import com.pos.system.mapper.Service_Account_Read_Mapper;
import com.pos.system.mapper.Service_Account_Update_Mapper;
import com.pos.system.service.IService_Email_Service;
import com.pos.system.util.MailUtils;
import com.pos.system.util.TempKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

@Service
public class IService_Email_Service_Impl implements IService_Email_Service {

    @Autowired
    public JavaMailSender emailSender;

    private Service_Account_Create_Mapper mapper_Create;
    private Service_Account_Read_Mapper mapper_Read;
    private Service_Account_Update_Mapper mapper_Update;
    private Service_Account_Delete_Mapper mapper_Delete;

    public IService_Email_Service_Impl(Service_Account_Create_Mapper mapper_Create, Service_Account_Read_Mapper mapper_Read, Service_Account_Update_Mapper mapper_Update, Service_Account_Delete_Mapper mapper_Delete) {
        this.mapper_Create = mapper_Create;
        this.mapper_Read = mapper_Read;
        this.mapper_Update = mapper_Update;
        this.mapper_Delete = mapper_Delete;
    }




    public boolean insertAuthKey(Service_Email_DTO dto){
        int n = mapper_Create.insertAuthKey(dto);

        return n>0? true: false;
    }

    public boolean updateAuthStatus(Service_Email_DTO dto){
        int n = mapper_Update.updateAuthStatus(dto);
        return n>0? true: false;
    }

    public String selectAuthStatus(Service_Email_DTO dto){


        return mapper_Read.selectAuthStatus(dto);
    }



    public boolean create(Service_Email_DTO dto) {

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);


        String authkey = new TempKey().getKey(5, false);
        dto.setAuth_key(authkey);

        try {
            helper.setSubject("회원가입 이메일 인증");
            helper.setTo(dto.getService_email());
            helper.setText(new StringBuffer().append("[이메일 인증]")
                .append("인증코드를 회원가입 화면에서 입력해주세요")
                .append("인증키는")
                .append(authkey)
                .toString());
                helper.setFrom("youstarkio@gmail.com");
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        emailSender.send(message);
        return (mapper_Create.insertAuthKey(dto)>0)?true:false;

//        mapper_Create.insertAuthKey(dto);
//
//        String authkey = new TempKey().getKey(5, false);
//        dto.setAuth_key(authkey);
//
//        System.out.println("아아아아아아ㅏ아아앙아ㅏ앙아ㅏ");
//        System.out.println(dto);
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setSubject("회원가입 이메일 인증");
//        message.setText(new StringBuffer().append("<h1>[이메일 인증]</h1>")
//                .append("<p>아래에 인증코드를 로그인 화면에서 입력해주세요.</p>")
//                .append("<&authkey=")
//                .append("<h1>"+authkey+"</h1>")
//                .toString());
//        message.setFrom("youstarkio@gmail.com");
//        message.setTo(dto.getService_email());
//
//        System.out.println("-----------------------여기까지 된다.");
//        System.out.println("------------"+message);
//        emailSender.send(message);

     //   return (mapper_Create.insertAuthKey(dto)>0)?true:false;

    }







    public boolean updateAuthstatus(Service_Email_DTO dto) {
//인증키 입력시 auth_status y로 업데이트

        return (mapper_Update.updateAuthStatus(dto)>0)?true:false;
    }



    public String selectmaile(Service_Email_DTO dto) {
//인증키가 유효한지 검색하는 쿼리
// TODO Auto-generated method stub
        return mapper_Read.selectAuthStatus(dto);
    }

    public int deleteAuth(Service_Email_DTO dto){

        return mapper_Delete.deleteAuth(dto);
    }



    public boolean pwFind(Service_Account_DTO dto){
        String randompw = new TempKey().getKey(10, false);
        dto.setService_pw(randompw);

        System.out.println(dto);

        int n = mapper_Update.pwFind(dto);

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setSubject("비밀번호 변경");
            helper.setTo(dto.getService_email());
            helper.setText(new StringBuffer().append("[비밀번호 변경]")
                    .append("비밀번호가 다음과 같이 변경되었습니다")
                    .append("비밀번호는")
                    .append(randompw)
                    .toString());
            helper.setFrom("youstarkio@gmail.com");
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        emailSender.send(message);
        return true;
    }





}
