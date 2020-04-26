package com.cg.iter.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.cg.iter.entity.Book;
import com.cg.iter.exception.BookAuthorException;
import com.cg.iter.util.JpaUtil;
import com.cg.iter.dao.QueryMapper;


public class BookAuthorDaoImpl implements BookAuthorDao {

	EntityManager em = JpaUtil.getEntityManager();
	EntityTransaction et = em.getTransaction();

	@Override
	public List<Book> getAllBookDetails() throws BookAuthorException {
		// TODO Auto-generated method stub
		TypedQuery<Book> tq= em.createQuery(QueryMapper.FETCH_ALL_BOOK_DETAIL,Book.class);
		List<Book> bookList= tq.getResultList();
		if(bookList.isEmpty())
		{
			throw new BookAuthorException("No books exist in table");
		}
		else
		{
			return bookList;
		}
	}

	@Override
	public List<Book> getAllBooksByAuthor(String authorName) throws BookAuthorException {
		// TODO Auto-generated method stub
		TypedQuery<Book> tq=em.createQuery(QueryMapper.FETCH_ALL_BOOK_BY_AUTHOR,Book.class);
		tq.setParameter("name",authorName);
		List<Book> bookListByOneAuthor= tq.getResultList();
		if(bookListByOneAuthor.isEmpty())
		{
			throw new BookAuthorException("No books exist with given author name");
		}
		else
		{
			return bookListByOneAuthor;
		}
	}

	@Override
	public List<Book> getAllBooksInRange(int minPrice, int maxPrice) throws BookAuthorException {
		// TODO Auto-generated method stub
		TypedQuery<Book> tq=em.createQuery(QueryMapper.FETCH_ALL_BOOK_BETWEEN_PRICE,Book.class);
		tq.setParameter("startPrice", minPrice);
		tq.setParameter("endPrice", maxPrice);
		List<Book> bookListInRange= tq.getResultList();
		if(bookListInRange.isEmpty())
		{
			throw new BookAuthorException("No books exist within given range");
		}
		else
		{
			return bookListInRange;
		}
		
	}

	@Override
	public java.lang.String getAuthorsByISBN(int isbn) throws BookAuthorException {
		// TODO Auto-generated method stub
		Book book = em.find(Book.class,isbn);
		String author = book.getAuthor().getName();
		
		if(author.equals(null))
		{
			throw new BookAuthorException("please enter a valid isbn");
		}
		else
		{
			return author;
		}
	}

}
