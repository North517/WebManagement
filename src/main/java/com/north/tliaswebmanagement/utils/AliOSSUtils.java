package com.north.tliaswebmanagement.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.UUID;

/**
 * 阿里云 OSS 工具类
 */
@Component
public class AliOSSUtils {
    /*
    value注入,Value只能一个一个的将对象从外部注入
     */
//    @Value("${aliyun.oss.endpoint}")
//    private String endpoint ;
//    @Value("${aliyun.oss.accessKeyId}")
//    private String accessKeyId;
//    @Value("${aliyun.oss.accessKeySecret}")
//    private String accessKeySecret;
//    @Value("${aliyun.oss.bucketName}")
//    private String bucketName;




    /*
    ConfigurationProperties自动注入,ConfigurationProperties所以一下子批量从外部注入
    */
    @Autowired
    private AliOSSProperties aliyOSSProperties;


    /**
     * 实现上传图片到OSS
     */
    public String upload(MultipartFile file) throws IOException {

        //ConfigurationProperties注入后，没有方法，需要获取
        //获取阿里云OSS参数
        String endpoint = aliyOSSProperties.getEndpoint();
        String accessKeyId = aliyOSSProperties.getAccessKeyId();
        String accessKeySecret = aliyOSSProperties.getAccessKeySecret();
        String bucketName = aliyOSSProperties.getBucketName();


        // 获取上传的文件的输入流
        InputStream inputStream = file.getInputStream();

        // 避免文件覆盖
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));

        //上传文件到 OSS
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, fileName, inputStream);

        //文件访问路径
        String url = "https://"+ bucketName + "." + endpoint.split("//")[1] + "/" + fileName;
        // 关闭ossClient
        ossClient.shutdown();
        return url;// 把上传到oss的路径返回
    }

}
