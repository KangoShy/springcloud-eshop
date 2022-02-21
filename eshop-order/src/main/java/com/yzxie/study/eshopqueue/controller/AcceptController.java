package com.yzxie.study.eshopqueue.controller;

import com.yzxie.study.client.provider.OrderProvider;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/* *
 * 说明：
 * 版本：1.0
 * 创建/修改日期：2022/2/15
 * 作者：大锤
 */
@RestController
public class AcceptController implements OrderProvider {

    @Override
    @RequestMapping("requestOrder")
    public String requestOrder(@RequestParam("param") String param) {
        System.err.println("接收到请求，param = " + param);
        return String.format("请求订单服务成功,请求参数 = [%s]！", param);
    }

    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //加密所需的salt(盐)
        textEncryptor.setPassword("KangoShyVpn500");
        //要加密的数据（数据库的用户名或密码）
        String password = textEncryptor.encrypt("dachui");

        //解密：
        //System.err.println(textEncryptor.decrypt(""));

        System.out.println("password:"+password);
    }

}
