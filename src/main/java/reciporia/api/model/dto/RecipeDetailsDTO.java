package reciporia.api.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeDetailsDTO {

    private Long id;
    private String title;
    private String description;
    private String ingredients;
    private String steps;

}
