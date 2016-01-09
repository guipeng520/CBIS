/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.records;


import com.school.cbis.domain.tables.PlaceFileInfo;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record8;
import org.jooq.Row8;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PlaceFileInfoRecord extends UpdatableRecordImpl<PlaceFileInfoRecord> implements Record8<Integer, Integer, String, String, String, Timestamp, String, String> {

	private static final long serialVersionUID = -1999087843;

	/**
	 * Setter for <code>cbis.place_file_info.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cbis.place_file_info.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>cbis.place_file_info.teach_task_info_id</code>.
	 */
	public void setTeachTaskInfoId(Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cbis.place_file_info.teach_task_info_id</code>.
	 */
	public Integer getTeachTaskInfoId() {
		return (Integer) getValue(1);
	}

	/**
	 * Setter for <code>cbis.place_file_info.place_file_info_url</code>.
	 */
	public void setPlaceFileInfoUrl(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cbis.place_file_info.place_file_info_url</code>.
	 */
	public String getPlaceFileInfoUrl() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>cbis.place_file_info.place_file_info_size</code>.
	 */
	public void setPlaceFileInfoSize(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cbis.place_file_info.place_file_info_size</code>.
	 */
	public String getPlaceFileInfoSize() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>cbis.place_file_info.place_file_info_name</code>.
	 */
	public void setPlaceFileInfoName(String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cbis.place_file_info.place_file_info_name</code>.
	 */
	public String getPlaceFileInfoName() {
		return (String) getValue(4);
	}

	/**
	 * Setter for <code>cbis.place_file_info.place_file_info_date</code>.
	 */
	public void setPlaceFileInfoDate(Timestamp value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>cbis.place_file_info.place_file_info_date</code>.
	 */
	public Timestamp getPlaceFileInfoDate() {
		return (Timestamp) getValue(5);
	}

	/**
	 * Setter for <code>cbis.place_file_info.file_user</code>.
	 */
	public void setFileUser(String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>cbis.place_file_info.file_user</code>.
	 */
	public String getFileUser() {
		return (String) getValue(6);
	}

	/**
	 * Setter for <code>cbis.place_file_info.file_type</code>.
	 */
	public void setFileType(String value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>cbis.place_file_info.file_type</code>.
	 */
	public String getFileType() {
		return (String) getValue(7);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Integer> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record8 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row8<Integer, Integer, String, String, String, Timestamp, String, String> fieldsRow() {
		return (Row8) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row8<Integer, Integer, String, String, String, Timestamp, String, String> valuesRow() {
		return (Row8) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return PlaceFileInfo.PLACE_FILE_INFO.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field2() {
		return PlaceFileInfo.PLACE_FILE_INFO.TEACH_TASK_INFO_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return PlaceFileInfo.PLACE_FILE_INFO.PLACE_FILE_INFO_URL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return PlaceFileInfo.PLACE_FILE_INFO.PLACE_FILE_INFO_SIZE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field5() {
		return PlaceFileInfo.PLACE_FILE_INFO.PLACE_FILE_INFO_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field6() {
		return PlaceFileInfo.PLACE_FILE_INFO.PLACE_FILE_INFO_DATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field7() {
		return PlaceFileInfo.PLACE_FILE_INFO.FILE_USER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field8() {
		return PlaceFileInfo.PLACE_FILE_INFO.FILE_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value2() {
		return getTeachTaskInfoId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getPlaceFileInfoUrl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getPlaceFileInfoSize();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value5() {
		return getPlaceFileInfoName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value6() {
		return getPlaceFileInfoDate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value7() {
		return getFileUser();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value8() {
		return getFileType();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PlaceFileInfoRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PlaceFileInfoRecord value2(Integer value) {
		setTeachTaskInfoId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PlaceFileInfoRecord value3(String value) {
		setPlaceFileInfoUrl(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PlaceFileInfoRecord value4(String value) {
		setPlaceFileInfoSize(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PlaceFileInfoRecord value5(String value) {
		setPlaceFileInfoName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PlaceFileInfoRecord value6(Timestamp value) {
		setPlaceFileInfoDate(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PlaceFileInfoRecord value7(String value) {
		setFileUser(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PlaceFileInfoRecord value8(String value) {
		setFileType(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PlaceFileInfoRecord values(Integer value1, Integer value2, String value3, String value4, String value5, Timestamp value6, String value7, String value8) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached PlaceFileInfoRecord
	 */
	public PlaceFileInfoRecord() {
		super(PlaceFileInfo.PLACE_FILE_INFO);
	}

	/**
	 * Create a detached, initialised PlaceFileInfoRecord
	 */
	public PlaceFileInfoRecord(Integer id, Integer teachTaskInfoId, String placeFileInfoUrl, String placeFileInfoSize, String placeFileInfoName, Timestamp placeFileInfoDate, String fileUser, String fileType) {
		super(PlaceFileInfo.PLACE_FILE_INFO);

		setValue(0, id);
		setValue(1, teachTaskInfoId);
		setValue(2, placeFileInfoUrl);
		setValue(3, placeFileInfoSize);
		setValue(4, placeFileInfoName);
		setValue(5, placeFileInfoDate);
		setValue(6, fileUser);
		setValue(7, fileType);
	}
}
