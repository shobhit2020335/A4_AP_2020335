package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Random;
import java.util.StringTokenizer;

class scn {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /**
     * call this method to initialize reader for InputStream
     */
    static void init() {
        reader = new BufferedReader(
                new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
    }

    /**
     * get next word
     */
    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static String nextLine() throws IOException {
        return reader.readLine();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }



    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}

class library<t1, t2, t3> {
    t1 title;
    t2 isbn;
    t3 barcode;

    public library(t1 title, t2 isbn, t3 barcode) {
        this.title = title;
        this.isbn = isbn;
        this.barcode = barcode;
    }
}

class library1 extends library {
    private final int slotno;
    private final int rackno;

    public library1(Object title, Object isbn, Object barcode, int slotno, int rackno) {
        super(title, isbn, barcode);
        this.slotno = slotno;
        this.rackno = rackno;
    }
    public int getSlotno() {
        return slotno;
    }
    public int getRackno() {
        return rackno;
    }
}

public class Main {
    public static long getbarcode() {


        long number;
        Random rand = new Random();
        number = (rand.nextInt(1000000) + 1000000000L) * (rand.nextInt(900) + 100);
        return number;
    }

    public static void main(String[] args) throws IOException {
        scn.init();
        LinkedList<library> l1 = new LinkedList<>();
        LinkedList<library1> lib1 = new LinkedList<>();
        System.out.print("ENTER NUMBER OF BOOKS: ");
        int n = scn.nextInt();
        System.out.print("ENTER NUMBER OF RACKS: ");

        int k = scn.nextInt();
        System.out.println();
        int slot = n / k;
        String title;
        long isbn;
        long barcode;
        if (n % k != 0) {
            System.out.println("INVALID INPUT");
        } else {
            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= slot; j++) {
                    System.out.print("ENTER TITLE OF BOOK: ");
                    title = scn.nextLine();
                    boolean check=false;
                    for(int x=0;x<title.length();x++){
                        char ch=title.charAt(x);
                        if(Character.isLowerCase(ch)){
                            System.out.println("---INVALID TITLE");
                            System.out.println("TITLE SHOULD BE IN CAPITAL LETTERS");
                            check=true;
                            break;
                        }
                    }
                    if(check){
                        j-=1;
                        continue;
                    }
                    System.out.print("ENTER ISBN NUMBER OF BOOK: ");
                    isbn = scn.nextLong();
                    System.out.println("--------------------------------");
                    long isbn2 = isbn;
                    int count = 0;
                    while (isbn2 != 0) {
                        isbn2 = isbn2 / 10;
                        count++;
                    }
                    if (count != 1) {
                        System.out.println("---INVALID ISBN NUMBER---");
                        j -= 1;
                        continue;
                    }
                    barcode = getbarcode();
                    library<String, Long, Long> lib = new library<>(title, isbn, barcode);
                    l1.add(lib);
                }
            }
        }
        String temp;
        long is1, is2;
        long bd1, bd2;
        String ttl1, ttl2;
        for (int i = 0; i < l1.size(); i++) {
            for (int j = i + 1; j < l1.size(); j++) {
                ttl1 = (String) l1.get(i).title;
                ttl2 = (String) l1.get(j).title;
                if (ttl1.compareTo(ttl2) > 0) {
                    temp = (String) l1.get(i).title;
                    l1.get(i).title = l1.get(j).title;
                    l1.get(j).title = temp;
                    is1 = (long) l1.get(i).isbn;
                    l1.get(i).isbn = l1.get(j).isbn;
                    l1.get(j).isbn = is1;
                    bd1 = (long) l1.get(i).barcode;
                    l1.get(i).barcode = l1.get(j).barcode;
                    l1.get(j).barcode = bd1;
                }
            }
        }
        String temp1;
        String temp2;
        long is3, bd3;
        for (int i = 0; i < l1.size(); i++) {
            for (int j = i + 1; j < l1.size(); j++) {
                if (l1.get(i).title.equals(l1.get(j).title)) {
                    if ((long) l1.get(i).isbn > (long) l1.get(j).isbn) {
                        temp1 = (String) l1.get(i).title;
                        l1.get(i).title = l1.get(j).title;
                        l1.get(j).title = temp1;

                        is2 = (long) l1.get(i).isbn;
                        l1.get(i).isbn = l1.get(j).isbn;
                        l1.get(j).isbn = is2;
                        bd2 = (long) l1.get(i).barcode;
                        l1.get(i).barcode = l1.get(j).barcode;
                        l1.get(j).barcode = bd2;
                    }
                    if (l1.get(i).isbn == l1.get(j).isbn) {
                        if ((long) l1.get(i).barcode > (long) l1.get(j).barcode) {
                            temp2 = (String) l1.get(i).title;
                            l1.get(i).title = l1.get(j).title;
                            l1.get(j).title = temp2;

                            is3 = (long) l1.get(i).isbn;
                            l1.get(i).isbn = l1.get(j).isbn;
                            l1.get(j).isbn = is3;
                            bd3 = (long) l1.get(i).barcode;
                            l1.get(i).barcode = l1.get(j).barcode;
                            l1.get(j).barcode = bd3;
                        }
                    }
                }
            }
        }
        int slot1 = l1.size() / k;
        int count1 = 0;
        int count2 = 1;
        int[] arr1 = new int[l1.size()];
        int[] arr = new int[l1.size()];
        for (int i = 0; i < arr.length; i++) {
            count1 += 1;
            if (count1 > slot1) {
                count1 = 1;
                count2 += 1;
            }
            arr[i] = count1;
            arr1[i] = count2;
        }
        for (int i = 0; i < arr.length; i++) {
            library1 lib2 = new library1(l1.get(i).title, l1.get(i).isbn, l1.get(i).barcode, arr[i], arr1[i]);
            lib1.add(lib2);
        }
        if (lib1.size() > 0){
            System.out.println("SLOT FOR EVERY BOOK IS AS FOLLOWS: ");
        for (int i = 0; i < l1.size(); i++) {
            System.out.println("SLOT NO. " + lib1.get(i).getSlotno() + " IN RACK " + lib1.get(i).getRackno() + "--> BOOK TITLE: " + lib1.get(i).title + " ISBN NUMBER: " + lib1.get(i).isbn + " BARCODE: " + lib1.get(i).barcode);
        }
        System.out.println("-----OR-----");
        while (true) {
            System.out.println("PRESS 1 TO SEARCH SLOT FOR A SPECIFIC BOOK AND 2 FOR EXIT: ");
            int input = scn.nextInt();
            String ttl3;
            long bc;
            if (input == 1) {
                System.out.println("ENTER BOOK TITLE: ");
                ttl3 = scn.nextLine();
                System.out.println("ENTER BARCODE NUMBER OF BOOK: ");
                bc = scn.nextLong();
                for (int i = 0; i < lib1.size(); i++) {
                    if (ttl3.equals(lib1.get(i).title) && bc == (long) lib1.get(i).barcode) {
                        System.out.println("---SLOT NO. " + lib1.get(i).getSlotno() + " IN RACK " + lib1.get(i).getRackno() + "---");
                    }
                }
            }
            if (input == 2) {
                break;
            } else if (input > 2) {
                System.out.println("INVALID INPUT");
            }
        }
    }
        else{
            System.out.println("NO BOOK FOUND");

        }
        System.out.println("--------------------------------\n--------------------------------");
    }
}

