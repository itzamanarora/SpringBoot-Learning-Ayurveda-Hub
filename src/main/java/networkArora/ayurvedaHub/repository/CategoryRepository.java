package networkArora.ayurvedaHub.repository;

import networkArora.ayurvedaHub.utility.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import networkArora.ayurvedaHub.model.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{
    public List<Category> findByStatus(Status status);
}
