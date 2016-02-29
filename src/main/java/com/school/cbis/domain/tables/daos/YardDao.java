/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.daos;


import com.school.cbis.domain.tables.Yard;
import com.school.cbis.domain.tables.records.YardRecord;

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
public class YardDao extends DAOImpl<YardRecord, com.school.cbis.domain.tables.pojos.Yard, Integer> {

	/**
	 * Create a new YardDao without any configuration
	 */
	public YardDao() {
		super(Yard.YARD, com.school.cbis.domain.tables.pojos.Yard.class);
	}

	/**
	 * Create a new YardDao with an attached configuration
	 */
	public YardDao(Configuration configuration) {
		super(Yard.YARD, com.school.cbis.domain.tables.pojos.Yard.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Integer getId(com.school.cbis.domain.tables.pojos.Yard object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.Yard> fetchById(Integer... values) {
		return fetch(Yard.YARD.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public com.school.cbis.domain.tables.pojos.Yard fetchOneById(Integer value) {
		return fetchOne(Yard.YARD.ID, value);
	}

	/**
	 * Fetch records that have <code>yard_name IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.Yard> fetchByYardName(String... values) {
		return fetch(Yard.YARD.YARD_NAME, values);
	}

	/**
	 * Fetch records that have <code>yard_address IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.Yard> fetchByYardAddress(String... values) {
		return fetch(Yard.YARD.YARD_ADDRESS, values);
	}
}