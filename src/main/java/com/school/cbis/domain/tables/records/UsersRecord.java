/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.records;


import com.school.cbis.domain.tables.Users;

import java.sql.Date;
import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


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
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> {

	private static final long serialVersionUID = 817484783;

	/**
	 * Setter for <code>cbis.users.username</code>.
	 */
	public void setUsername(String value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>cbis.users.username</code>.
	 */
	@NotNull
	@Size(max = 64)
	public String getUsername() {
		return (String) getValue(0);
	}

	/**
	 * Setter for <code>cbis.users.password</code>.
	 */
	public void setPassword(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>cbis.users.password</code>.
	 */
	@NotNull
	@Size(max = 500)
	public String getPassword() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>cbis.users.enabled</code>.
	 */
	public void setEnabled(Byte value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>cbis.users.enabled</code>.
	 */
	@NotNull
	public Byte getEnabled() {
		return (Byte) getValue(2);
	}

	/**
	 * Setter for <code>cbis.users.user_type_id</code>.
	 */
	public void setUserTypeId(Integer value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>cbis.users.user_type_id</code>.
	 */
	@NotNull
	public Integer getUserTypeId() {
		return (Integer) getValue(3);
	}

	/**
	 * Setter for <code>cbis.users.real_name</code>. 真实姓名
	 */
	public void setRealName(String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>cbis.users.real_name</code>. 真实姓名
	 */
	@Size(max = 30)
	public String getRealName() {
		return (String) getValue(4);
	}

	/**
	 * Setter for <code>cbis.users.mobile</code>. 手机
	 */
	public void setMobile(String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>cbis.users.mobile</code>. 手机
	 */
	@Size(max = 15)
	public String getMobile() {
		return (String) getValue(5);
	}

	/**
	 * Setter for <code>cbis.users.email</code>. 邮箱
	 */
	public void setEmail(String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>cbis.users.email</code>. 邮箱
	 */
	@Size(max = 500)
	public String getEmail() {
		return (String) getValue(6);
	}

	/**
	 * Setter for <code>cbis.users.birthday</code>. 生日
	 */
	public void setBirthday(Date value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>cbis.users.birthday</code>. 生日
	 */
	public Date getBirthday() {
		return (Date) getValue(7);
	}

	/**
	 * Setter for <code>cbis.users.head_img</code>. 头像
	 */
	public void setHeadImg(String value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>cbis.users.head_img</code>. 头像
	 */
	@Size(max = 500)
	public String getHeadImg() {
		return (String) getValue(8);
	}

	/**
	 * Setter for <code>cbis.users.sex</code>. 性别
	 */
	public void setSex(String value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>cbis.users.sex</code>. 性别
	 */
	@Size(max = 2)
	public String getSex() {
		return (String) getValue(9);
	}

	/**
	 * Setter for <code>cbis.users.identity_card</code>. 身份证号
	 */
	public void setIdentityCard(String value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>cbis.users.identity_card</code>. 身份证号
	 */
	@Size(max = 20)
	public String getIdentityCard() {
		return (String) getValue(10);
	}

	/**
	 * Setter for <code>cbis.users.family_residence</code>. 家庭居住地
	 */
	public void setFamilyResidence(String value) {
		setValue(11, value);
	}

	/**
	 * Getter for <code>cbis.users.family_residence</code>. 家庭居住地
	 */
	@Size(max = 600)
	public String getFamilyResidence() {
		return (String) getValue(11);
	}

	/**
	 * Setter for <code>cbis.users.post</code>. 职务
	 */
	public void setPost(String value) {
		setValue(12, value);
	}

	/**
	 * Getter for <code>cbis.users.post</code>. 职务
	 */
	@Size(max = 100)
	public String getPost() {
		return (String) getValue(12);
	}

	/**
	 * Setter for <code>cbis.users.political_landscape</code>. 政治面貌
	 */
	public void setPoliticalLandscape(String value) {
		setValue(13, value);
	}

	/**
	 * Getter for <code>cbis.users.political_landscape</code>. 政治面貌
	 */
	@Size(max = 10)
	public String getPoliticalLandscape() {
		return (String) getValue(13);
	}

	/**
	 * Setter for <code>cbis.users.religious_belief</code>. 宗教信仰
	 */
	public void setReligiousBelief(String value) {
		setValue(14, value);
	}

	/**
	 * Getter for <code>cbis.users.religious_belief</code>. 宗教信仰
	 */
	@Size(max = 500)
	public String getReligiousBelief() {
		return (String) getValue(14);
	}

	/**
	 * Setter for <code>cbis.users.nation</code>. 民族
	 */
	public void setNation(String value) {
		setValue(15, value);
	}

	/**
	 * Getter for <code>cbis.users.nation</code>. 民族
	 */
	@Size(max = 200)
	public String getNation() {
		return (String) getValue(15);
	}

	/**
	 * Setter for <code>cbis.users.is_check_mobile</code>. 已验证手机
	 */
	public void setIsCheckMobile(Byte value) {
		setValue(16, value);
	}

	/**
	 * Getter for <code>cbis.users.is_check_mobile</code>. 已验证手机
	 */
	@NotNull
	public Byte getIsCheckMobile() {
		return (Byte) getValue(16);
	}

	/**
	 * Setter for <code>cbis.users.is_check_email</code>. 已验证邮箱
	 */
	public void setIsCheckEmail(Byte value) {
		setValue(17, value);
	}

	/**
	 * Getter for <code>cbis.users.is_check_email</code>. 已验证邮箱
	 */
	@NotNull
	public Byte getIsCheckEmail() {
		return (Byte) getValue(17);
	}

	/**
	 * Setter for <code>cbis.users.mobile_check_key</code>. 手机验证码
	 */
	public void setMobileCheckKey(String value) {
		setValue(18, value);
	}

	/**
	 * Getter for <code>cbis.users.mobile_check_key</code>. 手机验证码
	 */
	@Size(max = 20)
	public String getMobileCheckKey() {
		return (String) getValue(18);
	}

	/**
	 * Setter for <code>cbis.users.email_check_key</code>. 邮箱验证码
	 */
	public void setEmailCheckKey(String value) {
		setValue(19, value);
	}

	/**
	 * Getter for <code>cbis.users.email_check_key</code>. 邮箱验证码
	 */
	@Size(max = 20)
	public String getEmailCheckKey() {
		return (String) getValue(19);
	}

	/**
	 * Setter for <code>cbis.users.password_reset_key</code>. 密码重置key
	 */
	public void setPasswordResetKey(String value) {
		setValue(20, value);
	}

	/**
	 * Getter for <code>cbis.users.password_reset_key</code>. 密码重置key
	 */
	@Size(max = 20)
	public String getPasswordResetKey() {
		return (String) getValue(20);
	}

	/**
	 * Setter for <code>cbis.users.mobile_check_key_validity_period</code>. 手机验证有效期
	 */
	public void setMobileCheckKeyValidityPeriod(Timestamp value) {
		setValue(21, value);
	}

	/**
	 * Getter for <code>cbis.users.mobile_check_key_validity_period</code>. 手机验证有效期
	 */
	public Timestamp getMobileCheckKeyValidityPeriod() {
		return (Timestamp) getValue(21);
	}

	/**
	 * Setter for <code>cbis.users.email_check_key_validity_period</code>. 邮箱验证有效期
	 */
	public void setEmailCheckKeyValidityPeriod(Timestamp value) {
		setValue(22, value);
	}

	/**
	 * Getter for <code>cbis.users.email_check_key_validity_period</code>. 邮箱验证有效期
	 */
	public Timestamp getEmailCheckKeyValidityPeriod() {
		return (Timestamp) getValue(22);
	}

	/**
	 * Setter for <code>cbis.users.password_reset_key_validity_period</code>. 密码重置key有效期
	 */
	public void setPasswordResetKeyValidityPeriod(Timestamp value) {
		setValue(23, value);
	}

	/**
	 * Getter for <code>cbis.users.password_reset_key_validity_period</code>. 密码重置key有效期
	 */
	public Timestamp getPasswordResetKeyValidityPeriod() {
		return (Timestamp) getValue(23);
	}

	/**
	 * Setter for <code>cbis.users.lang_key</code>. message source
	 */
	public void setLangKey(String value) {
		setValue(24, value);
	}

	/**
	 * Getter for <code>cbis.users.lang_key</code>. message source
	 */
	@Size(max = 5)
	public String getLangKey() {
		return (String) getValue(24);
	}

	/**
	 * Setter for <code>cbis.users.persona_introduction</code>. 个人介绍
	 */
	public void setPersonaIntroduction(String value) {
		setValue(25, value);
	}

	/**
	 * Getter for <code>cbis.users.persona_introduction</code>. 个人介绍
	 */
	@Size(max = 200)
	public String getPersonaIntroduction() {
		return (String) getValue(25);
	}

	/**
	 * Setter for <code>cbis.users.introduce_article_info_id</code>. 文章简介id
	 */
	public void setIntroduceArticleInfoId(Integer value) {
		setValue(26, value);
	}

	/**
	 * Getter for <code>cbis.users.introduce_article_info_id</code>. 文章简介id
	 */
	public Integer getIntroduceArticleInfoId() {
		return (Integer) getValue(26);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<String> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached UsersRecord
	 */
	public UsersRecord() {
		super(Users.USERS);
	}

	/**
	 * Create a detached, initialised UsersRecord
	 */
	public UsersRecord(String username, String password, Byte enabled, Integer userTypeId, String realName, String mobile, String email, Date birthday, String headImg, String sex, String identityCard, String familyResidence, String post, String politicalLandscape, String religiousBelief, String nation, Byte isCheckMobile, Byte isCheckEmail, String mobileCheckKey, String emailCheckKey, String passwordResetKey, Timestamp mobileCheckKeyValidityPeriod, Timestamp emailCheckKeyValidityPeriod, Timestamp passwordResetKeyValidityPeriod, String langKey, String personaIntroduction, Integer introduceArticleInfoId) {
		super(Users.USERS);

		setValue(0, username);
		setValue(1, password);
		setValue(2, enabled);
		setValue(3, userTypeId);
		setValue(4, realName);
		setValue(5, mobile);
		setValue(6, email);
		setValue(7, birthday);
		setValue(8, headImg);
		setValue(9, sex);
		setValue(10, identityCard);
		setValue(11, familyResidence);
		setValue(12, post);
		setValue(13, politicalLandscape);
		setValue(14, religiousBelief);
		setValue(15, nation);
		setValue(16, isCheckMobile);
		setValue(17, isCheckEmail);
		setValue(18, mobileCheckKey);
		setValue(19, emailCheckKey);
		setValue(20, passwordResetKey);
		setValue(21, mobileCheckKeyValidityPeriod);
		setValue(22, emailCheckKeyValidityPeriod);
		setValue(23, passwordResetKeyValidityPeriod);
		setValue(24, langKey);
		setValue(25, personaIntroduction);
		setValue(26, introduceArticleInfoId);
	}
}
