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
@Table(name="TutorialFile", uniqueConstraints = @UniqueConstraint(columnNames = { "FILE_TITLE" }))
public class TutorialFile implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	@Column(name = "FILE_ID")
	private int fileId;
	@NotNull(message = "Enter File Title")
	@Column(name = "FILE_TITLE")
	private String fileTitle;
	@NotNull(message = "Enter File Category")
	@Column(name = "FILE_CATEGORY")
	private String fileCategory;
	@NotNull(message = "Enter File Description")
	@Column(name = "FILE_DESCRIPTION")
	private String fileDescription;
	@Column(name = "FILE_LOCATION")
	private String fileLocation;

	@Transient
	@NotNull(message = "select file")
	private MultipartFile file;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileTitle() {
		return fileTitle;
	}

	public void setFileTitle(String fileTitle) {
		this.fileTitle = fileTitle;
	}

	public String getFileCategory() {
		return fileCategory;
	}

	public void setFileCategory(String fileCategory) {
		this.fileCategory = fileCategory;
	}

	public String getFileDescription() {
		return fileDescription;
	}

	public void setFileDescription(String fileDescription) {
		this.fileDescription = fileDescription;
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
