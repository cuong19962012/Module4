package com.example.service;

import com.example.model.Email;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmailService implements IEmailService {
    private static Map<Integer, Email> data = new HashMap<>();
//    private int id;
//    private String language;
//    private int pageSize;
//    private boolean spamsFilter;
//    private String signature;

    static {
        data.put(1, new Email(1, "English", 10, true, "Hihi"));
    }

    @Override
    public List<Email> display() {
        List<Email> list = new ArrayList<>();
        for (int e : data.keySet()) {
            list.add(data.get(e));
        }
        return list;
    }

    @Override
    public Email findEmail(int id) {
        return data.get(id);
    }

    @Override
    public void updateEmail(Email email) {
        data.put(email.getId(), email);
    }
}
