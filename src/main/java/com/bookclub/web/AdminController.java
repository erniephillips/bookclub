/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    Modified By: Ernie Phillips III
    Created Date: 11/02/2021
    Modified Date: 11/02/2021
    Purpose: Admin controller for updating the monthly book list 
*/

package com.bookclub.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;
import com.bookclub.service.impl.MongoBookOfTheMonthDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/monthly-books")
public class AdminController {
    @Autowired

    BookOfTheMonthDao bookOfTheMonthDao = new MongoBookOfTheMonthDao();

    public void setBookOfTheMonthDao(BookOfTheMonthDao bookOfTheMonthDao) {
        this.bookOfTheMonthDao = bookOfTheMonthDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showBookOfTheMonth(Model model) {
        model.addAttribute("books", bookOfTheMonthDao.list("999")); // set to specific value in case of empty or null
        return "monthly-books/list";
    }

    /* GET new record */
    // return the page for new book of the month with BOTM object and list of months
    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String bookOfTheMonthForm(Model model) {
        model.addAttribute("months", getMonths());
        model.addAttribute("bookOfTheMonth", new BookOfTheMonth());
        return "monthly-books/new";
    }

    /* POST new record */
    @RequestMapping(method = RequestMethod.POST)
    public String addBookOfTheMonth(@Valid BookOfTheMonth bookOfTheMonth, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) { // check posted model for inconsistencies and return if errored
            model.addAttribute("months", getMonths()); // return mapping of months again
            return "monthly-books/new";
        }

        bookOfTheMonthDao.add(bookOfTheMonth); // add book to db
        return "redirect:/monthly-books";
    }

    /* GET removed the record */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}") // probably safer with a post??
    public String removeBookOfTheMonth(@PathVariable String id) { // find id
        bookOfTheMonthDao.remove(id); // remove from db
        return "redirect:/monthly-books";
    }

    // creating a mapping for all months of the year
    private Map<Integer, String> getMonths() {
        Map<Integer, String> months = new HashMap<>();
        months.put(1, "January");
        months.put(2, "February");
        months.put(3, "March");
        months.put(4, "April");
        months.put(5, "May");
        months.put(6, "June");
        months.put(7, "July");
        months.put(8, "August");
        months.put(9, "September");
        months.put(10, "October");
        months.put(11, "November");
        months.put(12, "December");

        return months;
    }
}
