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
public class ArticleType implements Serializable {

	private static final long serialVersionUID = 632553156;

	private Integer id;
	private String  name;

	public ArticleType() {}

	public ArticleType(ArticleType value) {
		this.id = value.id;
		this.name = value.name;
	}

	public ArticleType(
		Integer id,
		String  name
	) {
		this.id = id;
		this.name = name;
	}

	@NotNull
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	@Size(max = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ArticleType (");

		sb.append(id);
		sb.append(", ").append(name);

		sb.append(")");
		return sb.toString();
	}
}