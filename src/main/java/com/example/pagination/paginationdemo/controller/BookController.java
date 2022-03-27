package com.example.pagination.paginationdemo.controller;

import com.example.pagination.paginationdemo.dao.BookDao;
import com.example.pagination.paginationdemo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookDao bookDao;

    //@PostConstruct
    public ResponseEntity<?> addBook(){

        List<Book> lstBook = new ArrayList<>();
        lstBook.add(new Book(1, "JAVA", "447GT", "Ramesh"));
        lstBook.add(new Book(2, "SQL", "447GTQ", "HIMESH"));
        lstBook.add(new Book(3, "SPRING", "447WGT", "MAMA"));
        lstBook.add(new Book(4, "SPRING MVC", "E447GT", "MANAS"));
        lstBook.add(new Book(5, "SPRING BOOT", "T447GT", "LOKI"));
        lstBook.add(new Book(6, "DS", "447GTT", "SIDDHARTHA"));
        lstBook.add(new Book(7, "ALGO", "447GYT", "UDAY"));
        lstBook.add(new Book(8, "PYTHON", "447HGT", "KRISHNA"));
        lstBook.add(new Book(9, "JAVASCRIPT", "J447GT", "LOKA"));
        bookDao.saveAll(lstBook);
        return ResponseEntity.ok("Data has been saved");

    }

    @GetMapping("/getallbooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> lst = bookDao.findAll();
        return ResponseEntity.ok(lst);
    }

    @GetMapping("/getbook")
    public ResponseEntity<Map<String, Object>>  getAllByPagination(
            @RequestParam(required = false) String bookName, @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size){

        try{
            List<Book> book = new ArrayList<>();
            Pageable pageable = PageRequest.of(page, size);
            Page<Book> pagelst;
            if(bookName == null){
                pagelst = bookDao.findAll(pageable);
            }else {
                pagelst = bookDao.findByBookNameContaining(bookName, pageable);
            }
            book = pagelst.getContent();
            Map<String, Object> resp = new HashMap<>();
            resp.put("resp", book);
            resp.put("currentPage", pagelst.getNumber());
            resp.put("totalItems", pagelst.getTotalPages());
            return new ResponseEntity<>(resp, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
