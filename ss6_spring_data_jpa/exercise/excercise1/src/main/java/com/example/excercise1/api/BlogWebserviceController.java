package com.example.excercise1.api;

import com.example.excercise1.model.Blog;
import com.example.excercise1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("blogs")
public class BlogWebserviceController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/")
    public ResponseEntity<Page<Blog>> getInfo(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "1") int size, @RequestParam(defaultValue = "") String keySearch) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Blog> listBlog = blogService.findAll(pageable, keySearch);
        if (listBlog.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(listBlog, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> getInfoBlog(@PathVariable int id) {
        if (blogService.findById(id) == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(blogService.findById(id), HttpStatus.OK);
    }
}
