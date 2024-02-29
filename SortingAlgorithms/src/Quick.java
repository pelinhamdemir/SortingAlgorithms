import java.util.Random;

public class Quick {

    //partitions an array into smaller sub-arrays, recursively sorts them, and combines them to form a sorted output.

    public static int partition(Student[] students, int left, int right) {
        Student pivot = students[right];
        int p = left - 1;
        for (int j = left; j < right; j++) {
            if (students[j].getID_num()-students[right].getID_num() < 0) {
                p++;
                swap(students, p, j);
            }
            if (students[j].getID_num()-students[right].getID_num() == 0) {
                if(students[j].getNumberOfsomester()- students[right].getNumberOfsomester()<0){
                    p++;
                    swap(students, p, j);
                }
                if(students[j].getNumberOfsomester()- students[right].getNumberOfsomester()==0){
                    if(students[j].getName().compareTo(students[right].getName())<0){
                        p++;
                    swap(students, p, j);
                    }
                }

            }
        }
        swap(students, p + 1, right);
        return p + 1;
    }

    public static void quickSort(Student[] students, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(students, left, right);
            quickSort(students, left, pivotIndex - 1);
            quickSort(students, pivotIndex + 1, right);
        }
    }


    public static void swap(Student[] students, int i, int j) {
        Student temp = students[i];
        students[i] = students[j];
        students[j] = temp;
    }
    static Random uniform = new Random();

    private static void exch(Student[] a, int i, int j)
    {
        Student swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void shuffle(Student[] p)
    {
        int N = p.length;
        for (int i = 0; i < N; i++)
        {
            int r = uniform.nextInt(i+1);
            exch(p, i, r);
        }
    }
    public static void sort(Student[] p)
    {
        shuffle(p);
        quickSort(p, 0, p.length - 1);
    }
}
