package com.hwx.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hwx.returnInfo.UserInfo;

@Repository
public class UserInfoDaoImpl implements HelloBoyDao {
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public int save(UserInfo userInfo) {
		// TODO Auto-generated method stub
//		Transaction tx = this.getCurrentSession().beginTransaction();
		try {
			this.getCurrentSession().save(userInfo);
			return 1;
		} catch (Exception e) {
//			if (null != tx) {
//				tx.rollback();
//			}
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int update(UserInfo userInfo) {
		// TODO Auto-generated method stub
//		Transaction tx = this.getCurrentSession().beginTransaction();
		try {
			this.getCurrentSession().update(userInfo);
//			tx.commit();
			return 1;
		} catch (Exception e) {
//			if (null != tx) {
//				tx.rollback();
//			}
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(UserInfo userInfo) {
		// TODO Auto-generated method stub
//		Transaction tx = this.getCurrentSession().beginTransaction();
		try {
			this.getCurrentSession().delete(userInfo);
//			tx.commit();
			return 1;
		} catch (Exception e) {
//			if (null != tx) {
//				tx.rollback();
//			}
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public UserInfo findById(Integer id) {
	     UserInfo userInfo=(UserInfo)this.getCurrentSession().get(UserInfo.class, id);
         return userInfo;

	}

	@Override
	public List<UserInfo> findAll() {
		// TODO Auto-generated method stub
		  List<UserInfo> userInfo=(List<UserInfo>) this.getCurrentSession().get(UserInfo.class,null);
		   return userInfo;
	}

	@Override
	public UserInfo findlogin(UserInfo userInfo) {
		// TODO Auto-generated method stub
		String hql = "from UserInfo where username=? and password=?";
		Query query=this.getCurrentSession().createQuery(hql);
		   query.setParameter(0,userInfo.getUsername());
           query.setParameter(1,userInfo.getPassword());
           List list = query.list();
           if(list!=null&&list.size()!=0){
               return (UserInfo)list.get(0);
           }else{
               return null;
           }
	}

	@Override
	public UserInfo findregister(UserInfo userInfo) {
		String hql = "from UserInfo where username=? or nickname=?";
		Query query=this.getCurrentSession().createQuery(hql);
		   query.setParameter(0,userInfo.getUsername());
           query.setParameter(1,userInfo.getNickname());
           List list = query.list();
           if(list!=null&&list.size()!=0){
               return (UserInfo)list.get(0);
           }else{
               return null;
           }
	}
}
