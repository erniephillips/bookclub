/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    Modified By: Ernie Phillips III
    Created Date: 09/27/2021
    Modified Date: 09/27/2021
    Purpose: Data access object to provide CRUD ops on the MongoDB bookclub collection
*/

package com.bookclub.service;

import java.util.List;

public interface GenericCrudDao<E, K> {
  void add(E entity); 
  void update(E entity);
  boolean remove(E entity);
  List<E> list();
  E find(K key);
}
