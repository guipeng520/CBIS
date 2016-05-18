/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.daos;


import com.school.cbis.domain.tables.MailboxSettings;
import com.school.cbis.domain.tables.records.MailboxSettingsRecord;

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
public class MailboxSettingsDao extends DAOImpl<MailboxSettingsRecord, com.school.cbis.domain.tables.pojos.MailboxSettings, Integer> {

	/**
	 * Create a new MailboxSettingsDao without any configuration
	 */
	public MailboxSettingsDao() {
		super(MailboxSettings.MAILBOX_SETTINGS, com.school.cbis.domain.tables.pojos.MailboxSettings.class);
	}

	/**
	 * Create a new MailboxSettingsDao with an attached configuration
	 */
	public MailboxSettingsDao(Configuration configuration) {
		super(MailboxSettings.MAILBOX_SETTINGS, com.school.cbis.domain.tables.pojos.MailboxSettings.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Integer getId(com.school.cbis.domain.tables.pojos.MailboxSettings object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.MailboxSettings> fetchById(Integer... values) {
		return fetch(MailboxSettings.MAILBOX_SETTINGS.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public com.school.cbis.domain.tables.pojos.MailboxSettings fetchOneById(Integer value) {
		return fetchOne(MailboxSettings.MAILBOX_SETTINGS.ID, value);
	}

	/**
	 * Fetch records that have <code>switch_email IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.MailboxSettings> fetchBySwitchEmail(Byte... values) {
		return fetch(MailboxSettings.MAILBOX_SETTINGS.SWITCH_EMAIL, values);
	}

	/**
	 * Fetch records that have <code>daily_limit IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.MailboxSettings> fetchByDailyLimit(Integer... values) {
		return fetch(MailboxSettings.MAILBOX_SETTINGS.DAILY_LIMIT, values);
	}
}
