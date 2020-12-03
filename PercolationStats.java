import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats
{
    private int t;
    private int x;
    private double w;
    private double u;
    private double[] p;
    private final double confidence_95;

   public PercolationStats(int n,int t)
   {
       this.t = t;
        if (n <= 0)
              throw new IllegalArgumentException("The grid size must be bigger than zero");
        if (t <= 0)
             throw new IllegalArgumentException("The number of experiments must be bigger than zero");
       p = new double[t];
       confidence_95 = 1.96;
       for(int i=0;i<t;i++)
       {
           Percolation perc = new Percolation(n);
           x = 0;
          while(!perc.percolates())
          {
              int row;
               int col;
              do
              {
                  row = 1+StdRandom.uniform(n);
                  col = 1+StdRandom.uniform(n);
               }
              while(perc.isOpen(row, col));
               perc.open(row, col);
               x++;
          }       
          p[i] = x/(double) (n*n);
      }
       w = StdStats.mean(p);
       u = StdStats.stddev(p);
   }
   public double mean()
   {
       return w;
   }
   public double stddev()
   {
     return u;
   }
   public double confidenceLo()
   {       
       return w-((confidence_95*u)/Math.sqrt(t));
   }
   public double confidenceHi()
   {
       return w+((confidence_95*u)/Math.sqrt(t));
   }
   public static void main(String args[])
   {
       In in = new In(args[0]);
       int n = in.readInt();
        int t = in.readInt();
        PercolationStats h = new PercolationStats(n,t);
         StdOut.println("mean = "+h.mean());
          StdOut.println("stddev = "+h.stddev());
           StdOut.println("95% confidence Interval = ["+h.confidenceLo()+","+h.confidenceHi()+"]");
   }
}
