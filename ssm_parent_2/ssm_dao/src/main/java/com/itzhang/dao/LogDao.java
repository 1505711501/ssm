package com.itzhang.dao;

import com.itzhang.domain.SysLog;
import org.apache.ibatis.annotations.Insert;

public interface LogDao {


    @Insert("insert into sys_log values(com_sequence.nextval,#{visitTime},#{username}," +
            "#{ip},#{method},#{executeResult},#{executeMsg},#{executeTime})")
    public void saveLog(SysLog log);
}
