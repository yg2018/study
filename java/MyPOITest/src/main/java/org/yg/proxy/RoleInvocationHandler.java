package org.yg.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: 动态代理处理类
 * @author yuange
 * @date 2024-1-5 17:25
 * @version 1.0
 */
public class RoleInvocationHandler implements InvocationHandler {

    private Object target;

    public RoleInvocationHandler(Object target) {
        this.target = target;
    }
    /**
     * @description: 代理的目标的方法值
     * @param: proxy
     * @param: method
     * @param: args
     * @return: java.lang.Object
     * @author yuange
     * @date: 2024-1-5 17:30
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用前");
        Object result = method.invoke(target,args);
        System.out.println("调用后");
        return result;
    }
}
