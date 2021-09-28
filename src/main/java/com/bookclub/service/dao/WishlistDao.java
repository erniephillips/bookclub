/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    Modified By: Ernie Phillips III
    Created Date: 09/20/2021
    Modified Date: 09/20/2021
    Purpose: Data access object for wishlist items
*/

package com.bookclub.service.dao;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.GenericCrudDao;

public interface WishlistDao extends GenericCrudDao<WishlistItem, String> {
  
}
