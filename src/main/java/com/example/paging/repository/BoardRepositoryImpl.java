package com.example.paging.repository;

import com.example.paging.entity.Board;
import com.example.paging.entity.QBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BoardRepositoryImpl implements BoardRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public BoardRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    QBoard board = QBoard.board;

//    @Override
//    public PageImpl<Board> getAll(Pageable pageable) {
//        List<Board> boardList = queryFactory.select(board)
//                .from(board)
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .fetch();
//        return new PageImpl<>(boardList, pageable, boardList.size());
//    }

    @Override
    public PageImpl<Board> getAll(Pageable pageable) {
        QueryResults<Board> results = queryFactory.select(board)
                .from(board)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }
}
