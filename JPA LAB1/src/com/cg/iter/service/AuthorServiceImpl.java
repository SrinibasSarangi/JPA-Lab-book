package com.cg.iter.service;

import com.cg.iter.dao.AuthorDao;
import com.cg.iter.dao.AuthorDaoImpl;
import com.cg.iter.entity.Author;

public class AuthorServiceImpl implements AuthorService {

	private AuthorDao aDao = new AuthorDaoImpl();
	@Override
	public boolean create(Author author) {
		// TODO Auto-generated method stub
		return aDao.create(author);
	}
	@Override
	public Author findauthor(int id) {
		// TODO Auto-generated method stub
		return aDao.findauthor(id);
	}
	@Override
	public Author update(Author author) {
		// TODO Auto-generated method stub
		return aDao.updateauthor(author);
	}
	@Override
	public boolean deleteauthor(int id) {
		// TODO Auto-generated method stub
		return aDao.deleteauthor(id);
	}

}
