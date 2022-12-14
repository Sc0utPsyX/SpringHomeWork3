package ru.gb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.ProductRepository;
import ru.gb.model.Product;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/all")
    public String getAllProducts(Model model) {
        List<Product> products = productRepository.getProductList();
        model.addAttribute("products", products);
        System.out.println(productRepository.getById(2L).toString()); // просто для проверки метода getById
        return "products";
    }



    @GetMapping("/addproduct")
    public String productForm(Model model) {
        model.addAttribute("product", productRepository.getProduct());
        // вот тут если не добавить условный "нулевой продукт", то получается всегда id с count + 1.
        // я смог придумать 2 метода обхода этой ошибки, этот и создание пустого продукта в репозитории
        // и отдельный метод setId
        // public void setId(){
        //  this.id = count++;
        // }
        // и просто в productSubmit добавляем product.setId();
        // Как в таком виде лучше сделать?
        return "addproduct";
    }

    @PostMapping("/addproduct")
    public String productSubmit(@ModelAttribute Product product, Model model) {
        productRepository.addProduct(product);
        List<Product> products = productRepository.getProductList();
        model.addAttribute("products", products);
        return "products";
    }

}
