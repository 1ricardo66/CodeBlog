package com.example.codeblog.service;

import com.example.codeblog.model.Post;

import java.util.List;
import com.example.codeblog.model.Post;

public interface CodeblogService {
	
	List<Post> findAll();
	Post findById(Long id);
	Post save(Post post);

}
