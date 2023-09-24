package path.learning.math.dao;

import java.util.List;

import path.learning.math.model.TutorialFile;

public interface TutorialFileDAO {

	 public boolean saveFile(TutorialFile document);
	 public List<TutorialFile> getAllFile();
	 public boolean deleteFile(int fileId);
}
