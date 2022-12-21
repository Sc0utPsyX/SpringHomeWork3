package ru.gb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.gb.model.Product;


public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = null;
        try{
            session = factory.getCurrentSession();
            session.beginTransaction();
            Product product = session.get(Product.class, 1L);
            System.out.println(product);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if (session != null){
                session.close();
            }
            if (factory != null){
                factory.close();
            }
        }
    }
}
