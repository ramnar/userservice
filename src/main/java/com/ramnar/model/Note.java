package com.ramnar.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table
//@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Note implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ApiModelProperty(notes = "Title of the notes", required =true)
	@NotBlank
	private String title;

	@NotBlank
	private String content;

//	@Column(nullable = false, updatable = false)
//	@Temporal(TemporalType.DATE)
//	@CreatedDate
//	private Date createdAt;
//	@Column(nullable = false)
//	@Temporal(TemporalType.DATE)
//	@LastModifiedDate
//	private Date updatedAt;
//
//	public String getUpdatedAt() {
//		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		return sdf.format(updatedAt);
//	}
//
//	public void setUpdatedAt(Date updatedAt) {
//		this.updatedAt = updatedAt;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

//	public String getCreatedAt() {
//		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		return sdf.format(createdAt);
//	}
//
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}

}
