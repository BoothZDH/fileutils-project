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

	//静态内部类
	static class EventData{
		Integer id;
		String msg;
		public EventData(Integer id,String msg){
			this.id=id;
			this.msg=msg;
		}


		@Override
		public String toString() {
			return "EventData{" +
					"id=" + id +
					", msg='" + msg + '\'' +
					'}';
		}
	}

	static class Transforms{
		static EventData transform(Integer id){
			switch (id){
				case 0:
					return new EventData(id,"Start");
				case 1:
					return new EventData(id,"Running");
				case 2:
					return new EventData(id,"Done");
				case 3:
					return new EventData(id,"Fail");
				default:
					return new EventData(id,"Error");
			}
		}
	}

	@FunctionalInterface
	interface  FN<A,B>{
		B apply(A a);
	}

	<B> Event<?> map(FN<T,B> f){
		return new Event<B>(f.apply(this.data));
	}

	public static void main(String[] args) {

		Stream<Event<Integer>> s = Stream.of(
				new Event(1),
				new Event(2),
				new Event(0),
				new Event(10)
		);
		s.map(event->event.map(Transforms::transform))
				.forEach(e->{
					System.out.println(e.data);
				});
	}
}
