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
public class TeachingMaterialHead implements Serializable {

	private static final long serialVersionUID = -599850195;

	private Integer id;
	private String  title;
	private String  titleVariable;
	private Integer teachTaskTitleId;
	private Integer teachingMaterialTemplateId;
	private Byte    isAssignment;
	private Integer sort;

	public TeachingMaterialHead() {}

	public TeachingMaterialHead(TeachingMaterialHead value) {
		this.id = value.id;
		this.title = value.title;
		this.titleVariable = value.titleVariable;
		this.teachTaskTitleId = value.teachTaskTitleId;
		this.teachingMaterialTemplateId = value.teachingMaterialTemplateId;
		this.isAssignment = value.isAssignment;
		this.sort = value.sort;
	}

	public TeachingMaterialHead(
		Integer id,
		String  title,
		String  titleVariable,
		Integer teachTaskTitleId,
		Integer teachingMaterialTemplateId,
		Byte    isAssignment,
		Integer sort
	) {
		this.id = id;
		this.title = title;
		this.titleVariable = titleVariable;
		this.teachTaskTitleId = teachTaskTitleId;
		this.teachingMaterialTemplateId = teachingMaterialTemplateId;
		this.isAssignment = isAssignment;
		this.sort = sort;
	}

	@NotNull
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	@Size(max = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@NotNull
	@Size(max = 50)
	public String getTitleVariable() {
		return this.titleVariable;
	}

	public void setTitleVariable(String titleVariable) {
		this.titleVariable = titleVariable;
	}

	public Integer getTeachTaskTitleId() {
		return this.teachTaskTitleId;
	}

	public void setTeachTaskTitleId(Integer teachTaskTitleId) {
		this.teachTaskTitleId = teachTaskTitleId;
	}

	@NotNull
	public Integer getTeachingMaterialTemplateId() {
		return this.teachingMaterialTemplateId;
	}

	public void setTeachingMaterialTemplateId(Integer teachingMaterialTemplateId) {
		this.teachingMaterialTemplateId = teachingMaterialTemplateId;
	}

	@NotNull
	public Byte getIsAssignment() {
		return this.isAssignment;
	}

	public void setIsAssignment(Byte isAssignment) {
		this.isAssignment = isAssignment;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("TeachingMaterialHead (");

		sb.append(id);
		sb.append(", ").append(title);
		sb.append(", ").append(titleVariable);
		sb.append(", ").append(teachTaskTitleId);
		sb.append(", ").append(teachingMaterialTemplateId);
		sb.append(", ").append(isAssignment);
		sb.append(", ").append(sort);

		sb.append(")");
		return sb.toString();
	}
}
