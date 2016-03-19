/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables;


import com.school.cbis.domain.Cbis;
import com.school.cbis.domain.Keys;
import com.school.cbis.domain.tables.records.TeachCourseInfoRecord;

import java.sql.Date;
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
public class TeachCourseInfo extends TableImpl<TeachCourseInfoRecord> {

	private static final long serialVersionUID = -1651971545;

	/**
	 * The reference instance of <code>cbis.teach_course_info</code>
	 */
	public static final TeachCourseInfo TEACH_COURSE_INFO = new TeachCourseInfo();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<TeachCourseInfoRecord> getRecordType() {
		return TeachCourseInfoRecord.class;
	}

	/**
	 * The column <code>cbis.teach_course_info.id</code>.
	 */
	public final TableField<TeachCourseInfoRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>cbis.teach_course_info.tie_id</code>.
	 */
	public final TableField<TeachCourseInfoRecord, Integer> TIE_ID = createField("tie_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>cbis.teach_course_info.teach_course_info_term</code>.
	 */
	public final TableField<TeachCourseInfoRecord, String> TEACH_COURSE_INFO_TERM = createField("teach_course_info_term", org.jooq.impl.SQLDataType.VARCHAR.length(20).nullable(false), this, "");

	/**
	 * The column <code>cbis.teach_course_info.teach_course_info_file_url</code>.
	 */
	public final TableField<TeachCourseInfoRecord, String> TEACH_COURSE_INFO_FILE_URL = createField("teach_course_info_file_url", org.jooq.impl.SQLDataType.VARCHAR.length(500).nullable(false), this, "");

	/**
	 * The column <code>cbis.teach_course_info.teach_course_info_file_pdf</code>.
	 */
	public final TableField<TeachCourseInfoRecord, String> TEACH_COURSE_INFO_FILE_PDF = createField("teach_course_info_file_pdf", org.jooq.impl.SQLDataType.VARCHAR.length(500), this, "");

	/**
	 * The column <code>cbis.teach_course_info.teach_course_info_file_size</code>.
	 */
	public final TableField<TeachCourseInfoRecord, String> TEACH_COURSE_INFO_FILE_SIZE = createField("teach_course_info_file_size", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

	/**
	 * The column <code>cbis.teach_course_info.teach_course_info_file_name</code>.
	 */
	public final TableField<TeachCourseInfoRecord, String> TEACH_COURSE_INFO_FILE_NAME = createField("teach_course_info_file_name", org.jooq.impl.SQLDataType.VARCHAR.length(30).nullable(false), this, "");

	/**
	 * The column <code>cbis.teach_course_info.teach_course_info_file_date</code>.
	 */
	public final TableField<TeachCourseInfoRecord, Timestamp> TEACH_COURSE_INFO_FILE_DATE = createField("teach_course_info_file_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>cbis.teach_course_info.teach_course_info_file_down_times</code>.
	 */
	public final TableField<TeachCourseInfoRecord, Integer> TEACH_COURSE_INFO_FILE_DOWN_TIMES = createField("teach_course_info_file_down_times", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>cbis.teach_course_info.teach_type_id</code>.
	 */
	public final TableField<TeachCourseInfoRecord, Integer> TEACH_TYPE_ID = createField("teach_type_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>cbis.teach_course_info.term_start_time</code>.
	 */
	public final TableField<TeachCourseInfoRecord, Date> TERM_START_TIME = createField("term_start_time", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

	/**
	 * The column <code>cbis.teach_course_info.term_end_time</code>.
	 */
	public final TableField<TeachCourseInfoRecord, Date> TERM_END_TIME = createField("term_end_time", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

	/**
	 * The column <code>cbis.teach_course_info.file_user</code>.
	 */
	public final TableField<TeachCourseInfoRecord, String> FILE_USER = createField("file_user", org.jooq.impl.SQLDataType.VARCHAR.length(64).nullable(false), this, "");

	/**
	 * The column <code>cbis.teach_course_info.file_type</code>.
	 */
	public final TableField<TeachCourseInfoRecord, String> FILE_TYPE = createField("file_type", org.jooq.impl.SQLDataType.VARCHAR.length(15), this, "");

	/**
	 * Create a <code>cbis.teach_course_info</code> table reference
	 */
	public TeachCourseInfo() {
		this("teach_course_info", null);
	}

	/**
	 * Create an aliased <code>cbis.teach_course_info</code> table reference
	 */
	public TeachCourseInfo(String alias) {
		this(alias, TEACH_COURSE_INFO);
	}

	private TeachCourseInfo(String alias, Table<TeachCourseInfoRecord> aliased) {
		this(alias, aliased, null);
	}

	private TeachCourseInfo(String alias, Table<TeachCourseInfoRecord> aliased, Field<?>[] parameters) {
		super(alias, Cbis.CBIS, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<TeachCourseInfoRecord, Integer> getIdentity() {
		return Keys.IDENTITY_TEACH_COURSE_INFO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<TeachCourseInfoRecord> getPrimaryKey() {
		return Keys.KEY_TEACH_COURSE_INFO_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<TeachCourseInfoRecord>> getKeys() {
		return Arrays.<UniqueKey<TeachCourseInfoRecord>>asList(Keys.KEY_TEACH_COURSE_INFO_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<TeachCourseInfoRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<TeachCourseInfoRecord, ?>>asList(Keys.TEACH_COURSE_INFO_IBFK_1, Keys.TEACH_COURSE_INFO_IBFK_2, Keys.TEACH_COURSE_INFO_IBFK_3);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeachCourseInfo as(String alias) {
		return new TeachCourseInfo(alias, this);
	}

	/**
	 * Rename this table
	 */
	public TeachCourseInfo rename(String name) {
		return new TeachCourseInfo(name, null);
	}
}
