//import com.company.library;

//import com.company.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}


class greymatrix<t1, t2> {

    private final t1 row;
    private final t2 col;
    private final int[][] mat;


    public greymatrix(t1 row, t2 col, int[][] mat) {
        this.row = row;
        this.col = col;
        this.mat = mat;

    }

    public t1 getRow() {
        return row;
    }

    public t2 getCol() {
        return col;
    }

    public int[][] getMat() {
        return mat;
    }
}

class colormatrix<t1, t2> {

    private final t1 row;
    private final t2 col;
    private final int[][] redmat;
    private final int[][] greenmat;
    private final int[][] bluemat;


    public colormatrix(t1 row, t2 col, int[][] redmat, int[][] greenmat, int[][] bluemat) {
        this.row = row;
        this.col = col;
        this.redmat = redmat;
        this.greenmat = greenmat;
        this.bluemat = bluemat;


    }

    public t1 getRow() {
        return row;
    }

    public t2 getCol() {
        return col;
    }

    public int[][] getRedmat() {
        return redmat;
    }

    public int[][] getGreenmat() {
        return greenmat;
    }

    public int[][] getBluemat() {
        return bluemat;
    }
}

public class QUESTION2 {
    static public int random() {


        int min = 0;
        int max = 1;
        int random = (int) (Math.random() * (max - min + 1) + min);
        return random;
    }

    public static void display(int row, int col, int[][] matrix) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        LinkedList<greymatrix> graymat = new LinkedList<>();
        LinkedList<colormatrix> colormat = new LinkedList<>();
        scn.init();
        System.out.println("1. CREATE MATRICES\n2. INPUT MATRICES\n3. UPDATE MATRICES\n4. DISPLAY MATRICES\n5. COMPUTE AND DISPLAY NEGATIVES\n6. EXIT");
        System.out.println("---------------------------------");
        while (true) {
            int input = scn.nextInt();
            if (input == 1) {
                System.out.println("1.GRAYSCALE IMAGE\n2.COLOR IMAGE\n");
                System.out.print("ENTER OPTION: ");
                int type = scn.nextInt();
                if (type == 1) {
                    System.out.print("ENTER NUMBER OF ROW: ");
                    int row = scn.nextInt();
                    System.out.print("ENTER NUMBER OF COLUMN: ");
                    int col = scn.nextInt();
                    int[][] mat = new int[row][col];
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            mat[i][j] = random();
                        }
                    }
                    greymatrix<Integer, Integer> gmatrix1 = new greymatrix<>(row, col, mat);
                    graymat.add(gmatrix1);
                }
                if (type == 2) {
                    System.out.print("ENTER NUMBER OF ROW: ");
                    int row = scn.nextInt();
                    System.out.print("ENTER NUMBER OF COLUMN: ");
                    int col = scn.nextInt();
                    int[][] rmat = new int[row][col];
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            rmat[i][j] = random();
                        }
                    }
                    int[][] gmat = new int[row][col];
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            gmat[i][j] = random();
                        }
                    }
                    int[][] bmat = new int[row][col];
                    for (int i = 0; i < row; i++) {
                        for (int j = 0; j < col; j++) {
                            bmat[i][j] = random();
                        }
                    }
                    colormatrix<Integer, Integer> cmatrix1 = new colormatrix<>(row, col, rmat, gmat, bmat);
                    colormat.add(cmatrix1);
                }
            }
            if (input == 2) {
                System.out.println("1.GRAYSCALE IMAGE\n2.COLOR IMAGE\n");
                System.out.print("ENTER OPTION: ");

                int type = scn.nextInt();
                int type1;
                if (type == 1) {
                    for (int i = 0; i < graymat.size(); i++) {
                        type1 = i + 1;
                        System.out.println("----MATRIX ID: " + type1 + "----");
                        System.out.println("SIZE OF MATRIX--> " + graymat.get(i).getRow() + "X" + graymat.get(i).getCol());
                        System.out.println("-----------------------------------------------------------------");
                    }
                    System.out.print("ENTER ID OF MATRIX: ");
                    int choice = scn.nextInt();
                    for (int i = 0; i < graymat.size(); i++) {
                        if (choice == (i + 1)) {

                            int r = (int) graymat.get(i).getRow();
                            int c = (int) graymat.get(i).getCol();
                            int[][] gm = new int[r][c];
                            System.out.println("ENTER " + (r * c) + " ELEMENTS OF MATRIX: ");
                            for (int j = 0; j < r; j++) {
                                for (int k = 0; k < c; k++) {
                                    gm[j][k] = scn.nextInt();
                                    if (gm[j][k] < 0 || gm[j][k] > 255) {
                                        System.out.println("---INVALID INPUT---");
                                        System.out.println("ELEMENT SHOULD BE IN RANGE(0-255)");
                                        k -= 1;
                                        continue;
                                    }
                                }
                            }
                            for (int j = 0; j < r; j++) {
                                for (int k = 0; k < c; k++) {
                                    graymat.get(i).getMat()[j][k] = gm[j][k];
                                }
                            }

                        }
                    }


                }
                if (type == 2) {
                    for (int i = 0; i < colormat.size(); i++) {
                        type1 = i + 1;
                        System.out.println("----MATRIX ID: " + type1 + "----");
                        System.out.println("SIZE OF MATRIX--> " + colormat.get(i).getRow() + "X" + colormat.get(i).getCol());
                        System.out.println("-----------------------------------------------------------------");
                    }
                    System.out.print("ENTER ID OF MATRIX: ");
                    int choice = scn.nextInt();
                    for (int i = 0; i < colormat.size(); i++) {
                        if (choice == (i + 1)) {

                            int cr = (int) colormat.get(i).getRow();
                            int cc = (int) colormat.get(i).getCol();
                            int[][] rm = new int[cr][cc];
                            System.out.println("ENTER " + (cr * cc) + " ELEMENTS FOR R MATRIX: ");
                            for (int j = 0; j < cr; j++) {
                                for (int k = 0; k < cc; k++) {
                                    rm[j][k] = scn.nextInt();
                                    if (rm[j][k] < 0 || rm[j][k] > 255) {
                                        System.out.println("---INVALID INPUT---");
                                        System.out.println("ELEMENT SHOULD BE IN RANGE(0-255)");
                                        k -= 1;
                                        continue;
                                    }
                                }
                            }
                            for (int j = 0; j < cr; j++) {
                                for (int k = 0; k < cc; k++) {
                                    colormat.get(i).getRedmat()[j][k] = rm[j][k];
                                }
                            }

                            int[][] greenm = new int[cr][cc];
                            System.out.println("ENTER " + (cr * cc) + " ELEMENTS FOR G MATRIX: ");
                            for (int j = 0; j < cr; j++) {
                                for (int k = 0; k < cc; k++) {
                                    greenm[j][k] = scn.nextInt();
                                    if (greenm[j][k] < 0 || greenm[j][k] > 255) {
                                        System.out.println("---INVALID INPUT---");
                                        System.out.println("ELEMENT SHOULD BE IN RANGE(0-255)");
                                        k -= 1;
                                        continue;
                                    }
                                }
                            }
                            for (int j = 0; j < cr; j++) {
                                for (int k = 0; k < cc; k++) {
                                    colormat.get(i).getGreenmat()[j][k] = greenm[j][k];
                                }
                            }

                            int[][] bm = new int[cr][cc];
                            System.out.println("ENTER " + (cr * cc) + " ELEMENTS FOR B MATRIX: ");
                            for (int j = 0; j < cr; j++) {
                                for (int k = 0; k < cc; k++) {
                                    bm[j][k] = scn.nextInt();
                                    if (bm[j][k] < 0 || bm[j][k] > 255) {
                                        System.out.println("---INVALID INPUT---");
                                        System.out.println("ELEMENT SHOULD BE IN RANGE(0-255)");
                                        k -= 1;
                                        continue;
                                    }
                                }
                            }
                            for (int j = 0; j < cr; j++) {
                                for (int k = 0; k < cc; k++) {
                                    colormat.get(i).getBluemat()[j][k] = bm[j][k];
                                }
                            }
                        }
                    }
                }

            }
            if (input == 3) {
                System.out.println("1.GRAYSCALE IMAGE\n2.COLOR IMAGE\n");
                System.out.print("ENTER OPTION: ");
                int type = scn.nextInt();
                int type1;
                if (type == 1) {
                    for (int i = 0; i < graymat.size(); i++) {
                        type1 = i + 1;
                        System.out.println("----MATRIX ID: " + type1 + "----");
                        display((int) graymat.get(i).getRow(), (int) graymat.get(i).getCol(), graymat.get(i).getMat());
                        System.out.println("-----------------------------------------------------------------");
                    }
                    System.out.print("ENTER ID OF MATRIX TO UPDATE: ");
                    int choice = scn.nextInt();
                    for (int i = 0; i < graymat.size(); i++) {
                        if (choice == (i + 1)) {

                            int r = (int) graymat.get(i).getRow();
                            int c = (int) graymat.get(i).getCol();
                            int[][] gm = new int[r][c];
                            System.out.println("ENTER " + (r * c) + " ELEMENTS OF MATRIX: ");
                            for (int j = 0; j < r; j++) {
                                for (int k = 0; k < c; k++) {
                                    gm[j][k] = scn.nextInt();
                                    if (gm[j][k] < 0 || gm[j][k] > 255) {
                                        System.out.println("---INVALID INPUT---");
                                        System.out.println("ELEMENT SHOULD BE IN RANGE(0-255)");
                                        k -= 1;
                                        continue;
                                    }
                                }
                            }
                            for (int j = 0; j < r; j++) {
                                for (int k = 0; k < c; k++) {
                                    graymat.get(i).getMat()[j][k] = gm[j][k];
                                }
                            }

                        }
                    }
                }
                if (type == 2) {
                    for (int i = 0; i < colormat.size(); i++) {
                        type1 = i + 1;
                        System.out.println("----MATRIX ID: " + type1 + "----");
                        System.out.println("RED  --> ");
                        display((int) colormat.get(i).getRow(), (int) colormat.get(i).getCol(), colormat.get(i).getRedmat());
                        System.out.println("GREEN --> ");
                        display((int) colormat.get(i).getRow(), (int) colormat.get(i).getCol(), colormat.get(i).getGreenmat());
                        System.out.println("BLUE --> ");
                        display((int) colormat.get(i).getRow(), (int) colormat.get(i).getCol(), colormat.get(i).getBluemat());
                        System.out.println("-----------------------------------------------------------------");

                    }
                    System.out.print("ENTER ID OF MATRIX TO UPDATE: ");
                    int choice = scn.nextInt();
                    for (int i = 0; i < colormat.size(); i++) {
                        if (choice == (i + 1)) {

                            int cr = (int) colormat.get(i).getRow();
                            int cc = (int) colormat.get(i).getCol();
                            int[][] rm = new int[cr][cc];
                            System.out.println("ENTER " + (cr * cc) + " ELEMENTS FOR R MATRIX: ");
                            for (int j = 0; j < cr; j++) {
                                for (int k = 0; k < cc; k++) {
                                    rm[j][k] = scn.nextInt();
                                    if (rm[j][k] < 0 || rm[j][k] > 255) {
                                        System.out.println("---INVALID INPUT---");
                                        System.out.println("ELEMENT SHOULD BE IN RANGE(0-255)");
                                        k -= 1;
                                        continue;
                                    }
                                }
                            }
                            for (int j = 0; j < cr; j++) {
                                for (int k = 0; k < cc; k++) {
                                    colormat.get(i).getRedmat()[j][k] = rm[j][k];
                                }
                            }

                            int[][] greenm = new int[cr][cc];
                            System.out.println("ENTER " + (cr * cc) + " ELEMENTS FOR G MATRIX: ");
                            for (int j = 0; j < cr; j++) {
                                for (int k = 0; k < cc; k++) {
                                    greenm[j][k] = scn.nextInt();
                                    if (greenm[j][k] < 0 || greenm[j][k] > 255) {
                                        System.out.println("---INVALID INPUT---");
                                        System.out.println("ELEMENT SHOULD BE IN RANGE(0-255)");
                                        k -= 1;
                                        continue;
                                    }
                                }
                            }
                            for (int j = 0; j < cr; j++) {
                                for (int k = 0; k < cc; k++) {
                                    colormat.get(i).getGreenmat()[j][k] = greenm[j][k];
                                }
                            }

                            int[][] bm = new int[cr][cc];
                            System.out.println("ENTER " + (cr * cc) + " ELEMENTS FOR B MATRIX: ");
                            for (int j = 0; j < cr; j++) {
                                for (int k = 0; k < cc; k++) {
                                    bm[j][k] = scn.nextInt();
                                    if (bm[j][k] < 0 || bm[j][k] > 255) {
                                        System.out.println("---INVALID INPUT---");
                                        System.out.println("ELEMENT SHOULD BE IN RANGE(0-255)");
                                        k -= 1;
                                        continue;
                                    }
                                }
                            }
                            for (int j = 0; j < cr; j++) {
                                for (int k = 0; k < cc; k++) {
                                    colormat.get(i).getBluemat()[j][k] = bm[j][k];
                                }
                            }
                        }
                    }
                }
            }
            if (input == 4) {
                System.out.println("1.GRAYSCALE IMAGE\n2.COLOR IMAGE\n");
                System.out.print("ENTER OPTION: ");
                int type = scn.nextInt();
                int type1;
                if (type == 1) {
                    for (int i = 0; i < graymat.size(); i++) {
                        type1 = i + 1;
                        System.out.println("----MATRIX ID: " + type1 + "----");
                        System.out.println("SIZE OF MATRIX--> " + graymat.get(i).getRow() + "X" + graymat.get(i).getCol());
                        display((int) graymat.get(i).getRow(), (int) graymat.get(i).getCol(), graymat.get(i).getMat());
                        System.out.println("-----------------------------------------------------------------");
                    }
                }
                if (type == 2) {
                    for (int i = 0; i < colormat.size(); i++) {
                        type1 = i + 1;
                        System.out.println("----MATRIX ID: " + type1 + "----");
                        System.out.println("SIZE OF MATRIX--> " + colormat.get(i).getRow() + "X" + colormat.get(i).getCol());
                        System.out.println("RED  --> ");
                        display((int) colormat.get(i).getRow(), (int) colormat.get(i).getCol(), colormat.get(i).getRedmat());
                        System.out.println("GREEN --> ");
                        display((int) colormat.get(i).getRow(), (int) colormat.get(i).getCol(), colormat.get(i).getGreenmat());
                        System.out.println("BLUE --> ");
                        display((int) colormat.get(i).getRow(), (int) colormat.get(i).getCol(), colormat.get(i).getBluemat());
                        System.out.println("-----------------------------------------------------------------");

                    }
                }
            }
            if (input == 5) {
                System.out.println("1.GRAYSCALE IMAGE\n2.COLOR IMAGE\n");
                System.out.print("ENTER OPTION: ");
                int type = scn.nextInt();
                int type1;
                if (type == 1) {
                    for (int i = 0; i < graymat.size(); i++) {
                        type1 = i + 1;
                        System.out.println("----MATRIX ID: " + type1 + "----");
                        System.out.println("SIZE OF MATRIX--> " + graymat.get(i).getRow() + "X" + graymat.get(i).getCol());
                        display((int) graymat.get(i).getRow(), (int) graymat.get(i).getCol(), graymat.get(i).getMat());
                        System.out.println("-----------------------------------------------------------------");
                    }

                    System.out.print("ENTER ID OF MATRIX TO CALCULATE NEGATIVE: ");
                    int choice = scn.nextInt();
                    for (int i = 0; i < graymat.size(); i++) {
                        if (choice == (i + 1)) {

                            int r = (int) graymat.get(i).getRow();
                            int c = (int) graymat.get(i).getCol();
                            int[][] gm = new int[r][c];
                            for (int j = 0; j < r; j++) {
                                for (int k = 0; k < c; k++) {
                                    gm[j][k] = (255 - graymat.get(i).getMat()[j][k]);
                                }
                            }
                            display(r, c, gm);
                        }
                    }
                }
                if (type == 2) {
                    for (int i = 0; i < colormat.size(); i++) {
                        type1 = i + 1;
                        System.out.println("----MATRIX ID: " + type1 + "----");
                        System.out.println("SIZE OF MATRIX--> " + colormat.get(i).getRow() + "X" + colormat.get(i).getCol());
                        System.out.println("RED  --> ");
                        display((int) colormat.get(i).getRow(), (int) colormat.get(i).getCol(), colormat.get(i).getRedmat());
                        System.out.println("GREEN --> ");
                        display((int) colormat.get(i).getRow(), (int) colormat.get(i).getCol(), colormat.get(i).getGreenmat());
                        System.out.println("BLUE --> ");
                        display((int) colormat.get(i).getRow(), (int) colormat.get(i).getCol(), colormat.get(i).getBluemat());
                        System.out.println("-----------------------------------------------------------------");

                    }
                    System.out.print("ENTER ID OF MATRIX TO CALCULATE NEGATIVE: ");
                    int choice = scn.nextInt();
                    for (int i = 0; i < colormat.size(); i++) {
                        if (choice == (i + 1)) {

                            int cr = (int) colormat.get(i).getRow();
                            int cc = (int) colormat.get(i).getCol();
                            int[][] rm = new int[cr][cc];
                            for (int j = 0; j < cr; j++) {
                                for (int k = 0; k < cc; k++) {
                                    rm[j][k] = (255 - colormat.get(i).getRedmat()[j][k]);

                                }
                            }
                            int[][] greenm = new int[cr][cc];
                            for (int j = 0; j < cr; j++) {
                                for (int k = 0; k < cc; k++) {
                                    greenm[j][k] = (255 - colormat.get(i).getGreenmat()[j][k]);

                                }
                            }


                            int[][] bm = new int[cr][cc];
                            for (int j = 0; j < cr; j++) {
                                for (int k = 0; k < cc; k++) {
                                    bm[j][k] = (255 - colormat.get(i).getBluemat()[j][k]);

                                }
                            }
                            System.out.println("--NEGATIVE FOR RED--");
                            display(cr, cc, rm);
                            System.out.println("--NEGATIVE FOR GREEN--");
                            display(cr, cc, greenm);
                            System.out.println("--NEGATIVE FOR BLUE--");
                            display(cr, cc, bm);

                        }
                    }
                }


            }
            if(input==6){
                System.out.println("{End of Test Case}");
                System.out.println("---------------------------------");
                break;
            }
            System.out.println("---------------------------------\n" +
                    "{Menu Options}");

        }

    }
}
