package com.ducpq.demo.myspringbootapp.responsemessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {
	private int status;
	private String message;
	private long timeStamp;
}
