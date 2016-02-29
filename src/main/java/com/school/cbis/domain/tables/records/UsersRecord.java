/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.records;


import com.school.cbis.domain.tables.Users;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
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
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record4<String, String, Byte, Integer> {

	private static final long serialVersionUID = 2094818685;

	/**
	 * Setter for <code>cbis.users.username</code>.
	 */
	public void setUsername(String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cbis.users.username</code>.
	 */
	@NotNull
	@Size(max = 64)
	public String getUsername() {
		return (String) getValue(0);
	}

	/**
	 * Setter for <code>cbis.users.password</code>.
	 */
	public void setPassword(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cbis.users.password</code>.
	 */
	@NotNull
	@Size(max = 500)
	public String getPassword() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>cbis.users.enabled</code>.
	 */
	public void setEnabled(Byte value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cbis.users.enabled</code>.
	 */
	@NotNull
	public Byte getEnabled() {
		return (Byte) getValue(2);
	}

	/**
	 * Setter for <code>cbis.users.user_type_id</code>.
	 */
	public void setUserTypeId(Integer value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cbis.users.user_type_id</code>.
	 */
	@NotNull
	public Integer getUserTypeId() {
		return (Integer) getValue(3);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<String> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<String, String, Byte, Integer> fieldsRow() {
		return (Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row4<String, String, Byte, Integer> valuesRow() {
		return (Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field1() {
		return Users.USERS.USERNAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return Users.USERS.PASSWORD;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Byte> field3() {
		return Users.USERS.ENABLED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field4() {
		return Users.USERS.USER_TYPE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value1() {
		return getUsername();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value2() {
		return getPassword();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Byte value3() {
		return getEnabled();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value4() {
		return getUserTypeId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsersRecord value1(String value) {
		setUsername(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsersRecord value2(String value) {
		setPassword(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsersRecord value3(Byte value) {
		setEnabled(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsersRecord value4(Integer value) {
		setUserTypeId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UsersRecord values(String value1, String value2, Byte value3, Integer value4) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached UsersRecord
	 */
	public UsersRecord() {
		super(Users.USERS);
	}

	/**
	 * Create a detached, initialised UsersRecord
	 */
	public UsersRecord(String username, String password, Byte enabled, Integer userTypeId) {
		super(Users.USERS);

		setValue(0, username);
		setValue(1, password);
		setValue(2, enabled);
		setValue(3, userTypeId);
	}
}
