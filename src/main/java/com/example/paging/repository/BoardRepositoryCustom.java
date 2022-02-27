package com.example.paging.repository;

import com.example.paging.entity.Board;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public interface BoardRepositoryCustom {

    PageImpl<Board> getAll(Pageable pageable);
}
