package decrypt;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
public class SolverSistem {
    private int[][] SistemMatrix;
    private int[][] BMatrix;
    private int[][] solMatrix;

    public SolverSistem(int colSize, int linSize) {
        SistemMatrix = new int[linSize][colSize];
        BMatrix = new int[linSize][1];
        solMatrix = new int[linSize][1];
    }

    public void setMatrix(List<Integer> PrimList, List<Integer> solList)
    {
        int col = 0;
        int lin = 0;
        for (int rez:solList) {

            for (int i : PrimList) {

                int rest = 0;
                int cons = 0;
                while (rest == 0) {
                    rez = rez / i;
                    rest = rez % i;
                    cons++;
                }

                SistemMatrix[lin][col] = cons;
                col++;
            }
            BMatrix[lin][0] = rez;
            lin++;
        }
    }
    public List solveSistem(List<Integer> PrimList, List<Integer> solList)
    {
        setMatrix(PrimList,solList);
        solMatrix = multiplyMatrices(BMatrix,invertMatrix());
        List sol = new ArrayList();
        for (int i=0;i<solMatrix.length;i++)
        {
            sol.add(solMatrix[i][0]);
        }
        return sol;
    }
    public int[][] invertMatrix () {
        int[][] auxiliaryMatrix, invertedMatrix;
        int[] index;

        auxiliaryMatrix = new int[SistemMatrix.length][SistemMatrix.length];
        invertedMatrix = new int[SistemMatrix.length][SistemMatrix.length];
        index = new int[SistemMatrix.length];

        for (int i = 0; i < SistemMatrix.length; ++i) {
            auxiliaryMatrix[i][i] = 1;
        }

        transformToUpperTriangle (SistemMatrix, index);

        for (int i = 0; i < (SistemMatrix.length - 1); ++i) {
            for (int j = (i + 1); j < SistemMatrix.length; ++j) {
                for (int k = 0; k < SistemMatrix.length; ++k) {
                    auxiliaryMatrix[index[j]][k] -= SistemMatrix[index[j]][i] * auxiliaryMatrix[index[i]][k];
                }
            }
        }

        for (int i = 0; i < SistemMatrix.length; ++i) {
            invertedMatrix[SistemMatrix.length - 1][i] = (auxiliaryMatrix[index[SistemMatrix.length - 1]][i] / SistemMatrix[index[SistemMatrix.length - 1]][SistemMatrix.length - 1]);

            for (int j = (SistemMatrix.length - 2); j >= 0; --j) {
                invertedMatrix[j][i] = auxiliaryMatrix[index[j]][i];

                for (int k = (j + 1); k < SistemMatrix.length; ++k) {
                    invertedMatrix[j][i] -= (SistemMatrix[index[j]][k] * invertedMatrix[k][i]);
                }

                invertedMatrix[j][i] /= SistemMatrix[index[j]][j];
            }
        }

        return (invertedMatrix);
    }
    public void transformToUpperTriangle (int[][] matrix, int[] index) {
        double[] c;
        int c0, c1, pi0, pi1, pj;
        int itmp, k;

        c = new double[matrix.length];

        for (int i = 0; i < matrix.length; ++i) {
            index[i] = i;
        }

        for (int i = 0; i < matrix.length; ++i) {
            c1 = 0;

            for (int j = 0; j < matrix.length; ++j) {
                c0 = Math.abs (matrix[i][j]);

                if (c0 > c1) {
                    c1 = c0;
                }
            }

            c[i] = c1;
        }

        k = 0;

        for (int j = 0; j < (matrix.length - 1); ++j) {
            pi1 = 0;

            for (int i = j; i < matrix.length; ++i) {
                pi0 = Math.abs (matrix[index[i]][j]);
                pi0 /= c[index[i]];

                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;

            for (int i = (j + 1); i < matrix.length; ++i) {
                pj = matrix[index[i]][j] / matrix[index[j]][j];
                matrix[index[i]][j] = pj;

                for (int l = (j + 1); l < matrix.length; ++l) {
                    matrix[index[i]][l] -= pj * matrix[index[j]][l];
                }
            }
        }
    }
    public static int[][] multiplyMatrices (int[][] x, int[][] y) {
        int[][] result;
        int xColumns, xRows, yColumns, yRows;

        xRows = x.length;
        xColumns = x[0].length;
        yRows = y.length;
        yColumns = y[0].length;
        result = new int[xRows][yColumns];

        if (xColumns != yRows) {
            throw new IllegalArgumentException (
                    MessageFormat.format ("Matrices don't match: {0} != {1}.", xColumns, yRows));
        }


        for (int i = 0; i < xRows; i++) {
            for (int j = 0; j < yColumns; j++) {
                for (int k = 0; k < xColumns; k++) {
                    result[i][j] += (x[i][k] * y[k][j]);
                }
            }
        }

        return (result);
    }




}
