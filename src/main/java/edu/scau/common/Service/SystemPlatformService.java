package edu.scau.common.Service;

import edu.scau.common.pojo.SystemPlatform;

import java.util.List;

/**
 * @description:
 * @auther:cyf
 * @create:2020/6/24 12:31
 **/
public interface SystemPlatformService {
    List<SystemPlatform> selectAllSystemPlatform();

    Integer insertSystemPlatform(SystemPlatform systemPlatform);

    Integer updateSystemPlatform(SystemPlatform systemPlatform);

    Integer deleteSystemPlatform(Integer id);

}
