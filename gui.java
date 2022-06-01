import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BaseBoard {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public BaseBoard(){
      prepareGUI();
   }
   public static void main(String[] args){
      BaseBoard baseBoard = new BaseBoard();  
      baseBoard.showEventDemo();       
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Java SWING Examples");
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
   private void showEventDemo(){
      headerLabel.setText("Basic Buttons"); 

      JButton oneButton = new JButton("1");
      JButton twoButton = new JButton("2");
      JButton threeButton = new JButton("3");

      oneButton.setActionCommand("1");
      twoButton.setActionCommand("2");
      threeButton.setActionCommand("3");

      oneButton.addActionListener(new ButtonClickListener()); 
      twoButton.addActionListener(new ButtonClickListener()); 
      threeButton.addActionListener(new ButtonClickListener()); 

      controlPanel.add(oneButton);
      controlPanel.add(twoButton);
      controlPanel.add(threeButton);       

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