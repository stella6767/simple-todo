package com.example.simpletodo.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate

import org.springframework.data.annotation.LastModifiedDate
import java.io.Serializable
import java.time.LocalDateTime


@Entity
@Table(name = "todo")
class Todo(
    id:Long,
    desc:String,
    status:Boolean,
) : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = id

    @Column
    var desc = desc

    @Column
    val status: Boolean = status


    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()
        protected set

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
        protected set

}