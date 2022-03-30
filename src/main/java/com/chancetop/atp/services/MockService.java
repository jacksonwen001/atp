package com.chancetop.atp.services;

import cn.hutool.http.server.HttpServerRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MockService {
    void dynamicMock(HttpServletRequest request, HttpServletResponse response);
}
