package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    @PersistenceContext
    private EntityManager entityManager;
//    private static final Map<Integer, Product> products;
//
//    static {
////        private int id;
////        private String name;
////        private double price;
////        private String description;
////        private String maker;
//        products = new HashMap<>();
//        products.put(1, new Product(1, "Bánh", 1000000, "Ngon Ngon", "Acecook"));
//        products.put(2, new Product(2, "Kẹo Bốn Mùa", 50000, "Cho Trẻ Em", "Vifon"));
//    }

    @Override
    public int findAvailableId() {
//        for (int i = 1; i <= products.size(); i++) {
//            if (products.get(i) == null)
//                return i;
//        }
//        return products.size() + 1;
        return 0;
    }

    @Override
    public List<Product> findAll() {
//        return new ArrayList<>(products.values());
        TypedQuery<Product> query = entityManager.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void save(Product product) {

//        products.put(product.getId(), product);
        entityManager.persist(product);

    }

    @Override
    @Transactional
    public Product findById(int id) {

//        return products.get(id);
        return entityManager.find(Product.class, id);
    }

    @Override
    @Transactional
    public void update(int id, Product product) {
//        products.put(id, product);
        entityManager.merge(product);
    }

    @Override
    @Transactional
    public void remove(int id) {
        Product product = findById(id);
        entityManager.remove(product);
//        products.remove(id);

    }

    @Override
    public List<Product> search(String name) {
        String searchLike = "%" + name + "%";
//        List<Product> list = new ArrayList<>();
//        for (int key : products.keySet()) {
//            if (products.get(key).getName().toLowerCase().contains(name.toLowerCase()))
//                list.add(products.get(key));
//
//        }
//        return list;
//        entityManager.
        TypedQuery<Product> query = entityManager.createQuery("from Product p where p.name like :searchLike", Product.class);
        query.setParameter("searchLike", searchLike);
        return query.getResultList();
    }

}
