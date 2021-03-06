/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables;


import com.school.cbis.domain.Cbis;
import com.school.cbis.domain.Keys;
import com.school.cbis.domain.tables.records.AutonomousPracticeHeadRecord;

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
public class AutonomousPracticeHead extends TableImpl<AutonomousPracticeHeadRecord> {

	private static final long serialVersionUID = -341944616;

	/**
	 * The reference instance of <code>cbis.autonomous_practice_head</code>
	 */
	public static final AutonomousPracticeHead AUTONOMOUS_PRACTICE_HEAD = new AutonomousPracticeHead();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<AutonomousPracticeHeadRecord> getRecordType() {
		return AutonomousPracticeHeadRecord.class;
	}

	/**
	 * The column <code>cbis.autonomous_practice_head.id</code>.
	 */
	public final TableField<AutonomousPracticeHeadRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>cbis.autonomous_practice_head.title</code>.
	 */
	public final TableField<AutonomousPracticeHeadRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

	/**
	 * The column <code>cbis.autonomous_practice_head.title_variable</code>.
	 */
	public final TableField<AutonomousPracticeHeadRecord, String> TITLE_VARIABLE = createField("title_variable", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

	/**
	 * The column <code>cbis.autonomous_practice_head.database_table</code>.
	 */
	public final TableField<AutonomousPracticeHeadRecord, String> DATABASE_TABLE = createField("database_table", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "");

	/**
	 * The column <code>cbis.autonomous_practice_head.database_table_field</code>.
	 */
	public final TableField<AutonomousPracticeHeadRecord, String> DATABASE_TABLE_FIELD = createField("database_table_field", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "");

	/**
	 * The column <code>cbis.autonomous_practice_head.authority</code>.
	 */
	public final TableField<AutonomousPracticeHeadRecord, String> AUTHORITY = createField("authority", org.jooq.impl.SQLDataType.VARCHAR.length(2000).nullable(false), this, "");

	/**
	 * The column <code>cbis.autonomous_practice_head.is_show_highly_active</code>.
	 */
	public final TableField<AutonomousPracticeHeadRecord, Byte> IS_SHOW_HIGHLY_ACTIVE = createField("is_show_highly_active", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>cbis.autonomous_practice_head.is_database</code>.
	 */
	public final TableField<AutonomousPracticeHeadRecord, Byte> IS_DATABASE = createField("is_database", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>cbis.autonomous_practice_head.is_required</code>.
	 */
	public final TableField<AutonomousPracticeHeadRecord, Byte> IS_REQUIRED = createField("is_required", org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>cbis.autonomous_practice_head.content</code>.
	 */
	public final TableField<AutonomousPracticeHeadRecord, String> CONTENT = createField("content", org.jooq.impl.SQLDataType.VARCHAR.length(2000), this, "");

	/**
	 * The column <code>cbis.autonomous_practice_head.sort</code>.
	 */
	public final TableField<AutonomousPracticeHeadRecord, Integer> SORT = createField("sort", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>cbis.autonomous_practice_head.head_type_id</code>.
	 */
	public final TableField<AutonomousPracticeHeadRecord, Integer> HEAD_TYPE_ID = createField("head_type_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>cbis.autonomous_practice_head.autonomous_practice_template_id</code>.
	 */
	public final TableField<AutonomousPracticeHeadRecord, Integer> AUTONOMOUS_PRACTICE_TEMPLATE_ID = createField("autonomous_practice_template_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * Create a <code>cbis.autonomous_practice_head</code> table reference
	 */
	public AutonomousPracticeHead() {
		this("autonomous_practice_head", null);
	}

	/**
	 * Create an aliased <code>cbis.autonomous_practice_head</code> table reference
	 */
	public AutonomousPracticeHead(String alias) {
		this(alias, AUTONOMOUS_PRACTICE_HEAD);
	}

	private AutonomousPracticeHead(String alias, Table<AutonomousPracticeHeadRecord> aliased) {
		this(alias, aliased, null);
	}

	private AutonomousPracticeHead(String alias, Table<AutonomousPracticeHeadRecord> aliased, Field<?>[] parameters) {
		super(alias, Cbis.CBIS, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<AutonomousPracticeHeadRecord, Integer> getIdentity() {
		return Keys.IDENTITY_AUTONOMOUS_PRACTICE_HEAD;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<AutonomousPracticeHeadRecord> getPrimaryKey() {
		return Keys.KEY_AUTONOMOUS_PRACTICE_HEAD_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<AutonomousPracticeHeadRecord>> getKeys() {
		return Arrays.<UniqueKey<AutonomousPracticeHeadRecord>>asList(Keys.KEY_AUTONOMOUS_PRACTICE_HEAD_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<AutonomousPracticeHeadRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<AutonomousPracticeHeadRecord, ?>>asList(Keys.AUTONOMOUS_PRACTICE_HEAD_IBFK_2, Keys.AUTONOMOUS_PRACTICE_HEAD_IBFK_1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AutonomousPracticeHead as(String alias) {
		return new AutonomousPracticeHead(alias, this);
	}

	/**
	 * Rename this table
	 */
	public AutonomousPracticeHead rename(String name) {
		return new AutonomousPracticeHead(name, null);
	}
}
