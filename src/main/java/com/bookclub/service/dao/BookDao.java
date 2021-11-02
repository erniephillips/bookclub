/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    Modified By: Ernie Phillips III
    Created Date: 09/13/2021
    Modified Date: 09/13/2021
    Purpose: Data access object for the book collection, will likely be implemented later in the class for data retrieval. Interfaced for instantiation contract 
*/

package com.bookclub.service.dao;

import com.bookclub.model.Book;
import com.bookclub.service.GenericDao;

public interface BookDao extends GenericDao<Book, String>  {
  
}
