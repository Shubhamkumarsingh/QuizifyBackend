package com.project.quizify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.quizify.models.Quiz;
import com.project.quizify.models.User;
import com.project.quizify.repository.QuizRepository;
import com.project.quizify.repository.UserRepository;
import com.project.quizify.service.QuizService;
import com.project.quizify.service.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/quiz")
public class QuizController {
    @Autowired
	private QuizService quizService;
    
    @Autowired
    private UserRepository userrepos;
    
	@PostMapping("/add-quiz")
	public Quiz save(@RequestBody Quiz quiz,@AuthenticationPrincipal UserDetailsImpl userdetail) {
//		Authentication auth =   SecurityContextHolder.getContext().getAuthentication(); 
//	      UserDetailsImpl userdetails = (UserDetailsImpl)auth.getPrincipal();
//	      userdetails.setUser(user);
		User user =userrepos.findById(userdetail.getId()).get();
	      System.out.println(user);
		return quizService.addQuiz(quiz, user);
	}
	
//	private User currentUser(Authentication authentication) {
//		Authentication auth =   SecurityContextHolder.getContext().getAuthentication(); 
//       UserDetailsImpl user=	(UserDetailsImpl)auth.getDetails();
//	   User u =user.getUser();
//		return u;
//	}
	
	@GetMapping("/{user_id}/quizzes")
	public List<Quiz> getQuizByUser(@AuthenticationPrincipal UserDetailsImpl userdetail,@PathVariable Long user_id){
		User user =userrepos.findById(userdetail.getId()).get();
	      System.out.println(user);
	      return quizService.findQuizzesByUser(user);
	}
	
	@PutMapping("/updatequiz/{quiz_id}")
	public Quiz updateQuiz(@PathVariable int quiz_id,@RequestBody Quiz quiz) {
		quiz.setId(quiz_id);
		return quizService.updateQuiz(quiz);
	}
	
	@DeleteMapping("/quizdelete/{quiz_id}")
	public void deleteQuiz(@PathVariable int quiz_id) {
		Quiz quiz =quizService.find(quiz_id);
		
		quizService.delete(quiz);
	}
}
