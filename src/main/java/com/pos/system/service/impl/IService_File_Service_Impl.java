package com.pos.system.service.impl;

import com.pos.system.dto.Service_File_DTO;
import com.pos.system.mapper.Service_File_Create_Mapper;
import com.pos.system.mapper.Service_File_Delete_Mapper;
import com.pos.system.mapper.Service_File_Read_Mapper;
import com.pos.system.service.IService_File_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IService_File_Service_Impl implements IService_File_Service {

    private final Service_File_Create_Mapper mapper_Create;
    private final Service_File_Delete_Mapper mapper_Delete;
    private final Service_File_Read_Mapper mapper_Read;

    @Autowired
    public IService_File_Service_Impl(Service_File_Create_Mapper mapper_Create, Service_File_Delete_Mapper mapper_Delete, Service_File_Read_Mapper mapper_read) {
        this.mapper_Create = mapper_Create;
        this.mapper_Delete = mapper_Delete;
        this.mapper_Read = mapper_read;
    }

    @Override
    public int uploadFile(Service_File_DTO dto) {
        return mapper_Create.uploadFile(dto);
    }

    @Override
    public int deleteFile(int board_seq) {
        return mapper_Delete.deleteFile(board_seq);
    }

    @Override
    public Service_File_DTO selectOneFile(int board_seq) {
        return mapper_Read.selectOneFile(board_seq);
    }
}
