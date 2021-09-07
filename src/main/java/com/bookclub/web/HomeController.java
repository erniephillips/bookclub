/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    URL: https://github.com/buwebdev/cis-530
    Modified By: Ernie Phillips III
    Created Date: 09/07/2021
    Modified Date: 09/07/2021
    Purpose: Home controller for dishing back main static application pages. Other controllers will likely follow for logic and other needed pieces
*/
package com.bookclub.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller //declare that class is of they controller. Similar to inheritance of controller class in .NET, i.e. HomeController : Controller {}
@RequestMapping("/") //requestMapping is setting of url mappings
public class HomeController {
  
  @RequestMapping(method = RequestMethod.GET) //route all base get requests to this method
  public String showHome(Model model) { //pass the current model (if any)
      return "index"; //return string value of the html page to be returned
  }

  @RequestMapping(path = "/about", method = RequestMethod.GET) //above comments apply the same for this and next method, rather map /about and /contact
  public String showAboutUs(Model model) {
      return "about";
  }

  @RequestMapping(path = "/contact", method = RequestMethod.GET)
  public String ShowContactUs(Model model) {
      return "contact";
  }
}
