package be.vdab.personeel.controllers;

import be.vdab.personeel.domain.Jobtitel;
import be.vdab.personeel.domain.Werknemer;
import be.vdab.personeel.repositories.JobtitelRepository;
import be.vdab.personeel.repositories.WerknemerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("jobtitel")
public class JobtitelController {

        private final JobtitelRepository jobtitelRepository;
        private final WerknemerRepository werknemerRepository;

    public JobtitelController(JobtitelRepository jobtitelRepository, WerknemerRepository werknemerRepository) {
        this.jobtitelRepository = jobtitelRepository;
        this.werknemerRepository = werknemerRepository;
    }


    @GetMapping
    public ModelAndView jobtitels() {
        return new ModelAndView("jobtitels", "jobtitels", jobtitelRepository.findAll());
    }


    @GetMapping("{id}")
    public ModelAndView jobtitel(@PathVariable long id) {
        var modelAndView = new ModelAndView("jobtitel");
        List <Jobtitel> jobtitel = jobtitelRepository.findAllById(id);
        List<Werknemer> werknemersPerJobtitel = werknemerRepository.findByJobtitel(jobtitel.get(0));
        modelAndView.addObject("werknemerPerJobId",werknemersPerJobtitel);
        return modelAndView;
    }
}
