package donkers.kevin.cocktailapp.controllers;

import donkers.kevin.cocktailapp.domain.Category;
import donkers.kevin.cocktailapp.domain.UnitOfMeasure;
import donkers.kevin.cocktailapp.repositories.CategoryRepository;
import donkers.kevin.cocktailapp.repositories.UnitOfMeasureRepository;
import donkers.kevin.cocktailapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.Option;
import java.util.Optional;

@Slf4j
@Controller
public class indexController {

    private final RecipeService recipeService;

    public indexController(RecipeService recipeService) {
        log.debug("Getting index page");
        this.recipeService = recipeService;
    }

    //No longer needed
/*    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public indexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }*/

    @RequestMapping({"", "/", "/index"})
    String getIndexPage(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());

    //No langer needed
/*        Optional<Category> categoryOptional = categoryRepository.findByDescription("Classic");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("ml");

        System.out.println("Cat Id is:" + categoryOptional.get().getId());
        System.out.println("UOM ID is:" + unitOfMeasureOptional.get().getId());*/
        return "index";
    }
}
