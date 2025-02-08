package designpatterns.builderpattern;

public class Student {

    private final String name;
    private final int age;
    private final int rollNumber;

    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.rollNumber = builder.rollNumber;
    }

    public static class Builder {
        private String name;
        private int age;
        private int rollNumber;

        public Builder() {
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setRollNumber(int rollNumber) {
            this.rollNumber = rollNumber;
            return this;
        }

        public Student build(){
            return new Student(this);
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", rollNumber=" + rollNumber +
                '}';
    }
}
