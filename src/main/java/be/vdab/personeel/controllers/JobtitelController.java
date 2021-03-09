package be.vdab.personeel.controllers;

import be.vdab.personeel.domain.Jobtitel;
import be.vdab.personeel.domain.Werknemer;
import be.vdab.personeel.services.JobtitelService;
import be.vdab.personeel.services.WerknemerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("jobtitel")
public class JobtitelController {

        private final JobtitelService jobtitelService;
        private final WerknemerService werknemerService;

    public JobtitelController(JobtitelService jobtitelService, WerknemerService werknemerService) {
        this.jobtitelService = jobtitelService;
        this.werknemerService = werknemerService;
    }


    @GetMapping
    public ModelAndView jobtitels() {
        return new ModelAndView("jobtitels", "jobtitels", jobtitelService.findAll());
    }


    @GetMapping("{id}")
    public ModelAndView jobtitel(@PathVariable long id) {
        var modelAndView = new ModelAndView("jobtitel");
        Jobtitel jobtitel = jobtitelService.findById(id);
        List<Werknemer> werknemersPerJobtitel = werknemerService.findByJobtitel(jobtitel);
        modelAndView.addObject("werknemerPerJobId",werknemersPerJobtitel);
        return modelAndView;
    }
}
