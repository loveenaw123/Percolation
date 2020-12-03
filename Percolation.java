package newpackage;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
public class Percolation
{
    private final boolean[] opened;
    private final int top = 0;
    private int number_opened;
    private final int bottom;
    private final int size;
    private final WeightedQuickUnionUF qf;
    private final WeightedQuickUnionUF backwash;

    public Percolation(int n)
    {
        if(n<1)
            throw new IllegalArgumentException("Out Of Range");
        size = n;
        bottom = size*size+1;
        qf = new WeightedQuickUnionUF(bottom+1);
        backwash = new WeightedQuickUnionUF(bottom);
        opened = new boolean[bottom];        
    }
    private void validate(int row,int col)
    {
        if(row<1||row>size)
            throw new IllegalArgumentException("Row Index Out Of Bounds");
        if(col<1||col>size)
            throw new IllegalArgumentException("Col index Out of Bounds");
        
    }
    public void open(int row,int col)
   {
       validate(row,col);
       if (isOpen(row, col))
            return;

       opened[getQFIndex(row,col)] = true;
      if(row==1)
      {
           qf.union(getQFIndex(row,col),top);
           backwash.union(getQFIndex(row,col),top);
      }
      if(row==size)
          qf.union(getQFIndex(row,col),bottom);
       if(row>1&&isOpen(row-1,col))
       {
           qf.union(getQFIndex(row,col),getQFIndex(row-1,col));
           backwash.union(getQFIndex(row,col),getQFIndex(row-1,col));
       }
       if(row<size&&isOpen(row+1,col))
       {
            qf.union(getQFIndex(row,col),getQFIndex(row+1,col));
            backwash.union(getQFIndex(row,col),getQFIndex(row+1,col));
       }
       if(col>1&&isOpen(row,col-1))
       {
        qf.union(getQFIndex(row,col),getQFIndex(row,col-1));
        backwash.union(getQFIndex(row,col),getQFIndex(row,col-1));
       }
       if(col<size&&isOpen(row,col+1))
       {
           qf.union(getQFIndex(row,col),getQFIndex(row,col+1));
           backwash.union(getQFIndex(row,col),getQFIndex(row,col+1));
       }         
   }
    public boolean isOpen(int row,int col)
   {
       validate(row,col);
       return opened[getQFIndex(row,col)];       
   }
    public boolean isFull(int row,int col)
   {
       validate(row,col);
       return backwash.connected(top,getQFIndex(row,col));
   }
    public int numberOfOpenSites()
    {
        number_opened = 0;
        for(int i=0;i<bottom;i++)
        {
            if(opened[i])
                number_opened++;
        }
        return number_opened;
    }
    public boolean percolates()
   {
        if(qf.connected(top,bottom))
            return true;
        else
            return false;
   }
    private int getQFIndex(int row,int col)
    {
      return size*(row-1)+col;
    }

}
