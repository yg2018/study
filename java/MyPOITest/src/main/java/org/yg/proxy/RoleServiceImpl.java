package org.yg.proxy;

/**
 * @description: 代理目标
 * @author yuange
 * @date 2024-1-5 17:31
 * @version 1.0
 */
public class RoleServiceImpl implements RoleService {

     @Override
     public void addRole() {
          System.out.println("添加角色");
     }

     @Override
     public void delRole() {
          System.out.println("删除角色");
     }
}
