/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.records;


import com.school.cbis.domain.tables.TeachTaskInfo;

import java.sql.Date;
import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record13;
import org.jooq.Row13;
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
public class TeachTaskInfoRecord extends UpdatableRecordImpl<TeachTaskInfoRecord> implements Record13<Integer, Integer, String, String, String, Timestamp, String, Integer, Integer, Date, Date, String, String> {

	private static final long serialVersionUID = 517392756;

	/**
	 * Setter for <code>cbis.teach_task_info.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cbis.teach_task_info.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>cbis.teach_task_info.tie_id</code>.
	 */
	public void setTieId(Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cbis.teach_task_info.tie_id</code>.
	 */
	public Integer getTieId() {
		return (Integer) getValue(1);
	}

	/**
	 * Setter for <code>cbis.teach_task_info.teach_task_file_url</code>.
	 */
	public void setTeachTaskFileUrl(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cbis.teach_task_info.teach_task_file_url</code>.
	 */
	public String getTeachTaskFileUrl() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>cbis.teach_task_info.teach_task_file_size</code>.
	 */
	public void setTeachTaskFileSize(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cbis.teach_task_info.teach_task_file_size</code>.
	 */
	public String getTeachTaskFileSize() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>cbis.teach_task_info.teach_task_file_name</code>.
	 */
	public void setTeachTaskFileName(String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cbis.teach_task_info.teach_task_file_name</code>.
	 */
	public String getTeachTaskFileName() {
		return (String) getValue(4);
	}

	/**
	 * Setter for <code>cbis.teach_task_info.teach_task_file_date</code>.
	 */
	public void setTeachTaskFileDate(Timestamp value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>cbis.teach_task_info.teach_task_file_date</code>.
	 */
	public Timestamp getTeachTaskFileDate() {
		return (Timestamp) getValue(5);
	}

	/**
	 * Setter for <code>cbis.teach_task_info.teach_task_term</code>.
	 */
	public void setTeachTaskTerm(String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>cbis.teach_task_info.teach_task_term</code>.
	 */
	public String getTeachTaskTerm() {
		return (String) getValue(6);
	}

	/**
	 * Setter for <code>cbis.teach_task_info.teach_task_down_times</code>.
	 */
	public void setTeachTaskDownTimes(Integer value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>cbis.teach_task_info.teach_task_down_times</code>.
	 */
	public Integer getTeachTaskDownTimes() {
		return (Integer) getValue(7);
	}

	/**
	 * Setter for <code>cbis.teach_task_info.teach_type_id</code>.
	 */
	public void setTeachTypeId(Integer value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>cbis.teach_task_info.teach_type_id</code>.
	 */
	public Integer getTeachTypeId() {
		return (Integer) getValue(8);
	}

	/**
	 * Setter for <code>cbis.teach_task_info.term_start_time</code>.
	 */
	public void setTermStartTime(Date value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>cbis.teach_task_info.term_start_time</code>.
	 */
	public Date getTermStartTime() {
		return (Date) getValue(9);
	}

	/**
	 * Setter for <code>cbis.teach_task_info.term_end_time</code>.
	 */
	public void setTermEndTime(Date value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>cbis.teach_task_info.term_end_time</code>.
	 */
	public Date getTermEndTime() {
		return (Date) getValue(10);
	}

	/**
	 * Setter for <code>cbis.teach_task_info.file_user</code>.
	 */
	public void setFileUser(String value) {
		setValue(11, value);
	}

	/**
	 * Getter for <code>cbis.teach_task_info.file_user</code>.
	 */
	public String getFileUser() {
		return (String) getValue(11);
	}

	/**
	 * Setter for <code>cbis.teach_task_info.file_type</code>.
	 */
	public void setFileType(String value) {
		setValue(12, value);
	}

	/**
	 * Getter for <code>cbis.teach_task_info.file_type</code>.
	 */
	public String getFileType() {
		return (String) getValue(12);
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
	// Record13 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row13<Integer, Integer, String, String, String, Timestamp, String, Integer, Integer, Date, Date, String, String> fieldsRow() {
		return (Row13) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row13<Integer, Integer, String, String, String, Timestamp, String, Integer, Integer, Date, Date, String, String> valuesRow() {
		return (Row13) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return TeachTaskInfo.TEACH_TASK_INFO.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field2() {
		return TeachTaskInfo.TEACH_TASK_INFO.TIE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return TeachTaskInfo.TEACH_TASK_INFO.TEACH_TASK_FILE_URL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return TeachTaskInfo.TEACH_TASK_INFO.TEACH_TASK_FILE_SIZE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field5() {
		return TeachTaskInfo.TEACH_TASK_INFO.TEACH_TASK_FILE_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Timestamp> field6() {
		return TeachTaskInfo.TEACH_TASK_INFO.TEACH_TASK_FILE_DATE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field7() {
		return TeachTaskInfo.TEACH_TASK_INFO.TEACH_TASK_TERM;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field8() {
		return TeachTaskInfo.TEACH_TASK_INFO.TEACH_TASK_DOWN_TIMES;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field9() {
		return TeachTaskInfo.TEACH_TASK_INFO.TEACH_TYPE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Date> field10() {
		return TeachTaskInfo.TEACH_TASK_INFO.TERM_START_TIME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Date> field11() {
		return TeachTaskInfo.TEACH_TASK_INFO.TERM_END_TIME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field12() {
		return TeachTaskInfo.TEACH_TASK_INFO.FILE_USER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field13() {
		return TeachTaskInfo.TEACH_TASK_INFO.FILE_TYPE;
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
		return getTieId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getTeachTaskFileUrl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getTeachTaskFileSize();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value5() {
		return getTeachTaskFileName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Timestamp value6() {
		return getTeachTaskFileDate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value7() {
		return getTeachTaskTerm();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value8() {
		return getTeachTaskDownTimes();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value9() {
		return getTeachTypeId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date value10() {
		return getTermStartTime();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date value11() {
		return getTermEndTime();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value12() {
		return getFileUser();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value13() {
		return getFileType();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeachTaskInfoRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeachTaskInfoRecord value2(Integer value) {
		setTieId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeachTaskInfoRecord value3(String value) {
		setTeachTaskFileUrl(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeachTaskInfoRecord value4(String value) {
		setTeachTaskFileSize(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeachTaskInfoRecord value5(String value) {
		setTeachTaskFileName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeachTaskInfoRecord value6(Timestamp value) {
		setTeachTaskFileDate(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeachTaskInfoRecord value7(String value) {
		setTeachTaskTerm(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeachTaskInfoRecord value8(Integer value) {
		setTeachTaskDownTimes(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeachTaskInfoRecord value9(Integer value) {
		setTeachTypeId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeachTaskInfoRecord value10(Date value) {
		setTermStartTime(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeachTaskInfoRecord value11(Date value) {
		setTermEndTime(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeachTaskInfoRecord value12(String value) {
		setFileUser(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeachTaskInfoRecord value13(String value) {
		setFileType(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TeachTaskInfoRecord values(Integer value1, Integer value2, String value3, String value4, String value5, Timestamp value6, String value7, Integer value8, Integer value9, Date value10, Date value11, String value12, String value13) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		value9(value9);
		value10(value10);
		value11(value11);
		value12(value12);
		value13(value13);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached TeachTaskInfoRecord
	 */
	public TeachTaskInfoRecord() {
		super(TeachTaskInfo.TEACH_TASK_INFO);
	}

	/**
	 * Create a detached, initialised TeachTaskInfoRecord
	 */
	public TeachTaskInfoRecord(Integer id, Integer tieId, String teachTaskFileUrl, String teachTaskFileSize, String teachTaskFileName, Timestamp teachTaskFileDate, String teachTaskTerm, Integer teachTaskDownTimes, Integer teachTypeId, Date termStartTime, Date termEndTime, String fileUser, String fileType) {
		super(TeachTaskInfo.TEACH_TASK_INFO);

		setValue(0, id);
		setValue(1, tieId);
		setValue(2, teachTaskFileUrl);
		setValue(3, teachTaskFileSize);
		setValue(4, teachTaskFileName);
		setValue(5, teachTaskFileDate);
		setValue(6, teachTaskTerm);
		setValue(7, teachTaskDownTimes);
		setValue(8, teachTypeId);
		setValue(9, termStartTime);
		setValue(10, termEndTime);
		setValue(11, fileUser);
		setValue(12, fileType);
	}
}
