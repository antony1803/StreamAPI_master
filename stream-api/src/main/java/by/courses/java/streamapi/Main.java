package by.courses.java.streamapi;
import by.courses.java.streamapi.entity.UserBase;
import by.courses.java.streamapi.operation.DefaultStream;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        ArrayList<UserBase> list = new ArrayList<>();
        list.add(UserBase.of("Timmoty", 21));
        list.add(UserBase.of("Rostislav", 45));
        list.add(UserBase.of("Valentina", 56));
        DefaultStream defaults = new DefaultStream();
        List<UserBase> newList = (List)defaults.removeWithMaxAge(list);
        //List<String> newList = list.stream().skip(1).limit(2).collect(Collectors.toList());

        //list.stream().map(s -> s +"_1").collect(Collectors.toList());
        newList.forEach(System.out::println);
    }
}