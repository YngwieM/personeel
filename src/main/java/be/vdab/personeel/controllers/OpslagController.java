package be.vdab.personeel.controllers;

import be.vdab.personeel.domain.Werknemer;
import be.vdab.personeel.services.WerknemerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("opslag")
public class OpslagController {

    private final WerknemerService werknemerService;

    public OpslagController(WerknemerService werknemerService) {
        this.werknemerService = werknemerService;
    }

    @GetMapping("{id}")
    public ModelAndView opslag(@PathVariable long id) {
        var modelAndView = new ModelAndView("opslag");

        List<Werknemer> werknemerPerId = werknemerService.findById(id);
        modelAndView.addObject("werknemerPerId",werknemerPerId);
        return modelAndView;
    }
}
