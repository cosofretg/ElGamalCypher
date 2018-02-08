package decrypt;

import java.util.*;

public class IndexCalculus {

    private List<Integer> basePrimNumbers = new ArrayList<>();
    private HashMap<Integer,Integer> logVal = new HashMap<>();
    private List<Integer> SolutionList = new ArrayList<>();
    private List<Integer> NeWbasePrimNumbers = new ArrayList<>();

    public void generateBase(int dimension)
    {
        int i = 0;
        int nr = 2;
        while(i<dimension)
        {
            if (isPrim(nr)==true)
            {
                basePrimNumbers.add(nr);
                i++;
            }
            nr++;
        }
    }
    public boolean isPrim(int nr)
    {
        boolean ok = true;
        for (int i=2;i<=nr/2;i++)
        {
            if (nr%i == 0)
            {
                ok = false;
            }
        }
        return ok;
    }
    public void printList()
    {
        for (int i=0;i<basePrimNumbers.size();i++)
        {
            System.out.println(basePrimNumbers.get(i));
        }
    }

    public int indexCalculusLog(int g, int p, int y, int dim)
    {
        generateBase(dim);
        for (int i = 0;i<basePrimNumbers.size();i++)
        {
            if (g == basePrimNumbers.get(i))
            {
                logVal.put(basePrimNumbers.get(i),1);
                basePrimNumbers.remove(i);
            }
            else
            {
                while (true) {
                    Random random = new Random();
                    int randNumb = random.nextInt(p - 1);
                    int sol = (int)Math.pow(g,randNumb)%p;

                    if (isSolution(sol))
                    {
                        SolutionList.add(randNumb);
                        break;
                    }
                }

            }
            NeWbasePrimNumbers.add(basePrimNumbers.get(i));
        }
        SolverSistem solverSistem = new SolverSistem(basePrimNumbers.size(),basePrimNumbers.size());
        List<Integer> sol = solverSistem.solveSistem(basePrimNumbers,SolutionList);
        for (int i=0;i<basePrimNumbers.size();i++)
        {
            logVal.put(basePrimNumbers.get(i),sol.get(i)%(p-1));
        }

        while (true) {
            Random random = new Random();
            int randNumb = random.nextInt(p - 1);
            int sol2 = y*(int) Math.pow(g, randNumb) % p;
            if (isSolution(sol2)) {
                return calc_val(sol2);
            }
        }
    }
    public int calc_val(int s)
    {

            int sol = 0;
            for (int i : NeWbasePrimNumbers) {

                int rest = 0;
                int cons = 0;
                while (rest == 0) {
                    s = s / i;
                    rest = s % i;
                    cons++;
                }
                sol = sol + cons*logVal.get(i);
            }
            return sol;

    }
    public boolean isSolution(int sol)
    {
        for (int i:basePrimNumbers)
        {
            int res = 0;

            while (res == 0)
            {
                sol = sol/i;
                res = sol%i;

            }
            if (sol == 1)
            {
                return true;
            }
        }
            return false;
    }

}
