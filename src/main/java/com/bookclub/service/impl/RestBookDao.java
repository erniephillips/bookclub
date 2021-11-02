/*
    Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all  rights reserved.
    https://www.baeldung.com/spring-uricomponentsbuilder
    Modified By: Ernie Phillips III
    Created Date: 09/13/2021
    Modified Date: 11/02/2021
    Purpose: class that implements contract between generic dao and book dao extension through inheritance
*/

package com.bookclub.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.ArrayList;
import java.util.List;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.MediaType;

public class RestBookDao implements BookDao {

  public RestBookDao() {

  }

  private Object getBooksDoc(String isbnString){ //send a GET req to an API and retrieve list of books by isbn string
    String apiUrl = "https://openlibrary.org/api/books"; //DOCUMENTATION: https://openlibrary.org/dev/docs/api/books
    //rest template provides simplified approach using HTTP protocols to synchronously call APIs
    RestTemplate rest = new RestTemplate(); //will be deprecated and should use WebClient. https://www.baeldung.com/rest-template
    HttpHeaders headers = new HttpHeaders(); //instantiate header object to set below
    headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE); //MediaType.APPLICATION_JSON is a "public constant media type for application/json", whereas MediaType.APPLICATION_JSON_VALUE is a "String equivalent of MediaType.APPLICATION_JSON
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl) //helps to create UriComponents instances by providing fine-grained control over all aspects of preparing a URI including construction, expansion from template variables, and encoding.
      .queryParam("bibkeys", isbnString) //list of IDs to request info: API supports ISBNs, LCCNs, OCLC numbers and OLIDs (Open Library IDs).
      .queryParam("format", "json")//Optional parameter which specifies the response format. Possible values are json and javascript. The default format is javascript.
      .queryParam("jscmd", "details");//Optional parameter to decide what information to provide for each matched bib_key. Possible values are viewapi and data. The default value is viewapi.
    HttpEntity<?> entity = new HttpEntity<>(headers); //set the entity request
    HttpEntity<String> response = rest.exchange(//get the response
      builder.toUriString(), //url 
      HttpMethod.GET, //request protocol
      entity, //request headers
      String.class); //Is this mapping the JSON to the BOOK object???? I don't think so, I think it is going to a string
    String jsonBooklist = response.getBody(); //get the returned results, probably that String.class above
    return Configuration.defaultConfiguration().jsonProvider().parse(jsonBooklist); //return the json string parsed by each book. When is it mapped to the book object? Still a string here regaurdless. 
  }

  @Override // override the list method declared in the generic dao interface
  public List<Book> list(String key) { // return the list of books
    String isbnString = "ISBN:9780593099322,9780261102361,9780261102378,9780590302715,9780316769532";
    Object document = getBooksDoc(isbnString); //store the parsed JSON string into this document variable
    List<Book> books = new ArrayList<Book>(); //where the books from object will be stored

    //store object values in list to be indexed and create book objects. This answers above question about how book object is created
    List<String> titles = JsonPath.read(document, "$..title");
    List<String> isbns = JsonPath.read(document, "$..bib_key");
    List<String> infoUrls = JsonPath.read(document, "$..info_url");

    //create the book objects by indexed list items from parsed JSON. I wonder if there is an easier way to map the JSON to an object, rather than create a bunch of in-memory lists.
    //For instance C# MVC, serialized JSON is mapped directly on a field name basis to the model object
    for (int index = 0; index < titles.size(); index++) {
        books.add(new Book(isbns.get(index), titles.get(index), infoUrls.get(index)));
    }
    return books;
  }

  @Override // override the generic dao find method to return specific book
  public Book find(String isbn) {
    Object document = getBooksDoc(isbn); 

    //store object values in list to be indexed and create book objects. This answers above question about how book object is created
    List<String> isbns = JsonPath.read(document, "$..bib_key");
    List<String> titles = JsonPath.read(document, "$..title");
    List<String> descriptions = JsonPath.read(document, "$..details.description.value");
    List<String> infoUrls = JsonPath.read(document, "$..info_url");
    List<Integer> pages = JsonPath.read(document, "$..details.number_of_pages");

    //create a new book object through ternary operations
    return new Book(
      ((isbns.size() > 0) ? isbns.get(0) : "N/A"),
      ((titles.size() > 0) ? titles.get(0) : "N/A"),
      ((descriptions.size() > 0) ? descriptions.get(0) : "N/A"),
      ((infoUrls.size() > 0) ? infoUrls.get(0) : "N/A"),
      ((pages.size() > 0) ? pages.get(0) : 0)
    );
  }
}
