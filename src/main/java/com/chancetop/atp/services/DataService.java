package com.chancetop.atp.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DataService {
    void invoke(HttpServletResponse response);
    void makeData(HttpServletRequest request, HttpServletResponse response);

}
