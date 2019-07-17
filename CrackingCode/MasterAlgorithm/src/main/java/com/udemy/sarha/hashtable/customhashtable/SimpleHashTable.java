package com.udemy.sarha.hashtable.customhashtable;

import com.udemy.sarha.Employee;

public class SimpleHashTable {
    private Employee[] hashTable;

    public SimpleHashTable() {
        hashTable = new Employee[10];
    }

    private int hashKey(String key){
        return key.length() % hashTable.length;
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        if(hashTable[hashedKey] != null){
            System.out.println("Sorry, there's already an employee at position " + hashedKey);
        }else{
            hashTable[hashedKey] = employee;
        }
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);
        return hashTable[hashedKey];
    }

    public void printHashTable(){
        for(int i = 0; i < hashTable.length; i++){
            System.out.println(hashTable[i]);
        }
    }
}
