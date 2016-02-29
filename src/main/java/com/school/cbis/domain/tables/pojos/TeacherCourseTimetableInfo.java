/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.pojos;


import java.io.Serializable;
import java.sql.Date;
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
public class TeacherCourseTimetableInfo implements Serializable {

	private static final long serialVersionUID = -2099561402;

	private Integer   id;
	private Integer   tieId;
	private String    timetableInfoTerm;
	private String    timetableInfoFileUrl;
	private String    timetableInfoFilePdf;
	private String    timetableInfoFileName;
	private Timestamp timetableInfoFileDate;
	private Integer   timetableInfoFileDownTimes;
	private Integer   teachTypeId;
	private Date      termStartTime;
	private Date      termEndTime;
	private String    fileUser;
	private String    fileType;

	public TeacherCourseTimetableInfo() {}

	public TeacherCourseTimetableInfo(TeacherCourseTimetableInfo value) {
		this.id = value.id;
		this.tieId = value.tieId;
		this.timetableInfoTerm = value.timetableInfoTerm;
		this.timetableInfoFileUrl = value.timetableInfoFileUrl;
		this.timetableInfoFilePdf = value.timetableInfoFilePdf;
		this.timetableInfoFileName = value.timetableInfoFileName;
		this.timetableInfoFileDate = value.timetableInfoFileDate;
		this.timetableInfoFileDownTimes = value.timetableInfoFileDownTimes;
		this.teachTypeId = value.teachTypeId;
		this.termStartTime = value.termStartTime;
		this.termEndTime = value.termEndTime;
		this.fileUser = value.fileUser;
		this.fileType = value.fileType;
	}

	public TeacherCourseTimetableInfo(
		Integer   id,
		Integer   tieId,
		String    timetableInfoTerm,
		String    timetableInfoFileUrl,
		String    timetableInfoFilePdf,
		String    timetableInfoFileName,
		Timestamp timetableInfoFileDate,
		Integer   timetableInfoFileDownTimes,
		Integer   teachTypeId,
		Date      termStartTime,
		Date      termEndTime,
		String    fileUser,
		String    fileType
	) {
		this.id = id;
		this.tieId = tieId;
		this.timetableInfoTerm = timetableInfoTerm;
		this.timetableInfoFileUrl = timetableInfoFileUrl;
		this.timetableInfoFilePdf = timetableInfoFilePdf;
		this.timetableInfoFileName = timetableInfoFileName;
		this.timetableInfoFileDate = timetableInfoFileDate;
		this.timetableInfoFileDownTimes = timetableInfoFileDownTimes;
		this.teachTypeId = teachTypeId;
		this.termStartTime = termStartTime;
		this.termEndTime = termEndTime;
		this.fileUser = fileUser;
		this.fileType = fileType;
	}

	@NotNull
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	public Integer getTieId() {
		return this.tieId;
	}

	public void setTieId(Integer tieId) {
		this.tieId = tieId;
	}

	@NotNull
	@Size(max = 20)
	public String getTimetableInfoTerm() {
		return this.timetableInfoTerm;
	}

	public void setTimetableInfoTerm(String timetableInfoTerm) {
		this.timetableInfoTerm = timetableInfoTerm;
	}

	@NotNull
	@Size(max = 500)
	public String getTimetableInfoFileUrl() {
		return this.timetableInfoFileUrl;
	}

	public void setTimetableInfoFileUrl(String timetableInfoFileUrl) {
		this.timetableInfoFileUrl = timetableInfoFileUrl;
	}

	@Size(max = 500)
	public String getTimetableInfoFilePdf() {
		return this.timetableInfoFilePdf;
	}

	public void setTimetableInfoFilePdf(String timetableInfoFilePdf) {
		this.timetableInfoFilePdf = timetableInfoFilePdf;
	}

	@NotNull
	@Size(max = 30)
	public String getTimetableInfoFileName() {
		return this.timetableInfoFileName;
	}

	public void setTimetableInfoFileName(String timetableInfoFileName) {
		this.timetableInfoFileName = timetableInfoFileName;
	}

	public Timestamp getTimetableInfoFileDate() {
		return this.timetableInfoFileDate;
	}

	public void setTimetableInfoFileDate(Timestamp timetableInfoFileDate) {
		this.timetableInfoFileDate = timetableInfoFileDate;
	}

	public Integer getTimetableInfoFileDownTimes() {
		return this.timetableInfoFileDownTimes;
	}

	public void setTimetableInfoFileDownTimes(Integer timetableInfoFileDownTimes) {
		this.timetableInfoFileDownTimes = timetableInfoFileDownTimes;
	}

	@NotNull
	public Integer getTeachTypeId() {
		return this.teachTypeId;
	}

	public void setTeachTypeId(Integer teachTypeId) {
		this.teachTypeId = teachTypeId;
	}

	@NotNull
	public Date getTermStartTime() {
		return this.termStartTime;
	}

	public void setTermStartTime(Date termStartTime) {
		this.termStartTime = termStartTime;
	}

	@NotNull
	public Date getTermEndTime() {
		return this.termEndTime;
	}

	public void setTermEndTime(Date termEndTime) {
		this.termEndTime = termEndTime;
	}

	@NotNull
	@Size(max = 64)
	public String getFileUser() {
		return this.fileUser;
	}

	public void setFileUser(String fileUser) {
		this.fileUser = fileUser;
	}

	@Size(max = 15)
	public String getFileType() {
		return this.fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("TeacherCourseTimetableInfo (");

		sb.append(id);
		sb.append(", ").append(tieId);
		sb.append(", ").append(timetableInfoTerm);
		sb.append(", ").append(timetableInfoFileUrl);
		sb.append(", ").append(timetableInfoFilePdf);
		sb.append(", ").append(timetableInfoFileName);
		sb.append(", ").append(timetableInfoFileDate);
		sb.append(", ").append(timetableInfoFileDownTimes);
		sb.append(", ").append(teachTypeId);
		sb.append(", ").append(termStartTime);
		sb.append(", ").append(termEndTime);
		sb.append(", ").append(fileUser);
		sb.append(", ").append(fileType);

		sb.append(")");
		return sb.toString();
	}
}
