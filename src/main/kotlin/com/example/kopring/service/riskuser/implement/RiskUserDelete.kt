package com.example.kopring.service.riskuser.implement

import com.example.kopring.controller.data.RiskUserInfo
import com.example.kopring.exception.TkException
import com.example.kopring.exception.enum.Status
import com.example.kopring.repository.RiskUserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@Transactional
class RiskUserDelete(
    private val riskUserRepository: RiskUserRepository,
    private val entityMapper: EntityMapper
) {

    fun deleteUser(id: Long) : RiskUserInfo.DeleteResponse{
        val riskUser = riskUserRepository.findById(id).orElseThrow{ throw TkException(
            HttpStatus.BAD_REQUEST,
            Status.NoExistEx.code,
            Status.NoExistEx.dec
        )}
        riskUserRepository.deleteById(id)
        return entityMapper.convertToRiskUserDeleteResponse(riskUser)
    }

}