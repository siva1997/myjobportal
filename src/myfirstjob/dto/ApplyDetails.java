package myfirstjob.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApplyDetails {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int applyId;
	@Column(nullable = false)
	private int jobId;
	
	@Column(nullable = false)
	private int jobSeekerId;

	public ApplyDetails(int jobId, int jobSeekerId) {
		super();
		this.jobId = jobId;
		this.jobSeekerId = jobSeekerId;
	}

	public ApplyDetails() {
		super();
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(int jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}
	
}
