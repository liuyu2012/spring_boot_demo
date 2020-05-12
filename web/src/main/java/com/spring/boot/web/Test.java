package com.spring.boot.web;

/**
 * @author： yu Liu
 * @date： 2020/4/4 0004 9:46
 * @description： 静态代理实现
 * @modifiedBy：
 * @version: 1.0
 */
public class Test {
	public static void main(String[] args) {
		DogProxy dogProxy = new DogProxy(new Dog());
		dogProxy.eat();
	}

}

/**
 * 公共接口
 */
interface Animal{
	void eat();
}

/**
 * 被代理类
 */
class Dog implements Animal {

	@Override
	public void eat() {
		System.out.println("这是一条狗");
	}
}

/**
 * 代理类
 */
class DogProxy implements Animal {

	private Dog dog;

	
	DogProxy(Dog dog) {
		this.dog = dog;
	}

	@Override
	public void eat() {
		dog.eat();
	}
}