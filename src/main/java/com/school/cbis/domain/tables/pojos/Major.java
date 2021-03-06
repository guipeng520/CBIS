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
public class Major implements Serializable {

	private static final long serialVersionUID = -818812492;

	private Integer id;
	private Integer tieId;
	private String  majorName;
	private Integer majorIntroduceArticleInfoId;
	private Integer majorTrainingGoalArticleInfoId;
	private Integer majorTraitArticleInfoId;
	private Integer majorForegoerArticleInfoId;
	private Byte    isShow;

	public Major() {}

	public Major(Major value) {
		this.id = value.id;
		this.tieId = value.tieId;
		this.majorName = value.majorName;
		this.majorIntroduceArticleInfoId = value.majorIntroduceArticleInfoId;
		this.majorTrainingGoalArticleInfoId = value.majorTrainingGoalArticleInfoId;
		this.majorTraitArticleInfoId = value.majorTraitArticleInfoId;
		this.majorForegoerArticleInfoId = value.majorForegoerArticleInfoId;
		this.isShow = value.isShow;
	}

	public Major(
		Integer id,
		Integer tieId,
		String  majorName,
		Integer majorIntroduceArticleInfoId,
		Integer majorTrainingGoalArticleInfoId,
		Integer majorTraitArticleInfoId,
		Integer majorForegoerArticleInfoId,
		Byte    isShow
	) {
		this.id = id;
		this.tieId = tieId;
		this.majorName = majorName;
		this.majorIntroduceArticleInfoId = majorIntroduceArticleInfoId;
		this.majorTrainingGoalArticleInfoId = majorTrainingGoalArticleInfoId;
		this.majorTraitArticleInfoId = majorTraitArticleInfoId;
		this.majorForegoerArticleInfoId = majorForegoerArticleInfoId;
		this.isShow = isShow;
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
	@Size(max = 150)
	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public Integer getMajorIntroduceArticleInfoId() {
		return this.majorIntroduceArticleInfoId;
	}

	public void setMajorIntroduceArticleInfoId(Integer majorIntroduceArticleInfoId) {
		this.majorIntroduceArticleInfoId = majorIntroduceArticleInfoId;
	}

	public Integer getMajorTrainingGoalArticleInfoId() {
		return this.majorTrainingGoalArticleInfoId;
	}

	public void setMajorTrainingGoalArticleInfoId(Integer majorTrainingGoalArticleInfoId) {
		this.majorTrainingGoalArticleInfoId = majorTrainingGoalArticleInfoId;
	}

	public Integer getMajorTraitArticleInfoId() {
		return this.majorTraitArticleInfoId;
	}

	public void setMajorTraitArticleInfoId(Integer majorTraitArticleInfoId) {
		this.majorTraitArticleInfoId = majorTraitArticleInfoId;
	}

	public Integer getMajorForegoerArticleInfoId() {
		return this.majorForegoerArticleInfoId;
	}

	public void setMajorForegoerArticleInfoId(Integer majorForegoerArticleInfoId) {
		this.majorForegoerArticleInfoId = majorForegoerArticleInfoId;
	}

	public Byte getIsShow() {
		return this.isShow;
	}

	public void setIsShow(Byte isShow) {
		this.isShow = isShow;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Major (");

		sb.append(id);
		sb.append(", ").append(tieId);
		sb.append(", ").append(majorName);
		sb.append(", ").append(majorIntroduceArticleInfoId);
		sb.append(", ").append(majorTrainingGoalArticleInfoId);
		sb.append(", ").append(majorTraitArticleInfoId);
		sb.append(", ").append(majorForegoerArticleInfoId);
		sb.append(", ").append(isShow);

		sb.append(")");
		return sb.toString();
	}
}
