package com.cg.iter.service;

import com.cg.iter.entity.Author;

public interface AuthorService {

	public boolean create(Author author);

	public Author findauthor(int id);

	public Author update(Author author);

	public boolean deleteauthor(int id);
	
	

}
