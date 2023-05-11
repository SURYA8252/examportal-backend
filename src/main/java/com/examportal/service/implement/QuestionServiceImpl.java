package com.examportal.service.implement;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.model.exam.Question;
import com.examportal.model.exam.Quiz;
import com.examportal.repository.QuestionRepository;
import com.examportal.service.QuestionService;
@Service
public class QuestionServiceImpl implements QuestionService{
    @Autowired
	private QuestionRepository questionRepository;
	@Override
	public Question addQuestion(Question question) {
		// Add Question
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		// Update Question
		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {
		// Get All Question
		return new HashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long quesId) {
		//Get Singal Question by id
		return this.questionRepository.findById(quesId).get();
	}

	@Override
	public Set<Question> getQuestionOfQuiz(Quiz quiz) {
		//Get Question by Quiz
		return this.questionRepository.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(Long quesId) {
		Question question=new Question();
		question.setQuesId(quesId);
		this.questionRepository.delete(question);
	}

	@Override
	public Question get(Long questionId) {
		return this.questionRepository.getOne(questionId);
	}

}
