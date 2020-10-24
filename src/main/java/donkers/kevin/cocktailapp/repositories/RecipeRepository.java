package donkers.kevin.cocktailapp.repositories;

import donkers.kevin.cocktailapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
