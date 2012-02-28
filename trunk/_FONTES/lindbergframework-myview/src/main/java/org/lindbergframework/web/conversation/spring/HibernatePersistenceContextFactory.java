package org.lindbergframework.web.conversation.spring;

import org.apache.myfaces.orchestra.conversation.spring.PersistenceContext;
import org.apache.myfaces.orchestra.conversation.spring.PersistenceContextFactory;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * 
 * @author Victor Lindberg
 * 
 */
public class HibernatePersistenceContextFactory implements
		PersistenceContextFactory {
	
	private SessionFactory sessionFactory;

	public PersistenceContext create() {
		final Session session = openSesssion();
		session.setFlushMode(FlushMode.COMMIT);

		return new HibernatePersistenceContext(sessionFactory,session);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session openSesssion() {
		return sessionFactory.openSession();
	}
}
