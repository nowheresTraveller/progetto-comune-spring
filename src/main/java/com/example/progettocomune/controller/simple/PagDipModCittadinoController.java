package com.example.progettocomune.controller.simple;

import com.example.progettocomune.db.entity.Cittadino;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PagDipModCittadinoController {


    @GetMapping("/modCittadino/{nome}/{cognome}/{dataNascita}/{codiceFiscale}")
    public String getPagModCittadino (@PathVariable("nome") String nome, @PathVariable("cognome") String cognome,
                                      @PathVariable("dataNascita") String dataNascita,@PathVariable("codiceFiscale") String codiceFiscale,
                                      Model model){

        Cittadino cittadino = new Cittadino(nome,cognome,codiceFiscale,dataNascita);
        model.addAttribute("singoloCittadino",cittadino);
        return "pag_dipendente_mod_citt";
    }
}
