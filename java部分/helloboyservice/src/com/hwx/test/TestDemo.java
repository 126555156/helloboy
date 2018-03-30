package com.hwx.test;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestDemo {
	// @Autowired
	// public static Configuration configuration;

	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUntils.getSessionObject();
			tx = session.beginTransaction();
//			org.hibernate.query.Query query = session.createQuery("from personal");
//			List<personal> list = query.list();
//			for (personal personal : list) {
//				System.out.println(personal);
//			}
//			session.createCriteria(personal.class);
//			personal per = session.get(personal.class, 1);
//			System.out.println(per);
//			per.setAge("36dd5");
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("数据库事务异常");
			tx.rollback();
		} finally {
//			session.close();
//			sessionFactory.close();
		}
		// TODO Auto-generated method stub
		// Configuration configuration=new Configuration();
		// configuration.configure();
		// SessionFactory sessionFactory=configuration.buildSessionFactory();

		// personal person=new personal();
		// person.setId(1);
		// person.setAge("12");
		// person.setName("5554dsf");
		// session.save(person);

		// personal.setAge("6");
		// session.update(personal);
		// System.out.println(personal.toString());
		// session.delete(person);

	}

}
