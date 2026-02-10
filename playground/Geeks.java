package playground;

import java.util.HashMap;
import java.util.Map;

class Student {
    public int roll_no;
    public String name;

    Student(int roll_no, String name){
        this.roll_no = roll_no;
        this.name = name;
    }
}

public class Geeks {
    public static void main(String[] args) {



        int[] arr = new int[4];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;

        System.out.println(
                "Trying to access element outside the size of array");
        System.out.println(arr[3]);

        Map<Integer, String> originalMap = new HashMap<>();
        originalMap.put(1, "Apple");
        originalMap.put(2, "Banana");
        originalMap.put(3, "Orange");

// Create a new HashMap using another map
        HashMap<Integer, String> hm = new HashMap<>(originalMap);

        System.out.println(hm.hashCode());

    }
}

