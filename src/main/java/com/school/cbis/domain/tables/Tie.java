/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables;


import com.school.cbis.domain.Cbis;
import com.school.cbis.domain.Keys;
import com.school.cbis.domain.tables.records.TieRecord;

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
		"jOOQ version:3.7.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tie extends TableImpl<TieRecord> {

	private static final long serialVersionUID = 1896940136;

	/**
	 * The reference instance of <code>cbis.tie</code>
	 */
	public static final Tie TIE = new Tie();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<TieRecord> getRecordType() {
		return TieRecord.class;
	}

	/**
	 * The column <code>cbis.tie.id</code>.
	 */
	public final TableField<TieRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>cbis.tie.tie_name</code>.
	 */
	public final TableField<TieRecord, String> TIE_NAME = createField("tie_name", org.jooq.impl.SQLDataType.VARCHAR.length(30).nullable(false), this, "");

	/**
	 * The column <code>cbis.tie.tie_address</code>.
	 */
	public final TableField<TieRecord, String> TIE_ADDRESS = createField("tie_address", org.jooq.impl.SQLDataType.VARCHAR.length(200), this, "");

	/**
	 * The column <code>cbis.tie.tie_phone</code>.
	 */
	public final TableField<TieRecord, String> TIE_PHONE = createField("tie_phone", org.jooq.impl.SQLDataType.VARCHAR.length(20), this, "");

	/**
	 * The column <code>cbis.tie.tie_principal</code>.
	 */
	public final TableField<TieRecord, String> TIE_PRINCIPAL = createField("tie_principal", org.jooq.impl.SQLDataType.VARCHAR.length(20), this, "");

	/**
	 * The column <code>cbis.tie.tie_introduce_article_info_id</code>.
	 */
	public final TableField<TieRecord, Integer> TIE_INTRODUCE_ARTICLE_INFO_ID = createField("tie_introduce_article_info_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>cbis.tie.tie_training_goal_article_info_id</code>.
	 */
	public final TableField<TieRecord, Integer> TIE_TRAINING_GOAL_ARTICLE_INFO_ID = createField("tie_training_goal_article_info_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>cbis.tie.tie_trait_article_info_id</code>.
	 */
	public final TableField<TieRecord, Integer> TIE_TRAIT_ARTICLE_INFO_ID = createField("tie_trait_article_info_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>cbis.tie.yard_id</code>.
	 */
	public final TableField<TieRecord, Integer> YARD_ID = createField("yard_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * Create a <code>cbis.tie</code> table reference
	 */
	public Tie() {
		this("tie", null);
	}

	/**
	 * Create an aliased <code>cbis.tie</code> table reference
	 */
	public Tie(String alias) {
		this(alias, TIE);
	}

	private Tie(String alias, Table<TieRecord> aliased) {
		this(alias, aliased, null);
	}

	private Tie(String alias, Table<TieRecord> aliased, Field<?>[] parameters) {
		super(alias, Cbis.CBIS, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<TieRecord, Integer> getIdentity() {
		return Keys.IDENTITY_TIE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<TieRecord> getPrimaryKey() {
		return Keys.KEY_TIE_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<TieRecord>> getKeys() {
		return Arrays.<UniqueKey<TieRecord>>asList(Keys.KEY_TIE_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<TieRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<TieRecord, ?>>asList(Keys.TIE_IBFK_2, Keys.TIE_IBFK_3, Keys.TIE_IBFK_4, Keys.TIE_IBFK_1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Tie as(String alias) {
		return new Tie(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Tie rename(String name) {
		return new Tie(name, null);
	}
}
