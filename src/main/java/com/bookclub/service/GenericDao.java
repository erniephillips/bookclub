/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    Modified By: Ernie Phillips III
    Created Date: 09/13/2021
    Modified Date: 09/13/2021
    Purpose: Data access object that accepts generic type-casted variables or objects. E for the entity, K for the key. Interfaced to ensure contract amoung instantiation
*/

package com.bookclub.service;

import java.util.List;

public interface GenericDao<E, K> {
  List<E> list(); //return a list of objects for the entity type represented by (E)
  E find(K key); //return the entity (E) object once obtianed by the Key represented by (K)
}
