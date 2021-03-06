/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.daos;


import com.school.cbis.domain.tables.SystemInform;
import com.school.cbis.domain.tables.records.SystemInformRecord;

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
public class SystemInformDao extends DAOImpl<SystemInformRecord, com.school.cbis.domain.tables.pojos.SystemInform, Integer> {

	/**
	 * Create a new SystemInformDao without any configuration
	 */
	public SystemInformDao() {
		super(SystemInform.SYSTEM_INFORM, com.school.cbis.domain.tables.pojos.SystemInform.class);
	}

	/**
	 * Create a new SystemInformDao with an attached configuration
	 */
	public SystemInformDao(Configuration configuration) {
		super(SystemInform.SYSTEM_INFORM, com.school.cbis.domain.tables.pojos.SystemInform.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Integer getId(com.school.cbis.domain.tables.pojos.SystemInform object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.SystemInform> fetchById(Integer... values) {
		return fetch(SystemInform.SYSTEM_INFORM.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public com.school.cbis.domain.tables.pojos.SystemInform fetchOneById(Integer value) {
		return fetchOne(SystemInform.SYSTEM_INFORM.ID, value);
	}

	/**
	 * Fetch records that have <code>system_inform IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.SystemInform> fetchBySystemInform(String... values) {
		return fetch(SystemInform.SYSTEM_INFORM.SYSTEM_INFORM_, values);
	}

	/**
	 * Fetch records that have <code>system_inform_show IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.SystemInform> fetchBySystemInformShow(Integer... values) {
		return fetch(SystemInform.SYSTEM_INFORM.SYSTEM_INFORM_SHOW, values);
	}
}
