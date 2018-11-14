package com.wang.jmonkey.common.http.abs.controller;

import com.wang.jmonkey.common.http.abs.BaseHttp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Enumeration;

@Controller
@RequestMapping("/page")
public class PageController extends BaseHttp {

    @RequestMapping(value = "/{modules}/{views}/{page}.html", method = RequestMethod.GET)
    public String page (@PathVariable("modules") String modules, @PathVariable("views") String views, @PathVariable("page") String page, Model model) {

        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String name = params.nextElement();
            String value = request.getParameter(name);
            model.addAttribute(name, value);
        }

        return new StringBuilder("modules/").append(modules).append("/").append(views).append("/").append(page).toString();
    }
}
