package com.jeff.tianti.entity;

import org.springframework.stereotype.Component;

@Component
public class WxMpProperties {

    /**
     * 公众号appId
     */
    private String appId="wxf3d1278e81d78eb6";

    /**
     * 公众号appSecret 
     */
    private String secret="2d7443eac313d5ac8dfe6049d89702af";

    /**
     * 公众号token
     */
    private String token="hanyun2014";

    /**
     * 公众号aesKey
     */
    private String aesKey="c39QYxAzAzW4CgtfBFL2SGUvT7Vj83J5k1ELCsNBGa8";

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAesKey() {
        return aesKey;
    }

    public void setAesKey(String aesKey) {
        this.aesKey = aesKey;
    }
}