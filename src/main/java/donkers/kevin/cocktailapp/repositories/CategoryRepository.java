package donkers.kevin.cocktailapp.repositories;

import donkers.kevin.cocktailapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
