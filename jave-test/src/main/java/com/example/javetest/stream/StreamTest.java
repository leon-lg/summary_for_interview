package com.example.javetest.stream;

import com.example.javetest.constant.EmployeeInfo;
import org.springframework.util.comparator.Comparators;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        ArrayList<EmployeeInfo> list = new ArrayList<>();

        list.add(new EmployeeInfo("Leon", 10000, "男", 12, "1"));
        list.add(new EmployeeInfo("Ting", 10000, "男", 14, "2"));
        list.add(new EmployeeInfo("Huang", 10000, "女", 10, "2"));
        list.add(new EmployeeInfo("Hong", 1000, "男", 12, "1"));
        list.add(new EmployeeInfo("Liang", 9000, "女", 12, "3"));
        list.add(new EmployeeInfo("Wang", 11000, "男", 12, "3"));

        System.out.println("=>>>>筛选工资大于8000的员工，并打印名字");
        list.stream().filter(EmployeeInfo -> EmployeeInfo.getSalary() > 8000).map(EmployeeInfo::getName).forEach(System.out::println);
        List<EmployeeInfo> collect = list.stream().filter(employee -> employee.getSalary() > 8000).collect(Collectors.toList());
        System.out.println(collect);

        System.out.println("=>>>>筛选工资大于8000的员工的人数");
        long count = list.stream().filter(EmployeeInfo -> EmployeeInfo.getSalary() > 8000).count();
        System.out.println(count);

        System.out.println("=>>>>筛选所有员工的工资最大值、最小值、平均值");
        int maxSa = -1;
        int minSa = Integer.MAX_VALUE;
        int avgSa = 0;
        int sum = 0;
        for(EmployeeInfo employeeInfo : list){
            sum += employeeInfo.getSalary();
            if(maxSa < employeeInfo.getSalary()){
                maxSa = employeeInfo.getSalary();
            }
            if(minSa > employeeInfo.getSalary()){
                minSa = employeeInfo.getSalary();
            }
        }
        avgSa = sum / list.size();
        System.out.println("=>>>>maxSa:" + maxSa + "minSa" + minSa + "avgSa:" + avgSa);

        Integer sum1 = list.stream().map(EmployeeInfo::getSalary).reduce(Integer::sum).get();
        List<EmployeeInfo> collect1 = list.stream().sorted(Comparator.comparingInt(EmployeeInfo::getSalary)).collect(Collectors.toList());
        System.out.println("=>>>>maxSa:" + collect1.get(collect1.size() - 1).getSalary() + "minSa" + collect1.get(0).getSalary() + "avgSa:" + sum1 / list.size());

        System.out.println("=>>>=>>>>案例：统计list中的各项数据");
        int maxSalary = list.stream().max(Comparator.comparingInt(EmployeeInfo::getSalary)).get().getSalary();
        int sum2 = list.stream().mapToInt(EmployeeInfo::getSalary).sum();
        IntSummaryStatistics collect4 = list.stream().collect(Collectors.summarizingInt(EmployeeInfo::getSalary));
        System.out.println(collect4);

        System.out.println("=>>>>案例：将员工的薪资全部增加1000");
        list.stream().peek(emp -> emp.setSalary(emp.getSalary() + 1000)).forEach(obj -> System.out.print(obj + " "));
        System.out.println();

        System.out.println("=>>>=>>>>案例：将若干字符数组合成一个新的字符数组");
        List<String> list2 = Arrays.asList("m.k.l.a", "1.3.5.7", "12.100.198.002");
        List<String> collect3 = list2.stream().flatMap(s -> {
            String[] split = s.split("\\.");
            Stream<String> stream = Arrays.stream(split);
            return stream;
        }).collect(Collectors.toList());
        System.out.println(collect3);

        System.out.println("=>>>=>>>>案例：将多个数组内容进行合并，以及筛选");
        String[] arr1 = { "a", "b", "c", "d" };
        String[] arr2 = { "d", "e", "f", "g" };
        Stream<String> stream1 = Arrays.stream(arr1);
        Stream<String> stream2 = Arrays.stream(arr2);
        List<String> concatList = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        System.out.println(concatList);

        System.out.println("=>>>=>>>>案例：快速生成等差数组，差值为10，数组大小为5");
        List<Integer> collect2 = Stream.iterate(1, x -> x + 100).skip(1).limit(5).collect(Collectors.toList());
        System.out.println(collect2);

        System.out.println("=>>>>将员工按照工资是否大于10000分为两组");
        Map<Boolean, List<EmployeeInfo>> groupBySalary = list.stream().collect(Collectors.groupingBy(emp -> emp.getSalary() > 10000));
        System.out.println(groupBySalary);
        System.out.println("=>>>>将员工先按性别进行划分再按照地区进行划分");
        Map<String, Map<String, List<EmployeeInfo>>> groupByGenderAndRegion = list.stream().collect(Collectors.groupingBy(EmployeeInfo::getGender, Collectors.groupingBy(EmployeeInfo::getRegion)));
        System.out.println(groupByGenderAndRegion);


    }
}
