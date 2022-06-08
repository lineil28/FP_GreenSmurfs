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
   }

   private void prepareGUI(){
      mainFrame = new JFrame("Minesweeper");
      mainFrame.setSize(1000,1000);
      mainFrame.setLayout(new GridLayout(3, 1));

      headerLabel = new JLabel("",JLabel.CENTER );

      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }
      });
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      headerLabel.setText("Select a difficulty");

      JButton easy = new JButton("Easy");
      JButton medium = new JButton("Medium");
      JButton hard = new JButton("Hard");

      easy.setActionCommand("1");
      medium.setActionCommand("2");
      hard.setActionCommand("3");

      easy.addActionListener(new ButtonClickListener());
      medium.addActionListener(new ButtonClickListener());
      hard.addActionListener(new ButtonClickListener());

      controlPanel.add(easy);
      controlPanel.add(medium);
      controlPanel.add(hard);

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.setVisible(true);
   }

   private class ButtonClickListener implements ActionListener{
     public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if(command.equals("1"))  {
           testDemo(8,8);
        } else if(command.equals("2"))  {
           testDemo(16,16);
        } else {
           testDemo(16,32);
        }
     }
   }

   public void testDemo(int x, int y){
      headerLabel.setText("Click on buttons");

      JPanel panel = new JPanel();
      mainFrame.getContentPane().remove(controlPanel);
      mainFrame.getContentPane().add(panel);
      mainFrame.invalidate();
      mainFrame.validate();
      panel.setBackground(Color.darkGray);
      panel.setSize(700,700);
      GridLayout layout = new GridLayout(x,y);
      layout.setHgap(2);
      layout.setVgap(2);
      panel.setLayout(layout);

      statusLabel = new JLabel("",JLabel.CENTER);
      statusLabel.setSize(350,100);
      mainFrame.add(statusLabel);

      JButton[][] buttons = new JButton[x][y];
      for (int a = 0; a < buttons.length; a++) {
        for(int b = 0; b < buttons[0].length; b++) {
          buttons[a][b] = new JButton();
          panel.add(buttons[a][b]);
          buttons[a][b].addMouseListener(new MouseClickListener(a, b));
        }
      }

      mainFrame.setVisible(true);
   }

   private class MouseClickListener implements MouseListener{
     public int xPos;
     public int yPos;
     public MouseClickListener(int x, int y){
        xPos = x;
        yPos = y;
     }
     public void mousePressed(MouseEvent c){}
     public void mouseReleased(MouseEvent c){}
     public void mouseEntered(MouseEvent c){}
     public void mouseExited(MouseEvent c){}
     public void mouseClicked(MouseEvent c){
      if(c.getButton() == MouseEvent.BUTTON1) {
        statusLabel.setText("Left" + xPos + yPos);
      } else if(c.getButton() == MouseEvent.BUTTON3){
        statusLabel.setText("Right" + xPos + yPos);
      }
    }
   }
}
