package com.hwx.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUntils {
	static Configuration configuration = null;
	static SessionFactory sessionFactory = null;
	static {
		configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
	}

	public static Session getSessionObject() {
		return sessionFactory.getCurrentSession();

	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
