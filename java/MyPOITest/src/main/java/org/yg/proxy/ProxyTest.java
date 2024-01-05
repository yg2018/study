package org.yg.proxy;

import java.lang.reflect.Proxy;

/**
 * @description: 使用JDK的proxy来进行动态代理
 * @author yuange
 * @date 2024-1-5 17:24
 * @version 1.0
 */
public class ProxyTest {
	public static void main(String[] args) {
		//真实的对象
		RoleService roleService = new RoleServiceImpl();
		//代理处置方法
		RoleInvocationHandler handler = new RoleInvocationHandler(roleService);
		// 生成动态代理的对象（反射实现）
		RoleService proxy = (RoleService) Proxy.newProxyInstance(roleService.getClass().getClassLoader(),
				roleService.getClass().getInterfaces(),handler);
		// 代理调用真实方法，并在之前或之后处置
		proxy.addRole();
		proxy.delRole();
	}
}
