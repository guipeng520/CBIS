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
public class PlaceFileContent implements Serializable {

	private static final long serialVersionUID = 1970570856;

	private Integer id;
	private Integer placeFileTitleId;
	private String  content;
	private Integer contentX;
	private Integer contentY;
	private Integer contentLx;
	private Integer contentLy;
	private String  contentFont;
	private String  contentFontSize;
	private String  contentFontColor;
	private String  contentBackground;
	private Byte    contentIsBig;
	private Byte    contentIsItalic;
	private Byte    isEdit;

	public PlaceFileContent() {}

	public PlaceFileContent(PlaceFileContent value) {
		this.id = value.id;
		this.placeFileTitleId = value.placeFileTitleId;
		this.content = value.content;
		this.contentX = value.contentX;
		this.contentY = value.contentY;
		this.contentLx = value.contentLx;
		this.contentLy = value.contentLy;
		this.contentFont = value.contentFont;
		this.contentFontSize = value.contentFontSize;
		this.contentFontColor = value.contentFontColor;
		this.contentBackground = value.contentBackground;
		this.contentIsBig = value.contentIsBig;
		this.contentIsItalic = value.contentIsItalic;
		this.isEdit = value.isEdit;
	}

	public PlaceFileContent(
		Integer id,
		Integer placeFileTitleId,
		String  content,
		Integer contentX,
		Integer contentY,
		Integer contentLx,
		Integer contentLy,
		String  contentFont,
		String  contentFontSize,
		String  contentFontColor,
		String  contentBackground,
		Byte    contentIsBig,
		Byte    contentIsItalic,
		Byte    isEdit
	) {
		this.id = id;
		this.placeFileTitleId = placeFileTitleId;
		this.content = content;
		this.contentX = contentX;
		this.contentY = contentY;
		this.contentLx = contentLx;
		this.contentLy = contentLy;
		this.contentFont = contentFont;
		this.contentFontSize = contentFontSize;
		this.contentFontColor = contentFontColor;
		this.contentBackground = contentBackground;
		this.contentIsBig = contentIsBig;
		this.contentIsItalic = contentIsItalic;
		this.isEdit = isEdit;
	}

	@NotNull
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	public Integer getPlaceFileTitleId() {
		return this.placeFileTitleId;
	}

	public void setPlaceFileTitleId(Integer placeFileTitleId) {
		this.placeFileTitleId = placeFileTitleId;
	}

	@Size(max = 600)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@NotNull
	public Integer getContentX() {
		return this.contentX;
	}

	public void setContentX(Integer contentX) {
		this.contentX = contentX;
	}

	@NotNull
	public Integer getContentY() {
		return this.contentY;
	}

	public void setContentY(Integer contentY) {
		this.contentY = contentY;
	}

	public Integer getContentLx() {
		return this.contentLx;
	}

	public void setContentLx(Integer contentLx) {
		this.contentLx = contentLx;
	}

	public Integer getContentLy() {
		return this.contentLy;
	}

	public void setContentLy(Integer contentLy) {
		this.contentLy = contentLy;
	}

	@Size(max = 25)
	public String getContentFont() {
		return this.contentFont;
	}

	public void setContentFont(String contentFont) {
		this.contentFont = contentFont;
	}

	@Size(max = 25)
	public String getContentFontSize() {
		return this.contentFontSize;
	}

	public void setContentFontSize(String contentFontSize) {
		this.contentFontSize = contentFontSize;
	}

	@Size(max = 25)
	public String getContentFontColor() {
		return this.contentFontColor;
	}

	public void setContentFontColor(String contentFontColor) {
		this.contentFontColor = contentFontColor;
	}

	@Size(max = 25)
	public String getContentBackground() {
		return this.contentBackground;
	}

	public void setContentBackground(String contentBackground) {
		this.contentBackground = contentBackground;
	}

	public Byte getContentIsBig() {
		return this.contentIsBig;
	}

	public void setContentIsBig(Byte contentIsBig) {
		this.contentIsBig = contentIsBig;
	}

	public Byte getContentIsItalic() {
		return this.contentIsItalic;
	}

	public void setContentIsItalic(Byte contentIsItalic) {
		this.contentIsItalic = contentIsItalic;
	}

	public Byte getIsEdit() {
		return this.isEdit;
	}

	public void setIsEdit(Byte isEdit) {
		this.isEdit = isEdit;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("PlaceFileContent (");

		sb.append(id);
		sb.append(", ").append(placeFileTitleId);
		sb.append(", ").append(content);
		sb.append(", ").append(contentX);
		sb.append(", ").append(contentY);
		sb.append(", ").append(contentLx);
		sb.append(", ").append(contentLy);
		sb.append(", ").append(contentFont);
		sb.append(", ").append(contentFontSize);
		sb.append(", ").append(contentFontColor);
		sb.append(", ").append(contentBackground);
		sb.append(", ").append(contentIsBig);
		sb.append(", ").append(contentIsItalic);
		sb.append(", ").append(isEdit);

		sb.append(")");
		return sb.toString();
	}
}
