package edu.scau.common.mapper;

import edu.scau.common.pojo.SystemPlatform;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:
 * @auther:cyf
 * @create:2020/6/24 15:25
 **/
@Mapper
public interface SystemPlatformMapper {

    List<SystemPlatform> selectAllSystemPlatform();

    Integer insertSystemPlatform(SystemPlatform systemPlatform);

    Integer updateSystemPlatform(SystemPlatform systemPlatform);

    Integer deleteSystemPlatform(Integer id);



}
