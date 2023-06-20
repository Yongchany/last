package com.example.last.service;

import com.example.last.dto.BookDTO;
import com.example.last.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> getList() {
        return bookRepository.findAll();
    }

    @Override
    public BookDTO read(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void register(BookDTO book) {
        bookRepository.save(book);
    }

    @Override
    public void modify(BookDTO book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Long id) {
        bookRepository.deleteById(id);
    }
}
