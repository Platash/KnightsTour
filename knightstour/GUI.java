
package knightstour;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;
import javax.swing.JTable;

public class GUI extends JFrame {
    private JPanel panel;
    private JTable table;
    private KnightsTour tour;
    
    public GUI (KnightsTour tour) {
        super ("Knight Tour");
        this.tour = tour;
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initTable();
    }
    
    private void initTable() {
        this.panel = new JPanel();
        this.table = new JTable(new MyTableModel());
        for (int i = 0; i < this.tour.getGridSizeX(); i++) {
            this.table.getColumnModel().getColumn(i).setPreferredWidth(30);
            this.table.setRowHeight(30);
        }
        
        this.panel.add(table);
        this.add(panel);
    }
    
    public JTable getTable () {
        return this.table;
    }
    
    class MyTableModel extends AbstractTableModel{

        @Override
        public int getRowCount() {
            return tour.getGridSizeY();
        }

        @Override
        public int getColumnCount() {
            return tour.getGridSizeX();
        }

        @Override
        public Object getValueAt(int x, int y) {
            return tour.getValueAt(x, y) ;
        }
    }
}
