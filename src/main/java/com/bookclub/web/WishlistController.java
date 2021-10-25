/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    URL: https://github.com/buwebdev/cis-530
    Modified By: Ernie Phillips III
    Created Date: 09/20/2021
    Modified Date: 09/20/2021
    Purpose: Wishlist controller for handling front-end to back-end requests dealing with wishlist items
*/

package com.bookclub.web;

import javax.validation.Valid;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MongoWishlistDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/wishlist") // requestMapping is setting of url mappings
public class WishlistController {
  WishlistDao wishlistDao = new MongoWishlistDao(); // create instance of child class from inherited parent

  @Autowired
  private void setWishlistDao(WishlistDao wishlistDao) {
    this.wishlistDao = wishlistDao;
  }

  /* GET ALL */
  @GetMapping
  public String showWishlist(Model model) { // return list of wishlist items
    return "wishlist/list";
  }

  /* GET BY ID */
  @RequestMapping(method = RequestMethod.GET, path = "/{id}")
  public String showWishlistItem(@PathVariable String id, Model model) { // pass the id in URL
    WishlistItem wishlistItem = wishlistDao.find(id); // find the entity
    model.addAttribute("wishlistItem", wishlistItem); // set the entity in model being returned
    return "wishlist/view";
  }

  /* GET NEW RECORD PAGE */
  @GetMapping("/new")
  public String wishlistForm(Model model) { // return page for new item
    model.addAttribute("wishlistItem", new WishlistItem());
    return "wishlist/new";
  }

  /* POST RECORD */
  @PostMapping // post to new page
  public String addWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult,
      Authentication authentication) {
    wishlistItem.setUsername(authentication.getName());// get the user's UN from principal and set in entity
    if (bindingResult.hasErrors()) // bindingResults evaluates form and any errors with boolean output
      return "wishlist/new"; // return current form back

    // add record to DB
    wishlistDao.add(wishlistItem);
    return "redirect:/wishlist";
  }

  /* UPDATE RECORD */
  @RequestMapping(method = RequestMethod.POST, path = "/update")
  public String updateWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult,
      Authentication authentication) {
    wishlistItem.setUsername(authentication.getName());// get the user's UN from principal and set in entity
    if (bindingResult.hasErrors()) { // check posted model for errors and redirect if any
      return "wishtlist/view";
    }
    wishlistDao.update(wishlistItem);// update the item
    return "redirect:/wishlist";
  }

  /* DELETE RECORD */
  @RequestMapping(method = RequestMethod.GET, path = "/remove/{id}")
  public String removeWishlistItem(@PathVariable String id) {
    wishlistDao.remove(id);
    return "redirect:/wishlist";
  }
}
