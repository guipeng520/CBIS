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
public class TeachTaskTitle implements Serializable {

	private static final long serialVersionUID = -832422666;

	private Integer id;
	private String  title;
	private Integer titleX;
	private Integer titleY;
	private Integer titleLx;
	private Integer titleLy;
	private String  titleFont;
	private String  titleFontSize;
	private String  titleFontColor;
	private String  titleBackground;
	private Byte    titleIsBig;
	private Byte    titleIsItalic;
	private Byte    isEdit;
	private Integer teachTaskInfoId;

	public TeachTaskTitle() {}

	public TeachTaskTitle(TeachTaskTitle value) {
		this.id = value.id;
		this.title = value.title;
		this.titleX = value.titleX;
		this.titleY = value.titleY;
		this.titleLx = value.titleLx;
		this.titleLy = value.titleLy;
		this.titleFont = value.titleFont;
		this.titleFontSize = value.titleFontSize;
		this.titleFontColor = value.titleFontColor;
		this.titleBackground = value.titleBackground;
		this.titleIsBig = value.titleIsBig;
		this.titleIsItalic = value.titleIsItalic;
		this.isEdit = value.isEdit;
		this.teachTaskInfoId = value.teachTaskInfoId;
	}

	public TeachTaskTitle(
		Integer id,
		String  title,
		Integer titleX,
		Integer titleY,
		Integer titleLx,
		Integer titleLy,
		String  titleFont,
		String  titleFontSize,
		String  titleFontColor,
		String  titleBackground,
		Byte    titleIsBig,
		Byte    titleIsItalic,
		Byte    isEdit,
		Integer teachTaskInfoId
	) {
		this.id = id;
		this.title = title;
		this.titleX = titleX;
		this.titleY = titleY;
		this.titleLx = titleLx;
		this.titleLy = titleLy;
		this.titleFont = titleFont;
		this.titleFontSize = titleFontSize;
		this.titleFontColor = titleFontColor;
		this.titleBackground = titleBackground;
		this.titleIsBig = titleIsBig;
		this.titleIsItalic = titleIsItalic;
		this.isEdit = isEdit;
		this.teachTaskInfoId = teachTaskInfoId;
	}

	@NotNull
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Size(max = 150)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@NotNull
	public Integer getTitleX() {
		return this.titleX;
	}

	public void setTitleX(Integer titleX) {
		this.titleX = titleX;
	}

	@NotNull
	public Integer getTitleY() {
		return this.titleY;
	}

	public void setTitleY(Integer titleY) {
		this.titleY = titleY;
	}

	public Integer getTitleLx() {
		return this.titleLx;
	}

	public void setTitleLx(Integer titleLx) {
		this.titleLx = titleLx;
	}

	public Integer getTitleLy() {
		return this.titleLy;
	}

	public void setTitleLy(Integer titleLy) {
		this.titleLy = titleLy;
	}

	@Size(max = 25)
	public String getTitleFont() {
		return this.titleFont;
	}

	public void setTitleFont(String titleFont) {
		this.titleFont = titleFont;
	}

	@Size(max = 25)
	public String getTitleFontSize() {
		return this.titleFontSize;
	}

	public void setTitleFontSize(String titleFontSize) {
		this.titleFontSize = titleFontSize;
	}

	@Size(max = 25)
	public String getTitleFontColor() {
		return this.titleFontColor;
	}

	public void setTitleFontColor(String titleFontColor) {
		this.titleFontColor = titleFontColor;
	}

	@Size(max = 25)
	public String getTitleBackground() {
		return this.titleBackground;
	}

	public void setTitleBackground(String titleBackground) {
		this.titleBackground = titleBackground;
	}

	public Byte getTitleIsBig() {
		return this.titleIsBig;
	}

	public void setTitleIsBig(Byte titleIsBig) {
		this.titleIsBig = titleIsBig;
	}

	public Byte getTitleIsItalic() {
		return this.titleIsItalic;
	}

	public void setTitleIsItalic(Byte titleIsItalic) {
		this.titleIsItalic = titleIsItalic;
	}

	public Byte getIsEdit() {
		return this.isEdit;
	}

	public void setIsEdit(Byte isEdit) {
		this.isEdit = isEdit;
	}

	@NotNull
	public Integer getTeachTaskInfoId() {
		return this.teachTaskInfoId;
	}

	public void setTeachTaskInfoId(Integer teachTaskInfoId) {
		this.teachTaskInfoId = teachTaskInfoId;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("TeachTaskTitle (");

		sb.append(id);
		sb.append(", ").append(title);
		sb.append(", ").append(titleX);
		sb.append(", ").append(titleY);
		sb.append(", ").append(titleLx);
		sb.append(", ").append(titleLy);
		sb.append(", ").append(titleFont);
		sb.append(", ").append(titleFontSize);
		sb.append(", ").append(titleFontColor);
		sb.append(", ").append(titleBackground);
		sb.append(", ").append(titleIsBig);
		sb.append(", ").append(titleIsItalic);
		sb.append(", ").append(isEdit);
		sb.append(", ").append(teachTaskInfoId);

		sb.append(")");
		return sb.toString();
	}
}
