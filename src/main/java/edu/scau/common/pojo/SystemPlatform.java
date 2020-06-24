package edu.scau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @auther:cyf
 * @create:2020/6/24 12:25
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemPlatform {

    private Integer id;
    /**
     * 系统图标
     */
    private String icon;
    /**
     * 系统名称
     */
    private String systemName;
    /**
     * 系统资料
     */
    private String systemInfo;

}
