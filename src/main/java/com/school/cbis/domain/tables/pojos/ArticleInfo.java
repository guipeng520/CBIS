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
public class ArticleInfo implements Serializable {

	private static final long serialVersionUID = -14709071;

	private Integer   id;
	private String    bigTitle;
	private String    articleWriter;
	private Timestamp date;
	private Integer   articleTypeId;
	private String    articleContent;
	private String    articlePhotoUrl;

	public ArticleInfo() {}

	public ArticleInfo(ArticleInfo value) {
		this.id = value.id;
		this.bigTitle = value.bigTitle;
		this.articleWriter = value.articleWriter;
		this.date = value.date;
		this.articleTypeId = value.articleTypeId;
		this.articleContent = value.articleContent;
		this.articlePhotoUrl = value.articlePhotoUrl;
	}

	public ArticleInfo(
		Integer   id,
		String    bigTitle,
		String    articleWriter,
		Timestamp date,
		Integer   articleTypeId,
		String    articleContent,
		String    articlePhotoUrl
	) {
		this.id = id;
		this.bigTitle = bigTitle;
		this.articleWriter = articleWriter;
		this.date = date;
		this.articleTypeId = articleTypeId;
		this.articleContent = articleContent;
		this.articlePhotoUrl = articlePhotoUrl;
	}

	@NotNull
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Size(max = 50)
	public String getBigTitle() {
		return this.bigTitle;
	}

	public void setBigTitle(String bigTitle) {
		this.bigTitle = bigTitle;
	}

	@NotNull
	@Size(max = 64)
	public String getArticleWriter() {
		return this.articleWriter;
	}

	public void setArticleWriter(String articleWriter) {
		this.articleWriter = articleWriter;
	}

	@NotNull
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@NotNull
	public Integer getArticleTypeId() {
		return this.articleTypeId;
	}

	public void setArticleTypeId(Integer articleTypeId) {
		this.articleTypeId = articleTypeId;
	}

	@Size(max = 2000)
	public String getArticleContent() {
		return this.articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	@Size(max = 500)
	public String getArticlePhotoUrl() {
		return this.articlePhotoUrl;
	}

	public void setArticlePhotoUrl(String articlePhotoUrl) {
		this.articlePhotoUrl = articlePhotoUrl;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ArticleInfo (");

		sb.append(id);
		sb.append(", ").append(bigTitle);
		sb.append(", ").append(articleWriter);
		sb.append(", ").append(date);
		sb.append(", ").append(articleTypeId);
		sb.append(", ").append(articleContent);
		sb.append(", ").append(articlePhotoUrl);

		sb.append(")");
		return sb.toString();
	}
}
