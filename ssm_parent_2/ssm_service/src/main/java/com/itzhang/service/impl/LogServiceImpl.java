package com.itzhang.service.impl;

import com.itzhang.dao.LogDao;
import com.itzhang.domain.SysLog;
import com.itzhang.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public void saveLog(SysLog sysLog) {
        logDao.saveLog(sysLog);
    }
}
