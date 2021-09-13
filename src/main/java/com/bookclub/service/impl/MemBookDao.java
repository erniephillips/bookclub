/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    Modified By: Ernie Phillips III
    Created Date: 09/13/2021
    Modified Date: 09/13/2021
    Purpose: 
*/

package com.bookclub.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

public class MemBookDao implements BookDao {
  private List<Book> books;

  public MemBookDao(){
    books = new ArrayList<Book>(
      List.of(
        new Book("2342345", "Test 1", "Test Description 1", 23, new ArrayList<String>(List.of("Author 1", "Author 2"))),
        new Book("511-8956541", "Test 2", "Test Description 2", 266, new ArrayList<String>(List.of("Author 3", "Author 4"))),
        new Book("8251-561651", "Test 3", "Test Description 3", 65, new ArrayList<String>(List.of("Author 5", "Author 6"))),
        new Book("654156146", "Test 4", "Test Description 4", 523, new ArrayList<String>(List.of("Author 7", "Author 8"))),
        new Book("44134254", "Test 5", "Test Description 5", 65, new ArrayList<String>(List.of("Author 9", "Author 10")))
      )
    );
  }

  @Override //override the list method declared in the generic dao interface
  public List<Book> list(){ //return the list of books
    return this.books;
  }

  @Override //override the generic dao find method to return specific book
  public Book find(String key){
    for (Book book : this.books){
      if(book.getIsbn().equals(key))
        return book;
    }
    return new Book();
  }
}
