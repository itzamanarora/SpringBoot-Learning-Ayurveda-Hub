package networkArora.ayurvedaHub.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.AllArgsConstructor;
import networkArora.ayurvedaHub.Service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private final CategoryService categoryService;

    @GetMapping
    public void getAllCategories() {
        categoryService.getAllCategories();
    }
    
}
