package emsi.orangers.nada_sr.web;

import emsi.orangers.nada_sr.dao.entities.Product;
import emsi.orangers.nada_sr.dao.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ShopController {


   @Autowired
   private ProductRepository productRepository;

    @GetMapping("/shop")
    public String showShop(Model model) {

        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "shop";
    }
}
