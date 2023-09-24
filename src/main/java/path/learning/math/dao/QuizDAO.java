package path.learning.math.dao;

import java.util.List;

import path.learning.math.model.QuizMe;

public interface QuizDAO {
	public boolean addQuiz(QuizMe quiz);
	public boolean delete(int quizid);
	public boolean updateQuestion(int quizid);
	public List<QuizMe> getAllQuiz();
}

