package com.pos.system.util;

import com.mysql.cj.util.StringUtils;
import com.pos.system.dto.Service_Board_DTO;
import com.pos.system.service.IService_Board_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ReadCount {

    private IService_Board_Service board_service;

    @Autowired
    public ReadCount(IService_Board_Service board_service) {
        this.board_service = board_service;
    }

    public int[] readCount(HttpServletRequest request, int board_seq){


        Cookie[] cookies = request.getCookies();
        Map mapCookie = new HashMap();

        if (request.getCookies() != null){
            for (int i = 0; i< cookies.length; i++){
                Cookie obj = cookies[i];
                mapCookie.put(obj.getName(), obj.getValue());
            }
        }

        String cookie_readCount = (String)mapCookie.get("read_count");
        String new_cookie_read_count = "|" + board_seq;

        if (StringUtils.indexOfIgnoreCase(cookie_readCount,new_cookie_read_count)==1){

        }



        return null;
    }
}
