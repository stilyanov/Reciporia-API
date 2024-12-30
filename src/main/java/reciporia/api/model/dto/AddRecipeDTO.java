package reciporia.api.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddRecipeDTO {

    @NotNull(message = "Title cannot be empty!")
    @Size(min = 3, max = 20, message = "Title length must be between 3 and 20 characters!")
    private String title;

    @NotNull(message = "Description cannot be empty!")
    @Size(min = 10, max = 500, message = "Description length must be between 10 and 500 characters!")
    private String description;

    @NotNull(message = "Ingredients cannot be empty!")
    @Size(min = 10, max = 1000, message = "Ingredients length must be between 10 and 1000 characters!")
    private String ingredients;

    @NotNull(message = "Steps cannot be empty!")
    @Size(min = 50, max = 2000, message = "Steps length must be between 50 and 2000 characters!")
    private String steps;
}
