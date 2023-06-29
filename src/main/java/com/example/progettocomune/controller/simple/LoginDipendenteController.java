package com.example.progettocomune.controller.simple;

import com.example.progettocomune.db.dao.interfaces.DipendenteDao;
import com.example.progettocomune.db.entity.Dipendente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginDipendenteController {

    @Autowired
    private DipendenteDao dipendenteDao;

    @GetMapping("/dipendenteLogin")
    public ModelAndView getDipendenteLoginPage (){
        return new ModelAndView ("login_dipendente","dipendente",new Dipendente());
    }

    @PostMapping("/loginFunction")
    public String login(@ModelAttribute("dipendente") Dipendente d, HttpSession session){
        Dipendente dipendente= dipendenteDao.selectByUserAndPass(d.getUsername(),d.getPassword());
        if(dipendente!=null){
            session.setAttribute("inSession",true);
            session.setAttribute("dipendente",dipendente);
            return "redirect:/pagDipendente";
        }
        return "redirect:/dipendenteLogin";
    }
}
