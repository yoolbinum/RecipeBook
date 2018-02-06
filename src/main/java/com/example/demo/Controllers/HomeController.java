package com.example.demo.Controllers;

import com.example.demo.Models.Recipe;
import com.example.demo.Repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class HomeController {
    @Autowired
    RecipeRepository recipeRepository;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/recipes")
    public String recipes(Model model) {
        Recipe crabby = new Recipe();
        crabby.setName("Crab cake");
        crabby.setIngredients(new ArrayList<>(Arrays.asList("ingredient #1", "ingredient #2", "ingredient #3")));
        crabby.setDirections(new ArrayList<>(Arrays.asList("direction #1", "dircetion #2", "direction #3")));
        crabby.setImgURL("img/crab.jpg");

        recipeRepository.save(crabby);

        model.addAttribute("recipes", recipeRepository.findAll());
        return "recipes";
    }
}
