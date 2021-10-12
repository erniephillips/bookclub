/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    URL: https://github.com/buwebdev/cis-530
    Modified By: Ernie Phillips III
    Created Date: 09/20/2021
    Modified Date: 09/20/2021
    Purpose: Wishlist controller for handling front-end to back-end requests dealing with wishlist items
*/

package com.bookclub.web;

import java.util.List;

import javax.validation.Valid;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MongoWishlistDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/wishlist") // requestMapping is setting of url mappings
public class WishlistController {
  WishlistDao wishlistDao = new MongoWishlistDao(); //create instance of child class from inherited parent

  @Autowired
  private void setWishlistDao(WishlistDao wishlistDao){
    this.wishlistDao = wishlistDao;
  }

  @GetMapping
  public String showWishlist(Model model){ //return list of wishlist items  
    return "wishlist/list";
  }

  @GetMapping("/new")
  public String wishlistForm(Model model){ //return page for new item
    model.addAttribute("wishlistItem", new WishlistItem());
    return "wishlist/new";
  }

  @PostMapping //post to new page
  public String addWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult){
    if(bindingResult.hasErrors()) //bindingResults evaluates form and any errors with boolean output
      return "wishlist/new"; //return current form back

    //add record to DB
    wishlistDao.add(wishlistItem);
    return "redirect:/wishlist";
  }
}
