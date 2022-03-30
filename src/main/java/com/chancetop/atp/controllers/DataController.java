package com.chancetop.atp.controllers;

import com.chancetop.atp.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/data/**")
public class DataController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    @Autowired
    DataService dataService;

    /**
     * 如果是 get 请求， 那么直接调用 API 制造数据
     */
    @GetMapping
    public void getRequest() {
        dataService.invoke(response);
    }

    /**
     * 如果是 post 请求， 那么需要执行一系列的构造参数等内容， 然后再陆续调用 API 制造数据
     */
    @PostMapping
    public void postRequest(){
        dataService.makeData(request, response);
    }
}
