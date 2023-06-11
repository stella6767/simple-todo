package com.example.simpletodo.repository

import com.example.simpletodo.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>, UserCustomRepository {

}