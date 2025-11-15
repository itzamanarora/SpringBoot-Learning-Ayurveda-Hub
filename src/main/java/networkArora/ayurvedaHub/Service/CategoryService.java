package networkArora.ayurvedaHub.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import networkArora.ayurvedaHub.Entity.Category;
import networkArora.ayurvedaHub.Repository.CategoryRepository;

@Service
@AllArgsConstructor
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    // Create Category
    public Category saveCategory(Category category) {
        category.setCreatedAt(Instant.now());
        return categoryRepository.save(category);
    }

    // Get All Categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Get Category by ID
    public Optional<Category> getCategoryById (String categoryId) {
        return categoryRepository.findById(categoryId);
    }

    // Delete Category by ID
    public void deleteCategory(String categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
