package com.example.codeblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.codeblog.model.Post;

public interface CodeblogRepository extends JpaRepository <Post, Long>{
	
}
