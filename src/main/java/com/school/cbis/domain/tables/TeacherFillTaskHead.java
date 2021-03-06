/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables;


import com.school.cbis.domain.Cbis;
import com.school.cbis.domain.Keys;
import com.school.cbis.domain.tables.records.TeacherFillTaskHeadRecord;

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
public class TeacherFillTaskHead extends TableImpl<TeacherFillTaskHeadRecord> {

	private static final long serialVersionUID = 979827405;

	/**
	 * The reference instance of <code>cbis.teacher_fill_task_head</code>
	 */
	public static final TeacherFillTaskHead TEACHER_FILL_TASK_HEAD = new TeacherFillTaskHead();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<TeacherFillTaskHeadRecord> getRecordType() {
		return TeacherFillTaskHeadRecord.class;
	}

	/**
	 * The column <code>cbis.teacher_fill_task_head.id</code>.
	 */
	public final TableField<TeacherFillTaskHeadRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>cbis.teacher_fill_task_head.title</code>.
	 */
	public final TableField<TeacherFillTaskHeadRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

	/**
	 * The column <code>cbis.teacher_fill_task_head.title_variable</code>.
	 */
	public final TableField<TeacherFillTaskHeadRecord, String> TITLE_VARIABLE = createField("title_variable", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

	/**
	 * The column <code>cbis.teacher_fill_task_head.teach_task_title_id</code>.
	 */
	public final TableField<TeacherFillTaskHeadRecord, Integer> TEACH_TASK_TITLE_ID = createField("teach_task_title_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>cbis.teacher_fill_task_head.teacher_fill_task_template_id</code>.
	 */
	public final TableField<TeacherFillTaskHeadRecord, Integer> TEACHER_FILL_TASK_TEMPLATE_ID = createField("teacher_fill_task_template_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>cbis.teacher_fill_task_head.is_assignment</code>.
	 */
	public final TableField<TeacherFillTaskHeadRecord, Byte> IS_ASSIGNMENT = createField("is_assignment", org.jooq.impl.SQLDataType.TINYINT.nullable(false), this, "");

	/**
	 * The column <code>cbis.teacher_fill_task_head.sort</code>.
	 */
	public final TableField<TeacherFillTaskHeadRecord, Integer> SORT = createField("sort", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * Create a <code>cbis.teacher_fill_task_head</code> table reference
	 */
	public TeacherFillTaskHead() {
		this("teacher_fill_task_head", null);
	}

	/**
	 * Create an aliased <code>cbis.teacher_fill_task_head</code> table reference
	 */
	public TeacherFillTaskHead(String alias) {
		this(alias, TEACHER_FILL_TASK_HEAD);
	}

	private TeacherFillTaskHead(String alias, Table<TeacherFillTaskHeadRecord> aliased) {
		this(alias, aliased, null);
	}

	private TeacherFillTaskHead(String alias, Table<TeacherFillTaskHeadRecord> aliased, Field<?>[] parameters) {
		super(alias, Cbis.CBIS, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<TeacherFillTaskHeadRecord, Integer> getIdentity() {
		return Keys.IDENTITY_TEACHER_FILL_TASK_HEAD;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<TeacherFillTaskHeadRecord> getPrimaryKey() {
		return Keys.KEY_TEACHER_FILL_TASK_HEAD_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<TeacherFillTaskHeadRecord>> getKeys() {
		return Arrays.<UniqueKey<TeacherFillTaskHeadRecord>>asList(Keys.KEY_TEACHER_FILL_TASK_HEAD_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<TeacherFillTaskHeadRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<TeacherFillTaskHeadRecord, ?>>asList(Keys.TEACHER_FILL_TASK_HEAD_IBFK_1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeacherFillTaskHead as(String alias) {
		return new TeacherFillTaskHead(alias, this);
	}

	/**
	 * Rename this table
	 */
	public TeacherFillTaskHead rename(String name) {
		return new TeacherFillTaskHead(name, null);
	}
}
