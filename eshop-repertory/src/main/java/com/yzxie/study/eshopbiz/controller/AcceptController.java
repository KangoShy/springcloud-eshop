package com.yzxie.study.eshopbiz.controller;

import com.yzxie.study.client.RepertoryProvider;
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
public class AcceptController implements RepertoryProvider {

    @Override
    @RequestMapping("requestRepertory")
    public String requestRepertory(@RequestParam("param") String param) {
        return String.format("请求仓储服务成功,请求参数 = [%s]！", param);
    }
}
