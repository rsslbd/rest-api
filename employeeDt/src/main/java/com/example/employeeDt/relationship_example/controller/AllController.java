package com.example.employeeDt.relationship_example.controller;



import com.example.employeeDt.relationship_example.many_2_many_entity.Author;
import com.example.employeeDt.relationship_example.many_2_many_entity.BookMM;
import com.example.employeeDt.relationship_example.one2one_entity.Address;
import com.example.employeeDt.relationship_example.one2one_entity.Library;
import com.example.employeeDt.relationship_example.one_to_many_entity.LibraryOM;
import com.example.employeeDt.relationship_example.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AllController {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    LibraryRepository libraryRepository;

    @Autowired
    LibraryOMRepository libraryOMRepository;

    @Autowired
    BookRepository bookRepository;


    @Autowired
    BookMMRepository bookMMRepository;

    @Autowired
    AuthorRepository authorRepository;

    //One to One
    @PostMapping(value = "/address")
    public Address saveAddress(@RequestBody Address address){
        return addressRepository.save(address);
    }
    /*
    http://localhost:8081/address

    {
    "location": "Test Library 2",
    "library": {
        "id": 36
    }
    }
    * */

    @GetMapping(value = "/address")
    public List<Address> saveAddress(){
        List<Address> addresses = (List<Address>) addressRepository.findAll();
        addresses.forEach((c) -> c.getLibrary().setAddress(null));
        return addresses;
    }

    @PostMapping(value = "/library")

//    @RequestMapping(value = "/library",method = RequestMethod.POST)

    public Library saveLibrary(@RequestBody Library library){
        return libraryRepository.save(library);
    }

    /*
    {
    "name": "Test Library 2",
    "address": {
        "location": "Khulna"
    }
    }
    */

    @GetMapping(value = "/library")
    public List<Library> saveLibrary(){
        List<Library> libraryList = libraryRepository.findAll();
        libraryList.forEach((c) -> c.getAddress().setLibrary(null));
        return libraryList;
    }



    //One to many

    @PostMapping(value = "/libraryOM")
    public LibraryOM saveLibraryOM(@RequestBody LibraryOM libraryOM){
        return libraryOMRepository.save(libraryOM);
    }

    /*
{
    "name": "saiful.alam",
    "books": [
        {
            "title": "ffff"
        },
        {
            "title": "AAAAA"
        }
    ]
}
    */

    @GetMapping(value = "/libraryOM")
    public List<LibraryOM> saveLibraryOm(){
        List<LibraryOM> libraryList = libraryOMRepository.findAll();
//        libraryList.forEach((c) -> c.getAddress().setLibrary(null));

        return libraryList;
    }



    //Many to Many



    @PostMapping(value = "/bookMM")
    public BookMM saveBookMM(@RequestBody BookMM bookMM){
        return bookMMRepository.save(bookMM);
    }


    @GetMapping(value = "/bookMM")
    public List<BookMM> saveBookMM(){
        List<BookMM> bookMMList = bookMMRepository.findAll();
//        libraryList.forEach((c) -> c.getAddress().setLibrary(null));

        return bookMMList;
    }



    @PostMapping(value = "/author")
    public Author saveAuthor(@RequestBody Author author){
        return authorRepository.save(author);
    }

    /*
{
    "name": "saiful.alam",
    "books": [
        {
            "title": "ffff"
        },
        {
            "title": "AAAAA"
        }
    ]
}
    */

    @GetMapping(value = "/author")
    public List<Author> saveAuthor(){
        List<Author> authorList = authorRepository.findAll();
//        libraryList.forEach((c) -> c.getAddress().setLibrary(null));
        return authorList;
    }


}
