package newpackage;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PercolationVisualizer {

    // delay in miliseconds (controls animation speed)
    private static final int DELAY = 100;

    // draw n-by-n percolation system
    public static void draw(Percolation perc, int n) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setXscale(-0.05 * n, 1.05 * n);
        StdDraw.setYscale(-0.05 * n, 1.05 * n);   // leave a border to write text
        StdDraw.filledSquare(n / 2.0, n / 2.0, n / 2.0);

        // draw n-by-n grid
        int opened = 0;
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                if (perc.isFull(row, col)) {
                    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                    opened++;
                }
                else if (perc.isOpen(row, col)) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    opened++;
                }
                else
                    StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledSquare(col - 0.5, n - row + 0.5, 0.45);
            }
        }

        // write status text
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 12));
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(0.25 * n, -0.025 * n, opened + " open sites");
        if (perc.percolates()) StdDraw.text(0.75 * n, -0.025 * n, "percolates");
        else StdDraw.text(0.75 * n, -0.025 * n, "does not percolate");

    }

    public static void main(String[] args)throws IOException {
       // File file = new File("C:\\Users\\abc\\Desktop\\greeting57.txt");
       // BufferedReader br = new BufferedReader(new FileReader(file));
        //String st;
        //while((st=br.readLine())!=null)
           // System.out.println(st);
        //In in = new In("C:\\Users\\abc\\Downloads\\percolation\\greeting57.txt");      // input file
        int n = StdIn.readInt();         // n-by-n percolation system

        // turn on animation mode
        StdDraw.enableDoubleBuffering();

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(n);
        draw(perc, n);
        StdDraw.show();
        StdDraw.pause(DELAY);
        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();
            int j = StdIn.readInt();
            perc.open(i, j);
            draw(perc, n);
            StdDraw.show();
            StdDraw.pause(DELAY);
        }
    }
}
