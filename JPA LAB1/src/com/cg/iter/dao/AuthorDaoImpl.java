package com.cg.iter.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.iter.entity.Author;
import com.cg.iter.util.JpaUtil;

public class AuthorDaoImpl implements AuthorDao {

	EntityManager em = JpaUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();

	@Override
	public boolean create(Author author) {
		try {
			
			em.getTransaction().begin();
			em.persist(author);
			em.getTransaction().commit();
			return true;
			
		} catch (Exception e) {	
			e.printStackTrace();
		return false;
		}
	}

	@Override
	public Author findauthor(int id) {
	
		return em.find(Author.class, id);
	}

	@Override
	public Author updateauthor(Author author) {
		
			Author temp = findauthor(author.getAuthorId());
			
			temp.setFirstName(author.getFirstName());
			temp.setLastName(author.getLastName());
			temp.setMiddleName(author.getMiddleName());
			temp.setPhoneNo(author.getPhoneNo());
			
			et.begin();
			em.merge(temp);
			et.commit();
			
			return temp;
		
	}

	@Override
	public boolean deleteauthor(int id) {
		
			Author author = findauthor(id);
			et.begin();
			em.remove(author);
			et.commit();
			return true;
		
		}
	}


