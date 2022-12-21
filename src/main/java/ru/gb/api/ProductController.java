package ru.gb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.ProductRepository;
import ru.gb.model.Product;

import java.util.List;

@Controller
//@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/all")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productRepository.getProductList();
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public List<Product> deleteProduct(@RequestParam Long productId){
        productRepository.deleteById(productId);
        return productRepository.getProductList();
    }

//    @GetMapping("/addproduct")
//    public String productForm(Model model) {
//        model.addAttribute("product", productRepository.getProduct());
//        // вот тут если не добавить условный "нулевой продукт", то получается всегда id с count + 1.
//        // я смог придумать 2 метода обхода этой ошибки, этот и создание пустого продукта в репозитории
//        // и отдельный метод setId
//        // public void setId(){
//        //  this.id = count++;
//        // }
//        // и просто в productSubmit добавляем product.setId();
//        // Как в таком виде лучше сделать?
//        return "addproduct";
//    }

    @PostMapping("/add")
    @ResponseBody
    public List<Product> productSubmit(@RequestParam String productTitle, @RequestParam Double productCost) {
        productRepository.addProduct(new Product(productTitle, productCost));
        return productRepository.getProductList();
    }

}
