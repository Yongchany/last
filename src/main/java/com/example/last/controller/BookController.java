package com.example.last.controller;

import com.example.last.dto.BookDTO;
import com.example.last.dto.PageRequestDTO;
import com.example.last.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
@Log4j2
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/")
    public String index(){
        return "redirect:/book/list";
    }

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        log.info("페이지 요청 정보" + pageRequestDTO);
        model.addAttribute("result", bookService.getList());
    }

    @GetMapping("/register")
    public void register(){
        log.info("show register");
    }

    @PostMapping("/register")
    public String registerPost(BookDTO dto, RedirectAttributes redirectAttributes){
        log.info("등록처리 후 목록페이지 리다이렉트");
        bookService.register(dto);
        redirectAttributes.addFlashAttribute("msg", dto.getGno());
        return "redirect:/book/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(@RequestParam("gno") Long gno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model){
        log.info("gno: " + gno);
        BookDTO dto = bookService.read(gno);
        model.addAttribute("dto", dto);
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("gno") Long gno, RedirectAttributes redirectAttributes){
        log.info("gno: " + gno);
        bookService.remove(gno);
        redirectAttributes.addFlashAttribute("msg", gno);
        return "redirect:/book/list";
    }

    @PostMapping("/modify")
    public String modify(BookDTO dto, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, RedirectAttributes redirectAttributes){
        bookService.modify(dto);

        redirectAttributes.addAttribute("page", requestDTO.getPage());
        redirectAttributes.addAttribute("gno", dto.getGno());
        return "redirect:/book/read";
    }
}
