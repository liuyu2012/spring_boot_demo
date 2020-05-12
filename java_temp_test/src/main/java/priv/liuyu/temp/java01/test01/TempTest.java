package priv.liuyu.temp.java01.test01;

import java.util.Random;

/**
 * @author： yu Liu
 * @date： 2020/5/12 0012 10:59
 * @description： java临时测试项目
 * @modifiedBy：
 * @version: 1.0
 */
public class TempTest {

	public static void main(String[] args) {

		//限制器，限制在1秒之内最多登录10次
		UserLoginLimiter limiter = new UserLoginLimiter(1000, 10);

		Random r = new Random();
		int allowCount = 0;
		int denyCount = 0;

		//模拟100次登录请求
		for (int i = 0; i < 100; i++) {
			LoginRecord loginRecord = new LoginRecord("123.456.789.10", System.currentTimeMillis(), "Jason.Li");
			try {
				Thread.sleep(r.nextInt(50)); //两次登录之间间隔的毫秒数
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (limiter.check(loginRecord)) {
				System.out.println(loginRecord + "允许登录！");
				allowCount++;
			} else {
				System.out.println(loginRecord + "禁止登录！");
				denyCount++;
			}
		}
		System.out.println("允许数量：" + allowCount);
		System.out.println("拒绝数量：" + denyCount);
	}


}
