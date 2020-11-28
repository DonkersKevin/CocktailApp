package donkers.kevin.cocktailapp.services;

import donkers.kevin.cocktailapp.commands.RecipeCommand;
import donkers.kevin.cocktailapp.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand findCommandById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long l);

}
