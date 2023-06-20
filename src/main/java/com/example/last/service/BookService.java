package com.example.last.service;

import com.example.last.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getList();
    BookDTO read(Long id);
    void register(BookDTO book);
    void modify(BookDTO book);
    void remove(Long id);
}
