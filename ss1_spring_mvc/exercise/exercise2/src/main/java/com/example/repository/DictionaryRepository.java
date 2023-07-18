package com.example.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {
    private static Map<String, String> data = new HashMap<>();

    static {
        data.put("Hello", "Xin chào");
        data.put("Computer", "Máy tính");
        data.put("Bee", "Con ong");
    }

    @Override
    public String translate(String input) {
        return data.get(input);
    }
}
