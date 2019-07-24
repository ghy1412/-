package com.bit;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLOutput;
import java.util.*;
//比较器PersonASc
class PersonASc implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return 0;
    }
}
@Data
class Person {

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private String name;
    private Integer age;

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (!(obj instanceof Person))
            return false;
        Person person = (Person)obj;
        return this.age.equals(person.age)&&this.name.equals(person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name,age);
    }
    /* @Override
    public int compareTo(Person o) {
        if (this.age < o.age){
            return -1;
        }
        if (this.age > o.age){
            return 1;
        }
        return this.name.compareTo(o.name);
    }*/
}
 class MyList {
    public static void main(String[] args) throws Exception{
      Properties properties = new Properties();
        properties.setProperty("xa","西安");
        properties.setProperty("bj","北京");
        properties.setProperty("sh","上海");
        File file = new File("");
        properties.store(new FileOutputStream(file),"first");
    }
}
