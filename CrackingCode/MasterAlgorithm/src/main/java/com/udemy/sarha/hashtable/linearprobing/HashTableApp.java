package com.udemy.sarha.hashtable.linearprobing;

import com.udemy.sarha.Employee;

public class HashTableApp {
    public static void main(String... args) {
        LinearProblingHashTable st = new LinearProblingHashTable();

        st.put("lama", new Employee(10,"Dipen", "lama"));
        st.put("lama", new Employee(10,"Dipen", "thapa"));
        st.put("shrestha", new Employee(10,"Dipen", "rai"));
        st.put("Shrestha", new Employee(10,"Dipen", "Shre∂stha"));
        st.put("Shrestha", new Employee(10,"Dipen", "Shre∂stha"));

        st.printHashTable();
        st.remove("thapa");
        System.out.println("Get Employee By id");
        System.out.println(st.get("lama"));
    }
}
