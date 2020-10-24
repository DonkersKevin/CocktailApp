package donkers.kevin.cocktailapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @RequestMapping({"", "/", "/index"})
    String getIndexPage(){
        return "index";
    }
}
