package com.spring.boot.web;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author： yu Liu
 * @date： 2020/4/4 0004 10:16
 * @description： 动态代理实现类
 * @modifiedBy：
 * @version: 1.0
 */

public class DynamicProxyTest {


	public static void main(String[] args) {

		Animal bind = (Animal)new ProxyHandler1().bind(new Cat());
		bind.eat();
	}

}

/**
 * 被代理类
 */
class Cat implements Animal{

	@Override
	public void eat() {
		System.out.println("这是一条狗");
	}
}


/**
 * 代理类
 */
class ProxyHandler1 implements InvocationHandler {

	private Object object;


	public Object bind(Object object) {
		this.object = object;
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(object, args);
	}
}