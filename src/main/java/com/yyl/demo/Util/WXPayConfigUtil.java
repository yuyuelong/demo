package com.yyl.demo.Util;

import com.github.wxpay.sdk.WXPayConfig;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * 微信支付工具类</br>
 */
@Component
public class WXPayConfigUtil implements WXPayConfig {
    /**
     *
     * @return
     */
    @Override
    public String getAppID() {
        return WXPayConstants.APP_ID;
    }

    /**
     *
     * @return
     */
    @Override
    public String getMchID() {
        return WXPayConstants.MCH_ID;
    }

    @Override
    public String getKey() {
        return WXPayConstants.API_KEY;
    }

    @Override
    public InputStream getCertStream() {
        return null;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 2000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }
}
