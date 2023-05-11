package com.examportal.service;

import java.util.List;
import java.util.Set;


import com.examportal.model.exam.Category;
import com.examportal.model.exam.Quiz;

public interface QuizService {
	  //Add Quiz
      public Quiz addQuiz(Quiz quiz);
      //Update Quiz
      public Quiz updateQuiz(Quiz quiz);
      //Get All Quiz
      public Set<Quiz> getQuizzes();
      //Get Singal Quiz by id
      public Quiz getQuiz(Long qId);
      //Get delete quiz by id
      public void deleteQuiz(Long qId);
	  public List<Quiz> getQuizzesOfCategory(Category category);
	  public List<Quiz> getActiveQuizzes();
	  public List<Quiz> getActiveQuizzesOfCategory(Category c);
	
}
