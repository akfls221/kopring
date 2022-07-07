package com.example.kopring.service.riskuser

import com.example.kopring.controller.data.RiskUserData
import com.example.kopring.exception.TkException
import com.example.kopring.exception.enum.Status
import com.example.kopring.repository.RiskUserRepository
import com.example.kopring.service.riskuser.implement.EntityMapper
import com.example.kopring.service.riskuser.implement.RiskUserReader
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

interface RiskUserQueryService {
    /**
     * 블랙리스트 유저 조회
     */

    fun getRiskUserById(id: Long) : RiskUserData.FormData

}

@Service
@Transactional(readOnly = true)
class RiskUserQueryServiceImpl(
    private val entityMapper: EntityMapper,
    private val riskUserReader: RiskUserReader
):RiskUserQueryService {

    override fun getRiskUserById(id: Long): RiskUserData.FormData {
        val readRiskUser = riskUserReader.readRisksUser(id)
        return entityMapper.convertToRiskUserInfoToRiskUserFormData(readRiskUser)
    }

}

