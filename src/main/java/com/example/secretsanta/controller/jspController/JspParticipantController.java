package com.example.secretsanta.controller.jspController;

import com.example.secretsanta.model.entity.Participant;
import com.example.secretsanta.sevice.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class JspParticipantController {
    private final ParticipantService participantService;

    @GetMapping(value = "/")
    public String home() {
        return "home_page";
    }

    @RequestMapping(value = "participant/info", method = RequestMethod.GET)
    public String info(Model model) {
        model.addAttribute("participants", participantService.getAll().values());
        model.addAttribute("notEnoughParticipants", String.valueOf(participantService.getAll().size() < 3));
        return "participants-info";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "add-participant";
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("participant", participantService.getById(id));
        return "update-participant";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Participant participant, Model model) {
        participantService.createParticipantDto(participant);
        model.addAttribute("participants", participantService.getAll().values());
        return "redirect:/participant/info";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id, Model model) {
        participantService.deleteById(id);
        model.addAttribute("participants", participantService.getAll().values());
        return "participants-info";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Participant participant, Model model) {
        participantService.updateParticipantDto(participant);
        model.addAttribute("participants", participantService.getAll().values());
        return "participants-info";
    }
}
