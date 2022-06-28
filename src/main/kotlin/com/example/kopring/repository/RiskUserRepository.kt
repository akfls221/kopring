package com.example.kopring.repository

import com.example.kopring.domain.RiskUser
import org.springframework.data.jpa.repository.JpaRepository

interface RiskUserRepository : JpaRepository<RiskUser, Long>{
}