package networkArora.ayurvedaHub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import networkArora.ayurvedaHub.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{

}
