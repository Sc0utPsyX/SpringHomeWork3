package ru.gb;

import org.springframework.stereotype.Repository;
import ru.gb.model.Product;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private Product product = new Product();

    public Product getProduct() {
        return product;
    }

    public List<Product> getProductList() {
        return productList;
    }

    private List<Product> productList = new ArrayList<>(List.of(
            new Product("Bread", 100d),
            new Product("Milk", 400d),
            new Product("Banana", 1000d))
    );


    public ProductRepository() {
    }


    public void addProduct(Product product) {
        productList.add(product);
    }

    public Product getById(Long id){
        return productList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

}
