package com.example.kopring.controller

import com.example.kopring.controller.data.RiskUserData
import com.example.kopring.controller.data.RiskUserInfo
import com.example.kopring.service.riskuser.implement.RiskUserAddService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RiskUserController(
    private val riskUserAddService: RiskUserAddService,
){

    @PostMapping("/api/add")
    fun addRiskUser(@RequestBody request: RiskUserInfo.RegisterRequest) : ResponseEntity<RiskUserInfo.RegisterResponse> {
        return ResponseEntity.ok(riskUserAddService.register(request.toRegisterInfo()))
    }
}

