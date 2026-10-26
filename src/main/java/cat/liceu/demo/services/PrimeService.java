package cat.liceu.demo.services;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PrimeService {



   public  List<List<Integer>> getPrimes(int n){
        int con = 0;
        List<Integer> numeros = new ArrayList<>();

        for (int i = 2; con < n; i++) {
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

        //model.addAttribute("numeros", numeros);
       List<List<Integer>> rows=new ArrayList<>();
        int nelemsRow=4;
        int ind=1;
        while ((ind < numeros.size())){
            List<Integer> row=new ArrayList<>();
            for (int i = 0; i < 4 && ind<rows.size(); i++) {
                row.add(numeros.get(ind));
                ind++;
            }
        }
       return numeros;

    }
    }

