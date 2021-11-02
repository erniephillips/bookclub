/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    Modified By: Ernie Phillips III
    Created Date: 11/02/2021
    Modified Date: 11/02/2021
    Purpose: Book of the Month data access object
*/

package com.bookclub.service.dao;

import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.GenericCrudDao;

public interface BookOfTheMonthDao extends GenericCrudDao<BookOfTheMonth, String>{
  
}
