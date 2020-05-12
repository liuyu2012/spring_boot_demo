package priv.liuyu.temp.java01.test01;

import java.util.LinkedList;

/**
 * @author： yu Liu
 * @date： 2020/5/12 0012 11:02
 * 用户登录记录限制类
 * 限制在一定时长（thresholdInMillisecond）内最多登录（maxLoginTimes）次
 */
public class UserLoginLimiter {

	private int maxLoginTimes; //一定时间（thresholdInMillisecond值）内的最多登录次数
	private int thresholdInMillisecond; //时长
	private LinkedList<LoginRecord> loginRecordList; //最近的登录队列


	private UserLoginLimiter() {
	}

	public UserLoginLimiter(int thresholdInMillisecond, int maxLoginTimes) {
		this.thresholdInMillisecond = thresholdInMillisecond;
		this.maxLoginTimes = maxLoginTimes;
		loginRecordList = new LinkedList<LoginRecord>();
	}

	/**
	 * 检查登录记录，
	 * 对在（thresholdInMillisecond）时长内超过（maxloginTimes）次的登录记录返回false，否则返回true;
	 *
	 * @param curLR 入参
	 * @return 判断结果
	 */
	public boolean check(LoginRecord curLR) {

		//检查设置的值，对0及负数表示不限制登录
		if (maxLoginTimes <= 0 || thresholdInMillisecond <= 0) return true;

		//队列长度未到maxLoginTimes的不用限制
		if (loginRecordList.size() < maxLoginTimes) {
			loginRecordList.addLast(curLR);
			return true;
		}

		//队列长度达到maxLoginTimes的，清理和当前记录比较超过thresholdInMillisecond值的记录
		LoginRecord firstLR = loginRecordList.getFirst();
		while (loginRecordList.size() > 0 && firstLR.getTime() + thresholdInMillisecond < curLR.getTime()) {
			loginRecordList.removeFirst();
			if (loginRecordList.size() > 0) {
				firstLR = loginRecordList.getFirst();
			} else {
				break;
			}
		}

		//检查队列是否有空间添加新的记录
		if (loginRecordList.size() < maxLoginTimes) {
			loginRecordList.addLast(curLR);
			return true;
		} else {
			return false; //队列中的记录与当前登录记录发生在thresholdInMillisecond内，拒绝
		}
	}
}
