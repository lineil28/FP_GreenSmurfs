import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class gui {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public gui(){
      prepareGUI();
   }
   public static void main(String[] args){
      gui b = new gui();
      b.testDemo(7,7);
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Minesweeper");
      mainFrame.setSize(1000,1000);
      mainFrame.setLayout(new GridLayout(3, 1));

      headerLabel = new JLabel("",JLabel.CENTER );
      statusLabel = new JLabel("",JLabel.CENTER);
      statusLabel.setSize(350,100);

      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }
      });
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);
   }
   private void testDemo(int x, int y){
      headerLabel.setText("Click on buttons");

      JPanel panel = new JPanel();
      panel.setBackground(Color.darkGray);
      panel.setSize(700,700);
      GridLayout layout = new GridLayout(x,y);
      layout.setHgap(2);
      layout.setVgap(2);

      JButton[][] buttons = new JButton[x][y];

      panel.setLayout(layout);

      for (int a = 0; a < buttons.length; a++) {
        for(int b = 0; b < buttons[0].length; b++) {
          buttons[a][b] = new JButton();
          buttons[a][b].addMouseListener(new MouseClickListener());
          panel.add(buttons[a][b]);
        }
      }

      controlPanel.add(panel);
      mainFrame.setVisible(true);
   }
   private class MouseClickListener implements MouseListener{
	   public void mousePressed(MouseEvent me){}
       public void mouseReleased(MouseEvent me){}
       public void mouseEntered(MouseEvent me){}
       public void mouseExited(MouseEvent me){}
	   public void mouseClicked(MouseEvent c){
		   if(c.getButton() == MouseEvent.BUTTON1) {
			   statusLabel.setText("Left");
		   } else if(c.getButton() == MouseEvent.BUTTON3){
			   statusLabel.setText("Right");
		   }
	  }
   }
}
