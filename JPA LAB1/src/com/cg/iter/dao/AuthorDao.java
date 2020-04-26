package com.cg.iter.dao;

import com.cg.iter.entity.Author;

public interface AuthorDao {

	boolean create(Author author);

	Author findauthor(int id);

	Author updateauthor(Author author);

	boolean deleteauthor(int id);

}
