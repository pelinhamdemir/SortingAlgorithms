public class Student implements Comparable<Student> {

      private long ID_num;
      private int NumberOfsomester;
      private String name;

    @Override
    public int compareTo(Student student2) {//compares two Student objects based on their name, ID number, and number of semesters, returning 1 if the current object is greater, -1 if it is less, and 0 if they are equal.
        int compareName = this.name.compareTo(student2.name);
        if (compareName != 0) {
            return compareName;
        }
        if (this.ID_num > student2.ID_num) {return 1;
        }
        else if (this.ID_num < student2.ID_num) {return -1;
        }
        if (this.NumberOfsomester > student2.NumberOfsomester) {return 1;
        }
        else if (this.NumberOfsomester < student2.NumberOfsomester) {return -1;
        }
        return 0;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumberOfsomester(int NumberOfsomester) {this.NumberOfsomester = NumberOfsomester;
    }
    public int getNumberOfsomester() {
        return NumberOfsomester;
    }


    public void setID_num(long ID_num) {
        this.ID_num = ID_num;
    }

    public long getID_num() {return ID_num;
    }

    public Student(String name, long ID_num, int NumberOfsomester) {
        this.name = name;
        this.NumberOfsomester = NumberOfsomester;
        this.ID_num = ID_num;

    }


    public static void sort(Student[] a, Comparator comparator)//using insertion sort algorithm based on a specified Comparator
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
            for (int j = i; j > 0 && less(comparator, a[j], a[j-1]); j--)
                exch(a, j, j-1);
    }

    private static boolean less(Comparator c, Object v, Object w)
    { return c.compare(v, w) < 0; }
    private static void exch(Object[] a, int i, int j)
    { Object swap = a[i]; a[i] = a[j]; a[j] = swap; }




}