import javax.swing.*;

public class RockPaperScissorsRunner
{
    public static void main(String[] args)
    {
        RockPaperScissorsFrame frame = new RockPaperScissorsFrame();

        frame.setTitle("Rock Paper Scissors Game");
        frame.setSize(525, 525);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}