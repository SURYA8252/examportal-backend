package com.examportal.service.implement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.model.exam.Category;
import com.examportal.model.exam.Quiz;
import com.examportal.repository.QuizRepository;
import com.examportal.service.QuizService;
@Service
public class QuizServiceImpl implements QuizService{
    @Autowired
	private QuizRepository quizRepository;
	@Override
	public Quiz addQuiz(Quiz quiz) {
		// Add Quiz
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		// Update Quiz
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		//Get All Quiz
		return new HashSet<>(this.quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long qId) {
		//Get Singal Quiz
		return this.quizRepository.findById(qId).get();
	}

	@Override
	public void deleteQuiz(Long qId) {
		// Delete Quiz by id
		this.quizRepository.deleteById(qId);
	}
    //get Active Quizzess
	@Override
	public List<Quiz> getQuizzesOfCategory(Category category) {
		return this.quizRepository.findBycategory(category);
	}

	@Override
	public List<Quiz> getActiveQuizzes() {
		return this.quizRepository.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizzesOfCategory(Category c) {
		return this.quizRepository.findByCategoryAndActive(c, true);
	}

}
