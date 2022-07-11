package com.example.kopring.service.riskuser

import com.example.kopring.controller.data.RiskUserInfo
import com.example.kopring.service.riskuser.implement.EntityMapper
import com.example.kopring.service.riskuser.implement.RiskUserAppend
import com.example.kopring.service.riskuser.vo.ModifyInfo
import org.springframework.data.jpa.repository.Modifying
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

interface RiskUserModifyService {

    fun modify(id: Long, request: ModifyInfo): RiskUserInfo.ModifyResponse
}

@Service
@Transactional
class RisUserModifyServiceImpl(
    private val entityMapper: EntityMapper,
    private val riskUserAppend : RiskUserAppend
) : RiskUserModifyService {

    override fun modify(id: Long, request: ModifyInfo): RiskUserInfo.ModifyResponse {
        val modifyRiskUser = riskUserAppend.update(id, request)
        return entityMapper.convertToRiskUserModifyResponse(modifyRiskUser)
    }
}