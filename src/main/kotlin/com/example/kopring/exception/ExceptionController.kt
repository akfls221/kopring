package com.example.kopring.exception

import com.example.kopring.exception.enum.Status
import com.example.kopring.logger.logger
import com.example.kopring.support.stackTrace
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionController {

    val log = logger()

    /**
     * @Validated, @Valid 에서 발생한 Error Handler
     * BindingResult 에서 발생 한 Exception 에 대한 ExceptionHandler
     */
    @ExceptionHandler(org.springframework.validation.BindException::class)
    fun bindingException(request: HttpServletRequest, error: BindException): ResponseEntity<ResponseError> {
        log.error(
            "Request Address: {}, URL: {}, message: {}, Bind Exception: {}",
            request.remoteHost,
            request.requestURL,
            error.message,
            error.stackTrace()
        )
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(ResponseError(HttpStatus.BAD_REQUEST.value(), error.message))
    }
}