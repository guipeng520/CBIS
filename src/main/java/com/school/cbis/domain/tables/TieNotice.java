/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables;


import com.school.cbis.domain.Cbis;
import com.school.cbis.domain.Keys;
import com.school.cbis.domain.tables.records.TieNoticeRecord;

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
public class TieNotice extends TableImpl<TieNoticeRecord> {

	private static final long serialVersionUID = -133574064;

	/**
	 * The reference instance of <code>cbis.tie_notice</code>
	 */
	public static final TieNotice TIE_NOTICE = new TieNotice();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<TieNoticeRecord> getRecordType() {
		return TieNoticeRecord.class;
	}

	/**
	 * The column <code>cbis.tie_notice.id</code>.
	 */
	public final TableField<TieNoticeRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>cbis.tie_notice.tie_id</code>.
	 */
	public final TableField<TieNoticeRecord, Integer> TIE_ID = createField("tie_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>cbis.tie_notice.tie_notice_article_info_id</code>.
	 */
	public final TableField<TieNoticeRecord, Integer> TIE_NOTICE_ARTICLE_INFO_ID = createField("tie_notice_article_info_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>cbis.tie_notice.tie_notice_time_id</code>.
	 */
	public final TableField<TieNoticeRecord, Integer> TIE_NOTICE_TIME_ID = createField("tie_notice_time_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>cbis.tie_notice.is_show</code>.
	 */
	public final TableField<TieNoticeRecord, Byte> IS_SHOW = createField("is_show", org.jooq.impl.SQLDataType.TINYINT.defaulted(true), this, "");

	/**
	 * Create a <code>cbis.tie_notice</code> table reference
	 */
	public TieNotice() {
		this("tie_notice", null);
	}

	/**
	 * Create an aliased <code>cbis.tie_notice</code> table reference
	 */
	public TieNotice(String alias) {
		this(alias, TIE_NOTICE);
	}

	private TieNotice(String alias, Table<TieNoticeRecord> aliased) {
		this(alias, aliased, null);
	}

	private TieNotice(String alias, Table<TieNoticeRecord> aliased, Field<?>[] parameters) {
		super(alias, Cbis.CBIS, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<TieNoticeRecord, Integer> getIdentity() {
		return Keys.IDENTITY_TIE_NOTICE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<TieNoticeRecord> getPrimaryKey() {
		return Keys.KEY_TIE_NOTICE_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<TieNoticeRecord>> getKeys() {
		return Arrays.<UniqueKey<TieNoticeRecord>>asList(Keys.KEY_TIE_NOTICE_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<TieNoticeRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<TieNoticeRecord, ?>>asList(Keys.TIE_NOTICE_IBFK_1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TieNotice as(String alias) {
		return new TieNotice(alias, this);
	}

	/**
	 * Rename this table
	 */
	public TieNotice rename(String name) {
		return new TieNotice(name, null);
	}
}
