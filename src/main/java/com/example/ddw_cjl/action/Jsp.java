package com.example.ddw_cjl.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class Jsp {
        @RequestMapping("/{pageName}")
        public String Jsp(@PathVariable("pageName") String pageName) {
            return pageName;
        }
}
