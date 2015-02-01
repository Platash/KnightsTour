
package knightstour;

import java.util.Iterator;

public class KnightsTour implements Application {
    
    public static final int UNKNOWN = 0;
    public static int path = 1;
    private Position start;
    private GUI window;
    public int[][] grid;
    
    public KnightsTour () {
        grid = new int [8][8];
        start = new Position (3, 5);                
//        window = new GUI (this);
//        window.setVisible(true);
    }

    @Override
    public boolean isOK(Position pos) {
        
        return (    pos.getY() >= 0 && pos.getY() < grid.length &&
                pos.getX() >= 0 && pos.getX() < grid [0].length &&
                this.grid [pos.getY()][pos.getX()] == 0);
    }

    @Override
    public void markAsPossible(Position pos) {
        
        this.grid[pos.getY()][pos.getX()] = path;
       // window.repaint();
        path++;
    }

    @Override
    public boolean isGoal(Position pos) {
        if (path == 65) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void markAsDeadEnd(Position pos) {
        this.grid[pos.getY()][pos.getX()] = UNKNOWN;
        this.path--;
    }
    
    public int getCell (int x, int y) {
        return this.grid [y][x];
    }
    
    public  void setCell (int value, int x, int y) {
        this.grid[y][x] = value;
    }
    
    public Position getStart () {
        return this.start;
    }
    
    public int getGridSizeX () {
       return grid[0].length;
    }

    public int getGridSizeY () {
       return grid.length;
    }

    public int getValueAt (int x, int y) {
       return grid[y][x];
    }
    
    
    
    @Override
    public Iterator<Position> iterator (Position pos) {
        return new TourIterator (pos);
    } 


    protected class TourIterator implements Iterator<Position> {
        protected static final int MAX_MOVES = 8;

        protected int y;
        protected int x;
        protected int countIterations;

        /**
         * Initializes this TourIterator object to start at a given position.
         *
         * @param pos the position the Iterator objects starts at.
         */
        public TourIterator (Position pos) {
            y = pos.getY();
            x = pos.getX();
            countIterations = 0;
        } 


        /**
        * Determines if this TourIterator object can advance to another
        * position.
        *
        * @return true if this TourIterator object can advance; false otherwise.
        */
        @Override
        public boolean hasNext () {
            return countIterations < MAX_MOVES;
        } 


        /**
        * Advances this TourIterator object to the next position.
        *
        * @return the position advanced to.
        */  
        @Override
        public Position next () {

            Position nextPosition = new Position();
            switch (countIterations++) {
                case 0: nextPosition = new Position (y-2, x+1); // (row – 2, column + 1)
                      break;
                case 1: nextPosition = new Position (y-1, x+2); // (row – 1, column + 2)
                      break;
                case 2: nextPosition = new Position (y+1, x+2); // (row + 1, column + 2)
                        break;
                case 3: nextPosition = new Position (y+2, x+1); // (row + 2, column + 1)
                        break;
                case 4: nextPosition = new Position (y+2, x-1); // (row + 2, column – 1)
                        break;
                case 5: nextPosition = new Position (y+1, x-2); // (row + 1, column – 2)
                        break;
                case 6: nextPosition = new Position (y-1, x-2); // (row – 1, column – 2)
                        break;
                case 7: nextPosition = new Position (y-2, x-1); // (row – 2, column – 1)
                        break;
            }              
        return nextPosition;
       } 

       @Override
       public void remove () { 
            // removal is illegal for a TourIterator object
            throw new UnsupportedOperationException(); 
        } 

    } 
}
