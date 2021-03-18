package com.booth.javaStream;

import org.apache.poi.ss.formula.functions.Even;

import java.util.stream.Stream;

/**
 * @ClassName: Event
 * @Description:TODO
 * @Version:1.0
 */
public class Event<T> {
	T data;
	public Event(T data){
		this.data = data;
	}

	static class EventData{
		Integer id;
		String msg;
		public EventData(Integer id,String msg){
			this.id=id;
			this.msg=msg;
		}
	}

}
