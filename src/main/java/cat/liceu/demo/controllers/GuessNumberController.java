package cat.liceu.demo.controllers;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class GuessNumberController {
   int target=0;
@GetMapping("/guess")
    public String guess(Model model, HttpSession session){
    target=new Random().nextInt(20);
    System.out.println(target);
  session.setAttribute("target",target);


    return "guess";
}
@PostMapping("/guess")
    public String guess2(Model model, @RequestParam int number, @SessionAttribute int target){

    String message="";
    if(number<target){
        message="numero massa petit";
        //num massa petit
    }else if(number> target){
        message="numero massa gros";
    }else{
        message="has acertat";
    }
    model.addAttribute("message",message);
    return "guess";
}
}
