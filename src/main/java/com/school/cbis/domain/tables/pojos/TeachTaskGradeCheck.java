/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.pojos;


import java.io.Serializable;

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
public class TeachTaskGradeCheck implements Serializable {

	private static final long serialVersionUID = 1191921898;

	private Integer id;
	private Integer rowX;
	private Integer teachTaskInfoId;
	private String  grade;
	private Integer gradeNum;
	private Byte    checkIsRight;
	private Integer databaseGradeId;

	public TeachTaskGradeCheck() {}

	public TeachTaskGradeCheck(TeachTaskGradeCheck value) {
		this.id = value.id;
		this.rowX = value.rowX;
		this.teachTaskInfoId = value.teachTaskInfoId;
		this.grade = value.grade;
		this.gradeNum = value.gradeNum;
		this.checkIsRight = value.checkIsRight;
		this.databaseGradeId = value.databaseGradeId;
	}

	public TeachTaskGradeCheck(
		Integer id,
		Integer rowX,
		Integer teachTaskInfoId,
		String  grade,
		Integer gradeNum,
		Byte    checkIsRight,
		Integer databaseGradeId
	) {
		this.id = id;
		this.rowX = rowX;
		this.teachTaskInfoId = teachTaskInfoId;
		this.grade = grade;
		this.gradeNum = gradeNum;
		this.checkIsRight = checkIsRight;
		this.databaseGradeId = databaseGradeId;
	}

	@NotNull
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	public Integer getRowX() {
		return this.rowX;
	}

	public void setRowX(Integer rowX) {
		this.rowX = rowX;
	}

	@NotNull
	public Integer getTeachTaskInfoId() {
		return this.teachTaskInfoId;
	}

	public void setTeachTaskInfoId(Integer teachTaskInfoId) {
		this.teachTaskInfoId = teachTaskInfoId;
	}

	@Size(max = 500)
	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Integer getGradeNum() {
		return this.gradeNum;
	}

	public void setGradeNum(Integer gradeNum) {
		this.gradeNum = gradeNum;
	}

	@NotNull
	public Byte getCheckIsRight() {
		return this.checkIsRight;
	}

	public void setCheckIsRight(Byte checkIsRight) {
		this.checkIsRight = checkIsRight;
	}

	public Integer getDatabaseGradeId() {
		return this.databaseGradeId;
	}

	public void setDatabaseGradeId(Integer databaseGradeId) {
		this.databaseGradeId = databaseGradeId;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("TeachTaskGradeCheck (");

		sb.append(id);
		sb.append(", ").append(rowX);
		sb.append(", ").append(teachTaskInfoId);
		sb.append(", ").append(grade);
		sb.append(", ").append(gradeNum);
		sb.append(", ").append(checkIsRight);
		sb.append(", ").append(databaseGradeId);

		sb.append(")");
		return sb.toString();
	}
}