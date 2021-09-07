/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    URL: https://github.com/buwebdev/cis-530
    Modified By: Ernie Phillips III
    Created Date: 09/01/2021
    Modified Date: 09/01/2021
    Purpose: Main class for bootstrapping the application
*/
package com.bookclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookclubApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookclubApplication.class, args);
    }

}
