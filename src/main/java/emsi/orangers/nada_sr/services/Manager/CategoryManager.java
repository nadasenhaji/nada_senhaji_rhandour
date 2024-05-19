package emsi.orangers.nada_sr.services.Manager;

import emsi.orangers.nada_sr.dao.entities.Category;

import java.util.List;

public interface CategoryManager {
    Category createCategory(Category category);

    Category getCategoryById(Long categoryId);

    void updateCategory(Category category);

    void deleteCategory(Long categoryId);

    List<Category> getAllCategories();
}
