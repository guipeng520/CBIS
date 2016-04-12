/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.daos;


import com.school.cbis.domain.tables.AutonomousPracticeTemplate;
import com.school.cbis.domain.tables.records.AutonomousPracticeTemplateRecord;

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
public class AutonomousPracticeTemplateDao extends DAOImpl<AutonomousPracticeTemplateRecord, com.school.cbis.domain.tables.pojos.AutonomousPracticeTemplate, Integer> {

	/**
	 * Create a new AutonomousPracticeTemplateDao without any configuration
	 */
	public AutonomousPracticeTemplateDao() {
		super(AutonomousPracticeTemplate.AUTONOMOUS_PRACTICE_TEMPLATE, com.school.cbis.domain.tables.pojos.AutonomousPracticeTemplate.class);
	}

	/**
	 * Create a new AutonomousPracticeTemplateDao with an attached configuration
	 */
	public AutonomousPracticeTemplateDao(Configuration configuration) {
		super(AutonomousPracticeTemplate.AUTONOMOUS_PRACTICE_TEMPLATE, com.school.cbis.domain.tables.pojos.AutonomousPracticeTemplate.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Integer getId(com.school.cbis.domain.tables.pojos.AutonomousPracticeTemplate object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.AutonomousPracticeTemplate> fetchById(Integer... values) {
		return fetch(AutonomousPracticeTemplate.AUTONOMOUS_PRACTICE_TEMPLATE.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public com.school.cbis.domain.tables.pojos.AutonomousPracticeTemplate fetchOneById(Integer value) {
		return fetchOne(AutonomousPracticeTemplate.AUTONOMOUS_PRACTICE_TEMPLATE.ID, value);
	}

	/**
	 * Fetch records that have <code>autonomous_practice_template_title IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.AutonomousPracticeTemplate> fetchByAutonomousPracticeTemplateTitle(String... values) {
		return fetch(AutonomousPracticeTemplate.AUTONOMOUS_PRACTICE_TEMPLATE.AUTONOMOUS_PRACTICE_TEMPLATE_TITLE, values);
	}

	/**
	 * Fetch records that have <code>create_time IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.AutonomousPracticeTemplate> fetchByCreateTime(Timestamp... values) {
		return fetch(AutonomousPracticeTemplate.AUTONOMOUS_PRACTICE_TEMPLATE.CREATE_TIME, values);
	}

	/**
	 * Fetch records that have <code>users_id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.AutonomousPracticeTemplate> fetchByUsersId(String... values) {
		return fetch(AutonomousPracticeTemplate.AUTONOMOUS_PRACTICE_TEMPLATE.USERS_ID, values);
	}

	/**
	 * Fetch records that have <code>tie_id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.AutonomousPracticeTemplate> fetchByTieId(Integer... values) {
		return fetch(AutonomousPracticeTemplate.AUTONOMOUS_PRACTICE_TEMPLATE.TIE_ID, values);
	}
}