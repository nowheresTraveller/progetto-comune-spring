package com.example.progettocomune.controller.simple;

import com.example.progettocomune.db.dao.interfaces.CittadinoDao;
import com.example.progettocomune.db.entity.Cittadino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PagDipController {

    @Autowired
    private CittadinoDao cittadinoDao;

    @GetMapping("/pagDipendente")
    public String getPagDipendente(Model model, HttpSession session){
        if(session.getAttribute("inSession")==null)
            return "redirect:/home";

        List<Cittadino> cittadinoList = cittadinoDao.selectAll();
        if (cittadinoList!=null){
            model.addAttribute("cittadinoList",cittadinoList);
        }

        return "pag_dipendente";
    }

    @PostMapping("/modificaCittadino")
    public String getPagModificaCittadino (Model model){
        Cittadino cittadino = (Cittadino)model.getAttribute("singoloCittadino");
        model.addAttribute("singoloCittadino",cittadino);
        return "pag_dipendente_mod_citt";
    }

    @PostMapping("/logoutAction")
    public String logout(HttpSession session){
        session.removeAttribute("inSession");
        session.removeAttribute("dipendente");
        return "redirect:/home";
    }
}
