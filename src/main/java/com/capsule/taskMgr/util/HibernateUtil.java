package com.capsule.taskMgr.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	static {
			try {
					sessionFactory=new Configuration().configure().buildSessionFactory();
				} catch (Throwable ex) {
						throw new ExceptionInInitializerError(ex);
				}
			}

		public static SessionFactory getSessionFactory() {
					// Alternatively, you could look up in JNDI here
				return sessionFactory;
		}

			public static void shutdown() {
					// Close caches and connection pools
				getSessionFactory().close();
			}

}
