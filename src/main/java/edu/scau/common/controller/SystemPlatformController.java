package edu.scau.common.controller;

import com.github.pagehelper.PageHelper;
import edu.scau.common.Service.SystemPlatformService;
import edu.scau.common.pojo.SystemPlatform;
import edu.scau.common.utils.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @auther:cyf
 * @create:2020/6/24 12:31
 **/
@RestController
@RequestMapping("/systemPlatform")
public class SystemPlatformController {
    @Autowired
    private SystemPlatformService systemPlatformService;

    @PostMapping("/queryAllSystemPlatform")
    public ApiResponse queryAllSystemPlatform(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                              @RequestParam(value = "size", defaultValue = "10") Integer size) {

        PageHelper.startPage(page,size);
        List<SystemPlatform> systemPlatforms = systemPlatformService.selectAllSystemPlatform();
        if (systemPlatforms!=null){
            return new ApiResponse(0,"query success",systemPlatforms);
        }
        return new ApiResponse(-1,"serve error");
    }

//    @PostMapping("/updateSystemPlatform")
//    @ResponseBody
//    public ApiResponse updateSystemPlatform(HttpServletRequest req,
//                                            @RequestParam(value = "id") Integer id,
//                                            @RequestParam("systemName") String systemName,
//                                            @RequestParam("systemInfo") String systemInfo){
//        Part part = null;
//        try {
//            part = req.getPart("image");
//        } catch (ServletException | IOException e) {
//            return new ApiResponse(-1,"null");
//        }
//        return new ApiResponse(0,"success");
//    }
    @PostMapping("/deleteSystemPlatform")
    public ApiResponse deleteSystemPlatform(@RequestParam("id") Integer id){
        Integer result = systemPlatformService.deleteSystemPlatform(id);
        if (result>0){
            return new ApiResponse(0,"删除成功");
        }
        return new ApiResponse(-1,"服务器出错");
    }
}