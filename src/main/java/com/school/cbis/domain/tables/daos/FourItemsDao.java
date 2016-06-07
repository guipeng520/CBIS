/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.daos;


import com.school.cbis.domain.tables.FourItems;
import com.school.cbis.domain.tables.records.FourItemsRecord;

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
public class FourItemsDao extends DAOImpl<FourItemsRecord, com.school.cbis.domain.tables.pojos.FourItems, Integer> {

	/**
	 * Create a new FourItemsDao without any configuration
	 */
	public FourItemsDao() {
		super(FourItems.FOUR_ITEMS, com.school.cbis.domain.tables.pojos.FourItems.class);
	}

	/**
	 * Create a new FourItemsDao with an attached configuration
	 */
	public FourItemsDao(Configuration configuration) {
		super(FourItems.FOUR_ITEMS, com.school.cbis.domain.tables.pojos.FourItems.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Integer getId(com.school.cbis.domain.tables.pojos.FourItems object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.FourItems> fetchById(Integer... values) {
		return fetch(FourItems.FOUR_ITEMS.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public com.school.cbis.domain.tables.pojos.FourItems fetchOneById(Integer value) {
		return fetchOne(FourItems.FOUR_ITEMS.ID, value);
	}

	/**
	 * Fetch records that have <code>teach_task_info_id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.FourItems> fetchByTeachTaskInfoId(Integer... values) {
		return fetch(FourItems.FOUR_ITEMS.TEACH_TASK_INFO_ID, values);
	}

	/**
	 * Fetch records that have <code>content_x IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.FourItems> fetchByContentX(Integer... values) {
		return fetch(FourItems.FOUR_ITEMS.CONTENT_X, values);
	}

	/**
	 * Fetch records that have <code>four_items_file_url IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.FourItems> fetchByFourItemsFileUrl(String... values) {
		return fetch(FourItems.FOUR_ITEMS.FOUR_ITEMS_FILE_URL, values);
	}

	/**
	 * Fetch records that have <code>four_items_file_size IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.FourItems> fetchByFourItemsFileSize(String... values) {
		return fetch(FourItems.FOUR_ITEMS.FOUR_ITEMS_FILE_SIZE, values);
	}

	/**
	 * Fetch records that have <code>four_items_file_name IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.FourItems> fetchByFourItemsFileName(String... values) {
		return fetch(FourItems.FOUR_ITEMS.FOUR_ITEMS_FILE_NAME, values);
	}

	/**
	 * Fetch records that have <code>four_items_file_date IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.FourItems> fetchByFourItemsFileDate(Timestamp... values) {
		return fetch(FourItems.FOUR_ITEMS.FOUR_ITEMS_FILE_DATE, values);
	}

	/**
	 * Fetch records that have <code>file_user IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.FourItems> fetchByFileUser(String... values) {
		return fetch(FourItems.FOUR_ITEMS.FILE_USER, values);
	}

	/**
	 * Fetch records that have <code>file_type IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.FourItems> fetchByFileType(String... values) {
		return fetch(FourItems.FOUR_ITEMS.FILE_TYPE, values);
	}
}
