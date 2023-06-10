package com.example.simpletodo.repository

import com.example.simpletodo.entity.QTodo
import com.example.simpletodo.entity.QTodo.*
import com.example.simpletodo.entity.Todo
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.support.PageableExecutionUtils

interface TodoCustomRepository {

    fun findTodos(pageable: Pageable): Page<Todo>

}



class TodoCustomRepositoryImpl(
    private val queryFactory: JPAQueryFactory,
    private val em: EntityManager,
) : TodoCustomRepository {


    override fun findTodos(pageable: Pageable): Page<Todo> {

        val fetch = queryFactory
            .selectFrom(todo)
//            .where(
//
//            )
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .orderBy(todo.id.desc())
            .fetch()

        val countQuery = queryFactory
            .select(todo.count())
            .from(todo)
            //.where()
            .fetchOne() ?: 0


        return PageableExecutionUtils.getPage(
            fetch, pageable
        ) { countQuery }
    }

}