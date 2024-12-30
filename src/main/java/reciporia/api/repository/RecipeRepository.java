package reciporia.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reciporia.api.model.entity.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
