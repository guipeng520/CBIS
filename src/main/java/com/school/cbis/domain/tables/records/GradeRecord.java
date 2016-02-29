/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.records;


import com.school.cbis.domain.tables.Grade;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class GradeRecord extends UpdatableRecordImpl<GradeRecord> implements Record5<Integer, Integer, String, String, String> {

	private static final long serialVersionUID = -2008671949;

	/**
	 * Setter for <code>cbis.grade.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cbis.grade.id</code>.
	 */
	@NotNull
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>cbis.grade.major_id</code>.
	 */
	public void setMajorId(Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cbis.grade.major_id</code>.
	 */
	@NotNull
	public Integer getMajorId() {
		return (Integer) getValue(1);
	}

	/**
	 * Setter for <code>cbis.grade.year</code>.
	 */
	public void setYear(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cbis.grade.year</code>.
	 */
	@NotNull
	@Size(max = 20)
	public String getYear() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>cbis.grade.grade_name</code>.
	 */
	public void setGradeName(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cbis.grade.grade_name</code>.
	 */
	@NotNull
	@Size(max = 70)
	public String getGradeName() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>cbis.grade.grade_head</code>.
	 */
	public void setGradeHead(String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cbis.grade.grade_head</code>.
	 */
	@NotNull
	@Size(max = 50)
	public String getGradeHead() {
		return (String) getValue(4);
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
	// Record5 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row5<Integer, Integer, String, String, String> fieldsRow() {
		return (Row5) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row5<Integer, Integer, String, String, String> valuesRow() {
		return (Row5) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return Grade.GRADE.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field2() {
		return Grade.GRADE.MAJOR_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return Grade.GRADE.YEAR;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return Grade.GRADE.GRADE_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field5() {
		return Grade.GRADE.GRADE_HEAD;
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
		return getMajorId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getYear();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getGradeName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value5() {
		return getGradeHead();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GradeRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GradeRecord value2(Integer value) {
		setMajorId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GradeRecord value3(String value) {
		setYear(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GradeRecord value4(String value) {
		setGradeName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GradeRecord value5(String value) {
		setGradeHead(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GradeRecord values(Integer value1, Integer value2, String value3, String value4, String value5) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached GradeRecord
	 */
	public GradeRecord() {
		super(Grade.GRADE);
	}

	/**
	 * Create a detached, initialised GradeRecord
	 */
	public GradeRecord(Integer id, Integer majorId, String year, String gradeName, String gradeHead) {
		super(Grade.GRADE);

		setValue(0, id);
		setValue(1, majorId);
		setValue(2, year);
		setValue(3, gradeName);
		setValue(4, gradeHead);
	}
}
