package com.xmh.gulimall.coupon;

import com.xmh.gulimall.coupon.controller.SmsSpuBoundsController;
import com.xmh.gulimall.coupon.entity.SmsSpuBoundsEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GulimallProductApplicationTests {

    @Autowired
    SmsSpuBoundsController smsSpuBoundsController;

    @Test
    public void contextLoads(){
        SmsSpuBoundsEntity smsSpuBoundsEntity = new SmsSpuBoundsEntity();
        smsSpuBoundsEntity.setSpuId(1L);
        smsSpuBoundsController.save(smsSpuBoundsEntity);
        System.out.println("保存成功");
    }

}
