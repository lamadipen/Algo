package com.cdk.effectiveJava.staticfactorymethod;
//use Builder pattern when faced with many constructor parameters
public class User {
    private int id;
    private String name;
    private int age;
    private long created;

     User(long created,int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    private static long $default$created() {
        return System.currentTimeMillis();
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", created=" + created +
                '}';
    }

    static class UserBuilder{
        private int id;
        private String name;
        private int age;
        private long created;

        public UserBuilder created(long created) {
            this.created = created;
            return this;
        }

        public UserBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public UserBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(User.$default$created(),id, name, age);
        }
    }

    public static void main(String[] args) {
        User user = User.builder()
                .withAge(20)
                .withName("Test")
                .withId(1)
                .build();

        System.out.println(user.toString());
    }
}
