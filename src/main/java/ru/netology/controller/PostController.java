package ru.netology.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.model.Post;
import ru.netology.service.PostService;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {
  private final PostService service;

  public PostController(PostService service) {
    this.service = service;
  }

  @GetMapping
  public Map<Long, Post> all() {
    return service.all();
  }

  @GetMapping("/{id}")
  public Optional<Post> getById(@PathVariable int id) {
    return service.getById(id);
  }

  @PostMapping
  public long save(@RequestBody Post post) {
    return service.save(post);
  }

  @DeleteMapping("/{id}")
  public void removeById(int id) {
    service.removeById(id);
  }
}