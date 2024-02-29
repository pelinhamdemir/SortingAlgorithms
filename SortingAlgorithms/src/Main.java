import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String nameOfFile = "integers.txt";
        File inputFile = new File(nameOfFile);
        int[] setOriginal = reader(nameOfFile);
        int[] setP = reader(nameOfFile);

        System.out.println("Integers are reading from the integers.txt file, the array is:");
        getting(setP);
        sort(setP);

        System.out.println();
        System.out.println("The array has been sorted in increasing order by using the insertion sort algorithm:");
        getting(setP);

        System.out.println();
        System.out.print("Step 1 has been completed.");
        System.out.println("\n");
        System.out.println("The array of integers that has been sorted in decreasing order by using the insertion sort algorithm:");
        SortingByDesc(setP);
        getting(setP);

        System.out.println();
        System.out.println("Step 2 has been completed.");

        System.out.println();
        String nameOfFile2 = "doubles.txt";
        File inputFile2 = new File(nameOfFile2);
        double[] setE = readerDouble(nameOfFile2);
        System.out.println("Doubles are reading from the doubles.txt file, the array is:");
        getting(setE);
        sortDouble(setE);

        System.out.println();
        System.out.print("The array of double values has been sorted in increasing order by using the insertion sort algorithm:");
        System.out.println();
        getting(setE);

        System.out.println();
        System.out.println("Step 3 has been completed.");

        System.out.println();
        String nameOfFile3 = "integers.txt";
        File inputFile3 = new File(nameOfFile3);
        int[] setA = reader(nameOfFile3);
        System.out.println("The original array is:");
        getting(setOriginal);
        Merge.sıralama2(setA);

        System.out.println();
        System.out.println("The array of integer values has been sorted in descending order by using the merge sort algorithm is:");
        getting(setA);

        System.out.println();
        System.out.println("Step 4 has been completed.");

        System.out.println();
        String nameOfFile4 = "student.txt";
        File inputFile4 = new File(nameOfFile4);
        Student[] students1 = StudentFileRead(nameOfFile4);
        Quick.sort(students1);
        for(int i=0;i< students1.length;i++) {
            System.out.println(students1[i].getID_num() + ": " + students1[i].getName() + " " + students1[i].getNumberOfsomester());
        }
        System.out.println();
        System.out.println("Step 6 has been completed.");

        System.out.println();
        String nameOfFile5 = "student.txt";
        File inputFile5 = new File(nameOfFile5);
        Student[] students2 = StudentFileRead(nameOfFile5);
        for(int i=0;i< students1.length;i++) {
            System.out.println(students1[students2.length - 1 - i].getID_num() + ": " + students1[students2.length - 1 - i].getName() + " " + students1[students2.length - 1 - i].getNumberOfsomester());
        }

        System.out.println();
        System.out.println("Step 7 has been completed.");



    }


    public static void getting(double[] p){
        for(int i=0;i<p.length;i++){

            System.out.print(p[i]+" ");
        }
    }
    public static void getting(int[] p){
        for(int i=0;i<p.length;i++){

            System.out.print(p[i]+" ");
        }
    }

    public static void sort(int[] a) {  //using insertion sort, if the last index smaller it does the swapping operation

        int N = a.length;
        for (int i = 0; i < N; i++)
            for (int j = i; j > 0; j--)
                if (a[j]<a[j-1])
                    exch(a, j, j - 1);
                else break;
    }
    public static void SortingByDesc(int[] a){  // uses basic insertion sort for the first step, then swaps indexes with the tail index//
        int N = a.length;
        int temp;
        for (int i = 0; i < N; i++){
            for (int j = i; j > 0; j--){
                if (a[j]<a[j-1])
                    exch(a, j, j - 1);}}

        for(int i = 0 ; i<N/2;i++){
            temp = a[i];
            a[i] = a[N-1-i];
            a[N-1-i] = temp;

        }

    }
    public static void sortDouble(double[] p) {  //using insertion sort, if the last index smaller it does the swapping operation.
        int N = p.length;
        for (int i = 0; i < N; i++)
            for (int j = i; j > 0; j--)
                if (p[j]< p[j-1])
                    exchDouble(p, j, j - 1);
                else break;
    }
    private static boolean less(Comparable v, Comparable w)
    { return v.compareTo(w) < 0; }

    private static void exchDouble(double[] a, int i, int j)
    {
        double swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void exch(int[] a, int i, int j)
    {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    public static Student[] StudentFileRead(String fileName) {//reads a file containing Student information, creates a Student object for each line of data, stores them in an array of Students, and returns the array.

        Student[] students = new Student[10];
        try {
            File file = new File(fileName);
            Scanner keyboard = new Scanner(file);
            int index = 0;
            while (keyboard.hasNextLine()) {
                String line = keyboard.nextLine();
                String[] tokens = line.split(",");

                String name = tokens[0].trim();
                long id = Long.parseLong(tokens[1].trim());
                int numberOfsomester = Integer.parseInt(tokens[2].trim());

                Student student = new Student(name, id, numberOfsomester);
                students[index++] = new Student(name, id, numberOfsomester);

            }

            keyboard.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        return students;}


    public static int[] reader(String file){//reads an input file that contains an integer size followed by a sequence of integers and returns an array of integers containing the read elements, or null if the file is not found.
        File nameofFile = new File(file);
        try {
            Scanner reader = new Scanner(nameofFile);
            int size = reader.nextInt();
            reader.nextLine(); // consume the first line
            int[] array = new int[size];

            int index = 0;
            while (reader.hasNextLine()) {
                for (int j = 0; j < size; j++) {
                    array[index] = reader.nextInt();
                    index++;}}
            reader.close();
            return array;
        } catch (FileNotFoundException e) {
            return null;}
    }
    public static double[] readerDouble(String file){
        File nameofFile = new File(file);
        try {
            Scanner reader = new Scanner(nameofFile);
            int size = reader.nextInt();

            reader.nextLine(); // consume the first line
            double[] array = new double[size];

            int index = 0;
            while (reader.hasNextLine()) {
                for (int j = 0; j < size; j++) {
                    String token = reader.next();
                    array[index] = Double.parseDouble(token);
                    index++;}
            }reader.close();
            return array;
        } catch (FileNotFoundException e) {
            return null;
        }
    }
}