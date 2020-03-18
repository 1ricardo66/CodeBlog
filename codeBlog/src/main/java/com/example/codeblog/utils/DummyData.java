package com.example.codeblog.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.codeblog.model.Post;
import com.example.codeblog.repository.CodeblogRepository;

@Component
public class DummyData {

	@Autowired
	CodeblogRepository codeblogRepository;
	
	//@PostConstruct
	public void savePost() {
		List<Post> postList = new ArrayList<>();
		
		Post post1 = new Post();
		
		post1.setAutor("Michelli brito");
		post1.setData(LocalDate.now());
		post1.setTitulo("Docker");
		post1.setTexto("Lorem ipsum dollor, Lorem ipsum dollor, Lorem ipsum dollor");
		
		Post post2 = new Post();
		
		post2.setAutor("Ricardo");
		post2.setData(LocalDate.now());
		post2.setTitulo("Java");
		post2.setTexto("Java was developed by James Gosling, who is known as the father of Java, in 1995. James Gosling and his team members started the project in the early '90s. Currently, Java is used in internet programming, mobile devices, games, e-business solutions, etc.");
		
		postList.add(post1);
		postList.add(post2);
		
		for(Post post : postList) {
			Post postSaved = codeblogRepository.save(post);
			System.out.println("Post Id: "+postSaved.getId());
		}
	}
	
}
