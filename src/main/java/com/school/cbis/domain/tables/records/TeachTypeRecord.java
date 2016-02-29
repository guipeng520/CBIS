/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.records;


import com.school.cbis.domain.tables.TeachType;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
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
public class TeachTypeRecord extends UpdatableRecordImpl<TeachTypeRecord> implements Record2<Integer, String> {

	private static final long serialVersionUID = -1723030496;

	/**
	 * Setter for <code>cbis.teach_type.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cbis.teach_type.id</code>.
	 */
	@NotNull
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>cbis.teach_type.name</code>.
	 */
	public void setName(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cbis.teach_type.name</code>.
	 */
	@NotNull
	@Size(max = 10)
	public String getName() {
		return (String) getValue(1);
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
	// Record2 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<Integer, String> fieldsRow() {
		return (Row2) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row2<Integer, String> valuesRow() {
		return (Row2) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return TeachType.TEACH_TYPE.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return TeachType.TEACH_TYPE.NAME;
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
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeachTypeRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeachTypeRecord value2(String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeachTypeRecord values(Integer value1, String value2) {
		value1(value1);
		value2(value2);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached TeachTypeRecord
	 */
	public TeachTypeRecord() {
		super(TeachType.TEACH_TYPE);
	}

	/**
	 * Create a detached, initialised TeachTypeRecord
	 */
	public TeachTypeRecord(Integer id, String name) {
		super(TeachType.TEACH_TYPE);

		setValue(0, id);
		setValue(1, name);
	}
}
