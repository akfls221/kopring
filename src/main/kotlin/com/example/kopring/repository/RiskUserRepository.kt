package com.example.kopring.repository

import com.example.kopring.domain.RiskUser
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface RiskUserRepository : JpaRepository<RiskUser, Long>{
    @Query("select r from RiskUser r order by r.id desc ")
    fun findAllBasic(pageable: Pageable): Page<RiskUser>

}