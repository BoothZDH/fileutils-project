package com.booth.javaTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.booth.entity.EmployEntity;
import com.booth.entity.Home;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: StreamApiTest
 * @Description:TODO
 * @Version:1.0
 */
@Slf4j
public class StreamApiTest {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		//functionStreamApi();
		distinctList();
	}

	/**
	 * 去重统计
	 */

	public static void distinctList(){

		List<String> lists = new ArrayList<>();
		lists.add("I love my honey");
		lists.add("her name is xin xin");
		lists.add("she is very cute");
		lists.add("and");
		lists.add("ver beautiful");

		Stream<String[]> lineArray = lists.stream()
				.map((line) -> line.split(","));
		Stream<String> stringStream = lineArray.flatMap(Arrays::stream);
		long count = stringStream
				.distinct().count();
		System.out.println(count);
	//	Stream<Stream<String>> streamStream = lineArray.map(Arrays::stream);
//				.distinct()
//				.forEach(System.out::println);
	}

	/**
	 * 流计算的使用步骤
	 */
	public static void  functionStreamApi(){
		log.info("----------创建数据源---------");

		/**
		 * 第一步：创建流（数据源）
		 */
		//由数组创建流          通过Arrays中的静态方法stream()获取数组流
		Home[] homes = new Home[10];
		Stream<Home> stream = Arrays.stream(homes);
		//stream.map(p->p.getCodeNum()).forEach(System.out::println);

		//由值创建流
		Stream<String> streamString = Stream.of("booth", "boss", "both");
		streamString
				.forEach(System.out::println);

		//有函数创建流   创建无限流： 迭代：Stream.interate(), 生成：Stream.generate()

		//迭代
		Stream<Integer> streamIterate = Stream
				.iterate(1, (X) -> X * 2);
		streamIterate
				.limit(5)
				.forEach(System.out::println);
		//生成
		Stream
				.generate(()->Math.random())
				.limit(5)
				.forEach(System.out::println);




		log.info("-------------中间操作---------------");




		/**
		 * 第二步：中间操作
		 */

		//创建集合对象

		List<Home> obj = new ArrayList<>();
		obj.add(new Home(001,4,"zhang","188--"));
		obj.add(new Home(002,3,"zhao","181--"));
		obj.add(new Home(003,3,"zhao","181--"));
		obj.add(new Home(004,2,"jiang","181--"));
		obj.add(new Home(004,2,"jiang","181--"));
		obj.add(new Home(005,3,"sun","181"));





		/**
		 * 类型一：筛选过滤
		 *
		 * 动作（1）过滤  filter: 接收 Lambda ， 从流中排除某些元素
		 *
		 * Notice:中间操作只有碰到终止操作才会执行系列操作
		 */
		obj.stream()
				.filter((p)->p.getFamilysNum()>1)
				.forEach(System.out::println);

		log.info("-----------limit----------------");
		/**
		 * 动作（2） 切片  limit ： 截断流，使其元素不超过给定数量
		 */
		obj.stream()
				.filter((p)->p.getFamilysNum()>1)
				.limit(3)
				.forEach(System.out::println);

		log.info("-------------skip-------------");
		/**
		 * 动作（3）跳过  skip:跳过元素，返回一个扔掉了前 n 个元素的流。
		 *                     若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
		 */
		obj.stream()
				.filter((p)->p.getFamilysNum()>1)
				.skip(1)
				.limit(3)
				.forEach(System.out::println);

		log.info("------------- distinct -------------");
		/**
		 * 动作（3）： 去重  distinct：通过流所生成元素的 hashCode() 和 equals() 去除重复元素
		 */
		obj.stream()
				.distinct()
				.forEach(System.out::println);



		/**
		 * 类型二：映射转换整理
		 */



		/**
		 *
		 * 动作1： map：接收Lambda，将元素转换成其他形式或提取信息。
		 * 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
		 */
		obj.stream()
				.map(p->p.getCodeNum()+1)
				.forEach(System.out::println);

		obj.stream()
				.map(Home::getFamilysNum)
				.filter((p)->p+1>=3)
				.limit(4)
				.skip(1)
				.forEach(System.out::println);


		/**
		 * 动作2：flatMap:接收一个函数作为参数，将流中的每个值都转换成另一个流，然后把所有流连接成一个流
		 */
		log.info("--------------flatMap-------");
		obj.stream()
				.flatMap(StreamApiTest::getStream)   //将所有的单个流连接成一个流
				.forEach(System.out::println);


		log.info("集合元素添加");
		List familyList = new ArrayList();
		obj.stream()
				.mapToInt(Home::getFamilysNum)
				.distinct()
				.forEach(familyList::add);

		familyList.stream()
				.forEach(System.out::println);


		/**
		 * 类型三： 排序
		 * 动作1 ：sorted:自然排序（Comparable）
		 */
		log.error("------元素排序------------");
		obj.stream()
				.map(Home::getFamilysNum)
				.sorted()
				.forEach(System.out::println);

		log.error("-----------对象自定义排序--------");
		obj.stream()
				.sorted((a,b)->{
					if (a.getFamilysNum().equals(b.getFamilysNum())){
						return a.getLastName().compareTo(b.getLastName());
					}else {
						return Integer.compare(a.getFamilysNum(),b.getFamilysNum());
					}
				})
				.forEach(System.out::println);

		log.info("-------排序规则------");
		List<String>  str = new ArrayList<String>();
		str.add("df");
		str.add("444");
		str.add("555");
		str.add("33");
		str.add("fgg");
		str.add("hh3");

		str.stream()
				.sorted()
				.forEach(System.out::println);

		str.stream()
				.sorted((x,y)->x.compareTo(y))
				.forEach(System.out::println);


		log.info("---------------终止操作----------------");
		/**
		 * 第三步：终止操作 ：终端操作会从流的流水线生成结果。其结果可以是任何不是流的值
		 */

		List<EmployEntity> emls = new ArrayList<>();
		emls.add(new EmployEntity(1,"zhao",18,20000305D,"on"));
		emls.add(new EmployEntity(2,"sun",88,19900205D,"close"));
		emls.add(new EmployEntity(3,"hu",77,18001105D,"close"));
		emls.add(new EmployEntity(4,"yu",9,20200905D,"on"));
		emls.add(new EmployEntity(5,"xin",67,20010805D,"on"));
		emls.add(new EmployEntity(6,"qu",46,19980405D,"close"));

		/**
		 * 类型一：查找和匹配
		 *
		 *
		 * 动作1：匹配： allMatch——检查是否匹配所有元素
		 */

		System.out.println(emls.stream()
				.allMatch((p) -> "on".equals(p.getStatus())));

		// 动作2：anyMatch  --检查匹配至少一个相同条件的元素
		System.out.println(emls.stream()
				.anyMatch((p) -> "yu".equals(p.getName())));

		//动作3： noneMatch   ----检查是否无法匹配任何一个元素
		System.out.println(emls.stream()
				.noneMatch((p) -> "yu".equals(p.getName())));

		//动作4：   findFirst ---返回第一个元素
		System.out.println(emls.stream()
				.filter((p) -> "on".equals(p.getStatus()))
				.findFirst().get());

		Optional<EmployEntity> first = emls.stream()
				.filter((p) -> "on".equals(p.getStatus()))
				.findFirst();
		EmployEntity employEntity = first.get();
		System.out.println(JSON.toJSONString(employEntity)+"toString");
		System.out.println(JSONArray.toJSON(employEntity)+"toJSON");
		System.out.println(JSONObject.toJSONString(employEntity)+"toString");

		//动作5：   findAny --返回流中的任意一个元素
		EmployEntity employEntity1 = emls.stream()
				.filter((p) -> "close".equals(p.getStatus()))
				.findAny().get();
		System.out.println(JSONObject.toJSONString(employEntity1) +"findANY");

		//动作6：    count --返回流中元素的总个数
		System.out.println(emls.stream().count()+" :count");

		//动作7：   MAX --返回流中的最大值
		System.out.println(emls.stream()
				.map(EmployEntity::getAge)
				.max(Integer::compareTo).get() +"   :max-age");

		//动作8： MIN---返回流中最小的值
		System.out.println(emls.stream()
				.map(EmployEntity::getAge)
				.min(Integer::compareTo).get() + "   min-age");

		/**
		 * 类型二： 规约
		 * 动作1:reduce(T identity, BinaryOperator) / reduce(BinaryOperator)
		 * ——可以将流中元素反复结合起来，得到一个值
		 */

		List<Integer> lists = new ArrayList<>();
		lists.add(1);
		lists.add(2);
		lists.add(3);
		lists.add(4);
		lists.add(88);
		lists.add(6);
		System.out.println("sum:  "+lists.stream()
				.reduce(0, (a, b) -> a + b));

		System.out.println("idSum : "+emls.stream()
				.map(EmployEntity::getId)
				.reduce((a, b) -> a + b).get());
		/**
		 * 类型三：收集整理
		 *动作1：收集进集合中
		 * Notice:  这里仅以Integer类型为例，操作方法还有Double和Long类型，使用的时候请注意使用拓展
		 */
		// toList
		lists.stream()
				.collect(Collectors.toList())
				.forEach(System.out::println);
		log.info("----------toSet--------");
		//toSet
		Iterator<Integer> iterator = lists.stream()
				.collect(Collectors.toSet())
				.iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}

		//toCollection
		ArrayList<Integer> integerArrayList = lists.stream()
				.collect(Collectors.toCollection(ArrayList::new));
		integerArrayList.forEach(System.out::println);
		//counting
		Long collect = lists.stream()
				.collect(Collectors.counting());
		System.out.println(collect+  ":  count");

		//summingint
		Integer collect1 = emls.stream()
				.collect(Collectors.summingInt(EmployEntity::getAge));
		System.out.println("ageSum : "+collect1);

		//averagingint
		Double collect2 = emls.stream()
				.collect(Collectors.averagingInt(EmployEntity::getAge));
		System.out.println("averageAge:"+collect2);

		//summarizingint(统计某个整型属性的总数、总和、最大、最小、平均值)IntSummaryStatistics{count=6, sum=305, min=9, average=50.833333, max=88}
		IntSummaryStatistics collect3 = emls.stream()
				.collect(Collectors.summarizingInt(EmployEntity::getAge));
		System.out.println("统计值:" + collect3);
		//.............................
		/*
		动作2：整理拼接
		 */
		//joining  可以在joining()中添加连接标识
		String collect4 = emls.stream()
				.map(EmployEntity::getName)
				.collect(Collectors.joining("+"));
		System.out.println("name拼接：" + collect4);

		//maxBy  ---根据属性的比较，选出最大的Optional<T>.get()
		Optional<EmployEntity> collect5 = emls.stream()
				.collect(Collectors.maxBy(Comparator.comparing(EmployEntity::getSalary)));
		System.out.println("salsryMax" +JSONObject.toJSONString(collect5.get()) );

		//minBy   ---
		EmployEntity employEntity2 = emls.stream()
				.collect(Collectors.minBy(Comparator.comparingInt(EmployEntity::getAge))).get();
		System.out.println(JSONObject.toJSONString(employEntity2));

		//reducing  从初始值开始将属性累加
		Integer collect6 = emls.stream()
				.collect(Collectors.reducing(50, EmployEntity::getAge, Integer::sum));
		System.out.println(collect6+"       ffffff");

		Integer collect7 = emls.stream()
				.collect(Collectors.summingInt(EmployEntity::getAge));
		System.out.println(collect7+"ffffdd");

		//collectingAndThen
		Integer collect8 = emls.stream()
				.collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
		System.out.println(collect8);

		// groupingBy
		Map<String, List<EmployEntity>> collect9 = emls.stream()
				.collect(Collectors.groupingBy(EmployEntity::getStatus));

		Iterator<String> iterator1 = collect9.keySet().iterator();
		while (iterator1.hasNext()){
			String key = iterator1.next();
			System.out.println(JSONObject.toJSONString(collect9.get(key)));
		}
	}

	/**
	 * 将值转换为一个流
	 * @param home
	 * @return
	 */
	public static Stream<Integer> getStream(Home home){
		List<Integer> listS = new ArrayList<>();
		listS.add(home.getFamilysNum());
		return listS.stream();
	}
}
