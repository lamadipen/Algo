package com.udemy.sarha.hashtable;

import com.udemy.sarha.Employee;

public class HashTableApp {
    public static void main(String... args) {
        SimpleHashTable st = new SimpleHashTable();

        st.put("lama", new Employee(10,"Dipen", "lama"));
        st.put("thapa", new Employee(10,"Dipen", "thapa"));
        st.put("rai", new Employee(10,"Dipen", "rai"));
        st.put("Shrestha", new Employee(10,"Dipen", "Shre∂stha"));
        st.put("Shrestha", new Employee(10,"Dipen", "Shre∂stha"));

        st.printHashTable();
    }
}
