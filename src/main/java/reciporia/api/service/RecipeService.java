package reciporia.api.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reciporia.api.model.dto.AddRecipeDTO;
import reciporia.api.model.dto.RecipeDTO;
import reciporia.api.model.entity.Recipe;
import reciporia.api.repository.RecipeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final ModelMapper modelMapper;

    public RecipeDTO addRecipe(AddRecipeDTO addRecipeDTO) {
        Recipe recipe = modelMapper.map(addRecipeDTO, Recipe.class);
        recipe.setLikes(0);
        recipeRepository.save(recipe);
        return modelMapper.map(recipe, RecipeDTO.class);
    }

    public List<RecipeDTO> getAllRecipes() {
        return recipeRepository.findAll()
                .stream()
                .map(r -> modelMapper.map(r, RecipeDTO.class))
                .toList();
    }

    public RecipeDTO getRecipeById(Long id) {
        return recipeRepository.findById(id)
                .map(r -> modelMapper.map(r, RecipeDTO.class))
                .orElseThrow(() -> new  IllegalArgumentException("Recipe not found"));
    }

    public void deleteRecipeById(Long id) {
        recipeRepository.deleteById(id);
    }

    public void likeRecipe(Long id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Recipe not found"));
        recipe.setLikes(recipe.getLikes() + 1);
        recipeRepository.save(recipe);
    }

    public void unlikeRecipe(Long id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Recipe not found"));
        recipe.setLikes(recipe.getLikes() - 1);
        recipeRepository.save(recipe);
    }
}
