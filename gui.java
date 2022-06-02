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
      GridLayout layout = new GridLayout(0,3);
      layout.setHgap(2);
      layout.setVgap(2);

      JButton one = new JButton("1");
      JButton two = new JButton("2");
      JButton three = new JButton("3");
      JButton four = new JButton("4");
      JButton five = new JButton("5");
      JButton six = new JButton("6");

      panel.setLayout(layout);
      panel.add(one);
      panel.add(two);
      panel.add(three);
      panel.add(four);
      panel.add(five);
      panel.add(six);

      one.setActionCommand("1");
      two.setActionCommand("2");
      three.setActionCommand("3");
      four.setActionCommand("3");
      five.setActionCommand("3");
      six.setActionCommand("3");

      one.addActionListener(new ButtonClickListener());
      two.addActionListener(new ButtonClickListener());
      three.addActionListener(new ButtonClickListener());
      four.addActionListener(new ButtonClickListener());
      five.addActionListener(new ButtonClickListener());
      six.addActionListener(new ButtonClickListener());

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
