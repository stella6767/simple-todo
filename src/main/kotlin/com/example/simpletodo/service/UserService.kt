package com.example.simpletodo.service

import com.example.simpletodo.config.security.UserPrincipal
import com.example.simpletodo.repository.UserRepository
import com.example.simpletodo.util.logger
import jakarta.persistence.EntityNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(
    private val userRepository: UserRepository,
) : UserDetailsService {

    private val log = logger()

    override fun loadUserByUsername(email: String): UserPrincipal? {

        log.debug("/login 이 호출되면 실행되어 username 이 DB에 있는지 확인한다.");

        val user =
            userRepository.findByEmail(email) ?: throw EntityNotFoundException()

        return UserPrincipal(user)
    }



}