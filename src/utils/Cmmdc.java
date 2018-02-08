package utils;

public class Cmmdc {
    public static int cmmdc(int a, int b)
    {
        if (a < b)
        {
            int aux = b;
            b = a;
            a = aux;
        }
        if (a == b)
        {
            return a;
        }
        int r;
        while ( b!=0 )
        {
            r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}
