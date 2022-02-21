package com.yzxie.study.client.provider;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/* *
 * 说明：
 * 版本：1.0
 * 创建/修改日期：2022/2/15
 * 作者：大锤
 *
 * <li>GET类型请求参数必须要加 @RequestParam() 注解，否则后端使用Provider请求不了
 * <li>返回值Result中的data实体类不能包含泛型，否则解析不了
 */
@Component
@FeignClient(name="order-server-developer", fallback = OrderProvider.OrderProviderFallBack.class)
public interface OrderProvider {


    @RequestMapping("requestOrder")
    String requestOrder(@RequestParam("param") String param);

    /** 服务降级  */
    @Component
    class OrderProviderFallBack implements OrderProvider{

        @Override
        public String requestOrder(String param) {
            return "抱歉，订单系统异常，请稍后再试！";
        }
    }

}
