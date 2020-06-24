package edu.scau.common.Service.impl;

import edu.scau.common.Service.SystemPlatformService;
import edu.scau.common.mapper.SystemPlatformMapper;
import edu.scau.common.pojo.SystemPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @auther:cyf
 * @create:2020/6/24 12:31
 **/
@Service
public class SystemPlatformServiceImpl implements SystemPlatformService {
    @Autowired
    private SystemPlatformMapper systemPlatformMapper;
    @Override
    public List<SystemPlatform> selectAllSystemPlatform() {
        return systemPlatformMapper.selectAllSystemPlatform();
    }

    @Override
    public Integer insertSystemPlatform(SystemPlatform systemPlatform) {

        return systemPlatformMapper.insertSystemPlatform(systemPlatform);
    }

    @Override
    public Integer updateSystemPlatform(SystemPlatform systemPlatform) {
        return systemPlatformMapper.updateSystemPlatform(systemPlatform);
    }

    @Override
    public Integer deleteSystemPlatform(Integer id) {
        return systemPlatformMapper.deleteSystemPlatform(id);
    }
}
