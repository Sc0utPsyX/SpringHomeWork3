package ru.gb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.dao.ProductDao;
import ru.gb.model.Product;

import java.util.List;

@Controller
//@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @GetMapping("/all")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public List<Product> deleteProduct(@RequestParam Long productId){
        productDao.deleteById(productId);
        return productDao.findAll();
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
        productDao.saveOrUpdate(new Product(productTitle, productCost));
        return productDao.findAll();
    }

}
