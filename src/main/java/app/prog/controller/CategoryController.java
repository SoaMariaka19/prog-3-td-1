package app.prog.controller;

import app.prog.model.CategoryEntity;
import app.prog.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping("/categories")
    public List<CategoryEntity> getCategory() {
        return service.getCategory();
    }

    @PostMapping("/categories")
    public List<CategoryEntity> createCategory(@RequestBody List<CategoryEntity> toCreate) {
        return service.createCategory(toCreate);
    }

    @PutMapping("/categories")
    public List<CategoryEntity> updateCategory(@RequestBody List<CategoryEntity> toUpdate) {
        return service.updateCategory(toUpdate);
    }

    @DeleteMapping("/categories/{id}")
    public CategoryEntity deleteAuthor(@PathVariable Integer id) {
        return service.deleteCategory(id);
    }
}
