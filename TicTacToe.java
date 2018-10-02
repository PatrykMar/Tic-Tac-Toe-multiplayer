package tic.tac.toe;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Patryk
 */
public class TicTacToe extends JFrame implements ActionListener {

    /**
     * @param args the command line arguments
     */
    JPanel mainPanel = new JPanel();
    private JTextField userField;
    private JPasswordField passwordField;
    public static void main(String[] args) {
        TicTacToe play = new TicTacToe();
        play.login();
  
    }
     public TicTacToe() {
                this.setVisible(true);
                this.setTitle("TicTacToe");
    }
     
    private  void login()
    {
       mainPanel = new JPanel(new GridLayout(3,1));
        
        JPanel user = new JPanel();
        JLabel userLabel = new JLabel("Username: ", JLabel.CENTER);
        userField = new JTextField("", 10);
        
        user.add(userLabel);
        user.add(userField);
        user.setVisible(true);
        
        JPanel password = new JPanel();
        JLabel passwordLabel = new JLabel("Password: ", JLabel.CENTER);
        passwordField = new JPasswordField("", 10);
        password.setVisible(true);
        password.add(passwordLabel);
        password.add(passwordField);
        
        
        JPanel control = new JPanel();
        control.setVisible(true);
        JButton button = new JButton("Login");
        button.setActionCommand("login");
        button.addActionListener(this);
        control.add(button);
        
        mainPanel.add(user);
        mainPanel.add(password);
        mainPanel.add(control);
        mainPanel.setVisible(true);
        this.add(mainPanel);
        this.pack();
    }
    private  void game()
    {
       JFrame frame = new JFrame();
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       JPanel panel = new JPanel(new GridLayout(3,3));
       for(int i = 0;i<3;i++)
       {
           for(int j = 0;j<3;j++)
           {
               JButton btn = new JButton("");
               btn.setBorder(BorderFactory.createLineBorder(Color.RED));
               btn.setActionCommand("Button" + i + " " + j);
               panel.add(btn,i,j);
           }
       }
       
       JPanel panel2 = new JPanel(new GridLayout(0,5));
       JButton startBtn = new JButton("Start");
       JButton quitBtn = new JButton("Quit");
       JPanel resultPanel = new JPanel();
       JLabel scoreLabel1 = new JLabel("Score: ",JLabel.CENTER);
       JLabel scoreLabel2 = new JLabel("0", JLabel.CENTER);
       resultPanel.add(scoreLabel1);
       resultPanel.add(scoreLabel2);
       
       JPanel turnPanel = new JPanel();
       JLabel turnLabel1 = new JLabel("Turn: ");
       JLabel turnLabel2 = new JLabel("Player 1");
       turnPanel.add(turnLabel1);
       turnPanel.add(turnLabel2);
       
       panel2.add(turnPanel,3,0);
       panel2.add(startBtn,0,0);
       panel2.add(quitBtn,1,0);
       panel2.add(resultPanel,2,0);
       
       mainPanel.add(panel,0,0);
       mainPanel.add(panel2,0,1);
       this.add(mainPanel);
       this.pack();
       
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String btnPressed = e.getActionCommand();
        if(btnPressed.equalsIgnoreCase("login"))
        {
            this.remove(mainPanel);
            game();
        }
    }
}




