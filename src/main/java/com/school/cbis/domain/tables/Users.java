/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables;


import com.school.cbis.domain.Cbis;
import com.school.cbis.domain.Keys;
import com.school.cbis.domain.tables.records.UsersRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class Users extends TableImpl<UsersRecord> {

	private static final long serialVersionUID = 1309617113;

	/**
	 * The reference instance of <code>cbis.users</code>
	 */
	public static final Users USERS = new Users();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<UsersRecord> getRecordType() {
		return UsersRecord.class;
	}

	/**
	 * The column <code>cbis.users.username</code>.
	 */
	public final TableField<UsersRecord, String> USERNAME = createField("username", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false), this, "");

	/**
	 * The column <code>cbis.users.password</code>.
	 */
	public final TableField<UsersRecord, String> PASSWORD = createField("password", org.jooq.impl.SQLDataType.VARCHAR.length(500).nullable(false), this, "");

	/**
	 * The column <code>cbis.users.enabled</code>.
	 */
	public final TableField<UsersRecord, Byte> ENABLED = createField("enabled", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

	/**
	 * The column <code>cbis.users.user_type_id</code>.
	 */
	public final TableField<UsersRecord, Integer> USER_TYPE_ID = createField("user_type_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * Create a <code>cbis.users</code> table reference
	 */
	public Users() {
		this("users", null);
	}

	/**
	 * Create an aliased <code>cbis.users</code> table reference
	 */
	public Users(String alias) {
		this(alias, USERS);
	}

	private Users(String alias, Table<UsersRecord> aliased) {
		this(alias, aliased, null);
	}

	private Users(String alias, Table<UsersRecord> aliased, Field<?>[] parameters) {
		super(alias, Cbis.CBIS, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<UsersRecord> getPrimaryKey() {
		return Keys.KEY_USERS_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<UsersRecord>> getKeys() {
		return Arrays.<UniqueKey<UsersRecord>>asList(Keys.KEY_USERS_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<UsersRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<UsersRecord, ?>>asList(Keys.USERS_IBFK_1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Users as(String alias) {
		return new Users(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Users rename(String name) {
		return new Users(name, null);
	}
}