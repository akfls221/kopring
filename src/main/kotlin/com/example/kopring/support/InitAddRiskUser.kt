package com.example.kopring.support

import com.example.kopring.repository.RiskUserRepository
import com.example.kopring.service.riskuser.implement.EntityMapper
import com.example.kopring.service.riskuser.vo.RegisterInfo
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Component

/**
 * 초기 로드시 100개의 임의 RiskUser을 DB에 넣기 위한 InitializingBean 작업
 */
@Component
class InitAddRiskUser(
    private val riskUserRepository : RiskUserRepository,
    private val entityMapper: EntityMapper
): InitializingBean{
    override fun afterPropertiesSet() {
        for (i in 1..100) {
            riskUserRepository.save(
                entityMapper.convertToEntity(
                    RegisterInfo(
                        accNo = "$i",
                        email = "akfls22$i@gmail.com",
                        reason = "init save$i",
                        mobile = "010-6242-694$i",
                        bank = "kakao$i",
                        bsb = "bsb$i",
                        localName = "owen$i",
                        lastName = "um$i",
                        firstName = "$i"
                    )
                )
            )
        }
    }
}