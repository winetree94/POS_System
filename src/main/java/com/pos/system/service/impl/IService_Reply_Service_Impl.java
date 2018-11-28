package com.pos.system.service.impl;

import com.pos.system.dto.Service_Board_DTO;
import com.pos.system.mapper.Service_Reply_Create_Mapper;
import com.pos.system.service.IService_Reply_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IService_Reply_Service_Impl implements IService_Reply_Service {

    private final Service_Reply_Create_Mapper mapper_Create;

    @Autowired
    public IService_Reply_Service_Impl(Service_Reply_Create_Mapper mapper_Create) {
        this.mapper_Create = mapper_Create;
    }

    @Override
    public int updateReply(int board_seq) {
        return mapper_Create.updateReply(board_seq);
    }

    @Override
    public int insertReply(Service_Board_DTO dto) {
        return mapper_Create.insertReply(dto);
    }
}
