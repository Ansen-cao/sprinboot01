package com.ansen.service;

import com.ansen.common.api.CommonResult;

/**
 * @Desc 会员管理
 * @Author caomx
 * @Date 2021-08-11
 */
public interface UmsMemberService {

    /**
     * @Desc 生成手机验证码
     * @Author caomx
     * @Date 2021-08-11
     * @param telephone
     * @return
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * @Desc 校验验证码
     * @Author caomx
     * @Date 2021-08-11
     * @param telephone
     * @param authCode
     * @return
     */
    CommonResult verityAuthCode(String telephone,String authCode);
}
