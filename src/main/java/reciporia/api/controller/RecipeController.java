package reciporia.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import reciporia.api.model.dto.AddRecipeDTO;
import reciporia.api.model.dto.RecipeDTO;
import reciporia.api.service.RecipeService;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@AllArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<RecipeDTO>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.getRecipeById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<RecipeDTO> createRecipe(@Valid @RequestBody AddRecipeDTO recipeDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException("Invalid recipe data");
        }
        RecipeDTO response = recipeService.addRecipe(recipeDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<RecipeDTO> deleteRecipeById(@PathVariable Long id) {
        recipeService.deleteRecipeById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/like/{id}")
    public ResponseEntity<RecipeDTO> likeRecipe(@PathVariable Long id) {
        recipeService.likeRecipe(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/unlike/{id}")
    public ResponseEntity<RecipeDTO> unlikeRecipe(@PathVariable Long id) {
        recipeService.unlikeRecipe(id);
        return ResponseEntity.noContent().build();
    }
}
