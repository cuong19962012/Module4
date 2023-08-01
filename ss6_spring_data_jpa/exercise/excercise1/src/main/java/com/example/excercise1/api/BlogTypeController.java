package com.example.excercise1.api;

import com.example.excercise1.model.Blog;
import com.example.excercise1.model.BlogType;
import com.example.excercise1.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("blog-types")
public class BlogTypeController {
    @Autowired
    private IBlogTypeService blogTypeService;

    @GetMapping("/")
    public ResponseEntity<List<BlogType>> getBlogType() {
        if (blogTypeService.findAll().isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(blogTypeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Set<Blog>> getInfoBlogType(@PathVariable int id) {
        if (blogTypeService.findById(id).getBlogSet().isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(blogTypeService.findById(id).getBlogSet(), HttpStatus.OK);
    }
}
