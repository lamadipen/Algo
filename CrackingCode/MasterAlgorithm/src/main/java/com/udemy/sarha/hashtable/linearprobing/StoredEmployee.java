package com.udemy.sarha.hashtable.linearprobing;

import com.udemy.sarha.Employee;

public class StoredEmployee {
    public String key;
    public Employee employee;

    public StoredEmployee(String key, Employee employee) {
        this.key = key;
        this.employee = employee;
    }
}
