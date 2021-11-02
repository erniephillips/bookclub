/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    Modified By: Ernie Phillips III
    Created Date: 11/02/2021
    Modified Date: 11/02/2021
    Purpose: Data access object implementing the contract class for CRUD operations. 
*/

package com.bookclub.service.impl;

import java.util.List;

import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository("bookOfTheMonthDao")
public class MongoBookOfTheMonthDao implements BookOfTheMonthDao {
  @Autowired
  private MongoTemplate mongoTemplate; // template pattern for Spring to pass object(s) to data persistence layer

  @Override
  public List<BookOfTheMonth> list(String key) {
    int month = Integer.parseInt(key);

    if (month == 999) {
      return mongoTemplate.findAll(BookOfTheMonth.class);
    }

    return mongoTemplate.find(new Query().addCriteria(Criteria.where("month").is(month)), BookOfTheMonth.class);
  }

  @Override
  public void add(BookOfTheMonth entity) {
    mongoTemplate.save(entity);
  }

  @Override
  public void update(BookOfTheMonth entity) {
    BookOfTheMonth bookOfTheMonth = mongoTemplate.findById((entity.getId()), BookOfTheMonth.class);// find item by mongo _id
    if (bookOfTheMonth != null) {// check if item exists and set db records to incoming values
      bookOfTheMonth.setIsbn(entity.getIsbn());
      bookOfTheMonth.setMonth(entity.getMonth());

      // save the record
      mongoTemplate.save(bookOfTheMonth);
    }

  }

  @Override
  public boolean remove(String key) {
    var result = mongoTemplate.remove(new Query().addCriteria(Criteria.where("id").is(key)), BookOfTheMonth.class);
    return result.wasAcknowledged();
  }

  @Override
  public BookOfTheMonth find(String key) {
    return mongoTemplate.findById(key, BookOfTheMonth.class); // find by the key
  }

}
