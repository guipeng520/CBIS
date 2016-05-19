/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables;


import com.school.cbis.domain.Cbis;
import com.school.cbis.domain.Keys;
import com.school.cbis.domain.tables.records.MobileCountRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
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
public class MobileCount extends TableImpl<MobileCountRecord> {

	private static final long serialVersionUID = -1465153575;

	/**
	 * The reference instance of <code>cbis.mobile_count</code>
	 */
	public static final MobileCount MOBILE_COUNT = new MobileCount();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<MobileCountRecord> getRecordType() {
		return MobileCountRecord.class;
	}

	/**
	 * The column <code>cbis.mobile_count.id</code>.
	 */
	public final TableField<MobileCountRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>cbis.mobile_count.accept_user</code>. 接收者
	 */
	public final TableField<MobileCountRecord, String> ACCEPT_USER = createField("accept_user", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false), this, "接收者");

	/**
	 * The column <code>cbis.mobile_count.content</code>. 内容
	 */
	public final TableField<MobileCountRecord, String> CONTENT = createField("content", org.jooq.impl.SQLDataType.CLOB, this, "内容");

	/**
	 * The column <code>cbis.mobile_count.send_time</code>.
	 */
	public final TableField<MobileCountRecord, Timestamp> SEND_TIME = createField("send_time", org.jooq.impl.SQLDataType.TIMESTAMP.defaulted(true), this, "");

	/**
	 * The column <code>cbis.mobile_count.accept_mobile</code>. 接收手机
	 */
	public final TableField<MobileCountRecord, String> ACCEPT_MOBILE = createField("accept_mobile", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false), this, "接收手机");

	/**
	 * Create a <code>cbis.mobile_count</code> table reference
	 */
	public MobileCount() {
		this("mobile_count", null);
	}

	/**
	 * Create an aliased <code>cbis.mobile_count</code> table reference
	 */
	public MobileCount(String alias) {
		this(alias, MOBILE_COUNT);
	}

	private MobileCount(String alias, Table<MobileCountRecord> aliased) {
		this(alias, aliased, null);
	}

	private MobileCount(String alias, Table<MobileCountRecord> aliased, Field<?>[] parameters) {
		super(alias, Cbis.CBIS, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<MobileCountRecord, Integer> getIdentity() {
		return Keys.IDENTITY_MOBILE_COUNT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<MobileCountRecord> getPrimaryKey() {
		return Keys.KEY_MOBILE_COUNT_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<MobileCountRecord>> getKeys() {
		return Arrays.<UniqueKey<MobileCountRecord>>asList(Keys.KEY_MOBILE_COUNT_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<MobileCountRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<MobileCountRecord, ?>>asList(Keys.MOBILE_COUNT_IBFK_1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MobileCount as(String alias) {
		return new MobileCount(alias, this);
	}

	/**
	 * Rename this table
	 */
	public MobileCount rename(String name) {
		return new MobileCount(name, null);
	}
}