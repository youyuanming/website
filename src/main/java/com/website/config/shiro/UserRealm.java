/*
package com.website.config.shiro;

import com.website.entity.po.UserInfo;
import com.website.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.website.entity.dto.User;

*/
/**
 * @author Solar
 *//*

@Slf4j
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userInfoService;

	*/
/**
     * 此方法调用  hasRole,hasPermission的时候才会进行回调.
     *
     * 权限信息.(授权):
     * 1、如果用户正常退出，缓存自动清空；
     * 2、如果用户非正常退出，缓存自动清空；
     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。
     * （需要手动编程进行实现；放在service进行调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例，
     * 调用clearCached方法；
     * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
     * @param principals
     * @return
     *//*

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    	log.info("权限配置-->UserRealm.doGetAuthorizationInfo()");
    	return null;
    }

    */
/**
     * 认证信息.(身份验证)
     * :
     * Authentication 是用来验证用户身份
     * @param token
     * @return
     * @throws AuthenticationException
     *//*

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        //final char[] password = (char[]) token.getCredentials();
        String p = ((char[]) token.getCredentials()).toString();
        //这里改成查询数据库
//        UserInfo userInfo = userInfoService.findUserByUsername(username);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("user");
        userInfo.setPassword("password");
        userInfo.setMobilePhone("13300000000");
        userInfo.setId(1);
        if(userInfo==null){
            return null;
        }
        //存储在session的对象
        User user=new User();
        user.setUserName(userInfo.getUserName());
        user.setMobilePhone(userInfo.getMobilePhone());
        //校验用的密码
        String password = userInfo.getPassword();
        //放入user对象
        return new SimpleAuthenticationInfo(user, password, getName());
    }
}
*/
