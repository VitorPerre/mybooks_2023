package br.com.jlgregorio.mybooks.controller;

import br.com.jlgregorio.mybooks.dto.BookDTO;
import br.com.jlgregorio.mybooks.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/api/book/v1")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable("id") int id){
        return service.findById(id);
    }

    @GetMapping
    public List<BookDTO> findAll(){
        return service.findAll();
    }

    @PostMapping
    public BookDTO create(@RequestBody BookDTO dto){
        return service.create(dto);
    }

    @PutMapping
    public BookDTO update(@RequestBody BookDTO dto){
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
        service.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }



}
