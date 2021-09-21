/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    Modified By: Ernie Phillips III
    Created Date: 09/13/2021
    Modified Date: 09/13/2021
    Purpose: class that implements contract between generic dao and book dao extension through inheritance
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
        new Book("978-0262510875", "Structure and Interpretation of Computer Programs (SICP)", 
          "The Structure and Interpretation of Computer Programs, a.k.a. SICP is among the best books to learn the fundamentals of programming. Employed as a foundational course to programming at MIT, SICP is a generic programming book that uses Scheme to illustrate the various programming concepts.", 
          304, new ArrayList<String>(List.of("Harold Abelson", "Gerald Jay Sussman", "Julie Sussman"))),
        new Book("978-0132350884", "Clean Code: A Handbook of Agile Software Craftsmanship", 
          "The clean code offers invaluable insights into code cleaning and software development. It has thorough, step-by-step explanations on cleaning, writing, and refactoring code. The programming book has a galore of practical examples about the how and why of writing clean code.", 
          784, new ArrayList<String>(List.of("Robert C. Martin"))),
        new Book("978-0262033848", "Introduction to Algorithms", 
          "All the algorithms discussed in the Introduction to Algorithms book are amply explained. They are presented using pseudocode, readable by programmers of all skill levels, even those who are relatively new to programming.", 
          65, new ArrayList<String>(List.of("Thomas H. Cormen", "Charles E. Leiserson", "Ronald L. Rivest", "Clifford Stein"))),
        new Book("978-0137081073", "Code Complete: A Practical Handbook of Software Construction", 
          "Want to know how to write robust code irrespective of the architecture of a programming language? Then consider reading the Code Complete: A Practical Handbook of Software Construction. It comprehensively covers all the aspects of the structure of good code.", 
          523, new ArrayList<String>(List.of("Steve McConnell"))),
        new Book("978-0201633610", "Design Patterns: Elements of Reusable Object-Oriented Software", 
          "If you don’t have a good grasp over UML, you might find it difficult to ingest some of the information and examples compiled in the programming book. That, however, will not stop you from appreciating the beauty of the narration in the Design Patterns book, which is easy and informative.", 
          655, new ArrayList<String>(List.of("Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides", "Grady Booch (Foreword)")))
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
