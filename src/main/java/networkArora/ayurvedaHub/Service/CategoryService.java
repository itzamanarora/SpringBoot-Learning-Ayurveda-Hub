package networkArora.ayurvedaHub.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import networkArora.ayurvedaHub.Repository.CategoryRepository;

@Service
@AllArgsConstructor
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    public ResponseEntity<CategoryRepository> getAllCategories() {
        return ResponseEntity.ok().body(categoryRepository);          
    }
}
