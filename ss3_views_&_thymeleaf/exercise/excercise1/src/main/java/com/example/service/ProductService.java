package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {
//        private int id;
//        private String name;
//        private double price;
//        private String description;
//        private String maker;
        products = new HashMap<>();
        products.put(1, new Product(1, "Bánh", 1000000, "Ngon Ngon", "Acecook"));
        products.put(2, new Product(2, "Kẹo Bốn Mùa", 50000, "Cho Trẻ Em", "Vifon"));
    }

    @Override
    public int findAvailableId() {
        for (int i = 1; i <= products.size(); i++) {
            if (products.get(i) == null)
                return i;
        }
        return products.size() + 1;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> list = new ArrayList<>();
        for (int key : products.keySet()) {
            if (products.get(key).getName().toLowerCase().contains(name.toLowerCase()))
                list.add(products.get(key));

        }
        return list;
    }

}
