package priv.liuyu.temp.java01.test01;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author： yu Liu
 * @date： 2020/5/12 0012 11:00
 * @description：
 * @modifiedBy：
 * @version: 1.0
 */
public class LoginRecord {
	private String ip;
	private long time;
	private String username;

	public LoginRecord() {
	}

	public LoginRecord(String ip, long time, String username) {
		this.ip = ip;
		this.time = time;
		this.username = username;
	}

	public String getIp() {
		return ip;
	}

	public LoginRecord setIp(String ip) {
		this.ip = ip;
		return this;
	}

	public long getTime() {
		return time;
	}

	public LoginRecord setTime(long time) {
		this.time = time;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public LoginRecord setUsername(String username) {
		this.username = username;
		return this;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
