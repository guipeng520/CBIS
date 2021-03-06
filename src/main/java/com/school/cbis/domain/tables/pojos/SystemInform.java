/**
 * This class is generated by jOOQ
 */
package com.school.cbis.domain.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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
public class SystemInform implements Serializable {

	private static final long serialVersionUID = -267455476;

	private Integer id;
	private String  systemInform;
	private Integer systemInformShow;

	public SystemInform() {}

	public SystemInform(SystemInform value) {
		this.id = value.id;
		this.systemInform = value.systemInform;
		this.systemInformShow = value.systemInformShow;
	}

	public SystemInform(
		Integer id,
		String  systemInform,
		Integer systemInformShow
	) {
		this.id = id;
		this.systemInform = systemInform;
		this.systemInformShow = systemInformShow;
	}

	@NotNull
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Size(max = 1000)
	public String getSystemInform() {
		return this.systemInform;
	}

	public void setSystemInform(String systemInform) {
		this.systemInform = systemInform;
	}

	public Integer getSystemInformShow() {
		return this.systemInformShow;
	}

	public void setSystemInformShow(Integer systemInformShow) {
		this.systemInformShow = systemInformShow;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("SystemInform (");

		sb.append(id);
		sb.append(", ").append(systemInform);
		sb.append(", ").append(systemInformShow);

		sb.append(")");
		return sb.toString();
	}
}
