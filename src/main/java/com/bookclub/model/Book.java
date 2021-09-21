/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    Modified By: Ernie Phillips III
    Created Date: 09/13/2021
    Modified Date: 09/13/2021
    Purpose: Book object model with constructor for book instantiation and access/mutator methods for all private vars
*/

package com.bookclub.model;

import java.util.List;

public class Book { //class creation
  //declare variables
  private String isbn;
  private String title;
  private String description;
  private int numOfPages;
  private List<String> authors;

  //create a default toString method to return var accessors back to client
  @Override
  public String toString() {
    return "Book{" +
      " isbn=<" + getIsbn() + ">" +
      ", title=<" + getTitle() + ">" +
      ", description=<" + getDescription() + ">" +
      ", numOfPages=<" + getNumOfPages() + ">" +
      ", authors=<" + getAuthors() + ">" +
      "}";
  }

  public Book(){ //directions did not call for a default constructor, but on page 2 in the override method, a new empty book is returned. Can't do that in the MemBookDao without a dao so this was added

  }

  //constructor using all vars set here
  public Book(String isbn, String title, String description, int numOfPages, List<String> authors) {
    this.isbn = isbn;
    this.title = title;
    this.description = description;
    this.numOfPages = numOfPages;
    this.authors = authors;
  }

  //getter/setter methods
  public String getIsbn() {
    return this.isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getNumOfPages() {
    return this.numOfPages;
  }

  public void setNumOfPages(int numOfPages) {
    this.numOfPages = numOfPages;
  }

  public List<String> getAuthors() {
    return this.authors;
  }

  public void setAuthors(List<String> authors) {
    this.authors = authors;
  }
}
