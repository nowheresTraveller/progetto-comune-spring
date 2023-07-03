package com.example.progettocomune.controller.simple;


import com.example.progettocomune.db.dao.interfaces.CittadinoDao;
import com.example.progettocomune.db.entity.Cittadino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private CittadinoDao cittadinoDao;

    @GetMapping("/home")
    public ModelAndView getHome(){
        return new ModelAndView("home","cittadino",new Cittadino());
    }

    @PostMapping("/inserisciCittadino")
    public String inserisciCittadino(@ModelAttribute Cittadino newCittadino){
        cittadinoDao.insert(newCittadino);
        return "redirect:/home";
    }


}
