package edu.scau.common.Service.impl;

import edu.scau.common.Service.ImageService;
import edu.scau.common.pojo.Picture;
import edu.scau.common.utils.MyUtil;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @description:
 * @auther:cyf
 * @create:2020/6/24 17:05
 **/
@Service
public class ImageServiceImpl implements ImageService{

    @Override
    public void get(String folder, HttpServletResponse resp,String name) throws IOException {
        File file = new File(MyUtil.URL_HEAD, "/images/" + folder + "/"+name);
        FileInputStream is = new FileInputStream(file);
        OutputStream os = resp.getOutputStream();
        byte[] buffer = new byte[1024 * 5];
        //读取图片
        while ((is.read(buffer)) != -1) {
            os.write(buffer);
        }
        is.close();
        os.close();
    }

    @Override
    public Picture save(String oldName, InputStream inputStream) throws IOException {
        String suffix = oldName.substring(oldName.lastIndexOf("."));// 获取文件后缀名
        BufferedInputStream is = new BufferedInputStream(inputStream);// 用BufferedInputStream封装网络流，使其可以复用（reset）

        String fileName;
        is.mark(is.available() + 1);//标记流以复用
        fileName = MyUtil.saveFile(is, "/images/" , suffix);//保存文件
        is.reset();//重置流，复用

        //获取图片宽、高、url
        BufferedImage image = ImageIO.read(is);
        Picture pic = new Picture(MyUtil.fileUrl("image/get/",  fileName), image.getWidth(), image.getHeight());
        is.close();
        return pic;
    }

    @Override
    public void del(String[] urls) {
        File image;
        String[] temp;
        String folder;
        String name;
        int len = urls.length;
        for (int i = 0; i < len; i++) {
            //解析url
            temp = urls[i].split("&");
            folder = temp[0].substring(temp[0].indexOf("=") + 1);
            name = temp[1].substring(temp[1].indexOf("=") + 1);
            image = new File(MyUtil.URL_HEAD, "images/" + folder + "/" + name);
            //如果图片存在则删除
            if (image.exists()) {
                image.delete();
            }
        }
    }
}
