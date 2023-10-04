//imports
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

import static java.awt.Color.black;


public class RockPaperScissorsFrame extends JFrame
{
    //JPanels
    JPanel mainPnl;
    JPanel buttonPnl;
    JPanel statsPnl;
    JPanel resultsPnl;


    //JButtons;
    JButton rockBttn;
    JButton paperBttn;
    JButton scissorsBttn;
    JButton quitBttn;

    //JLabels
    JLabel title;
    JLabel playerWins;
    JLabel computerWins;
    JLabel tie;
    JLabel totalPlayed;

    //JTextFields
    JTextField playerWinCount;
    JTextField compWinCount;
    JTextField tieCount;
    JTextField totalGames;

    //ImageIcons
    ImageIcon rockIcon;
    ImageIcon paperIcon;
    ImageIcon scissorsIcon;


    JTextArea results;
    JScrollPane scroller;

    //Declarations for game itself
    int compMove;
    int playerMove;

    Random rndMove = new Random();

    int numPlayerWins = 0;
    int numCompWins = 0;
    int numTies = 0;
    int numTotalGames = 0;

    String playerWinsString;
    String compWinsString;
    String tieString;
    String totalString;

    public RockPaperScissorsFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createButtonPnl();
        mainPnl.add(buttonPnl, BorderLayout.NORTH);

        createResultsPnl();
        mainPnl.add(resultsPnl, BorderLayout.CENTER);

        createStatsPnl();
        mainPnl.add(statsPnl, BorderLayout.SOUTH);

        add(mainPnl);
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    private void createButtonPnl()
    {
        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(1, 4));

        //border created for buttonPnl
        buttonPnl.setBorder(new TitledBorder ((new LineBorder(black, 4 )), "Pick A Move!"));


        //Images
        rockIcon = new ImageIcon("src/rockIcon.jpg");
        Image rIcon = rockIcon.getImage();
        Image modifiedRockIcon = rIcon.getScaledInstance(100,100, Image.SCALE_DEFAULT);
        rockIcon = new ImageIcon(modifiedRockIcon);

        paperIcon = new ImageIcon("src/paperIcon.jpg");
        Image pIcon = paperIcon.getImage();
        Image modifiedPaperIcon = pIcon.getScaledInstance(100,100, Image.SCALE_DEFAULT);
        paperIcon = new ImageIcon(modifiedPaperIcon);

        scissorsIcon = new ImageIcon("src/scissorsIcon.jpg");
        Image sIcon = scissorsIcon.getImage();
        Image modifiedScissorsIcon = sIcon.getScaledInstance(100,100, Image.SCALE_DEFAULT);
        scissorsIcon = new ImageIcon(modifiedScissorsIcon);

        //note that 0 == rock, 1 == paper, 2 == scissors

        //action for rock buttone
        rockBttn = new JButton(rockIcon);
        rockBttn.addActionListener((ActionEvent ae) ->
        {
            playerMove = 0; //paper selected and set to 0
            compMove = rndMove.nextInt(3);
            numTotalGames++;

            if (compMove == playerMove) //rndMove chose 0 which is paper, tie
            {
                numTies++;
                results.append("Computer threw rock. It is a tie \n");
            }
            else if (compMove == 1) //rndMove chose 1 which is paper, comp wins
            {
                numCompWins++;
                results.append("Computer threw paper. Paper covers rock (computer wins) \n");
            }

            else if(compMove ==2) //rndMove chose 2 which is scissors, player wins
            {
                numPlayerWins++;
                results.append("Computer threw scissors. Rock breaks scissors (player wins) \n");
            }

            //takes the int of wins and converts to string to put into JTestFields
            compWinsString = Integer.toString(numCompWins);
            playerWinsString = Integer.toString(numPlayerWins);
            tieString = Integer.toString(numTies);
            totalString = Integer.toString(numTotalGames);

            //sets the JTextFields after each round
            playerWinCount.setText(playerWinsString);
            compWinCount.setText(compWinsString);
            tieCount.setText(tieString);
            totalGames.setText(totalString);
        });




        //action for paper button
        paperBttn = new JButton(paperIcon);
        paperBttn.addActionListener((ActionEvent ae) ->
        {
            playerMove = 1;
            compMove = rndMove.nextInt(3);
            numTotalGames++;

            if (compMove == playerMove) //if rndMove selects 1, they both selected paper
            {
                numTies++;
                results.append("Computer threw paper. It is a tie \n");
            }
            else if (compMove == 0) //rndMove selected rock
            {
                numPlayerWins++;
                results.append("Computer threw rock. Paper covers rock (player wins) \n");
            }

            else if(compMove == 2) //rndMove selected scissors
            {
                numCompWins++;
                results.append("Computer threw scissors. Scissors cut paper (computer wins) \n");

            }

            //takes the int of wins and converts to string to put into JTestFields
            compWinsString = Integer.toString(numCompWins);
            playerWinsString = Integer.toString(numPlayerWins);
            tieString = Integer.toString(numTies);
            totalString = Integer.toString(numTotalGames);

            //sets the JTextFields after each round
            playerWinCount.setText(playerWinsString);
            compWinCount.setText(compWinsString);
            tieCount.setText(tieString);
            totalGames.setText(totalString);
        });

        //scissors button action
        scissorsBttn = new JButton(scissorsIcon);
        scissorsBttn.addActionListener((ActionEvent ae) ->
        {
            playerMove = 2;
            compMove = rndMove.nextInt(3);
            numTotalGames++;

            if (compMove == playerMove) //rndMove selected scissors
            {
                numTies++;
                results.append("Computer threw scissors. It is a tie \n");
            }
            else if (compMove == 0)//rndMove selected rock
            {
                numCompWins++;
                results.append("Computer threw rock. Rock breaks scissors (computer wins) \n");
            }

            else if(compMove == 1)//rndMove selecte paper
            {
                numPlayerWins++;
                results.append("Computer threw paper. Scissors cut paper (player wins) \n");

            }

            //takes the int of wins and converts to string to put into JTestFields
            compWinsString = Integer.toString(numCompWins);
            playerWinsString = Integer.toString(numPlayerWins);
            tieString = Integer.toString(numTies);
            totalString = Integer.toString(numTotalGames);

            //sets the JTextFields after each round
            playerWinCount.setText(playerWinsString);
            compWinCount.setText(compWinsString);
            tieCount.setText(tieString);
            totalGames.setText(totalString);

        });

        //quit button action
        quitBttn = new JButton("Quit Game");
        quitBttn.addActionListener((ActionEvent ae) -> System.exit(0));

        //add to panel
        buttonPnl.add(rockBttn);
        buttonPnl.add(paperBttn);
        buttonPnl.add(scissorsBttn);
        buttonPnl.add(quitBttn);
    }

    private void createResultsPnl()
    {
        resultsPnl = new JPanel();
        results = new JTextArea(10, 35);
        results.setEditable(false);
        scroller = new JScrollPane(results);
        resultsPnl.add(scroller);
    }

    private void createStatsPnl()
    {
        statsPnl = new JPanel();

        //JLabels
        playerWins = new JLabel("Player Wins:");
        computerWins = new JLabel("Computer Wins:");
        tie = new JLabel("Ties:");
        totalPlayed = new JLabel("Total Games:");

        //create the JTextFields so user cannot edit the
        playerWinCount = new JTextField(3);
        playerWinCount.setEditable(false);

        compWinCount = new JTextField(3);
        compWinCount.setEditable(false);

        tieCount = new JTextField(3);
        tieCount.setEditable(false);

        totalGames = new JTextField(3);
        totalGames.setEditable(false);

        //add to panel
        statsPnl.add(playerWins);
        statsPnl.add(playerWinCount);

        statsPnl.add(computerWins);
        statsPnl.add(compWinCount);

        statsPnl.add(tie);
        statsPnl.add(tieCount);

        statsPnl.add(totalPlayed);
        statsPnl.add(totalGames);

    }


}
