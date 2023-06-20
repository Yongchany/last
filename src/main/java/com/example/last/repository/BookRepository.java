// BookRepository.java
package com.example.last.repository;

import com.example.last.dto.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookDTO, Long> {
    // 필요한 추가적인 메서드들을 선언할 수 있습니다.
}
