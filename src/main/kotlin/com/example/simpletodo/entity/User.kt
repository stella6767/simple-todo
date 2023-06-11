package com.example.simpletodo.entity


import com.example.simpletodo.config.security.OAuth2UserInfo
import com.example.simpletodo.entity.type.SignType
import jakarta.persistence.*


@Entity
@Table(name = "user")
class User(
    username: String,
    email: String,
    password: String,
    rawData: String,
    signType: SignType,
    role: Role = Role.USER,
) : BaseEntity() {

    @Column(nullable = false)
    val username = username

    @Column(nullable = false, length = 100)
    val email = email

    @Column(nullable = false, length = 100)
    val password = password

    @Column(length = 5000)
    val rawData = rawData

    @Enumerated(EnumType.STRING)
    private val role = role

    @Enumerated(EnumType.STRING)
    private val signType = signType

    enum class Role {
        USER, ADMIN
    }

    companion object {


        fun createInstanceByOauth(oAuth2UserInfo: OAuth2UserInfo,
                                  encPassword: String,
                                  rawData: String): User {

            return User(
                username = oAuth2UserInfo.getUsername(),
                email = oAuth2UserInfo.getEmail()!!,
                password = encPassword,
                rawData = rawData,
                signType = oAuth2UserInfo.signType
            )
        }

    }


}