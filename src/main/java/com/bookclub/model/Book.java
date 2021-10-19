/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    Modified By: Ernie Phillips III
    Created Date: 09/13/2021
    Modified Date: 09/13/2021
    Purpose: Book object model with constructor for book instantiation and access/mutator methods for all private vars
*/

package com.bookclub.model;

public class Book { //class creation
  //declare variables
  private String isbn;
  private String title;
  private String description;
  private String infoUrl;
  private int numOfPages;

  //create a default toString method to return var accessors back to client
  @Override
  public String toString() {
    return "Book{" +
      " isbn=<" + getIsbn() + ">" +
      ", title=<" + getTitle() + ">" +
      ", description=<" + getDescription() + ">" +
      ", infoUrl=<" + getInfoUrl() + ">" +
      ", numOfPages=<" + getNumOfPages() + ">" +
      "}";
  }

  public Book(){ //directions did not call for a default constructor, but on page 2 in the override method, a new empty book is returned. Can't do that in the MemBookDao without a dao so this was added

  }

  public Book(String isbn, String title, String infoUrl) {
    this.isbn = isbn;
    this.title = title;
    this.infoUrl = infoUrl;
  }

  //constructor using all vars set here
  public Book(String isbn, String title, String description, String infoUrl, int numOfPages) {
    this.isbn = isbn;
    this.title = title;
    this.description = description;
    this.infoUrl = infoUrl;
    this.numOfPages = numOfPages;
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

  public String getInfoUrl() {
    return this.infoUrl;
  }

  public void setInfoUrl(String infoUrl) {
    this.infoUrl = infoUrl;
  }
}
