package com.bookclub.service.impl;

import java.util.ArrayList;
/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    Modified By: Ernie Phillips III
    Created Date: 09/20/2021
    Modified Date: 09/20/2021
    Purpose: class that implements contract between generic dao and wishlistitem dao extension through inheritance
*/

import java.util.List;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

public class MemWishlistDao implements WishlistDao {
  List<WishlistItem> wishlistItem = null;
  public MemWishlistDao(){
    wishlistItem = new ArrayList<WishlistItem>(
      List.of(
        new WishlistItem("0-4264-2316-X", "Duke Without A Home"),
        new WishlistItem("0-5969-5811-0", "The Buried Grave"),
        new WishlistItem("0-8269-0427-0", "Warrior Of The World"),
        new WishlistItem("0-4275-6298-8", "Rebels And Creators"),
        new WishlistItem("0-2766-5225-8", "Breath Of The West")
    ));
  }

  @Override //override the list method declared in the generic dao interface
  public List<WishlistItem> list(){ //return the list of books
    return this.wishlistItem;
  }

  @Override //override the generic dao find method to return specific book
  public WishlistItem find(String key){
    for (WishlistItem wli : this.wishlistItem){
      if(wli.getIsbn().equals(key))
        return wli;
    }
    return new WishlistItem();
  }

  //custom add method just so I can see data update on wishlist page
  public List<WishlistItem> add(WishlistItem wli){
    this.wishlistItem.add(wli);
    return list();
  }
}
