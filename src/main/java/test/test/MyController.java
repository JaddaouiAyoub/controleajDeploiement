//package test.test;
//
//import org.springframework.ui.Model;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class MyController {
//
//    @GetMapping("/")
//    public String home(Model model) {
//        model.addAttribute("message", "Bienvenue sur la page d'accueil!");
//        return "index";
//    }
//
//    @GetMapping("/thymeleaf")
//    public String thymeleaf(Model model) {
//        model.addAttribute("message", "Ceci est une page Thymeleaf");
//        return "thymeleaf";
//    }
//
//    @GetMapping("/jsp")
//    public String jsp(Model model) {
//        model.addAttribute("message", "Ceci est une page JSP");
//        return "jsp";
//    }
//}
//
