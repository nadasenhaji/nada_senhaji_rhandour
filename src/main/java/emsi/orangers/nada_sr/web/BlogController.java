package emsi.orangers.nada_sr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {


    @GetMapping("/blog")
    public String showBlog() {

        return "blog";
    }
}
