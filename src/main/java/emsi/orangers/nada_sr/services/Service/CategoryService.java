package emsi.orangers.nada_sr.services.Service;

import emsi.orangers.nada_sr.dao.entities.Category;
import emsi.orangers.nada_sr.dao.repositories.CategoryRepository;
import emsi.orangers.nada_sr.services.Manager.CategoryManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryManager {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {

        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
    }

    @Override
    public void updateCategory(Category category) {

        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long categoryId) {

        categoryRepository.deleteById(categoryId);
    }

    @Override
    public List<Category> getAllCategories() {

        return categoryRepository.findAll();
    }
}