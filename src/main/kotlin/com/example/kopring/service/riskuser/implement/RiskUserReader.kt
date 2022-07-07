package com.example.kopring.service.riskuser.implement

import com.example.kopring.domain.RiskUser
import com.example.kopring.exception.TkException
import com.example.kopring.repository.RiskUserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component

@Component
class RiskUserReader(
    private val riskUserRepository: RiskUserRepository
) {
    fun readRisksUser(id: Long) : RiskUser{
        return riskUserRepository.findByIdOrNull(id)
            ?: throw TkException(
                status = HttpStatus.BAD_REQUEST,
                code = HttpStatus.BAD_REQUEST.value(),
                message = "존재하지 않는 블랙리스트 입니다."
            )
    }
}