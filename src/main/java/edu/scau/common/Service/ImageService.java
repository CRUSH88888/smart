package edu.scau.common.Service;

import edu.scau.common.pojo.Picture;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @auther:cyf
 * @create:2020/6/24 17:04
 **/
public interface ImageService {
    /**
     * 获取服务器图片
     * @param folder 图片所在文件路径
     * @param resp 通过resp的outputstream返回图片
     * @throws IOException
     */
    void get(String folder, HttpServletResponse resp,String name) throws IOException;


    /**
     * 保存用户上传图片
     * @param inputStream 网络流
     * @return
     * @throws IOException
     */
    Picture save(String oldName, InputStream inputStream) throws IOException;

    /**
     * 批量删除服务器图片
     * @param urls 需要删除图片的url数组
     */
    void del(String[] urls);

}
