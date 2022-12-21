package ru.gb.dao;

import javassist.NotFoundException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.ProductFactory;
import ru.gb.model.Product;

import java.util.List;

@Component
public class ProductDao {

    @Autowired
    ProductFactory productFactory;

    public Product findById(Long id){
        Session session = productFactory.getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        productFactory.closeSession(session);
        return product;
    }

    public List<Product> findAll(){
        Session session = productFactory.getSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        session.getTransaction().commit();
        productFactory.closeSession(session);
        return products;
    }
    public void deleteById(Long id){
        Session session = productFactory.getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        if (product != null){
            session.delete(product);
        } else {
            try {
                throw new NotFoundException("Id not found");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        session.getTransaction().commit();
        productFactory.closeSession(session);
    }

    public void saveOrUpdate(Product product){ // тут в задании написано, что метод должен быть public Product
        // но не понятно зачем при сохранении обратно возвращать данные обратно
        Session session = productFactory.getSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();
        productFactory.closeSession(session);
    }


}
