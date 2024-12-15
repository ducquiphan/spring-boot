package com.ducpq.demo.myspringbootapp.playload.response;

import java.util.List;

public record ListResponse<T>(int totalPage, int numOfRecords, List<T> data) {
	public static <T> ListResponse<T> build(int totalPage, int numOfRecords, List<T> data) {
		return new ListResponse<>(totalPage, numOfRecords, data);
	}
}
