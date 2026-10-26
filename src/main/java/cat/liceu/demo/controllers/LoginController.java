package cat.liceu.demo.controllers;

import cat.liceu.demo.others.LoginForm;
import cat.liceu.demo.services.LoginService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping ("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@Valid @ModelAttribute LoginForm loginForm, Model model, BindingResult result, HttpSession session){
        if (result.hasErrors()){
            System.out.println("Error");
            return  "redirect:/login";
        }
        String username=loginForm.getUsername();
        String password=loginForm.getPassword();
        if(loginService.checkLogin(username,password)){
            session.setAttribute("username", loginForm.getUsername());
            return  "redirect:/private";
        }
        model.addAttribute("message","Usuari/pass incorrectes");
        return "login";
    }
    @GetMapping("/private")
    public String partPrivada(HttpSession session){
        String username= (String)session.getAttribute("username");
        if (username==null){
            return "redirect:/login";
        }
        return "private";
    }
}
