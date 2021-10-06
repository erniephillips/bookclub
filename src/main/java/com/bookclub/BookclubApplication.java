/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    URL: https://github.com/buwebdev/cis-530
         https://www.geeksforgeeks.org/how-to-encrypt-passwords-in-a-spring-boot-project-using-jasypt/
    Modified By: Ernie Phillips III
    Created Date: 09/01/2021
    Modified Date: 09/27/2021
    Purpose: Main class for bootstrapping the application
    Modification: Adding Jasypt annotation to tell app to look for decrypt key and ENC() values anywhere in app
*/
package com.bookclub;

//import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
//@EnableEncryptableProperties //Adding Jasypt annotation to tell app to look for decrypt key and ENC() values anywhere in app
public class BookclubApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookclubApplication.class, args);
    }

}
