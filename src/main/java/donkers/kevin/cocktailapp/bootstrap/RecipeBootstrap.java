package donkers.kevin.cocktailapp.bootstrap;

import donkers.kevin.cocktailapp.domain.*;
import donkers.kevin.cocktailapp.repositories.CategoryRepository;
import donkers.kevin.cocktailapp.repositories.RecipeRepository;
import donkers.kevin.cocktailapp.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
/*    @Transactional*/
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
        log.debug("Loading bootstrap Data");
    }

    private List<Recipe> getRecipes() {
        List<Recipe> recipes = new ArrayList<>(2);

        //get UOMs
        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if (!eachUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found.");
        }

        Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");

        if (!ounceUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found.");
        }

        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");

        if (!pinchUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found.");
        }

        Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if (!teaspoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found.");
        }

        Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if (!tablespoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found.");
        }

        Optional<UnitOfMeasure> mlUomOptional = unitOfMeasureRepository.findByDescription("ml");

        if (!mlUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found.");
        }

        Optional<UnitOfMeasure> clUomOptional = unitOfMeasureRepository.findByDescription("cl");

        if (!clUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found.");
        }

        Optional<UnitOfMeasure> grUomOptional = unitOfMeasureRepository.findByDescription("gr");

        if (!grUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found.");
        }

        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure ounceUom = ounceUomOptional.get();
        UnitOfMeasure pinchUom = pinchUomOptional.get();
        UnitOfMeasure teaSpoonUom = teaspoonUomOptional.get();
        UnitOfMeasure tableSpoonUom = tablespoonUomOptional.get();
        UnitOfMeasure mlUom = mlUomOptional.get();
        UnitOfMeasure clUom = clUomOptional.get();
        UnitOfMeasure grUom = grUomOptional.get();

        Optional<Category> nonAlcoholicCategoryOptional = categoryRepository.findByDescription("Non-Alcoholic");

        if (!nonAlcoholicCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected category not found");
        }

        Optional<Category> classicCategoryOptional = categoryRepository.findByDescription("Classic");

        if (!classicCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected category not found");
        }

        Optional<Category> fruityCategoryOptional = categoryRepository.findByDescription("Fruity");

        if (!fruityCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected category not found");
        }

        Optional<Category> strongCategoryOptional = categoryRepository.findByDescription("Strong");

        if (!strongCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected category not found");
        }

        Optional<Category> creamyCategoryOptional = categoryRepository.findByDescription("Creamy");

        if (!creamyCategoryOptional.isPresent()) {
            throw new RuntimeException("Expected category not found");
        }

        Category nonAlcoholicCategory = nonAlcoholicCategoryOptional.get();
        Category classicCategory = classicCategoryOptional.get();
        Category fruityCategory = fruityCategoryOptional.get();
        Category strongCategory = strongCategoryOptional.get();
        Category creamyCategory = creamyCategoryOptional.get();

        Recipe longIslandRecipe = new Recipe();
        longIslandRecipe.setDescription("Long island ice tea");
        longIslandRecipe.setGlass("Highball");
        longIslandRecipe.setDifficulty(Difficulty.EASY);
        longIslandRecipe.setDirections(
                "1 - Fill glass with ice." + "\n" +
                        "2 - Add Vodka, Tequila, White rum, Cointreau(or Triple sec) and gin." + "\n" +
                        "3 - Add the juice of half a lemon, add the simple syrup and top off with Cola." + "\n" +
                        "4 - Garnish with lemon wedge and a straw.");

        System.out.println(longIslandRecipe.getDirections());

        Notes longIslandNotes = new Notes();
        longIslandNotes.setRecipeNotes("One of the all time classics and a personal favourite." + "\n" +
                "Go easy on this one, the punch comes a while later ;).");

        longIslandRecipe.setNotes(longIslandNotes);

        longIslandRecipe.addIngredient(new Ingredient("Vodka", new BigDecimal(15), mlUom));
        longIslandRecipe.addIngredient(new Ingredient("Tequila Blanco", new BigDecimal(15), mlUom));
        longIslandRecipe.addIngredient(new Ingredient("White rum", new BigDecimal(15), mlUom));
        longIslandRecipe.addIngredient(new Ingredient("Cointreau", new BigDecimal(15), mlUom));
        longIslandRecipe.addIngredient(new Ingredient("Gin", new BigDecimal(15), mlUom));
        longIslandRecipe.addIngredient(new Ingredient("Lemon juice", new BigDecimal(15), mlUom));
        longIslandRecipe.addIngredient(new Ingredient("Sugar syrup", new BigDecimal(30), mlUom));
        longIslandRecipe.addIngredient(new Ingredient("Cola", new BigDecimal(10), mlUom));
        longIslandRecipe.addIngredient(new Ingredient("Ice", new BigDecimal(1), eachUom));

        longIslandRecipe.getCategories().add(classicCategory);
        longIslandRecipe.getCategories().add(strongCategory);

        longIslandRecipe.setSource("Liquor.com");
        longIslandRecipe.setUrl("https://www.liquor.com/recipes/long-island-iced-tea/");

        recipes.add(longIslandRecipe);

        Recipe wRussianRecipe = new Recipe();
        wRussianRecipe.setDescription("White russian");
        wRussianRecipe.setGlass("Thumbler");
        wRussianRecipe.setDifficulty(Difficulty.MODERATE);
        wRussianRecipe.setDirections(
                "1 - Fill glass with ice." + "\n" +
                        "2 - Add Vodka and Kahlua." + "\n" +
                        "3 - Softly pour cream on top." + "\n" +
                        "4 - Garnish with freshly grated nutmeg and a short straw.");


        Notes wRussianNotes = new Notes();
        wRussianNotes.setRecipeNotes("Popularized by the movie \"The Big Lebowsky\", this soft and creamy drink can also be enjoyed with half and half milk and cream." );

        wRussianRecipe.setNotes(wRussianNotes);

        wRussianRecipe.addIngredient(new Ingredient("Vodka", new BigDecimal(40),mlUom));
        wRussianRecipe.addIngredient(new Ingredient("Kahlua", new BigDecimal(30),mlUom));
        wRussianRecipe.addIngredient(new Ingredient("Cream", new BigDecimal(30),mlUom));
        wRussianRecipe.addIngredient(new Ingredient("Nutmeg", new BigDecimal(1),pinchUom));
        wRussianRecipe.addIngredient(new Ingredient("Ice", new BigDecimal(1),eachUom));

        wRussianRecipe.getCategories().add(classicCategory);
        wRussianRecipe.getCategories().add(creamyCategory);

        wRussianRecipe.setSource("Njam");
        wRussianRecipe.setUrl("https://njam.tv/recepten/straffe-koffie-white-russian");

        recipes.add(wRussianRecipe);
        return recipes;
    }
}
