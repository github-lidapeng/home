package com.home.shiro;

import com.home.entity.Timu;
import com.home.service.TimuService;
import com.home.utils.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private TimuService service;
    private HttpServletRequest request;

    public void setService(TimuService service) {
        this.service = service;
    }

    /**
     * 获取授权信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("--权限认证--");
        String name = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //u获得该用户角色
        String role = service.verifyTimuName(name).getRole();
        Set<String> set=new HashSet<>();
        // 需要将 role 封装到 Set 作为 info.setRoles() 的参数
        set.add(role);
        //设置该用户拥有的角色
        info.setRoles(set);
        return info;
    }

    /**
     * 获取身份信息到shiro，最终通过realm来获取应用程序中的用户、角色及权限信息
     * @param authenticationToken 用户身份信息token
     * @return 返回封装了用户信息的authenticationException
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("--身份认证方法--");
        //身份验证令牌token
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        System.out.println("tokem"+token);
        //从数据库获取到对应用户名密码的用户
        Timu timu = service.verifyTimuName(token.getUsername());
        if (timu == null)
            throw new AccountException("用户不存在");
        //获取密码
        String password = MD5Utils.MD5(new String((char[]) token.getCredentials()));
        if (password == null){
            throw new AccountException("密码为空，请输入密码");
        }else  if (!password.equals(timu.getPassword())){
            System.out.println(password);
            System.out.println(timu.getPassword());
            throw new AccountException("用户名或密码不正确");
        }
        if ("admin".equals(timu.getRole())){

        }else if (!timu.isVip()){
            if (timu.getPlayTime() == null){
                throw  new AccountException("对不起，您尚未成为我们的会员");
            }else {
                throw new AccountException("您已提交会员申请，请稍后");
            }
        }
        return new SimpleAuthenticationInfo(timu,token.getCredentials(),getName());
    }
}
