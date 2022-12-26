package com.yxj.gulimall.thirdparty;

import com.aliyun.oss.OSSClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
public class GulimallThirdPartyApplicationTest {
    @Autowired
    OSSClient ossClient;

    @Test
    public void test() throws FileNotFoundException {
        // 上传文件流。
        InputStream inputStream = new FileInputStream("C:\\Users\\greysonfang\\Desktop\\fc.png");
        this.ossClient.putObject("fc-yygh", "fc.png", inputStream);

        // 关闭OSSClient。
        this.ossClient.shutdown();

        System.out.println("上传完成...");
    }
}
