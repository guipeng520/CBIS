/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.daos;


import com.school.cbis.domain.tables.StudentCourseTimetableInfo;
import com.school.cbis.domain.tables.records.StudentCourseTimetableInfoRecord;

import java.sql.Date;
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
public class StudentCourseTimetableInfoDao extends DAOImpl<StudentCourseTimetableInfoRecord, com.school.cbis.domain.tables.pojos.StudentCourseTimetableInfo, Integer> {

	/**
	 * Create a new StudentCourseTimetableInfoDao without any configuration
	 */
	public StudentCourseTimetableInfoDao() {
		super(StudentCourseTimetableInfo.STUDENT_COURSE_TIMETABLE_INFO, com.school.cbis.domain.tables.pojos.StudentCourseTimetableInfo.class);
	}

	/**
	 * Create a new StudentCourseTimetableInfoDao with an attached configuration
	 */
	public StudentCourseTimetableInfoDao(Configuration configuration) {
		super(StudentCourseTimetableInfo.STUDENT_COURSE_TIMETABLE_INFO, com.school.cbis.domain.tables.pojos.StudentCourseTimetableInfo.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Integer getId(com.school.cbis.domain.tables.pojos.StudentCourseTimetableInfo object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.StudentCourseTimetableInfo> fetchById(Integer... values) {
		return fetch(StudentCourseTimetableInfo.STUDENT_COURSE_TIMETABLE_INFO.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public com.school.cbis.domain.tables.pojos.StudentCourseTimetableInfo fetchOneById(Integer value) {
		return fetchOne(StudentCourseTimetableInfo.STUDENT_COURSE_TIMETABLE_INFO.ID, value);
	}

	/**
	 * Fetch records that have <code>grade_id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.StudentCourseTimetableInfo> fetchByGradeId(Integer... values) {
		return fetch(StudentCourseTimetableInfo.STUDENT_COURSE_TIMETABLE_INFO.GRADE_ID, values);
	}

	/**
	 * Fetch records that have <code>timetable_info_term IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.StudentCourseTimetableInfo> fetchByTimetableInfoTerm(String... values) {
		return fetch(StudentCourseTimetableInfo.STUDENT_COURSE_TIMETABLE_INFO.TIMETABLE_INFO_TERM, values);
	}

	/**
	 * Fetch records that have <code>timetable_info_file_url IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.StudentCourseTimetableInfo> fetchByTimetableInfoFileUrl(String... values) {
		return fetch(StudentCourseTimetableInfo.STUDENT_COURSE_TIMETABLE_INFO.TIMETABLE_INFO_FILE_URL, values);
	}

	/**
	 * Fetch records that have <code>timetable_info_file_pdf IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.StudentCourseTimetableInfo> fetchByTimetableInfoFilePdf(String... values) {
		return fetch(StudentCourseTimetableInfo.STUDENT_COURSE_TIMETABLE_INFO.TIMETABLE_INFO_FILE_PDF, values);
	}

	/**
	 * Fetch records that have <code>timetable_info_file_size IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.StudentCourseTimetableInfo> fetchByTimetableInfoFileSize(String... values) {
		return fetch(StudentCourseTimetableInfo.STUDENT_COURSE_TIMETABLE_INFO.TIMETABLE_INFO_FILE_SIZE, values);
	}

	/**
	 * Fetch records that have <code>timetable_info_file_name IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.StudentCourseTimetableInfo> fetchByTimetableInfoFileName(String... values) {
		return fetch(StudentCourseTimetableInfo.STUDENT_COURSE_TIMETABLE_INFO.TIMETABLE_INFO_FILE_NAME, values);
	}

	/**
	 * Fetch records that have <code>timetable_info_file_date IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.StudentCourseTimetableInfo> fetchByTimetableInfoFileDate(Timestamp... values) {
		return fetch(StudentCourseTimetableInfo.STUDENT_COURSE_TIMETABLE_INFO.TIMETABLE_INFO_FILE_DATE, values);
	}

	/**
	 * Fetch records that have <code>timetable_info_file_down_times IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.StudentCourseTimetableInfo> fetchByTimetableInfoFileDownTimes(Integer... values) {
		return fetch(StudentCourseTimetableInfo.STUDENT_COURSE_TIMETABLE_INFO.TIMETABLE_INFO_FILE_DOWN_TIMES, values);
	}

	/**
	 * Fetch records that have <code>teach_type_id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.StudentCourseTimetableInfo> fetchByTeachTypeId(Integer... values) {
		return fetch(StudentCourseTimetableInfo.STUDENT_COURSE_TIMETABLE_INFO.TEACH_TYPE_ID, values);
	}

	/**
	 * Fetch records that have <code>term_start_time IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.StudentCourseTimetableInfo> fetchByTermStartTime(Date... values) {
		return fetch(StudentCourseTimetableInfo.STUDENT_COURSE_TIMETABLE_INFO.TERM_START_TIME, values);
	}

	/**
	 * Fetch records that have <code>term_end_time IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.StudentCourseTimetableInfo> fetchByTermEndTime(Date... values) {
		return fetch(StudentCourseTimetableInfo.STUDENT_COURSE_TIMETABLE_INFO.TERM_END_TIME, values);
	}

	/**
	 * Fetch records that have <code>file_user IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.StudentCourseTimetableInfo> fetchByFileUser(String... values) {
		return fetch(StudentCourseTimetableInfo.STUDENT_COURSE_TIMETABLE_INFO.FILE_USER, values);
	}

	/**
	 * Fetch records that have <code>file_type IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.StudentCourseTimetableInfo> fetchByFileType(String... values) {
		return fetch(StudentCourseTimetableInfo.STUDENT_COURSE_TIMETABLE_INFO.FILE_TYPE, values);
	}
}
