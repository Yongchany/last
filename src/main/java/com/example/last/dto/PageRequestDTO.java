package com.example.last.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageRequestDTO {
    private int page;
    private int size;

    // 생성자, getter, setter, toString 등 필요한 메서드들을 추가하세요
    // ...

    public int getPage() {
        return page;
    }
}
