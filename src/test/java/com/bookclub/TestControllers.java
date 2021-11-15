package com.bookclub;

import static org.assertj.core.api.Assertions.assertThat;

//import com.bookclub.web.AdminController;
import com.bookclub.web.HomeController;
import com.bookclub.web.WishlistController;
import com.bookclub.web.WishlistRestController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestControllers {
  @Autowired
  //private AdminController adminController;
  private WishlistController wishlistController;
  private WishlistRestController wishlistRestController;
  private HomeController homeController;

  @Test /*THESE ALL FAIL Is this due to authentication being required to access them?*/
  public void contextLoads() throws Exception{
    //assertThat(adminController).isNotNull(); 
    assertThat(wishlistController).isNotNull();
    assertThat(wishlistRestController).isNotNull();
    assertThat(homeController).isNotNull();
  }
}
