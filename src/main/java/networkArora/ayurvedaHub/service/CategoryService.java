package networkArora.ayurvedaHub.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import networkArora.ayurvedaHub.exception.apiException;
import networkArora.ayurvedaHub.model.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        Optional<Category> existingCategory = categoryRepository.findByCategoryName(category.getCategoryName());
                if(existingCategory.isPresent()) {
                    throw new apiException("Category with name '" + category.getCategoryName() + "' already exists.", HttpStatus.CONFLICT);
                }
        category.setCreatedAt(Instant.now());
        return categoryRepository.save(category);
    }

    // Get All Categories
    public List<Category> getAllCategories(int page, int size) {
        int safeSize = Math.min(size,50); // Limit size to a maximum of 50
        PageRequest pageRequest = PageRequest.of(page, safeSize);

        Page<Category> result = categoryRepository.findByStatus(Status.ACTIVE, pageRequest);
               if(result.isEmpty()) {
                  throw new apiException("No categories found", HttpStatus.NOT_FOUND);
               }
        return result.getContent();
    }

    // Get Category by ID
    public Category getCategoryById(String categoryId) {
        return categoryRepository.findById(categoryId).
                orElseThrow(() -> new apiException("Category not found with ID: " + categoryId, HttpStatus.NOT_FOUND));
    }

    // Update Category
    public Category updateCategory(Category category, String categoryId) {
        if (categoryId == null || categoryId.isEmpty()) {
            throw new apiException("Category ID must be provided for update", HttpStatus.BAD_REQUEST);
        }
        Category existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new apiException("Category not found! ", HttpStatus.NOT_FOUND));

        // UPDATE ONLY IF NEW VALUE PROVIDED
        if (category.getCategoryName() != null && !category.getCategoryName().isEmpty()) {
            existingCategory.setCategoryName(category.getCategoryName());
        }
        if(category.getCategoryDescription() != null  && !category.getCategoryDescription().isEmpty()) {
            existingCategory.setCategoryDescription(category.getCategoryDescription());
        }
        if (category.getCategorySlug() != null && !category.getCategorySlug().isEmpty()) {
            existingCategory.setCategorySlug(category.getCategorySlug());
        }
        if (category.getCoverImageURL() != null && !category.getCoverImageURL().isEmpty()) {
            existingCategory.setCoverImageURL(category.getCoverImageURL());
        }
        if (category.getStatus() != null && !category.getStatus().toString().isEmpty()) {
            existingCategory.setStatus(category.getStatus());
        }
        existingCategory.setUpdatedAt(Instant.now());
        return categoryRepository.save(existingCategory);
    }

    // Delete Category by ID
    public void deleteCategory(String categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new apiException("Category not found with ID: " + categoryId, HttpStatus.NOT_FOUND));
        categoryRepository.delete(category);
    }
}
