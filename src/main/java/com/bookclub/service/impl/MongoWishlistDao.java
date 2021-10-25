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
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("wishlistDao") // create repo name
public class MongoWishlistDao implements WishlistDao { // implement the CRUD interface

  @Autowired // annotation for dependency injection allowing for resolve and injecting of
             // collaborating beans into this bean
  private MongoTemplate mongoTemplate; // template pattern for Spring to pass object(s) to data persistence layer

  @Override
  public List<WishlistItem> list(String username) {
    // construct a db query and find by the current user's username
    return mongoTemplate.find(new Query().addCriteria(Criteria.where("username").is(username)), WishlistItem.class);
  }

  @Override
  public void add(WishlistItem entity) {
    mongoTemplate.save(entity);
  }

  @Override
  public void update(WishlistItem entity) {
    WishlistItem wishlistItem = mongoTemplate.findById((entity.getId()), WishlistItem.class);// find item by mongo _id
    if (wishlistItem != null) {// check if item exists and set db records to incoming values
      wishlistItem.setIsbn(entity.getIsbn());
      wishlistItem.setTitle(entity.getTitle());
      wishlistItem.setUsername(entity.getUsername());

      // save the record
      mongoTemplate.save(wishlistItem);
    }

  }

  @Override
  public boolean remove(String key) {
    // what's the result t/f, can it be converted
    var result = mongoTemplate.remove(new Query().addCriteria(Criteria.where("id").is(key)), WishlistItem.class);
    // navigating to the remove() method has return type of 'DeleteResult'
    // navigating to DeleteResult library reveals an acknoledgement of if the record
    // was delete t/f
    return result.wasAcknowledged();
  }

  @Override
  public WishlistItem find(String key) {
    return mongoTemplate.findById(key, WishlistItem.class); // find by the key
  }

}
