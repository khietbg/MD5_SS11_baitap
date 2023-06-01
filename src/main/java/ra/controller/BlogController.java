package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Blog;
import ra.model.entity.Catalog;
import ra.service.blog.IBlogService;
import ra.service.catalog.ICatalogService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin(origins = "*")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICatalogService catalogService;

    @ModelAttribute("catalog")
    Iterable<Catalog> getlist() {
        return catalogService.findAll();
    }

    @GetMapping
    public ResponseEntity<List<Blog>> home() {
        List<Blog> listBlog = (List<Blog>) blogService.findAll();
        if (listBlog.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listBlog, HttpStatus.OK);
        }

    }

    @PostMapping
    public ResponseEntity<Blog> add(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Blog> edit(@PathVariable("id") Long id, @RequestBody Blog blog) {
        Optional<Blog> blog1 = blogService.findById(id);
        if (blog1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            blog.setId(id);
            return new ResponseEntity<>(blogService.save(blog), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> delete(@PathVariable("id") Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()) {
            blogService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
}