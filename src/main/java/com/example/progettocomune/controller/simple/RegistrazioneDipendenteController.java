package com.example.progettocomune.controller.simple;


import com.example.progettocomune.db.dao.interfaces.DipendenteDao;
import com.example.progettocomune.db.entity.Dipendente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrazioneDipendenteController {

    @Autowired
    private DipendenteDao dipendeteDao;

    @GetMapping("/registrationPage")
    public String getRegistrPage(Model model){
        model.addAttribute("nuovoDipendente",new Dipendente());
        return "registr_dipendente";
    }

    @PostMapping("/doRegistration")
    public String doRegistration(@ModelAttribute Dipendente nuovoDipendente){
        dipendeteDao.insert(nuovoDipendente);
        return "redirect:/loginDipendente";
    }

}
