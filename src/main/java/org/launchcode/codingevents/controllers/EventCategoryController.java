package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("eventCategories")
public class EventCategoryController {

    @Autowired
    private EventCategoryRepository eventCategoryRepository;

    @GetMapping //use GET cuz you are displaying
    public String displayAllEvents(Model model) { //use Model model in param cuz book says "attribute"
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", eventCategoryRepository.findAll()); //use repository.findAll() to give all categories
        return "eventCategories/index";
    }

    @GetMapping("create") //render is another way to say display, so use GET
    public String renderCreateEventCategoryForm(Model model) { //use Model model in param cuz book says "attribute"
        model.addAttribute("title", "Create Category");
        model.addAttribute(new EventCategory()); //this passes in class, by default uses class name as attribute name
        return "eventCategories/create";
    }


    @PostMapping() //doing something or an action after something happens on site is POST
    public String createEventCategoryForm(Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "eventCategories/create";
        }
        model.addAttribute("title", "Create Category");
        model.addAttribute(new EventCategory()); //this passes in class, by default uses class name as attribute name
        return "redirect:";
    }

}
