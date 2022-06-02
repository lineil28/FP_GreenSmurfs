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
      b.testDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Minesweeper");
      mainFrame.setSize(400,400);
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
   private void testDemo(){
      headerLabel.setText("Basic Buttons");

      JPanel panel = new JPanel();
      panel.setBackground(Color.darkGray);
      panel.setSize(300,300);
      GridLayout layout = new GridLayout(0,7);
      layout.setHgap(2);
      layout.setVgap(2);

      buttons = new JButton[3][7];

      panel.setLayout(layout);

      for (int a = 0; a < buttons.length; a++) {
        for(int b = 0; b < buttons[0].length; b++) {
          buttons[a][b] = new JButton();
          buttons[a][b].setActionCommand("1");
          buttons[a][b].addActionListener(new ButtonClickListener());
          panel.add(buttons[a][b]);
        }
      }

      controlPanel.add(panel);
      mainFrame.setVisible(true);
   }
   private class ButtonClickListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();

         if( command.equals( "1" ))  {
            statusLabel.setText("empty square clicked.");
         } else if( command.equals( "2" ) )  {
            statusLabel.setText("bomb licked.");
         } else {
            statusLabel.setText("empty square clicked.");
         }
      }
   }
}
