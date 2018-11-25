package com.pos.system.service;

import com.pos.system.dto.Service_Account_DTO;
import com.pos.system.dto.Service_Email_DTO;

public interface IService_Email_Service {


    public boolean insertAuthKey(Service_Email_DTO dto);

    public boolean create(Service_Email_DTO dto);

    public boolean updateAuthstatus(Service_Email_DTO dto);
    public int deleteAuth(Service_Email_DTO dto);

    public boolean pwFind(Service_Account_DTO dto);

}
