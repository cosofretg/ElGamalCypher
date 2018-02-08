package decrypt;

import utils.Cmmdc;
import utils.Pow;
import utils.Triplet;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class PollardRho {
    private List<Triplet> listi = new ArrayList<>();
    private List<Triplet> list2i = new ArrayList<>();
    public int partitionare(int x)
    {
        int s = x%3;
        if (s==1)
        {
            return 1;
        }
        if (s==0)
        {
            return 2;
        }
        if (s==2)
        {
            return 3;
        }
        return -1;
    }
    public Triplet function(Triplet t,int p,int y,int g)
    {
        Triplet tNew = new Triplet();
        int part = partitionare(t.getX());
        switch (part) {
            case 1:
                {
                int x = (y * t.getX())%p;
                x = x%p;
                int a = t.getA();
                int b = t.getB() + 1;
                tNew.setX(x);
                tNew.setA(a);
                tNew.setB(b);
                break;
            }
            case 2:
            {
                int x = (t.getX()*t.getX())%p; //de verificat

                int a = 2*t.getA();
                int b = 2*t.getB();
                tNew = new Triplet(x,a,b);
                tNew.setX(x);
                tNew.setA(a);
                tNew.setB(b);
                break;
            }
            case 3:
            {
                int x = (g*t.getX())%p;
                int a = t.getA()+1;
                int b = t.getB();
                tNew = new Triplet(x,a,b);
                tNew.setX(x);
                tNew.setA(a);
                tNew.setB(b);
                break;
            }
        }
        return tNew;
    }
    public int PollardRhoAlgoritm(int y,int g,int p)
    {
        Triplet next = new Triplet(1,0,0);
        int n = ordinElemGrup(g,p);
        listi.add(next);
        int i=0;
        while (true)
        {

            next = function(next,p,y,g);
            i++;
            listi.add(next);
            System.out.println(next.getX()+" "+next.getA()+" "+next.getB());
            if (i%2==0)
            {
                if (listi.get(i).getX()==listi.get(i/2).getX())
                {
                    int a = (listi.get(i/2).getA()-listi.get(i).getA())%n;
                    int b = (listi.get(i).getB()-listi.get(i/2).getB())%n;
                    if (Cmmdc.cmmdc(b,n)==1)
                    {
                        if (a<0)
                        {
                           a = n+a;
                        }
                        int c = (a*inversModular(b,n))%n;

                        return c;
                    }
                    else {
                        return -1;
                    }
                }
            }
        }
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
    public int ordinElemGrup(int g, int p)
    {
        int i=1;
        while (true)
        {
            int e = Pow.pow(g,i,p);
            if (e == 1)
            {
                return i;
            }
            i++;
        }


    }
}
