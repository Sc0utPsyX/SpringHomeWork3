package ru.gb.model;

public class Product {
    private static Long count = 0L;
    private Long id;
    private String title;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public Double getCost() {
        return cost;
    }

    public Long getId() {
        return id;
    }

    private Double cost;

    public Product() {
        this.id = count++;
    }


    public Product(String title, Double cost) {
        this.id = count++;
        this.title = title;
        this.cost = cost;
    }
}
