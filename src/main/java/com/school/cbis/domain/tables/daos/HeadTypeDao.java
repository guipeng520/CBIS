/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.daos;


import com.school.cbis.domain.tables.HeadType;
import com.school.cbis.domain.tables.records.HeadTypeRecord;

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
public class HeadTypeDao extends DAOImpl<HeadTypeRecord, com.school.cbis.domain.tables.pojos.HeadType, Integer> {

	/**
	 * Create a new HeadTypeDao without any configuration
	 */
	public HeadTypeDao() {
		super(HeadType.HEAD_TYPE, com.school.cbis.domain.tables.pojos.HeadType.class);
	}

	/**
	 * Create a new HeadTypeDao with an attached configuration
	 */
	public HeadTypeDao(Configuration configuration) {
		super(HeadType.HEAD_TYPE, com.school.cbis.domain.tables.pojos.HeadType.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Integer getId(com.school.cbis.domain.tables.pojos.HeadType object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.HeadType> fetchById(Integer... values) {
		return fetch(HeadType.HEAD_TYPE.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public com.school.cbis.domain.tables.pojos.HeadType fetchOneById(Integer value) {
		return fetchOne(HeadType.HEAD_TYPE.ID, value);
	}

	/**
	 * Fetch records that have <code>type_value IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.HeadType> fetchByTypeValue(String... values) {
		return fetch(HeadType.HEAD_TYPE.TYPE_VALUE, values);
	}

	/**
	 * Fetch records that have <code>type_name IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.HeadType> fetchByTypeName(String... values) {
		return fetch(HeadType.HEAD_TYPE.TYPE_NAME, values);
	}
}