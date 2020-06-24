package edu.scau.common.utils;



import org.springframework.boot.system.ApplicationHome;

import java.io.*;
import java.util.Random;

/**
 * @author czh
 * @date 2020/4/8 21:57
 */
public class MyUtil {
    public static String URL_HEAD="http://8.129.172.254";
    /**
     * 存储网络流中图片（注意：未关闭输入流，以便复用）
     * @param is 网络流
     * @param pathName 存储路径
     * @param suffix 文件后缀名
     * @return 返回存储的文件名
     * @throws IOException
     */
    public static String saveFile(InputStream is, String pathName, String suffix) throws IOException {
        Random random = new Random();
        String name = random.nextInt() + "-" + System.currentTimeMillis() + suffix;// 生成随机文件名

        //存储路径：jar包所在文件夹下
        File path = new File((new ApplicationHome()).getDir(), pathName);

        //如果不存在则创建路径
        if (!path.exists()) {
            path.mkdirs();
        }

        //创建文件
        File file = new File(path, name);
        file.createNewFile();
        OutputStream os = new FileOutputStream(file);//流方式存储

        byte[] buffer = new byte[1024 * 5];
        while ((is.read(buffer)) != -1) {
            os.write(buffer);
            os.flush();
        }
        os.close();
        return name;
        //不关闭输入流，需在外部处理
    }

    /**
     * 生成文件url
     * @param controller 取出文件经由的controller
     * @param folder 所在文件夹
     * @param fileName 文件名
     * @return 获取文件的url
     */
    public static String fileUrl(String controller, String folder, String fileName) {
        return URL_HEAD + controller + "?folder=" + folder + "&name=" + fileName;
    }

    /**
     * 参数校验
     * @param params 需要校验的参数
     * @throws NullParameterException 返回校验参数表第几个参数为空的异常信息
     */
    public static void vertifyParams(Object... params) throws NullParameterException {
        int len = params.length;
        for (int i = 0; i < len; i++) {
            if (params[i] == null) {
                throw new NullParameterException("params[" + i + "] is null");
            }
        }
    }
}
