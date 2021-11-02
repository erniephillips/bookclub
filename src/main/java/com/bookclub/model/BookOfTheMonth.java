/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    Modified By: Ernie Phillips III
    Created Date: 11/02/2021
    Modified Date: 11/02/2021
    Purpose: Book of the Month object model with constructor for book instantiation and access/mutator methods for all private vars
*/
package com.bookclub.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;

public class BookOfTheMonth {
  @Id
  String id;
  int month;

  @NotEmpty(message = "ISBN required")
  String isbn;

  public BookOfTheMonth() {
  }

  public BookOfTheMonth(int month, String isbn) {
    this.month = month;
    this.isbn = isbn;
  }

  // creating a mapping for all months of the year
  public String getMonthText() {
    String monthText = "";
    switch (this.getMonth()) {
    case 1:
      monthText = "January";
      break;
    case 2:
      monthText = "February";
      break;
    case 3:
      monthText = "March";
      break;
    case 4:
      monthText = "April";
      break;
    case 5:
      monthText = "May";
      break;
    case 6:
      monthText = "June";
      break;
    case 7:
      monthText = "July";
      break;
    case 8:
      monthText = "August";
      break;
    case 9:
      monthText = "September";
      break;
    case 10:
      monthText = "October";
      break;
    case 11:
      monthText = "November";
      break;
    case 12:
      monthText = "December";
      break;
    default:
      monthText = "Invalid Month";
      break;
    }
    return monthText;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getMonth() {
    return this.month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public String getIsbn() {
    return this.isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  @Override
  public String toString() {
    return "BookOfTheMonth{id=" + getId() + ", month=" + getMonth() + ", isbn=" + getIsbn() + "}";
  }

}
