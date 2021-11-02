package ru.netology.service;

import org.springframework.stereotype.Service;
import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;
import ru.netology.repository.PostRepository;

import java.util.Map;
import java.util.Optional;

@Service
public class PostService {
  private final PostRepository repository;

  public PostService(PostRepository repository) {
    this.repository = repository;
  }

  public Map<Long, Post> all() {
    return repository.all();
  }

  public Optional<Post> getById(long id) {
    return repository.getById(id);
  }

  public long save(Post post) {
    return repository.save(post).orElseThrow(NotFoundException::new);
  }

  public void removeById(long id) {
    repository.removeById(id);
  }
}