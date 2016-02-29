/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.daos;


import com.school.cbis.domain.tables.Student;
import com.school.cbis.domain.tables.records.StudentRecord;

import java.sql.Date;
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
public class StudentDao extends DAOImpl<StudentRecord, com.school.cbis.domain.tables.pojos.Student, Integer> {

	/**
	 * Create a new StudentDao without any configuration
	 */
	public StudentDao() {
		super(Student.STUDENT, com.school.cbis.domain.tables.pojos.Student.class);
	}

	/**
	 * Create a new StudentDao with an attached configuration
	 */
	public StudentDao(Configuration configuration) {
		super(Student.STUDENT, com.school.cbis.domain.tables.pojos.Student.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Integer getId(com.school.cbis.domain.tables.pojos.Student object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.Student> fetchById(Integer... values) {
		return fetch(Student.STUDENT.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>id = value</code>
	 */
	public com.school.cbis.domain.tables.pojos.Student fetchOneById(Integer value) {
		return fetchOne(Student.STUDENT.ID, value);
	}

	/**
	 * Fetch records that have <code>student_number IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.Student> fetchByStudentNumber(String... values) {
		return fetch(Student.STUDENT.STUDENT_NUMBER, values);
	}

	/**
	 * Fetch records that have <code>student_name IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.Student> fetchByStudentName(String... values) {
		return fetch(Student.STUDENT.STUDENT_NAME, values);
	}

	/**
	 * Fetch records that have <code>grade_id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.Student> fetchByGradeId(Integer... values) {
		return fetch(Student.STUDENT.GRADE_ID, values);
	}

	/**
	 * Fetch records that have <code>student_phone IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.Student> fetchByStudentPhone(String... values) {
		return fetch(Student.STUDENT.STUDENT_PHONE, values);
	}

	/**
	 * Fetch records that have <code>student_email IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.Student> fetchByStudentEmail(String... values) {
		return fetch(Student.STUDENT.STUDENT_EMAIL, values);
	}

	/**
	 * Fetch records that have <code>student_birthday IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.Student> fetchByStudentBirthday(Date... values) {
		return fetch(Student.STUDENT.STUDENT_BIRTHDAY, values);
	}

	/**
	 * Fetch records that have <code>student_head_photo IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.Student> fetchByStudentHeadPhoto(String... values) {
		return fetch(Student.STUDENT.STUDENT_HEAD_PHOTO, values);
	}

	/**
	 * Fetch records that have <code>student_sex IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.Student> fetchByStudentSex(String... values) {
		return fetch(Student.STUDENT.STUDENT_SEX, values);
	}

	/**
	 * Fetch records that have <code>student_identity_card IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.Student> fetchByStudentIdentityCard(String... values) {
		return fetch(Student.STUDENT.STUDENT_IDENTITY_CARD, values);
	}

	/**
	 * Fetch records that have <code>student_address IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.Student> fetchByStudentAddress(String... values) {
		return fetch(Student.STUDENT.STUDENT_ADDRESS, values);
	}

	/**
	 * Fetch records that have <code>student_introduce_article_info_id IN (values)</code>
	 */
	public List<com.school.cbis.domain.tables.pojos.Student> fetchByStudentIntroduceArticleInfoId(Integer... values) {
		return fetch(Student.STUDENT.STUDENT_INTRODUCE_ARTICLE_INFO_ID, values);
	}
}
