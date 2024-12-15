package com.ducpq.demo.myspringbootapp.respmessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseMessage {
	private int status;
	private String message;
	private long timestamp;
}
