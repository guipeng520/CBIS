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
public class Recruit implements Serializable {

	private static final long serialVersionUID = 1852622867;

	private Integer   id;
	private Timestamp recruitTime;
	private String    recruitAddress;
	private String    recruitContent;
	private String    textLink;
	private Integer   tieId;

	public Recruit() {}

	public Recruit(Recruit value) {
		this.id = value.id;
		this.recruitTime = value.recruitTime;
		this.recruitAddress = value.recruitAddress;
		this.recruitContent = value.recruitContent;
		this.textLink = value.textLink;
		this.tieId = value.tieId;
	}

	public Recruit(
		Integer   id,
		Timestamp recruitTime,
		String    recruitAddress,
		String    recruitContent,
		String    textLink,
		Integer   tieId
	) {
		this.id = id;
		this.recruitTime = recruitTime;
		this.recruitAddress = recruitAddress;
		this.recruitContent = recruitContent;
		this.textLink = textLink;
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
	public Timestamp getRecruitTime() {
		return this.recruitTime;
	}

	public void setRecruitTime(Timestamp recruitTime) {
		this.recruitTime = recruitTime;
	}

	@Size(max = 500)
	public String getRecruitAddress() {
		return this.recruitAddress;
	}

	public void setRecruitAddress(String recruitAddress) {
		this.recruitAddress = recruitAddress;
	}

	@Size(max = 65535)
	public String getRecruitContent() {
		return this.recruitContent;
	}

	public void setRecruitContent(String recruitContent) {
		this.recruitContent = recruitContent;
	}

	@Size(max = 1000)
	public String getTextLink() {
		return this.textLink;
	}

	public void setTextLink(String textLink) {
		this.textLink = textLink;
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
		StringBuilder sb = new StringBuilder("Recruit (");

		sb.append(id);
		sb.append(", ").append(recruitTime);
		sb.append(", ").append(recruitAddress);
		sb.append(", ").append(recruitContent);
		sb.append(", ").append(textLink);
		sb.append(", ").append(tieId);

		sb.append(")");
		return sb.toString();
	}
}