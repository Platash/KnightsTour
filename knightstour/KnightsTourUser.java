package knightstour;

public class KnightsTourUser {
    
    public static void main(String[] args) {
        KnightsTour tour = new KnightsTour();
        goTour (tour);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
            System.out.printf("%d ", tour.grid[j][i]);
            }
            System.out.println();
        }
    }
    
    
    public static boolean goTour (KnightsTour tour) {        
        Position start = tour.getStart();
        tour.markAsPossible (start);
        BackTrack backTrack = new BackTrack (tour);
        
        if (tour.isGoal (start) || backTrack.tryToReachGoal (start)) {
            return true;
        }
        tour.markAsDeadEnd (start);
        return false;        
    } 
    
}
