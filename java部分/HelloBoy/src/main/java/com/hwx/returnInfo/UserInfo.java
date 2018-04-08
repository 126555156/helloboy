package com.hwx.returnInfo;

import org.springframework.stereotype.Controller;

@Controller
public class UserInfo {
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", password=" + password + ", username=" + username + ", islogin=" + islogin
				+ ", email=" + email + ", level=" + level + ", phone=" + phone + ", nickname=" + nickname + "]";
	}

	private int id;
	private String password;
	private String username;
	private int islogin;
	private String email;
	private String level;
	private String phone;
	private String nickname;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public int getIslogin() {
		return islogin;
	}

	public void setIslogin(int islogin) {
		this.islogin = islogin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
