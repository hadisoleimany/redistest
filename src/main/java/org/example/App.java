package org.example;

import org.apache.commons.lang.SerializationUtils;
import redis.clients.jedis.Jedis;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println("Hello World!");
        byte[] keyyy = (Student.class.getSimpleName()+"hash").getBytes();
        List<Student> students = new ArrayList<>(10000);

        for (int i = 0; i < 100000; i++) {
            Student student = new Student((long) i, "hadi" + i, "soleimany" + i, String.valueOf(i));
            students.add(student);
            jedis.hset(keyyy,String.valueOf(i).getBytes(), getByte(student));
        }
        Student object = getObject(jedis.hget(keyyy, "150".getBytes()));
        long llen = jedis.hlen(keyyy);
        System.out.println(llen);
        boolean hexists = jedis.hexists(keyyy, "9000".getBytes());
        System.out.println(hexists);
        Random random=new Random();


        System.out.println(object);
        for (int i=0;i<10;i++){
            int i1 = random.nextInt(100000);
            System.out.println(i1);
            System.out.println(getObject(jedis.hget(keyyy, String.valueOf(i1).getBytes())));
        }

    }

    static byte[] getByte(Student student) {
        return SerializationUtils.serialize(student);

    }
    static Student getObject(byte[] bytes) {
        return (Student) SerializationUtils.deserialize(bytes);
    }

}
