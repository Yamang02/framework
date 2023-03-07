package com.kh.mybatis.member.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

	public Member(String id, String password, String name) {
		this.id = id;
		this.password = password;
		this.name = name;
	}

	private int no;

	private String id;

	private String password;

	private String role;

	private String name;

	private String phone;

	private String email;

	private String address;

	private String hobby;

	private String status;

	private Date enrollDate;

	private Date modifyDate;

}
