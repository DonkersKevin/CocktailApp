package donkers.kevin.cocktailapp.services;

import donkers.kevin.cocktailapp.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecipeService {

    Set<Recipe> getRecipes();
}
