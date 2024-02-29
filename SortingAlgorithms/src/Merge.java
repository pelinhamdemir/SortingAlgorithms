public class Merge {


    //get the array divided into two parts,sort by themselves,get the both side compared and repeat sorting

    private static void Merge(int[] p, int[] temp, int low, int mid, int hi)
    {
        for (int k = low; k <= hi; k++)
            temp[k] = p[k];
        int i = low;
        int j = mid+1;

        for (int e = low; e <= hi; e++)
        {

            if (j > hi)
                p[e] = temp[i++];
            else if (i > mid)
                p[e] = temp[j++];
            else if (less(temp[j], temp[i]))
                p[e] = temp[j++];
            else
                p[e] = temp[i++];
        }
    }


    private static void sıralama(int[] a, int[] aux, int lo, int hi)
    {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sıralama(a, aux, lo, mid);
        sıralama(a, aux, mid+1, hi);
        Merge(a, aux, lo, mid, hi);
        int N= a.length ;
    }

    private static boolean less(int v, int w)
    { return v-w < 0; }


    public static void sıralama2(int[] p)
    {
        int [] aux = new int[p.length];
        int N= p.length ;

        sıralama(p,aux,0,p.length - 1);

        for(int i = 0 ; i<N/2;i++){
            int temp = p[i];
            p[i] = p[N-1-i];
            p[N-1-i] = temp;
        }
    }


}