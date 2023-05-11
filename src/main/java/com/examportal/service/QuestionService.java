package com.examportal.service;

import java.util.Set;

import com.examportal.model.exam.Question;
import com.examportal.model.exam.Quiz;

public interface QuestionService {
	 //Add Question
     public Question addQuestion(Question question);
     //Update Question
     public Question updateQuestion(Question question);
     //Get All Question
     public Set<Question> getQuestions();
     //Get Singal Question by id
     public Question getQuestion(Long quesId);
     //Get Question of Quiz
     public Set<Question> getQuestionOfQuiz(Quiz quiz);
     //Delete Question
     public void deleteQuestion(Long quesId);
     //Get Question by Id
     public Question get(Long questionId);
}
