package com.example.codeblog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.codeblog.model.Post;
import com.example.codeblog.service.CodeblogService;

@Controller
public class CodeblogController {
	
	@Autowired
	CodeblogService codeblogService;
	
	
	@RequestMapping(value= "/posts", method = RequestMethod.GET)
	public ModelAndView getPost() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = codeblogService.findAll();
		
		mv.addObject("posts",posts);
		
		return mv;
	}
	
	@RequestMapping(value= "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		
		Post post = codeblogService.findById(id);
		
		mv.addObject("post",post);
		
		return mv;
	}
	
	
	@RequestMapping(value = "/newpost", method = RequestMethod.GET)
	public String getPostForm() {
		
		return "postForm";
	}
	
	@RequestMapping(value = "/newpost", method = RequestMethod.POST)
	public String savePost(@Valid Post post, BindingResult result , RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return "redirect:/newpost";
		}
		
		post.setData(LocalDate.now());
		codeblogService.save(post);
		
		return "redirect:/posts";
		
	}
	
	@GetMapping(value="/home")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("home");
		return mv;
	}

}
