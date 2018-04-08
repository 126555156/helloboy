package com.hwx.dao;


import java.util.List;


import com.hwx.returnInfo.UserInfo;

	public interface HelloBoyDao {
		  public int save(UserInfo userInfo);
		  public int update(UserInfo userInfo);
		  public int delete(UserInfo userInfo);
		  public UserInfo findById(Integer id);
		  public UserInfo findlogin(UserInfo userInfo);
		  public UserInfo findregister(UserInfo userInfo);
		  public List<UserInfo> findAll();
		}
