package com.cg.iter.service;

import java.util.List;

import com.cg.iter.dao.BookAuthorDao;
import com.cg.iter.dao.BookAuthorDaoImpl;
import com.cg.iter.entity.Book;
import com.cg.iter.exception.BookAuthorException;

public class BookAuthorServiceImpl implements BookAuthorService {
	
	private BookAuthorDao baDao= new BookAuthorDaoImpl();
	@Override
	public List<Book> getAllBooksDetail() throws BookAuthorException {
		// TODO Auto-generated method stub
		return baDao.getAllBookDetails();
	}
	@Override
	public List<Book> getAllBookByAuthor(String authorName) throws BookAuthorException {
		// TODO Auto-generated method stub
		return baDao.getAllBooksByAuthor(authorName);
	}
	@Override
	public List<Book> getAllBooksInRange(int minPrice, int maxPrice) throws BookAuthorException {
		// TODO Auto-generated method stub
		return baDao.getAllBooksInRange(minPrice, maxPrice);
	}
	@Override
	public String getAuthorsByISBN(int isbn) throws BookAuthorException {
		// TODO Auto-generated method stub
		return baDao.getAuthorsByISBN(isbn);
	}
	
}
