package com.ansen.service.impl;

import com.ansen.common.api.CommonResult;
import com.ansen.service.RedisService;
import com.ansen.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;
    /**
     * @Desc 生成手机验证码
     * @Author caomx
     * @Date 2021-08-11
     * @param telephone
     * @return
     */
    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random rm = new Random();
        for (int i = 0; i < 6 ; i++) {
            sb.append(rm.nextInt(10));
        }
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE+telephone,sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE+telephone,AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(sb.toString(),"获取验证码成功");
    }


    /**
     * @Desc 校验验证码
     * @Author caomx
     * @Date 2021-08-11
     * @param telephone
     * @param authCode
     * @return
     */
    @Override
    public CommonResult verityAuthCode(String telephone, String authCode) {
        if(StringUtils.isEmpty(authCode)){
            return CommonResult.failed("获取验证码失败");
        }

        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE+telephone);
        if(authCode.equals(realAuthCode)){
            return CommonResult.success(null,"验证码校验成功");
        }else{
            return CommonResult.failed("验证码校验失败");
        }
    }
}
