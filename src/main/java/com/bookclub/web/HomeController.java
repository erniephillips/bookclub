/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    URL: https://github.com/buwebdev/cis-530
    Modified By: Ernie Phillips III
    Created Date: 09/07/2021
    Modified Date: 09/13/2021
    Purpose: Home controller for dishing back main static application pages. Other controllers will likely follow for logic and other needed pieces
*/
package com.bookclub.web;

import java.util.List;

import com.bookclub.model.Book;
import com.bookclub.service.impl.RestBookDao;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // declare that class is of they controller. Similar to inheritance of
            // controller class in .NET, i.e. HomeController : Controller {}
@RequestMapping("/") // requestMapping is setting of url mappings
public class HomeController {

    @RequestMapping(method = RequestMethod.GET) // route all base get requests to this method
    /*HOME PAGE*/
    public String showHome(Model model) { // pass the current model (if any)
        RestBookDao bookDao = new RestBookDao(); //instantiate the book data access object
        List<Book> books = bookDao.list(); //create a list of five books from dao
        
        for (Book book : books){//loop through the books and output default overridden string method to console
            System.out.println(book.toString());    
        }

        //map the books list to the model being sent to the view
        model.addAttribute("books", books);
        
        return "index"; // return string value of the html page to be returned
    }

    /*GET BOOK BY ID*/
    @RequestMapping(method = RequestMethod.GET, value = "/{id}") //only allow requests of type GET to the path /id
    public String getMonthlyBook(@PathVariable("id") String id, Model model){//let the method know param is string and stored in URL param string id
        String isbn = id; //set the isbn to be searched
        
        RestBookDao bookDao = new RestBookDao(); //instantiate the book data access object
        Book book = bookDao.find(isbn); //call the access layer to find specific book

        System.out.println(book.toString()); //output the found book, if none, new empty book obj is returned
        model.addAttribute("book", book); //store book in model
        return "monthly-books/view"; //return to view
    }

    @RequestMapping(path = "/about", method = RequestMethod.GET) // above comments apply the same for this and next
                                                                 // method, rather map /about and /contact
    public String showAboutUs(Model model) {
        return "about";
    }

    @RequestMapping(path = "/contact", method = RequestMethod.GET)
    public String ShowContactUs(Model model) {
        return "contact";
    }
}
