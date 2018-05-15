package com.yyl.demo.controller;

import com.github.wxpay.sdk.WXPay;
import com.yyl.demo.Util.OrderIdGenerator;
import com.yyl.demo.Util.WXPayConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 控制层<br/>
 * 微信支付<br/>
 */
@RequestMapping(value = "wxPay")
@RestController
public class WXPayController {

    /**
     *
     */
    @Autowired
    private WXPayConfigUtil wxPayConfigUtil;

    /**
     * 微信扫码支付<br/>
     * @return
     */
    @RequestMapping(value = "scanPay")
    public Map<String, String> scanPay(){
        WXPay wxPay = new WXPay(wxPayConfigUtil);
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("body", "腾讯充值中心-QQ会员充值");
        data.put("out_trade_no", OrderIdGenerator.getOrderId());
        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "123.12.12.123");
        data.put("notify_url", "http://test.letiantian.me/wxpay/notify");
        data.put("trade_type", "NATIVE");
        data.put("product_id", "12");
        Map<String,String> result = null;
        try {
            result = wxPay.unifiedOrder(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
