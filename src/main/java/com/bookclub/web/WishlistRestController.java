/*
    Krasso, R., (2021). CIS 530 Intermediate Java Programming. Bellevue University, all  rights reserved.
    https://www.amitph.com/spring-autowired-guide/
    Modified By: Ernie Phillips III
    Created Date: 10/11/2021
    Modified Date: 10/11/2021
    Purpose: Creating a RESTful controller for managing data exchanges with persistence layer in a decoupled architecture
*/

package com.bookclub.web;

import java.util.List;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MongoWishlistDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//inform Spring with specified path that outputs JSON formatted data sets
@RestController
@RequestMapping(path = "/api/wishlist", produces = "application/json") 
@CrossOrigin(origins = "*") //allow CORS from anywhere (lock this down to only application before deployment to Heroku)
public class WishlistRestController {
  WishlistDao wishlistDao = new MongoWishlistDao();

  @Autowired //DI the wishlist connection to local instance "has-a"/reuse DAO functionality
  private void setWishlistDao(WishlistDao wishlistDao){
    this.wishlistDao = wishlistDao;
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<WishlistItem> showWishlist(){
    return wishlistDao.list(); //return the list of items
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.GET)//any GET with id param
  public WishlistItem findById(@PathVariable String id){
    return wishlistDao.find(id);//get the wishlist item by id
  }


}
