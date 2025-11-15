package networkArora.ayurvedaHub.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import lombok.AllArgsConstructor;
import networkArora.ayurvedaHub.Entity.Category;
import networkArora.ayurvedaHub.Repository.CategoryRepository;

@Service
@AllArgsConstructor
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    public Category saveCategory(Category category) {
        category.setCreatedAt(Instant.now());
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}
