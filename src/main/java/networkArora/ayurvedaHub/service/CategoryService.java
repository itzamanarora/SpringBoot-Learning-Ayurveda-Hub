package networkArora.ayurvedaHub.service;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import networkArora.ayurvedaHub.exception.apiException;
import networkArora.ayurvedaHub.utility.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import networkArora.ayurvedaHub.model.Category;
import networkArora.ayurvedaHub.repository.CategoryRepository;

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
        List<Category> categories = categoryRepository.findByStatus(Status.ACTIVE);
       if (categories == null && categories.isEmpty()){
           throw new apiException("No active categories found", HttpStatus.NOT_FOUND);
       } else {
           return categories;
       }
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
