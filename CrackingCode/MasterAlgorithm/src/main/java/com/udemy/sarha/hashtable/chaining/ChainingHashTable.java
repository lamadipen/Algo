package com.udemy.sarha.hashtable.chaining;

import com.udemy.sarha.Employee;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainingHashTable {
    private LinkedList<StoredEmployee>[] hashTable;

    public ChainingHashTable() {
        this.hashTable = new LinkedList[10];

        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new LinkedList<StoredEmployee>();
        }
    }

    private int hashKey(String key) {
        return key.length() % hashTable.length;
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        hashTable[hashedKey].add(new StoredEmployee(key, employee));
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);

        ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();

        StoredEmployee employee = null;

        while (iterator.hasNext()) {
            employee = iterator.next();
            if (employee.key.equals(key)) {
                return employee.employee;
            }
        }
        return null;
    }

    public Employee remove(String key) {
        int hashedKey = hashKey(key);

        ListIterator<StoredEmployee> iterator = hashTable[hashedKey].listIterator();

        StoredEmployee employee = null;

        while (iterator.hasNext()) {
            employee = iterator.next();
            if (employee.key.equals(key)) {
                break;
            }
        }

        if (employee == null) {
            return null;
        } else {
            hashTable[hashedKey].remove(employee);
            return employee.employee;
        }
    }


    static String addKbeforeFs(String text) {
        StringBuilder sb = new StringBuilder(text);

        for (int i = text.length()-1; i >=0 ; i--) {
            if ((Character.toLowerCase(text.charAt(i))) == 'f') {
                sb.insert(i, "K");
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(addKbeforeFs("Force"));
        System.out.println(addKbeforeFs("ForFFFce"));
    }
    
}
