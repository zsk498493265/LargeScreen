package com.organOld.outService.tool;

import org.apache.http.entity.ContentType;
import org.apache.poi.ss.usermodel.PictureData;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by joy12 on 2017/11/5.
 */
public class ImgUpload {
    public static int number=0;//多个照片上传时 容易导致 处理过快  在“同一时刻”生成 即 文件名的时间戳一样

    public static final String ROOT_PATH = "img/";

    /**
     * 表单上传的照片
     * @param file
     * @param request
     * @param childPath
     * @return
     * @throws IOException
     */
    //    路径规范 images/2012/9/25/1343287394783.jpg  按照时间戳+随机数来生成
    public static String uploadFile(MultipartFile file, HttpServletRequest request,String childPath) throws IOException {
//        String root_path="";
//        String rela_path=ROOT_PATH+childPath+"/";
//
//        root_path = request.getSession().getServletContext().getRealPath(rela_path);
//
//        Calendar now = Calendar.getInstance();
//        String path=root_path+"/"+now.get(Calendar.YEAR)+"/"+(now.get(Calendar.MONTH) + 1)+"/"+now.get(Calendar.DAY_OF_MONTH)+"/";
//        File tempFile = new File(path, new Date().getTime()+number+".jpg");
//        if (!tempFile.getParentFile().exists()) {
////            System.out.println(tempFile.getParentFile());
//            tempFile.getParentFile().mkdirs();
//        }
//        if (!tempFile.exists()) {
//            tempFile.createNewFile();
//        }
//        file.transferTo(tempFile);
//
//        number++;
//        if(number==10){
//            number=0;
//        }
//        return tempFile.getAbsolutePath();
        String name = OssClientUtil.uploadImg2Oss(file);
        String url = OssClientUtil.getImgUrl(name);
        return  url;
    }


    /**
     * Excel上传的照片
     * @throws IOException
     */
    public static Map<Integer,String> excelImg(Map<Integer, PictureData> mapPic,HttpServletRequest request,String childPath) throws IOException {
        Map<Integer,String> returnMap=new HashMap<>();


        String root_path="";
        String rela_path=ROOT_PATH+childPath+"/";

        root_path = request.getSession().getServletContext().getRealPath(rela_path);

            Object key[] = mapPic.keySet().toArray();
            for (int i = 0; i < mapPic.size(); i++) {
                // 获取图片流
                PictureData pic = mapPic.get(key[i]);
                // 获取图片索引
                Integer picIndex = (Integer) key[i];
                // 获取图片格式
                String ext = pic.suggestFileExtension();

                byte[] data = pic.getData();

                Calendar now = Calendar.getInstance();
                String path=root_path+now.get(Calendar.YEAR)+"/"+(now.get(Calendar.MONTH) + 1)+"/"+now.get(Calendar.DAY_OF_MONTH)+"/";
                String dateTime=new Date().getTime()+"";
                File tempFile = new File(path, dateTime+i+"."+ext);
                if (!tempFile.getParentFile().exists()) {
                    tempFile.getParentFile().mkdirs();
                }
                if (!tempFile.exists()) {
                    tempFile.createNewFile();
                }

                FileOutputStream out = new FileOutputStream(path+dateTime+i+"."+ext);
                out.write(data);
                out.close();
                FileInputStream fileInputStream = new FileInputStream(tempFile);
                MultipartFile multipartFile = new MockMultipartFile(tempFile.getName(), tempFile.getName(), ContentType.APPLICATION_OCTET_STREAM.toString(), fileInputStream);
                String name = OssClientUtil.uploadImg2Oss(multipartFile);
                String imgUrl = OssClientUtil.getImgUrl(name);
//                String absolute=path+dateTime+i+"."+ext;
//                int index = absolute.indexOf("img");
//                String picUrl= absolute.substring(index, absolute.length());
                returnMap.put(picIndex,imgUrl);
            }
        return returnMap;

    }
}
