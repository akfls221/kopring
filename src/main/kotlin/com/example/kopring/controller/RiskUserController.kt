package com.example.kopring.controller

import com.example.kopring.controller.data.RiskUserData
import com.example.kopring.controller.data.RiskUserInfo
import com.example.kopring.service.riskuser.RiskUserQueryService
import com.example.kopring.service.riskuser.implement.RiskUserAddService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class RiskUserController(
    private val riskUserAddService: RiskUserAddService,
    private val riskUserQueryService: RiskUserQueryService
) {

    @PostMapping("/api/add")
    fun addRiskUser(@RequestBody @Valid request: RiskUserInfo.RegisterRequest): ResponseEntity<RiskUserInfo.RegisterResponse> {
        return ResponseEntity.ok(riskUserAddService.register(request.toRegisterInfo()))
    }

    @GetMapping("/api/{id}")
    fun detailRiskUser(@PathVariable id : Long): RiskUserData.FormData {
        return riskUserQueryService.getRiskUserById(id)
    }
}

