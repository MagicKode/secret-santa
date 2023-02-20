package com.example.secretsanta.controller.jspController;

import com.example.secretsanta.sevice.AssignmentConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class JspAssignController {
    private final AssignmentConverter assignmentConverter;

    @RequestMapping(value = "/generate", method = RequestMethod.GET)
    public String generate(Model model) {
        var result = assignmentConverter.createGenerator();
        model.addAttribute("assignments", result);
        return "generate-participants";
    }
}
