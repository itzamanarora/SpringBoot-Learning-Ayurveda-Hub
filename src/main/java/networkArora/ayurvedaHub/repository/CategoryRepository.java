package networkArora.ayurvedaHub.repository;

import networkArora.ayurvedaHub.model.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import networkArora.ayurvedaHub.model.Category;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{
    Page<Category> findByStatus(Status status, Pageable pageable);
    public Optional<Category> findByCategoryName(String categoryName);
}
