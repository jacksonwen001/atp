package com.chancetop.atp.controllers;

import com.chancetop.atp.services.MockService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@RestController
public class MockController {
    @Autowired
    private MockService mockService;

    @RequestMapping("/mock/**")
    public void getResponse(HttpServletRequest request, HttpServletResponse response){
        mockService.dynamicMock(request, response);
    }

}
