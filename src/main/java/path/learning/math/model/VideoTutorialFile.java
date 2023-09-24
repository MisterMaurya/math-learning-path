package path.learning.math.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "VideoTutorialFile",uniqueConstraints = @UniqueConstraint(columnNames = { "VIDEO_TITLE" }))

public class VideoTutorialFile implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "VIDEO_ID")
	private int videoId;
	@NotNull
	@Column(name = "VIDEO_TITLE")
	private String videoTitle;
	@NotNull
	@Column(name = "VIDEO_CATEGORY")
	private String videoCategory;
	@NotNull
	@Column(name = "VIDEO_DESCRIPTION")
	private String videoDescription;
	@Transient
	@NotNull(message = "select file")
	private MultipartFile file;

	@Column(name = "FILE_LOCATION")
	private String fileLocation;
	
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public String getVideoTitle() {
		return videoTitle;
	}
	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}
	public String getVideoCategory() {
		return videoCategory;
	}
	public void setVideoCategory(String videoCategory) {
		this.videoCategory = videoCategory;
	}
	public String getVideoDescription() {
		return videoDescription;
	}
	public void setVideoDescription(String videoDescription) {
		this.videoDescription = videoDescription;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getFileLocation() {
		return fileLocation;
	}
}
