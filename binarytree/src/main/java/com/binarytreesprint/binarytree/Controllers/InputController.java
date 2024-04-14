package com.binarytreesprint.binarytree.Controllers;

import com.binarytreesprint.binarytree.Entities.InputEntity;
import com.binarytreesprint.binarytree.Services.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class InputController {

    private final InputService inputService;

    @Autowired
    public InputController(InputService inputService) {
        this.inputService = inputService;
    }

    @GetMapping("/enter-numbers")
    public String showEnterNumbersPage() {
        return "enter-numbers"; // Assuming you have an HTML page named "enter-numbers.html"
    }

    @PostMapping("/process-numbers")
    public ModelAndView processNumbers(@RequestParam("numbers") String numbers) {
        // Save the input numbers using the InputService
        InputEntity savedInput = inputService.saveInput(numbers);

        // Perform any additional processing as needed

        // Redirect to a page to display the result
        return new ModelAndView("redirect:/show-input?id=" + savedInput.getId());
    }
}
