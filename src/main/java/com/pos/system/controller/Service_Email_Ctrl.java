package com.pos.system.controller;

import com.pos.system.dto.Service_Account_DTO;
import com.pos.system.dto.Service_Email_DTO;
import com.pos.system.service.IService_Account_Service;
import com.pos.system.service.IService_Email_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/email")
@Controller
public class Service_Email_Ctrl {

    private final IService_Email_Service service;
    private final IService_Account_Service service2;
    @Autowired
    public Service_Email_Ctrl(IService_Email_Service service, IService_Account_Service service2) {

        this.service = service;
        this.service2 = service2;
    }


    @PostMapping("/sendemail")
    @ResponseBody
    public String sendEmail(Service_Email_DTO dto, String service_email){
        System.out.println(service_email);
        dto.setAuth_key(service_email);
        dto.setService_email(service_email);
        service.create(dto);
        System.out.println("이메일이 발송되었습니다");
        return "이메일이 발송되었습니다. 인증키를 입력해주세요.";
    }

    @PostMapping("/confirmemail")
    @ResponseBody
    public String confirmEmail(Service_Email_DTO dto){
        System.out.println(dto);
            boolean isc  =service.updateAuthstatus(dto);
            if(isc){
                service.deleteAuth(dto);
                return "성공";
            }else{
                return "실패";
            }
    }



    @PostMapping("/pwfindcheck")
    @ResponseBody
    public String pwFindCheck(Service_Account_DTO dto){
        System.out.println(dto);
        int n = service2.emailDuplicate(dto.getService_email());

        if(n>0){
            boolean isc = service.pwFind(dto);
            return isc? "성공":"실패";
        }else{
            return "없음";
        }


    }

    @PostMapping("/pwfind")
    public String pwFind(Service_Account_DTO dto){


            return "/WEB-INF/view/account/loginform.jsp";


    }




}
