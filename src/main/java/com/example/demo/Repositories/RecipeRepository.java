package com.example.demo.Repositories;

import com.example.demo.Models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{
}
