package reciporia.api.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeDTO {

    private Long id;
    private String title;
    private String description;
    private String ingredients;
    private String steps;
    private Integer likes;

}
