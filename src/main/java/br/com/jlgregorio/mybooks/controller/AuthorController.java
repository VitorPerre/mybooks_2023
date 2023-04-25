package br.com.jlgregorio.mybooks.controller;

import br.com.jlgregorio.mybooks.dto.AuthorDTO;
import br.com.jlgregorio.mybooks.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @PostMapping
    public AuthorDTO create(@RequestBody AuthorDTO dto){
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public AuthorDTO findById(@PathVariable("id") int id){
        return service.findById(id);
    }

    @GetMapping
    public List<AuthorDTO> findAll(){
        return service.findAll();
    }

    @PutMapping
    public AuthorDTO update(@RequestBody AuthorDTO dto){
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
        service.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }




}
