package com.yzxie.study.eshopbiz.controller;

import com.alibaba.fastjson.JSONObject;
import com.yzxie.study.client.provider.OrderProvider;
import com.yzxie.study.eshopbiz.cache.RedisContantKey;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* *
 * 说明：
 * 版本：1.0
 * 创建/修改日期：2022/2/15
 * 作者：大锤
 */
@RestController
public class TestController {

    @Autowired
    private OrderProvider orderProvider;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/requestOrder")
    public String requestOrder(@RequestParam("param") String param) {
        return restTemplate.getForObject("http://order-server-developer/requestOrder?param=" + param, String.class);
    }

    @SuppressWarnings("all")
    @RequestMapping("/requestRedis")
    public Object requestRedis(boolean first) {
        String shopKey = RedisContantKey.MT_JXTCG_TDPG;
        if (first) {
            redisTemplate.opsForValue().set(
                    shopKey,
                    SHOP.builder().shopName("TDPG").shopPrice("19").build(),
                    3L,
                    TimeUnit.MINUTES);
            return "下单成功！";
        }
        Object o = redisTemplate.opsForValue().get(shopKey);
        if (o == null) {
            return "订单超时，请重新下单！";
        }
        // 获取剩余时间
        Long seconds = redisTemplate.opsForValue().getOperations().getExpire(shopKey);
        return getFormatTime(Integer.parseInt(seconds.toString()));
    }

    public static String getFormatTime(Integer second) {
        if (second == null)
            return "--";
        String num0 = NumFormat(0);
        if(second < 60)
            return num0 + ":"+ num0 + ":" + NumFormat(second);
        if(second < 3600)
            return num0 + ":" +NumFormat(second / 60) + ":" + NumFormat(second % 60);
        if(second< 3600 * 24)
            return NumFormat(second/ 60 / 60) + ":" + NumFormat(second/ 60 % 60) + ":" + NumFormat(second% 60);
        return NumFormat(second/ 60 / 60 /24) + "天" +NumFormat(second/ 60 / 60 % 24) + ":" + NumFormat(second/ 60 % 60) + ":" + NumFormat(second% 60);
    }

    private static String NumFormat(int sec) {
        if (String.valueOf(sec).length() < 2){
            return "0"+sec;
        }else {
            return String.valueOf(sec);
        }
    }


    public static void main(String[] args) {
        System.err.println(getFormatTime(1147));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    static
    class SHOP{
        private String shopName;
        private String shopPrice;
    }

}
