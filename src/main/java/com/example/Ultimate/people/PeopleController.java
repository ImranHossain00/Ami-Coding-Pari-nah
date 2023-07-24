package com.example.Ultimate.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public String getPeople(Model model) {
        List<People> peopleList = peopleService.getPeople();
        model.addAttribute("something", "Ami Coding Pari Na");
        model.addAttribute("people", peopleList);
        return "people";
    }

    @PostMapping("/search")
    public String searchPeople(@RequestParam("inputValues") String inputValues,
                               @RequestParam("searchValues") String searchValues,
                               Model model) {
        // Process the input values and search values here as needed.
        // For example, you can pass them to the service to filter the data.
        boolean flag = peopleService.searchNumber(inputValues, Integer.parseInt(searchValues));
        String state = "False";
        if (flag) state = "True";
        model.addAttribute("result", state);
        return "people";
    }
}
