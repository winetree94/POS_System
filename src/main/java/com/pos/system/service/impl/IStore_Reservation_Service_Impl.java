package com.pos.system.service.impl;

import com.pos.system.dto.Store_Reservation_DTO;
import com.pos.system.mapper.Store_Reservation_Create_Mapper;
import com.pos.system.mapper.Store_Reservation_Delete_Mapper;
import com.pos.system.mapper.Store_Reservation_Read_Mapper;
import com.pos.system.mapper.Store_Reservation_Update_Mapper;
import com.pos.system.service.IStore_Reservation_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IStore_Reservation_Service_Impl implements IStore_Reservation_Service {

    private Store_Reservation_Create_Mapper mapper_Create;

    private Store_Reservation_Read_Mapper mapper_Read;
    private Store_Reservation_Update_Mapper mapper_Update;
    private Store_Reservation_Delete_Mapper mapper_Delete;

    @Autowired
    public IStore_Reservation_Service_Impl(Store_Reservation_Create_Mapper mapper_Create, Store_Reservation_Read_Mapper mapper_Read, Store_Reservation_Update_Mapper mapper_Update, Store_Reservation_Delete_Mapper mapper_Delete) {
        this.mapper_Create = mapper_Create;
        this.mapper_Read = mapper_Read;
        this.mapper_Update = mapper_Update;
        this.mapper_Delete = mapper_Delete;
    }

    //전체조회
    public List<Store_Reservation_DTO> selectAll(int store_seq){
        return mapper_Read.selectAll(store_seq);
    }

    //예약 세부조회
    public Store_Reservation_DTO selectOne(Store_Reservation_DTO dto){
    return mapper_Read.selectOne(dto);
    }

    //예약 생성
    public int createReserv(Store_Reservation_DTO dto){
        return mapper_Create.createReserv(dto);

    }


    //예약 수정
    public Store_Reservation_DTO modifyReserv(Store_Reservation_DTO dto){
        int n = mapper_Update.updateReserv(dto);

        if(n>0){
            return mapper_Read.selectOne(dto);

        }
        return null;

    }

    //예약 삭제
    public int deleteReserv(Store_Reservation_DTO dto){
        return mapper_Delete.deleteReserv(dto);
    }




}
