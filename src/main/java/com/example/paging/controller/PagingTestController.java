package com.example.paging.controller;

import com.example.paging.entity.Board;
import com.example.paging.repository.BoardRepository;
import com.example.paging.util.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pagingTest")
public class PagingTestController {

    private final BoardRepository boardRepository;

    @GetMapping("")
    public PageImpl<Board> getAll(PageRequest pageRequest) {

        Pageable pageable = pageRequest.of();
        PageImpl<Board> result = boardRepository.getAll(pageable);
        return result;
    }
}
