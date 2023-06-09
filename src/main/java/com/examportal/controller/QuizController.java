package com.examportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.model.exam.Category;
import com.examportal.model.exam.Quiz;
import com.examportal.service.QuizService;


@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
	 @Autowired
     private QuizService quizService;
	 //Add Quiz
	 @PostMapping("/")
	 public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz)
	 {
		 return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	 }
	 //Update Quiz
	 @PutMapping("/")
	 public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz)
	 {
		 return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	 }
	 //Get All Quiz
	 @GetMapping("/")
	 public ResponseEntity<?> getQuizzes()
	 {
		 return ResponseEntity.ok(this.quizService.getQuizzes());
	 }
	 //Get Singal Quiz
	 @GetMapping("/{qId}")
	 public ResponseEntity<Quiz> getQuiz(@PathVariable("qId") Long qId)
	 {
		 return ResponseEntity.ok(this.quizService.getQuiz(qId));
	 }
	 @DeleteMapping("/{qId}")
	 public void deleteQuiz(@PathVariable("qId") Long qId)
	 {
		 this.quizService.deleteQuiz(qId);
	 }
	 @GetMapping("/category/{cId}")
	 public List<Quiz> getQuizzessOfCategory(@PathVariable("cId") Long cId)
	 {
		 Category category=new Category();
		 category.setcId(cId);
		 return this.quizService.getQuizzesOfCategory(category);
	 }
	 //Get Active Quiz
	 @GetMapping("/active")
	 public List<Quiz> getActiveQuizzess()
	 {
		 return this.quizService.getActiveQuizzes();
	 }
	//Get Active Quiz of Category
		 @GetMapping("/category/active/{cId}")
		 public List<Quiz> getActiveQuizzessOfCategory(@PathVariable("cId") Long cId)
		 {
			 Category category=new Category();
			 category.setcId(cId);
			 return this.quizService.getActiveQuizzesOfCategory(category);
		 }
}
