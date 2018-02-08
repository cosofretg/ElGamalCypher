package decrypt;

import utils.Pow;

import java.util.ArrayList;
import java.util.List;
public class Shanks {
    private List<Integer> L1 = new ArrayList<>();
    private List<Integer> L2 = new ArrayList<>();

    public void ConstructL1(int p,int g)
    {
        double mD = Math.sqrt(p-1);
        int m = (int)mD+1;
        int var = Pow.pow(g,m,p)%p;
        //System.out.println(Pow.pow(g,m,p));

        int val = 1;
        for (int j=1;j<=m-1;j++)
        {
            L1.add((int)val);
            val = (val*var)%p;
        }
        L1.add((int)val);
    }
    public void ConstructL2(int p,int g,int y)
    {
        double mD = Math.sqrt(p-1);
        int m = (int)mD+1;

        double frac = inversModular(g,p);
        if (frac == -1)
        {
            System.out.println("Nu am gasit inversul modular");
        }
        else {
            //System.out.println(frac);
            double c = 1;
            double val = y;
            for (int i = 1; i <= m - 1; i++) {

                L2.add((int) val);
                c = (c * frac) % p;

                val = (y * c) % p;
            }
            L2.add((int) val);
        }
    }
    public int ShanksAlgoritm(int g,int y,int p)
    {
        ConstructL1(p,g);
        ConstructL2(p,g,y);
        int i = 0;
        int j;
        boolean ok = false;
        for (j=0;j<L1.size();j++)
        {
            if (L2.contains(L1.get(j)))
            {
                i = L2.lastIndexOf(L1.get(j));
                ok = true;
                break;
            }
        }
        if (ok == true) {
            double mD = Math.sqrt(p - 1);
            int m = (int) mD + 1;
            int rez = (m * j + i) % (p - 1);
            return rez;
        }
        return -1;
    }
    public int inversModular(int a,int p)
    {

        for (int i = 1;i<=p-1;i++)
        {
            int val = a*i;
            int rez = val%p;
            if (rez==1)
            {
                return i;
            }
        }
        return -1;


    }

    public void printList1()
    {
        for (int i=0;i<L1.size();i++)
        {
            System.out.println("("+i+","+L1.get(i)+")");
        }
    }

    public void printList2()
    {
        for (int i=0;i<L2.size();i++)
        {
            System.out.println("("+i+","+L2.get(i)+")");
        }
    }

}
