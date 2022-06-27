package com.example.kopring.domain.core

import java.io.Serializable
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class AbstractEntity (
    @Id
    @GeneratedValue
    val id: Long? = null
) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AbstractEntity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "id=$id"
    }
}