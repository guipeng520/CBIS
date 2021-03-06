/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.daos;


import com.school.cbis.domain.tables.TeacherFillTaskContent;
import com.school.cbis.domain.tables.records.TeacherFillTaskContentRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


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
public class TeacherFillTaskContentDao extends DAOImpl<TeacherFillTaskContentRecord, com.school.cbis.domain.tables.pojos.TeacherFillTaskContent, Integer> {

	/**
	 * Create a new TeacherFillTaskContentDao without any configuration
	 */
	public TeacherFillTaskContentDao() {
		super(TeacherFillTaskContent.TEACHER_FILL_TASK_CONTENT, com.school.cbis.domain.tables.pojos.TeacherFillTaskContent.class);
	}

	/**
	 * Create a new TeacherFillTaskContentDao with an attached configuration
	 */
	public TeacherFillTaskContentDao(Configuration configuration) {
		super(TeacherFillTaskContent.TEACHER_FILL_TASK_CONTENT, com.school.cbis.domain.tables.pojos.TeacherFillTaskContent.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Integer getId(com.school.cbis.domain.tables.pojos.TeacherFillTaskContent object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.TeacherFillTaskContent> fetchById(Integer... values) {
		return fetch(TeacherFillTaskContent.TEACHER_FILL_TASK_CONTENT.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public com.school.cbis.domain.tables.pojos.TeacherFillTaskContent fetchOneById(Integer value) {
		return fetchOne(TeacherFillTaskContent.TEACHER_FILL_TASK_CONTENT.ID, value);
	}

	/**
	 * Fetch records that have <code>content IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.TeacherFillTaskContent> fetchByContent(String... values) {
		return fetch(TeacherFillTaskContent.TEACHER_FILL_TASK_CONTENT.CONTENT, values);
	}

	/**
	 * Fetch records that have <code>teacher_fill_task_head_id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.TeacherFillTaskContent> fetchByTeacherFillTaskHeadId(Integer... values) {
		return fetch(TeacherFillTaskContent.TEACHER_FILL_TASK_CONTENT.TEACHER_FILL_TASK_HEAD_ID, values);
	}

	/**
	 * Fetch records that have <code>teacher_id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.TeacherFillTaskContent> fetchByTeacherId(Integer... values) {
		return fetch(TeacherFillTaskContent.TEACHER_FILL_TASK_CONTENT.TEACHER_ID, values);
	}

	/**
	 * Fetch records that have <code>content_x IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.TeacherFillTaskContent> fetchByContentX(Integer... values) {
		return fetch(TeacherFillTaskContent.TEACHER_FILL_TASK_CONTENT.CONTENT_X, values);
	}
}
