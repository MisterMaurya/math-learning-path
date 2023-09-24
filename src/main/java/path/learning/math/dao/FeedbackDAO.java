package path.learning.math.dao;

import java.util.List;

import path.learning.math.model.Feedback;

public interface FeedbackDAO {
	public boolean sendFeedback(Feedback feedback);
	public List<Feedback> getAllFeedbacks();
	public boolean delete(int feedId);

}
