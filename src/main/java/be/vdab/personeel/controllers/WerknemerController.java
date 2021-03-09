package be.vdab.personeel.controllers;

import be.vdab.personeel.domain.Jobtitel;
import be.vdab.personeel.domain.Werknemer;
import be.vdab.personeel.services.WerknemerService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("werknemer")
public class WerknemerController {

    private final WerknemerService werknemerService;

    public WerknemerController(WerknemerService werknemerService) {
        this.werknemerService = werknemerService;
    }


    @GetMapping("{id}")
    public ModelAndView jobtitel(@PathVariable long id) {
        var modelAndView = new ModelAndView("werknemer");

        Werknemer werknemerPerId = werknemerService.findById(id);
        modelAndView.addObject("werknemerPerId",werknemerPerId);

        List <Werknemer> ondergeschikten = werknemerService.findByChefId(id);
        modelAndView.addObject("ondergeschikten",ondergeschikten);
        return modelAndView;
    }



}
