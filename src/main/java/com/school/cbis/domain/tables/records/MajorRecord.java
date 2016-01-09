/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.records;


import com.school.cbis.domain.tables.Major;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class MajorRecord extends UpdatableRecordImpl<MajorRecord> implements Record7<Integer, Integer, String, Integer, Integer, Integer, Integer> {

	private static final long serialVersionUID = 1972178197;

	/**
	 * Setter for <code>cbis.major.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cbis.major.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>cbis.major.tie_id</code>.
	 */
	public void setTieId(Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cbis.major.tie_id</code>.
	 */
	public Integer getTieId() {
		return (Integer) getValue(1);
	}

	/**
	 * Setter for <code>cbis.major.major_name</code>.
	 */
	public void setMajorName(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cbis.major.major_name</code>.
	 */
	public String getMajorName() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>cbis.major.major_introduce_article_info_id</code>.
	 */
	public void setMajorIntroduceArticleInfoId(Integer value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cbis.major.major_introduce_article_info_id</code>.
	 */
	public Integer getMajorIntroduceArticleInfoId() {
		return (Integer) getValue(3);
	}

	/**
	 * Setter for <code>cbis.major.major_training_goal_article_info_id</code>.
	 */
	public void setMajorTrainingGoalArticleInfoId(Integer value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cbis.major.major_training_goal_article_info_id</code>.
	 */
	public Integer getMajorTrainingGoalArticleInfoId() {
		return (Integer) getValue(4);
	}

	/**
	 * Setter for <code>cbis.major.major_trait_article_info_id</code>.
	 */
	public void setMajorTraitArticleInfoId(Integer value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>cbis.major.major_trait_article_info_id</code>.
	 */
	public Integer getMajorTraitArticleInfoId() {
		return (Integer) getValue(5);
	}

	/**
	 * Setter for <code>cbis.major.major_foregoer_article_info_id</code>.
	 */
	public void setMajorForegoerArticleInfoId(Integer value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>cbis.major.major_foregoer_article_info_id</code>.
	 */
	public Integer getMajorForegoerArticleInfoId() {
		return (Integer) getValue(6);
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
	// Record7 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row7<Integer, Integer, String, Integer, Integer, Integer, Integer> fieldsRow() {
		return (Row7) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row7<Integer, Integer, String, Integer, Integer, Integer, Integer> valuesRow() {
		return (Row7) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Major.MAJOR.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field2() {
		return Major.MAJOR.TIE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return Major.MAJOR.MAJOR_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field4() {
		return Major.MAJOR.MAJOR_INTRODUCE_ARTICLE_INFO_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field5() {
		return Major.MAJOR.MAJOR_TRAINING_GOAL_ARTICLE_INFO_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field6() {
		return Major.MAJOR.MAJOR_TRAIT_ARTICLE_INFO_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field7() {
		return Major.MAJOR.MAJOR_FOREGOER_ARTICLE_INFO_ID;
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
	public Integer value2() {
		return getTieId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getMajorName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value4() {
		return getMajorIntroduceArticleInfoId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value5() {
		return getMajorTrainingGoalArticleInfoId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value6() {
		return getMajorTraitArticleInfoId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value7() {
		return getMajorForegoerArticleInfoId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MajorRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MajorRecord value2(Integer value) {
		setTieId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MajorRecord value3(String value) {
		setMajorName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MajorRecord value4(Integer value) {
		setMajorIntroduceArticleInfoId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MajorRecord value5(Integer value) {
		setMajorTrainingGoalArticleInfoId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MajorRecord value6(Integer value) {
		setMajorTraitArticleInfoId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MajorRecord value7(Integer value) {
		setMajorForegoerArticleInfoId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MajorRecord values(Integer value1, Integer value2, String value3, Integer value4, Integer value5, Integer value6, Integer value7) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached MajorRecord
	 */
	public MajorRecord() {
		super(Major.MAJOR);
	}

	/**
	 * Create a detached, initialised MajorRecord
	 */
	public MajorRecord(Integer id, Integer tieId, String majorName, Integer majorIntroduceArticleInfoId, Integer majorTrainingGoalArticleInfoId, Integer majorTraitArticleInfoId, Integer majorForegoerArticleInfoId) {
		super(Major.MAJOR);

		setValue(0, id);
		setValue(1, tieId);
		setValue(2, majorName);
		setValue(3, majorIntroduceArticleInfoId);
		setValue(4, majorTrainingGoalArticleInfoId);
		setValue(5, majorTraitArticleInfoId);
		setValue(6, majorForegoerArticleInfoId);
	}
}
