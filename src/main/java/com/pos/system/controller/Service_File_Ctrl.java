package com.pos.system.controller;

import com.pos.system.dto.Service_File_DTO;
import com.pos.system.service.IService_File_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Service_File_Ctrl {

    private final IService_File_Service service;

    @Autowired
    public Service_File_Ctrl(IService_File_Service service) {
        this.service = service;
    }

    public int uploadFile(Service_File_DTO dto) {
        return service.uploadFile(dto);
    }

    public int deleteFile(int file_seq) {
        return service.deleteFile(file_seq);
    }
}
