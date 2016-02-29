/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.records;


import com.school.cbis.domain.tables.ArticleSub;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


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
public class ArticleSubRecord extends UpdatableRecordImpl<ArticleSubRecord> implements Record6<Integer, String, String, String, Integer, Integer> {

	private static final long serialVersionUID = -1771039779;

	/**
	 * Setter for <code>cbis.article_sub.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cbis.article_sub.id</code>.
	 */
	@NotNull
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>cbis.article_sub.sub_title</code>.
	 */
	public void setSubTitle(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cbis.article_sub.sub_title</code>.
	 */
	@Size(max = 50)
	public String getSubTitle() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>cbis.article_sub.sub_content</code>.
	 */
	public void setSubContent(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cbis.article_sub.sub_content</code>.
	 */
	@Size(max = 1000)
	public String getSubContent() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>cbis.article_sub.sub_photo_url</code>.
	 */
	public void setSubPhotoUrl(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cbis.article_sub.sub_photo_url</code>.
	 */
	@Size(max = 500)
	public String getSubPhotoUrl() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>cbis.article_sub.article_info_id</code>.
	 */
	public void setArticleInfoId(Integer value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cbis.article_sub.article_info_id</code>.
	 */
	@NotNull
	public Integer getArticleInfoId() {
		return (Integer) getValue(4);
	}

	/**
	 * Setter for <code>cbis.article_sub.row</code>.
	 */
	public void setRow(Integer value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>cbis.article_sub.row</code>.
	 */
	@NotNull
	public Integer getRow() {
		return (Integer) getValue(5);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Integer> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record6 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row6<Integer, String, String, String, Integer, Integer> fieldsRow() {
		return (Row6) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row6<Integer, String, String, String, Integer, Integer> valuesRow() {
		return (Row6) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return ArticleSub.ARTICLE_SUB.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return ArticleSub.ARTICLE_SUB.SUB_TITLE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return ArticleSub.ARTICLE_SUB.SUB_CONTENT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return ArticleSub.ARTICLE_SUB.SUB_PHOTO_URL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field5() {
		return ArticleSub.ARTICLE_SUB.ARTICLE_INFO_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field6() {
		return ArticleSub.ARTICLE_SUB.ROW;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getSubTitle();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getSubContent();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getSubPhotoUrl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value5() {
		return getArticleInfoId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value6() {
		return getRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArticleSubRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArticleSubRecord value2(String value) {
		setSubTitle(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArticleSubRecord value3(String value) {
		setSubContent(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArticleSubRecord value4(String value) {
		setSubPhotoUrl(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArticleSubRecord value5(Integer value) {
		setArticleInfoId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArticleSubRecord value6(Integer value) {
		setRow(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArticleSubRecord values(Integer value1, String value2, String value3, String value4, Integer value5, Integer value6) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached ArticleSubRecord
	 */
	public ArticleSubRecord() {
		super(ArticleSub.ARTICLE_SUB);
	}

	/**
	 * Create a detached, initialised ArticleSubRecord
	 */
	public ArticleSubRecord(Integer id, String subTitle, String subContent, String subPhotoUrl, Integer articleInfoId, Integer row) {
		super(ArticleSub.ARTICLE_SUB);

		setValue(0, id);
		setValue(1, subTitle);
		setValue(2, subContent);
		setValue(3, subPhotoUrl);
		setValue(4, articleInfoId);
		setValue(5, row);
	}
}