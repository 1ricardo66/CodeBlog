package com.example.codeblog.service.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.codeblog.model.Post;
import com.example.codeblog.service.CodeblogService;
import com.example.codeblog.repository.CodeblogRepository;

@Service
public class CodeblogServiceImpl implements CodeblogService {
	
	@Autowired
	CodeblogRepository codeblogRepository;
	
	
	

	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return codeblogRepository.findAll();
	}

	@Override
	public Post findById(Long id) {
		// TODO Auto-generated method stub
		return codeblogRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		// TODO Auto-generated method stub
		return codeblogRepository.save(post);
	}
	
	
}
