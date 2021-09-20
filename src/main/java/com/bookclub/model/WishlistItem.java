/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    Modified By: Ernie Phillips III
    Created Date: 09/20/2021
    Modified Date: 09/20/2021
    Purpose: WishlistItem class w/ properties, constructors, and getter/setters
*/

package com.bookclub.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class WishlistItem {
  @NotNull
  @NotEmpty(message = "ISBN is a required field")
  private String isbn;

  @NotNull
  @NotEmpty(message = "Title is a required field")
  private String title;


  public WishlistItem() {
  }

  public WishlistItem(String isbn, String title) {
    this.isbn = isbn;
    this.title = title;
  }

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

  @Override
  public String toString() {
    return "WishlistItem{isbn=" + getIsbn() + ", title=" + getTitle() + "}";
  }

}