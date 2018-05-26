package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //ArrayList - Israel post queue
        //LinkedList - live queue (like, when you by cheese in supermarket)

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        //vs
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();


    }

    public static void profiling() {
        //profiling -> time between some operation

        //time before
        //saveToDatabase(String s)
        //time after
        //result between = how long does it take to save to DB


        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        Date start = new Date();
        for (int i = 0; i < 50_000_000; i++) {
            arrayList.add("a");
        }

        Date endDate = new Date();
        System.out.println("Time took to add 1M elements to ArrayList");
        System.out.println(endDate.getTime() - start.getTime());


        start = new Date();
        for (int i = 0; i < 50_000_000; i++) {
            linkedList.add("a");
        }
        endDate = new Date();
        System.out.println("Time took to add 1M elements to LinkedList");
        System.out.println(endDate.getTime() - start.getTime());

        System.out.println(" ***************************** ");

        /*start = new Date();
        for (int i = 0; i < 100_000; i++) {
            arrayList.add(0, "b");
        }
        endDate = new Date();
        System.out.println("Time took to add 100 000 elements to 0 index to ArrayList");
        System.out.println(endDate.getTime() - start.getTime());

        start = new Date();
        for (int i = 0; i < 1_000_000; i++) {
            linkedList.add(0, "b");
        }
        endDate = new Date();
        System.out.println("Time took to add 1M elements to 0 index to LinkedList");
        System.out.println(endDate.getTime() - start.getTime());
*/

        /*System.out.println(" ***************************** ");

        start = new Date();
        for (int i = 0; i < 10_000; i++) {
            arrayList.remove(100_000);
        }
        endDate = new Date();
        System.out.println("Time took to remove 10 000 elements by 100_000 index from ArrayList");
        System.out.println(endDate.getTime() - start.getTime());

        start = new Date();
        for (int i = 0; i < 10_000; i++) {
            linkedList.remove(100_000);
            //99_999 goes before 100_000
            //99_999 goes now before 100_001
            //99_999 goes now before 100_002
            //99_999 goes now before 100_003
            //...
        }
        endDate = new Date();
        System.out.println("Time took to remove 10 000 elements by 100_000 index from LinkedList");
        System.out.println(endDate.getTime() - start.getTime());

*/
        System.out.println(" ***************************** ");

        start = new Date();
        String s = arrayList.get(arrayList.size() / 2);
        endDate = new Date();
        System.out.println("Time took to get element by the last index from ArrayList");
        System.out.println(endDate.getTime() - start.getTime());

        start = new Date();
        String s1 = linkedList.get(linkedList.size() / 2);
        endDate = new Date();
        System.out.println("Time took to get element by the last index from LinkedList");
        System.out.println(endDate.getTime() - start.getTime());

        //Big O
        //O(1)
        //O(n) (0..array size(), CPU load)
    }

    public static void linkedListDemo() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        System.out.println(linkedList);
//        [a, b, c, d]

        linkedList.push("z");
        System.out.println(linkedList);
        //[z, a, b, c, d]

        //pop() - removes first element
        String pop = linkedList.pop();
        System.out.println(pop);
        //z
        System.out.println(linkedList);
        //[a, b, c, d]

        linkedList.push("z");
        //poll() - same as pop()
        String poll = linkedList.poll();
        System.out.println(poll);
        System.out.println(linkedList);

        //LinkedList will iterate through 99 previous in order to find the 100th.
        //linkedList.get(100);
    }

    public static void arrayListDemo() {
        //Random access example
        String[] array = new String[1_000_000];
        array[123] = "a";
        array[124] = "b";


        //ArrayList vs LinkedList
        //capacity

        ArrayList<String> arrayList = new ArrayList<>();
        //String [] array = new String[10];, where 10 is initial capacity
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        arrayList.add("f");
        //capacity ("internal" array length) increase * 2
        //capacity = 20
        arrayList.add("g");
        arrayList.add("h");
        System.out.println(arrayList);
        //[a, b, c, d, e, f, g, h]

        arrayList.add(0, "z"); //-> insert - is adding by specific index

//        array[0] = "z";
        System.out.println(arrayList);
        //[z, a, b, c, d, e, f, g, h]

        arrayList.remove(0);
        System.out.println(arrayList);
        //[a, b, c, d, e, f, g, h]


        arrayList.remove("h");
        System.out.println(arrayList);
        //[a, b, c, d, e, f, g]

        ArrayList<String> backwardLetters = new ArrayList<>();
        backwardLetters.add("z");
        backwardLetters.add("y");
        backwardLetters.add("x");
        backwardLetters.add("w");
        backwardLetters.add("v");
        arrayList.addAll(backwardLetters);

        System.out.println(arrayList);
        //[a, b, c, d, e, f, g, z, y, x, w, v]

        boolean hasAll = arrayList.containsAll(backwardLetters);
        System.out.println(hasAll);
        //true -> "arrayList" contains all starting and the ending letters
        // of the alphabet

        hasAll = backwardLetters.containsAll(arrayList);
        System.out.println(hasAll);
        //false -> backwardLetters contains the starting letters and
        // the ending letters of the alphabet.

        arrayList.add(0, "WORD");
        System.out.println(arrayList);
        //[WORD, a, b, c, d, e, f, g, z, y, x, w, v]

        arrayList.set(0, "SUBSTITUTED WORD");
        System.out.println(arrayList);
        //[SUBSTITUTED WORD, a, b, c, d, e, f, g, z, y, x, w, v]

        arrayList.removeAll(backwardLetters);
        System.out.println(arrayList);
        //[SUBSTITUTED WORD, a, b, c, d, e, f, g]

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(10);
        list2.add(20);

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(10);
        list3.add(20);

        list1.addAll(list2);
        System.out.println(list1);

        list1.removeAll(list3);
        System.out.println(list1);
        //Removing by VALUE
    }

}
