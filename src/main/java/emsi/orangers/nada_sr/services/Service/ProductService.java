package emsi.orangers.nada_sr.services.Service;

import emsi.orangers.nada_sr.dao.entities.Product;
import emsi.orangers.nada_sr.dao.repositories.ProductRepository;
import emsi.orangers.nada_sr.services.Manager.ProductManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductManager {



    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository menuItemRepository) {
        this.productRepository = menuItemRepository;
    }

    public Product createProduct(Product product) {

        return productRepository.save(product);
    }


    public Product getProductById(Long productId) {

        return productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product item not found"));
    }

    public Product updateProduct(Product product) {

        return productRepository.save(product);
    }

    public void deleteProduct(Long productId) {

        productRepository.deleteById(productId);
    }

    public List<Product> getAllProduct() {

        return productRepository.findAll();
    }

    public List<Product> getProductByCategory(Long id) {

        return productRepository.findByCategoryCategoryId(id);
    }

}

