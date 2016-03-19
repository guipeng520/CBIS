/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.records;


import com.school.cbis.domain.tables.TieNoticeAffix;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
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
public class TieNoticeAffixRecord extends UpdatableRecordImpl<TieNoticeAffixRecord> implements Record8<Integer, String, String, String, Timestamp, Integer, String, String> {

	private static final long serialVersionUID = 63377962;

	/**
	 * Setter for <code>cbis.tie_notice_affix.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cbis.tie_notice_affix.id</code>.
	 */
	@NotNull
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>cbis.tie_notice_affix.tie_notice_file_url</code>.
	 */
	public void setTieNoticeFileUrl(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cbis.tie_notice_affix.tie_notice_file_url</code>.
	 */
	@NotNull
	@Size(max = 500)
	public String getTieNoticeFileUrl() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>cbis.tie_notice_affix.tie_notice_file_size</code>.
	 */
	public void setTieNoticeFileSize(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cbis.tie_notice_affix.tie_notice_file_size</code>.
	 */
	@Size(max = 50)
	public String getTieNoticeFileSize() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>cbis.tie_notice_affix.tie_notice_file_name</code>.
	 */
	public void setTieNoticeFileName(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cbis.tie_notice_affix.tie_notice_file_name</code>.
	 */
	@NotNull
	@Size(max = 30)
	public String getTieNoticeFileName() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>cbis.tie_notice_affix.tie_notice_file_date</code>.
	 */
	public void setTieNoticeFileDate(Timestamp value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cbis.tie_notice_affix.tie_notice_file_date</code>.
	 */
	@NotNull
	public Timestamp getTieNoticeFileDate() {
		return (Timestamp) getValue(4);
	}

	/**
	 * Setter for <code>cbis.tie_notice_affix.article_info_id</code>.
	 */
	public void setArticleInfoId(Integer value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>cbis.tie_notice_affix.article_info_id</code>.
	 */
	@NotNull
	public Integer getArticleInfoId() {
		return (Integer) getValue(5);
	}

	/**
	 * Setter for <code>cbis.tie_notice_affix.file_user</code>.
	 */
	public void setFileUser(String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>cbis.tie_notice_affix.file_user</code>.
	 */
	@NotNull
	@Size(max = 64)
	public String getFileUser() {
		return (String) getValue(6);
	}

	/**
	 * Setter for <code>cbis.tie_notice_affix.file_type</code>.
	 */
	public void setFileType(String value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>cbis.tie_notice_affix.file_type</code>.
	 */
	@NotNull
	@Size(max = 15)
	public String getFileType() {
		return (String) getValue(7);
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
	// Record8 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row8<Integer, String, String, String, Timestamp, Integer, String, String> fieldsRow() {
		return (Row8) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row8<Integer, String, String, String, Timestamp, Integer, String, String> valuesRow() {
		return (Row8) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return TieNoticeAffix.TIE_NOTICE_AFFIX.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return TieNoticeAffix.TIE_NOTICE_AFFIX.TIE_NOTICE_FILE_URL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return TieNoticeAffix.TIE_NOTICE_AFFIX.TIE_NOTICE_FILE_SIZE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return TieNoticeAffix.TIE_NOTICE_AFFIX.TIE_NOTICE_FILE_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field5() {
		return TieNoticeAffix.TIE_NOTICE_AFFIX.TIE_NOTICE_FILE_DATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field6() {
		return TieNoticeAffix.TIE_NOTICE_AFFIX.ARTICLE_INFO_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field7() {
		return TieNoticeAffix.TIE_NOTICE_AFFIX.FILE_USER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field8() {
		return TieNoticeAffix.TIE_NOTICE_AFFIX.FILE_TYPE;
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
		return getTieNoticeFileUrl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getTieNoticeFileSize();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getTieNoticeFileName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value5() {
		return getTieNoticeFileDate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value6() {
		return getArticleInfoId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value7() {
		return getFileUser();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value8() {
		return getFileType();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TieNoticeAffixRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TieNoticeAffixRecord value2(String value) {
		setTieNoticeFileUrl(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TieNoticeAffixRecord value3(String value) {
		setTieNoticeFileSize(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TieNoticeAffixRecord value4(String value) {
		setTieNoticeFileName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TieNoticeAffixRecord value5(Timestamp value) {
		setTieNoticeFileDate(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TieNoticeAffixRecord value6(Integer value) {
		setArticleInfoId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TieNoticeAffixRecord value7(String value) {
		setFileUser(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TieNoticeAffixRecord value8(String value) {
		setFileType(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TieNoticeAffixRecord values(Integer value1, String value2, String value3, String value4, Timestamp value5, Integer value6, String value7, String value8) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached TieNoticeAffixRecord
	 */
	public TieNoticeAffixRecord() {
		super(TieNoticeAffix.TIE_NOTICE_AFFIX);
	}

	/**
	 * Create a detached, initialised TieNoticeAffixRecord
	 */
	public TieNoticeAffixRecord(Integer id, String tieNoticeFileUrl, String tieNoticeFileSize, String tieNoticeFileName, Timestamp tieNoticeFileDate, Integer articleInfoId, String fileUser, String fileType) {
		super(TieNoticeAffix.TIE_NOTICE_AFFIX);

		setValue(0, id);
		setValue(1, tieNoticeFileUrl);
		setValue(2, tieNoticeFileSize);
		setValue(3, tieNoticeFileName);
		setValue(4, tieNoticeFileDate);
		setValue(5, articleInfoId);
		setValue(6, fileUser);
		setValue(7, fileType);
	}
}
