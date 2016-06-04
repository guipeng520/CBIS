/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables;


import com.school.cbis.domain.Cbis;
import com.school.cbis.domain.Keys;
import com.school.cbis.domain.tables.records.TeachingMaterialContentRecord;

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
public class TeachingMaterialContent extends TableImpl<TeachingMaterialContentRecord> {

	private static final long serialVersionUID = -654504287;

	/**
	 * The reference instance of <code>cbis.teaching_material_content</code>
	 */
	public static final TeachingMaterialContent TEACHING_MATERIAL_CONTENT = new TeachingMaterialContent();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<TeachingMaterialContentRecord> getRecordType() {
		return TeachingMaterialContentRecord.class;
	}

	/**
	 * The column <code>cbis.teaching_material_content.id</code>.
	 */
	public final TableField<TeachingMaterialContentRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>cbis.teaching_material_content.content</code>.
	 */
	public final TableField<TeachingMaterialContentRecord, String> CONTENT = createField("content", org.jooq.impl.SQLDataType.VARCHAR.length(500), this, "");

	/**
	 * The column <code>cbis.teaching_material_content.teaching_material_head_id</code>.
	 */
	public final TableField<TeachingMaterialContentRecord, Integer> TEACHING_MATERIAL_HEAD_ID = createField("teaching_material_head_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>cbis.teaching_material_content.teacher_id</code>.
	 */
	public final TableField<TeachingMaterialContentRecord, Integer> TEACHER_ID = createField("teacher_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>cbis.teaching_material_content.content_x</code>.
	 */
	public final TableField<TeachingMaterialContentRecord, Integer> CONTENT_X = createField("content_x", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * Create a <code>cbis.teaching_material_content</code> table reference
	 */
	public TeachingMaterialContent() {
		this("teaching_material_content", null);
	}

	/**
	 * Create an aliased <code>cbis.teaching_material_content</code> table reference
	 */
	public TeachingMaterialContent(String alias) {
		this(alias, TEACHING_MATERIAL_CONTENT);
	}

	private TeachingMaterialContent(String alias, Table<TeachingMaterialContentRecord> aliased) {
		this(alias, aliased, null);
	}

	private TeachingMaterialContent(String alias, Table<TeachingMaterialContentRecord> aliased, Field<?>[] parameters) {
		super(alias, Cbis.CBIS, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<TeachingMaterialContentRecord, Integer> getIdentity() {
		return Keys.IDENTITY_TEACHING_MATERIAL_CONTENT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<TeachingMaterialContentRecord> getPrimaryKey() {
		return Keys.KEY_TEACHING_MATERIAL_CONTENT_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<TeachingMaterialContentRecord>> getKeys() {
		return Arrays.<UniqueKey<TeachingMaterialContentRecord>>asList(Keys.KEY_TEACHING_MATERIAL_CONTENT_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<TeachingMaterialContentRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<TeachingMaterialContentRecord, ?>>asList(Keys.TEACHING_MATERIAL_CONTENT_IBFK_1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeachingMaterialContent as(String alias) {
		return new TeachingMaterialContent(alias, this);
	}

	/**
	 * Rename this table
	 */
	public TeachingMaterialContent rename(String name) {
		return new TeachingMaterialContent(name, null);
	}
}