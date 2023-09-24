package path.learning.math.dao;

import java.util.List;

import path.learning.math.model.VideoTutorialFile;

public interface VideoTutorialFileDAO {

	boolean save(VideoTutorialFile document);

	boolean deleteById(int id);

	public List<VideoTutorialFile> getAllFile();

}
