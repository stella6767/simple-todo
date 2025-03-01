package com.example.simpletodo.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate

import org.springframework.data.annotation.LastModifiedDate
import java.io.Serializable
import java.time.LocalDateTime


@Entity
@Table(name = "todo")
class Todo(
    id:Long = 0,
    content:String,
    status:Boolean = false,
    user: User,
) : BaseEntity(id = id) {


    @Column
    var content = content

    @Column
    var status: Boolean = status


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user = user


}