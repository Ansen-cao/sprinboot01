package com.ansen.service;

import com.ansen.mbg.model.UmsAdmin;
import com.ansen.mbg.model.UmsPermission;

import java.util.List;

/**
 * @Desc 后台管理员service
 * @Author caom
 * @Date 2021-08-12
 */
public interface UmsAdminService {

    /**
     * @Desc 根据用户名获取后台管理员
     * @Author caom
     * @Date 2021-08-12
     * @param username
     * @return
     */
    UmsAdmin getAdminByUsername(String username);


    /**
     * @Desc 注册功能
     * @Author caom
     * @Date 2021-08-12
     * @param umsAdmin
     * @return
     */
    UmsAdmin register(UmsAdmin umsAdmin);

    /**
     * Desc 登录功能
     * @Auhtor caomx
     * @Date 2021-08-12
     * @param username 用户名
     * @param password 密码
     * @return
     */
    String login(String username,String password);

    /**
     * @Desc 获取用户的权限
     * @Auhtor caomx
     * @Date 2021-08-12
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
