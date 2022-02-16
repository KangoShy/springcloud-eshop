package com.yzxie.study.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* *
 * 说明：
 * 版本：1.0
 * 创建/修改日期：2022/2/15
 * 作者：大锤
 */
@Component
@FeignClient(name = "repository-server-developer", fallback = RepertoryProvider.RepertoryProviderFallBack.class)
public interface RepertoryProvider {


    @RequestMapping("/requestRepertory")
    String requestRepertory(@RequestParam("param") String param);

    /** 服务降级 */
    @Component
    class RepertoryProviderFallBack implements RepertoryProvider{

        @Override
        public String requestRepertory(String param) {
            return "抱歉，仓储系统异常，请稍后再试！";
        }
    }

}
