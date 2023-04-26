package br.com.jlgregorio.mybooks.service;

import br.com.jlgregorio.mybooks.dto.BookDTO;
import br.com.jlgregorio.mybooks.exception.ResourceNotFoundException;
import br.com.jlgregorio.mybooks.mapper.CustomModelMapper;
import br.com.jlgregorio.mybooks.model.BookModel;
import br.com.jlgregorio.mybooks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public BookDTO findById(int id){
        BookModel model = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não Encontrado!"));
        return CustomModelMapper.parseObject(model, BookDTO.class);
    }

    public List<BookDTO> findAll(){
        return CustomModelMapper.parseObjectList(repository.findAll(), BookDTO.class);
    }

    public BookDTO create(BookDTO dto){
        BookModel model = CustomModelMapper.parseObject(dto, BookModel.class);
        return CustomModelMapper.parseObject(repository.save(model), BookDTO.class);
    }

    public BookDTO update(BookDTO dto){
        var bookFound = repository.findById(dto.getId()).orElseThrow(() -> new ResourceNotFoundException("Não Encontrado!"));
        var updated = CustomModelMapper.parseObject(dto, BookModel.class);
        return CustomModelMapper.parseObject(repository.save(updated), BookDTO.class);
    }

    public void delete(int id){
        var bookFound = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não Encontrado!"));
        repository.delete(bookFound);
    }


}
