package org.lindbergframework.web.conversation.spring;

import java.util.Stack;

import org.apache.myfaces.orchestra.conversation.spring.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class HibernatePersistenceContext implements PersistenceContext{

	private SessionFactory sessionFactory;
	
	private Session currentSession;
	
	private final Stack bindings = new Stack();
	
	public HibernatePersistenceContext(SessionFactory sessionFactory, Session currentSession){
		this.sessionFactory = sessionFactory;
		this.currentSession = currentSession;
	}

	public void bind() {
		synchronized (bindings) {
			SessionHolder current = (SessionHolder) TransactionSynchronizationManager
					.getResource(sessionFactory);

			if (current != null) {
				TransactionSynchronizationManager
						.unbindResource(sessionFactory);
			}
			bindings.push(current);

			TransactionSynchronizationManager.bindResource(
					sessionFactory, new SessionHolder(currentSession));
		}
	}

	public void unbind() {
		synchronized (bindings) {
			if (TransactionSynchronizationManager
					.hasResource(sessionFactory)) {
				TransactionSynchronizationManager
						.unbindResource(sessionFactory);
			}

			Object holder = null;
			if (bindings.size() > 0) {
				holder = bindings.pop();
			}
			if (holder != null) {
				TransactionSynchronizationManager.bindResource(
						sessionFactory, holder);
			}
		}
	}

	public void close() {
		currentSession.close();
	}
}
