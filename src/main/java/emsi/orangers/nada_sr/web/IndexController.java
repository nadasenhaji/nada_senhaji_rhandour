package emsi.orangers.nada_sr.web;

import emsi.orangers.nada_sr.dao.entities.Product;
import emsi.orangers.nada_sr.dao.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class IndexController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/index")
    public String showShop(Model model) {
        List<Product> allProducts = productRepository.findAll();
        List<Product> selectedProducts = new ArrayList<>();

        // Select three random products
        if (!allProducts.isEmpty()) {
            int totalProducts = allProducts.size();
            Random random = new Random();
            for (int i = 0; i < 3; i++) {
                int randomIndex = random.nextInt(totalProducts);
                selectedProducts.add(allProducts.get(randomIndex));
            }
        }

        model.addAttribute("products", selectedProducts);
        return "index";
    }
}
