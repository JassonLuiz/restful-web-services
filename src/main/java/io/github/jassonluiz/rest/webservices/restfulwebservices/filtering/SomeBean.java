package io.github.jassonluiz.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("field1")
public class SomeBean {

	private String field1;
	
	@JsonIgnore
	private String fild2;
	
	private String fild3;

	public SomeBean(String field1, String fild2, String fild3) {
		super();
		this.field1 = field1;
		this.fild2 = fild2;
		this.fild3 = fild3;
	}

	public String getField1() {
		return field1;
	}

	public String getFild2() {
		return fild2;
	}

	public String getFild3() {
		return fild3;
	}

	@Override
	public String toString() {
		return "SomeBean [field1=" + field1 + ", fild2=" + fild2 + ", fild3=" + fild3 + "]";
	}

}
