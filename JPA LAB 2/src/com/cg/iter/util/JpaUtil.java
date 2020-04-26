package com.cg.iter.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManager em;

	public static EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		if(em==null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookauthorentity"); 
			em = emf.createEntityManager();
		}
		return em;
	}
}
