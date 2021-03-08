package com.springBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contacts {

	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String tag;
	private Integer user;
}
