package com.udemy.sarha.hashtable.linearprobing;

import com.udemy.sarha.Employee;

public class LinearProblingHashTable {
    private StoredEmployee[] hashTable;

    public LinearProblingHashTable() {
        hashTable = new StoredEmployee[10];
    }

    private int hashKey(String key){
        return key.length() % hashTable.length;
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        if(occupied(hashedKey)){
            int stopIndex = hashedKey;
            if(hashedKey == hashTable.length -1){
                hashedKey = 0;
            }else{
                hashedKey++;
            }
            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1)% hashTable.length;
            }
        }
        if(occupied(hashedKey)){
            System.out.println("Sorry, there's already an employee at position " + hashedKey);
        }else{
            hashTable[hashedKey] = new StoredEmployee(key,employee);
        }
    }

    private boolean occupied(int key) {
        if(hashTable[key] != null){
            return true;
        }
        return false;
    }

    private int findKey(String key){
        int hashedKey = hashKey(key);
        if(hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)){
            return hashedKey;
        }
        int stopIndex = hashedKey;
        if (hashedKey == hashTable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }
        while (hashedKey != stopIndex &&
                hashTable[hashedKey] != null &&
                !hashTable[hashedKey].key.equals(key) ) {
                hashedKey = (hashedKey + 1) % hashTable.length;
        }

//        if(stopIndex == hashedKey){
//            return -1;
//        }else{
//            return hashedKey;
//        }

        if(hashTable[hashedKey] != null &&
                hashTable[hashedKey].key.equals(key)){
            return hashedKey;
        }else{
            return -1;
        }

    }

    public Employee get(String key) {
        int hashedKey = findKey(key);

        if(hashedKey == -1){
            return null;
        }
        return hashTable[hashedKey].employee;
    }

    public void printHashTable(){
        for(int i = 0; i < hashTable.length; i++){
            if(hashTable[i] == null){
                System.out.println("Empty");
            }else{
                System.out.println(hashTable[i].employee);
            }
        }
    }

    public Employee remove(String key) {
        int hashedKey = findKey(key);
        if(hashedKey ==  -1){
            return null;
        }
        Employee employee = hashTable[hashedKey].employee;
        hashTable[hashedKey] = null;
        StoredEmployee[] oldHashTable = hashTable;
        hashTable = new StoredEmployee[oldHashTable.length];

        for(int i=0; i < oldHashTable.length; i++){
            if(oldHashTable[i] != null){
                put(oldHashTable[i].key,oldHashTable[i].employee);
            }
        }

        return employee;
    }
}
/** This is one of the technique when there is a collusion in the hashtable
 * we increment the index value of the hash code and try to add the value in
 * next available index of hashtable
 *
 * */