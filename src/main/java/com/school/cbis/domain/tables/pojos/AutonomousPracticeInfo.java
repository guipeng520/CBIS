/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AutonomousPracticeInfo implements Serializable {

	private static final long serialVersionUID = -1882542457;

	private Integer   id;
	private String    autonomousPracticeTitle;
	private Timestamp createTime;
	private String    gradeYear;
	private Integer   autonomousPracticeTemplateId;
	private Timestamp startTime;
	private Timestamp endTime;
	private String    usersId;
	private Integer   tieId;

	public AutonomousPracticeInfo() {}

	public AutonomousPracticeInfo(AutonomousPracticeInfo value) {
		this.id = value.id;
		this.autonomousPracticeTitle = value.autonomousPracticeTitle;
		this.createTime = value.createTime;
		this.gradeYear = value.gradeYear;
		this.autonomousPracticeTemplateId = value.autonomousPracticeTemplateId;
		this.startTime = value.startTime;
		this.endTime = value.endTime;
		this.usersId = value.usersId;
		this.tieId = value.tieId;
	}

	public AutonomousPracticeInfo(
		Integer   id,
		String    autonomousPracticeTitle,
		Timestamp createTime,
		String    gradeYear,
		Integer   autonomousPracticeTemplateId,
		Timestamp startTime,
		Timestamp endTime,
		String    usersId,
		Integer   tieId
	) {
		this.id = id;
		this.autonomousPracticeTitle = autonomousPracticeTitle;
		this.createTime = createTime;
		this.gradeYear = gradeYear;
		this.autonomousPracticeTemplateId = autonomousPracticeTemplateId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.usersId = usersId;
		this.tieId = tieId;
	}

	@NotNull
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	@Size(max = 100)
	public String getAutonomousPracticeTitle() {
		return this.autonomousPracticeTitle;
	}

	public void setAutonomousPracticeTitle(String autonomousPracticeTitle) {
		this.autonomousPracticeTitle = autonomousPracticeTitle;
	}

	@NotNull
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@NotNull
	@Size(max = 20)
	public String getGradeYear() {
		return this.gradeYear;
	}

	public void setGradeYear(String gradeYear) {
		this.gradeYear = gradeYear;
	}

	public Integer getAutonomousPracticeTemplateId() {
		return this.autonomousPracticeTemplateId;
	}

	public void setAutonomousPracticeTemplateId(Integer autonomousPracticeTemplateId) {
		this.autonomousPracticeTemplateId = autonomousPracticeTemplateId;
	}

	@NotNull
	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	@NotNull
	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	@NotNull
	@Size(max = 64)
	public String getUsersId() {
		return this.usersId;
	}

	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}

	@NotNull
	public Integer getTieId() {
		return this.tieId;
	}

	public void setTieId(Integer tieId) {
		this.tieId = tieId;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("AutonomousPracticeInfo (");

		sb.append(id);
		sb.append(", ").append(autonomousPracticeTitle);
		sb.append(", ").append(createTime);
		sb.append(", ").append(gradeYear);
		sb.append(", ").append(autonomousPracticeTemplateId);
		sb.append(", ").append(startTime);
		sb.append(", ").append(endTime);
		sb.append(", ").append(usersId);
		sb.append(", ").append(tieId);

		sb.append(")");
		return sb.toString();
	}
}
