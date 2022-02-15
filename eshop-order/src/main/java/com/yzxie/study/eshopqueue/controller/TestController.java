package com.yzxie.study.eshopqueue.controller;

import com.yzxie.study.client.RepertoryProvider;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TestController  {

    @Autowired
    private RepertoryProvider repertoryProvider;

    @RequestMapping("/requestRepertory")
    public String requestRepertory(@RequestParam("param") String param) {
        return repertoryProvider.requestTest(param);
    }

}
