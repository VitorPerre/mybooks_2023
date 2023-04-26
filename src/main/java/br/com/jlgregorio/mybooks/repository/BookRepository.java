package br.com.jlgregorio.mybooks.repository;

import br.com.jlgregorio.mybooks.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer> {


}
