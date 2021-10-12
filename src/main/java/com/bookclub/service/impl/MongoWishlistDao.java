/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    Modified By: Ernie Phillips III
    Created Date: 09/27/2021
    Modified Date: 09/27/2021
    Purpose: Data access object implementing the contract class for CRUD operations. Here actual DB calls take place. (Meat and potatoes)
*/
package com.bookclub.service.impl;

import java.util.List;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository("wishlistDao") // create repo name
public class MongoWishlistDao implements WishlistDao { // implement the CRUD interface

  @Autowired // annotation for dependency injection allowing for resolve and injecting of
             // collaborating beans into this bean
  private MongoTemplate mongoTemplate; // template pattern for Spring to pass object(s) to data persistence layer

  @Override
  public List<WishlistItem> list() {
    return mongoTemplate.findAll(WishlistItem.class);
  }

  @Override
  public void add(WishlistItem entity) {
    mongoTemplate.save(entity);
  }

  @Override
  public void update(WishlistItem entity) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean remove(WishlistItem entity) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public WishlistItem find(String key) {
    return mongoTemplate.findById(key, WishlistItem.class); //find by the key
  }

}
