package com.pos.system.service;

import com.pos.system.dto.Store_Table_DTO;

import java.util.List;

public interface IStore_Table_Service {


    public List<Store_Table_DTO> selectAll(int store_seq);
    public Store_Table_DTO selectOne(int table_seq);
    public int createTable(Store_Table_DTO dto);
    public Store_Table_DTO modifyTable(Store_Table_DTO dto);
    public int deleteTable(int table_seq);

}
