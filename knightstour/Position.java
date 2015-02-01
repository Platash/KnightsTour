package knightstour;

public class Position {
    	private int y;
        private int x;
            

	/**
         * Initializes this Position object to (0, 0).
         */    	
        public Position () {
        	y = 0;
        	x = 0;
    	} 

	public Position (int row, int column) {
        	this.y = row;
        	this.x = column;
    	} 

        public int getY () {
        	return this.y;
    	} 

	public int getX () {
        	return this.x;
    	} 
} 
