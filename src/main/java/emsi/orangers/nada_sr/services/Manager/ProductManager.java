package emsi.orangers.nada_sr.services.Manager;

import emsi.orangers.nada_sr.dao.entities.Product;

import java.util.List;

public interface ProductManager {


    Product createProduct(Product product);

    Product getProductById(Long productId);

    Product updateProduct(Product product);

    void deleteProduct(Long productId);

    List<Product> getAllProduct();

    List<Product> getProductByCategory(Long id);
}
