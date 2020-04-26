package com.cg.iter.service;

import java.util.List;

import com.cg.iter.entity.Book;
import com.cg.iter.exception.BookAuthorException;

public interface BookAuthorService {

	List<Book> getAllBooksDetail() throws BookAuthorException;

	List<Book> getAllBookByAuthor(String authorName) throws BookAuthorException;

	List<Book> getAllBooksInRange(int minPrice, int maxPrice) throws BookAuthorException;

	String getAuthorsByISBN(int isbn) throws BookAuthorException;

}
