package org.example;


import java.io.Serializable;

public class Student implements Serializable {
    public Student(Long id, String name, String family, String code) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.code = code;
    }

    private Long id;
    private String name;
    private String family;
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
