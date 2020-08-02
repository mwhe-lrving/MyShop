package com.myshop.shiro;


import com.myshop.pojo.Userinfo;
import com.myshop.service.UserinfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;


//自定义realm
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserinfoService service;

    /*执行授权逻辑*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        //给资源授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加支援的授权字符串
        info.addStringPermission("user");
        Subject subject = SecurityUtils.getSubject();
        Userinfo user = (Userinfo) subject.getPrincipal();
        Userinfo dbUser = service.login(user);
        //为了不动表，先将权限码设置为用户名称
        info.addStringPermission(dbUser.getUsername());
        return info;
    }

    /*执行认证逻辑*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        //编写判断逻辑
        Userinfo user = service.findByName(token.getUsername());//根据前端传来的参数到数据库查询

        if (user == null) {
            //用户名不存在
            return null;//shiro抛出UnKnowAccountException
        }
        //判断密码
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), "");
        return simpleAuthenticationInfo;

    }

}
