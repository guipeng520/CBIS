/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.daos;


import com.school.cbis.domain.tables.TeachingMaterialInfo;
import com.school.cbis.domain.tables.records.TeachingMaterialInfoRecord;

import java.sql.Timestamp;
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
public class TeachingMaterialInfoDao extends DAOImpl<TeachingMaterialInfoRecord, com.school.cbis.domain.tables.pojos.TeachingMaterialInfo, Integer> {

	/**
	 * Create a new TeachingMaterialInfoDao without any configuration
	 */
	public TeachingMaterialInfoDao() {
		super(TeachingMaterialInfo.TEACHING_MATERIAL_INFO, com.school.cbis.domain.tables.pojos.TeachingMaterialInfo.class);
	}

	/**
	 * Create a new TeachingMaterialInfoDao with an attached configuration
	 */
	public TeachingMaterialInfoDao(Configuration configuration) {
		super(TeachingMaterialInfo.TEACHING_MATERIAL_INFO, com.school.cbis.domain.tables.pojos.TeachingMaterialInfo.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Integer getId(com.school.cbis.domain.tables.pojos.TeachingMaterialInfo object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.TeachingMaterialInfo> fetchById(Integer... values) {
		return fetch(TeachingMaterialInfo.TEACHING_MATERIAL_INFO.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public com.school.cbis.domain.tables.pojos.TeachingMaterialInfo fetchOneById(Integer value) {
		return fetchOne(TeachingMaterialInfo.TEACHING_MATERIAL_INFO.ID, value);
	}

	/**
	 * Fetch records that have <code>title IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.TeachingMaterialInfo> fetchByTitle(String... values) {
		return fetch(TeachingMaterialInfo.TEACHING_MATERIAL_INFO.TITLE, values);
	}

	/**
	 * Fetch records that have <code>create_time IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.TeachingMaterialInfo> fetchByCreateTime(Timestamp... values) {
		return fetch(TeachingMaterialInfo.TEACHING_MATERIAL_INFO.CREATE_TIME, values);
	}

	/**
	 * Fetch records that have <code>teaching_material_template_id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.TeachingMaterialInfo> fetchByTeachingMaterialTemplateId(Integer... values) {
		return fetch(TeachingMaterialInfo.TEACHING_MATERIAL_INFO.TEACHING_MATERIAL_TEMPLATE_ID, values);
	}

	/**
	 * Fetch records that have <code>start_time IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.TeachingMaterialInfo> fetchByStartTime(Timestamp... values) {
		return fetch(TeachingMaterialInfo.TEACHING_MATERIAL_INFO.START_TIME, values);
	}

	/**
	 * Fetch records that have <code>end_time IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.TeachingMaterialInfo> fetchByEndTime(Timestamp... values) {
		return fetch(TeachingMaterialInfo.TEACHING_MATERIAL_INFO.END_TIME, values);
	}

	/**
	 * Fetch records that have <code>users_id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.TeachingMaterialInfo> fetchByUsersId(String... values) {
		return fetch(TeachingMaterialInfo.TEACHING_MATERIAL_INFO.USERS_ID, values);
	}

	/**
	 * Fetch records that have <code>tie_id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.TeachingMaterialInfo> fetchByTieId(Integer... values) {
		return fetch(TeachingMaterialInfo.TEACHING_MATERIAL_INFO.TIE_ID, values);
	}
}
