package cat.liceu.demo.controllers;

import cat.liceu.demo.services.PrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/liceu")
public class HelloController {
    @Autowired
    PrimeService primeService;
    @GetMapping("/")
    public String hello(Model model){
      //escriure una taula de 100 números primers
        // 2,3,5,7,11,13,17,23
            //formatar en taula de 4 columnes
        //2,3,5,7
        //11,13,17,23
        int con = 0;
        List<Integer> numeros = new ArrayList<>();

        for (int i = 2; con < 100; i++) {
            int divisores = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    divisores++;
                }
            }

            if (divisores == 2) {
                con++;
                numeros.add(i);
            }
        }

        model.addAttribute("numeros", numeros);
        return "hello";
    }

    @GetMapping("/primes/{n}/{nom}")
    public String hola(@PathVariable int n, @PathVariable String nom, Model model) {
        List<List<Integer>> primes = primeService.getPrimes(n);

        model.addAttribute("numeros", primes);
        model.addAttribute("nom", nom);

        return "hello";
    }

    @GetMapping("/goodbye")
    public String goodbye() {
        return "goodbye";
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }
}

