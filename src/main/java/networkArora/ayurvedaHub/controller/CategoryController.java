package networkArora.ayurvedaHub.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import networkArora.ayurvedaHub.model.Category;
import networkArora.ayurvedaHub.service.CategoryService;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable String categoryId) {
        Optional<Category> categoryOpt = categoryService.getCategoryById(categoryId);
        if (categoryOpt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryOpt.get(), HttpStatus.OK);
    }

    @PutMapping("{categoryId}")
    public ResponseEntity<Category> updateCategoryById(@PathVariable String categoryId, @RequestBody Category category) {
        Optional<Category> existingCategoryOpt = categoryService.getCategoryById(categoryId);
        if (!existingCategoryOpt.isEmpty()) {
            existingCategoryOpt.get().setCategoryName(category.getCategoryName() != null && !category.getCategoryName().equals("") ? category.getCategoryName() : existingCategoryOpt.get().getCategoryName());
            existingCategoryOpt.get().setCategorySlug(category.getCategorySlug() != null && !category.getCategorySlug().equals("") ? category.getCategorySlug() : existingCategoryOpt.get().getCategorySlug());
            existingCategoryOpt.get().setCategoryDescription(category.getCategoryDescription() != null && !category.getCategoryDescription().equals("") ? category.getCategoryDescription() : existingCategoryOpt.get().getCategoryDescription());
            existingCategoryOpt.get().setCoverImageURL(category.getCoverImageURL() != null && !category.getCoverImageURL().equals("") ? category.getCoverImageURL() : existingCategoryOpt.get().getCoverImageURL());
            existingCategoryOpt.get().setStatus(category.getStatus() != null ? category.getStatus() : existingCategoryOpt.get().getStatus());
            existingCategoryOpt.get().setUpdatedAt(new java.util.Date());
            existingCategoryOpt.get().setParentCategory(category.getParentCategory() != null ? category.getParentCategory() : existingCategoryOpt.get().getParentCategory());
            return new ResponseEntity<>(categoryService.saveCategory(existingCategoryOpt.get()), HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable String categoryId) { 
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
