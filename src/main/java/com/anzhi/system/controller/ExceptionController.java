package com.anzhi.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.ShiroException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.anzhi.common.domain.AzResponse;


@RestControllerAdvice
public class ExceptionController {
	private final AzResponse resultMap;

    @Autowired
    public ExceptionController(AzResponse resultMap) {
        this.resultMap = resultMap;
    }

    // 捕捉shiro的异常
    @ExceptionHandler(ShiroException.class)
    public AzResponse handle401() {
        return resultMap.fail().data(401).message("您没有权限访问！");
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    public AzResponse globalException(HttpServletRequest request, Throwable ex) {
        return resultMap.fail()
                .data(getStatus(request).value())
                .message("访问出错，无法访问: " + ex.getMessage());
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
