package com.example.kopring.service.riskuser

import com.example.kopring.controller.data.RiskUserData
import com.example.kopring.domain.RiskUser
import com.example.kopring.service.riskuser.implement.EntityMapper
import com.example.kopring.service.riskuser.implement.RiskUserReader
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

interface RiskUserQueryService {
    /**
     * 블랙리스트 유저 조회
     */
    fun getRiskUserById(id: Long) : RiskUserData.FormData

    fun getTotalRiskUser(pageable: Pageable) : Page<RiskUserData.FormData>

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

    override fun getTotalRiskUser(pageable: Pageable): Page<RiskUserData.FormData> {
        val page = if (pageable.pageNumber == 0) 0 else (pageable.pageNumber - 1)
        val pageRequest = PageRequest.of(page, 10)
        val totalRiskUser: Page<RiskUser> = riskUserReader.getTotalRiskUser(pageRequest)
        return totalRiskUser.map { entityMapper.convertToRiskUserInfoToRiskUserFormData(it) }
    }
}

