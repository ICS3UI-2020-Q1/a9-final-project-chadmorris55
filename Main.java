import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  //array for the deck
  int[] cards = new int[52];
  //array for the pictures
  JLabel[] userCards = new JLabel[6];
  JLabel[] dealerCards = new JLabel[7];
  //variable for the total score of the user
  int userScore = 0;
  //total score for the dealer
  int dealerScore = 0;
  //Label to declare victory or defeat, or the users score
  JLabel winLabel;
  //buttons
  JButton hitButton;
  JButton standButton;
  JButton resetButton;
  //variable for the number of cards in the users hand
  int numberOfCards = 0;
  //number of cards in dealers hand
  int dealerNumberOfCards = 0;
  //font biginator 3000
  Font larger = new Font("arial", Font.PLAIN, 30);
  Font smaller = new Font("arial", Font.PLAIN, 20);
  Font largerSuper = new Font("arial", Font.PLAIN, 60);
  //panels
  JPanel mainPanel;
  JPanel dealerArea;
  JPanel userArea;
  JPanel userHand;
  JPanel dealerHand;
  //Labels to show where the dealer and user hands are
  JLabel userAreaLabel;
  JLabel dealerAreaLabel;

  //makes a boolean that changes to true whenever an ace is drawn
  boolean aceCheck = false;
  boolean dealerAceCheck = false;
  //a boolean which will be changed to true when an ace is drawn and changed to false whenever an ace is changed from 11 to 1
  boolean aceValid = false;
  boolean dealerAceValid = false;

  //Picture things
  JLabel userPictureOne;
  JLabel userPictureTwo;
  JLabel userPictureThree;
  JLabel userPictureFour;
  JLabel userPictureFive;
  JLabel userPictureSix;
  JLabel userPictureSeven;
  JLabel userPictureEight;
  JLabel dealerPictureOne;
  JLabel dealerPictureTwo;
  JLabel dealerPictureThree;
  JLabel dealerPictureFour;
  JLabel dealerPictureFive;
  JLabel dealerPictureSix;
  JLabel dealerPictureSeven;
  JLabel dealerPictureEight;
  ImageIcon cardAce;
  ImageIcon cardTwo;
  ImageIcon cardThree;
  ImageIcon cardFour;
  ImageIcon cardFive;
  ImageIcon cardSix;
  ImageIcon cardSeven;
  ImageIcon cardEight;
  ImageIcon cardNine;
  ImageIcon cardTen;
  ImageIcon cardJack;
  ImageIcon cardQueen;
  ImageIcon cardKing;
  ImageIcon resetPic;
  ImageIcon hitPic;
  ImageIcon standPic;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("BlackJack");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
    //initialize main panel and set the layout
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    //initialize the two area panels and 
    dealerArea = new JPanel();
    userArea = new JPanel();
    dealerArea.setLayout(new BorderLayout());
    userArea.setLayout(new BorderLayout());
    dealerArea.setPreferredSize(new Dimension(800,300));
    userArea.setPreferredSize(new Dimension(800,300));
    //labels to label the areas
    userAreaLabel = new JLabel("                                Your Area");
    userAreaLabel.setFont(larger);
    userAreaLabel.setPreferredSize(new Dimension(100,100));
    dealerAreaLabel = new JLabel("                             Dealers Area");
    dealerAreaLabel.setFont(larger);

    //label to show result
    winLabel = new JLabel("");
    winLabel.setFont(largerSuper);
    //initialize the hand panels and the user button panel 
    dealerHand = new JPanel();
    dealerHand.setLayout(new GridLayout(1,8));
    dealerHand.setPreferredSize(new Dimension(800,125));
    userHand = new JPanel();
    userHand.setLayout(new GridLayout(1,8));
    userHand.setPreferredSize(new Dimension(800,100));

    //initialize buttons and their pictures
    standPic = new ImageIcon("stand.png");
    hitPic = new ImageIcon("hit.png");
    resetPic = new ImageIcon("reset.png");
    hitButton = new JButton();
    hitButton.setPreferredSize(new Dimension (200,100));
    hitButton.setFont(smaller);
    hitButton.setIcon(hitPic);
    standButton = new JButton();
    standButton.setPreferredSize(new Dimension (200,100));
    standButton.setFont(smaller);
    standButton.setIcon(standPic);
    resetButton = new JButton();
    resetButton.setPreferredSize(new Dimension(100,100));
    resetButton.setFont(largerSuper);
    resetButton.setIcon(resetPic);
    resetButton.setActionCommand("reset");
    hitButton.setActionCommand("hit");
    standButton.setActionCommand("stand");
    resetButton.addActionListener(this);
    hitButton.addActionListener(this);
    standButton.addActionListener(this);
    //initialize images
    cardAce = new ImageIcon("ADiamonds.png");
    cardTwo = new ImageIcon("2Diamonds.png");
    cardThree = new ImageIcon("3Diamonds.png");
    cardFour = new ImageIcon("4Diamonds.png");
    cardFive = new ImageIcon("5Diamonds.png");
    cardSix = new ImageIcon("6Diamonds.png");
    cardSeven = new ImageIcon("7Diamonds.png");
    cardEight = new ImageIcon("8Diamonds.png");
    cardNine = new ImageIcon("9Diamonds.png");
    cardTen = new ImageIcon("10Diamonds.png");
    cardJack = new ImageIcon("JDiamonds.png");
    cardQueen = new ImageIcon("QDiamonds.png");
    cardKing = new ImageIcon("KDiamonds.png");
    //initialize image labels 
    userPictureOne = new JLabel("card 1");
    userPictureTwo = new JLabel("card 2");
    userPictureThree = new JLabel("card 3");
    userPictureFour = new JLabel("card 4");
    userPictureFive = new JLabel("card 5");
    userPictureSix = new JLabel("card 6");
    userPictureSeven = new JLabel("card 7");
    userPictureEight = new JLabel("card 8");
    userCards[0] = userPictureThree;
    userCards[1] = userPictureFour;
    userCards[2] = userPictureFive;
    userCards[3] = userPictureSix;
    userCards[4] = userPictureSeven;
    userCards[5] = userPictureEight;
    dealerPictureOne = new JLabel("card 1");
    dealerPictureTwo = new JLabel("card 2");
    dealerPictureThree = new JLabel("card 3");
    dealerPictureFour = new JLabel("card 4");
    dealerPictureFive = new JLabel("card 5");
    dealerPictureSix = new JLabel("card 6");
    dealerPictureSeven = new JLabel("card 7");
    dealerPictureEight = new JLabel("card 8");
    dealerCards[0] = dealerPictureTwo;
    dealerCards[1] = dealerPictureThree;
    dealerCards[2] = dealerPictureFour;
    dealerCards[3] = dealerPictureFive;
    dealerCards[4] = dealerPictureSix;
    dealerCards[5] = dealerPictureSeven;
    dealerCards[6] = dealerPictureEight;
    //add the picture labels to the userHand
    userHand.add(userPictureOne);
    userHand.add(userPictureTwo);
    userHand.add(userPictureThree);
    userHand.add(userPictureFour);
    userHand.add(userPictureFive);
    userHand.add(userPictureSix);
    userHand.add(userPictureSeven);
    userHand.add(userPictureEight);
    //add the picture labels to dealerHand
    dealerHand.add(dealerPictureOne);
    dealerHand.add(dealerPictureTwo);
    dealerHand.add(dealerPictureThree);
    dealerHand.add(dealerPictureFour);
    dealerHand.add(dealerPictureFive);
    dealerHand.add(dealerPictureSix);
    dealerHand.add(dealerPictureSeven);
    dealerHand.add(dealerPictureEight);
    //adds things to panels 
    dealerArea.add(dealerAreaLabel, BorderLayout.PAGE_START);
    dealerArea.add(dealerHand, BorderLayout.PAGE_END);
    dealerArea.add(resetButton,BorderLayout.CENTER);
    userArea.add(winLabel, BorderLayout.CENTER);
    userArea.add(userAreaLabel, BorderLayout.PAGE_START);
    userArea.add(hitButton, BorderLayout.LINE_START);
    userArea.add(standButton, BorderLayout.LINE_END);
    userArea.add(userHand, BorderLayout.PAGE_END);
    mainPanel.add(dealerArea, BorderLayout.PAGE_START);
    mainPanel.add(userArea, BorderLayout.PAGE_END);
    //adds main panel to the screen
    frame.add(mainPanel);
    
    //makes each spot in the array equal to what spot its in (spot 5 = number 5 etc.)
    for (int i = 0; i < cards.length; i++){
      //adds one so the thing in spot 5 will eual 5 instead of 4 since arrays start at 0 instead of 1
      cards[i] = i + 1;
    }
    //gets a random card for the dealer 
    int randomDealerPicOne = randomCard();
    //converts
    int firstDealerConvert = convertToThirteen(randomDealerPicOne);
    //see code below for the exact same comments i would put here
    if(firstDealerConvert == 1){
      dealerAceCheck = true;
    }
    ImageIcon dealerFirstImage = pictureChoose(firstDealerConvert);
    dealerPictureOne.setIcon(dealerFirstImage);
    dealerPictureOne.setText("");
    if(firstDealerConvert == 1){
      dealerScore = dealerScore + 11;
    }else if(firstDealerConvert == 11 || firstDealerConvert == 12 || firstDealerConvert == 13){
      dealerScore = dealerScore + 10;
    }else{
      dealerScore = dealerScore + firstDealerConvert;
    }
    //gets a random card
    int randomPicOne = randomCard();
    //converts that number to 1-13 number
    int firstConvert = convertToThirteen(randomPicOne);
    //if its = 1 then its an ace
    if(firstConvert == 1){
      //checks if its an ace
      aceCheck = true;
      aceValid = true;
    }
    ImageIcon firstImage = pictureChoose(firstConvert);
    userPictureOne.setIcon(firstImage);
    userPictureOne.setText("");
    if(firstConvert == 1){
      //ace has the value of 11 to start
      userScore = userScore + 11;
    }else if(firstConvert == 11 || firstConvert == 12 || firstConvert == 13){
      //if its jack queen or king, only add 10 instead of their actual values of 11 12 and 13 respectively
      userScore = userScore + 10;
    }else{
      userScore = userScore + firstConvert;
    }
    int randomPicTwo = randomCard();
    int secondConvert =  convertToThirteen(randomPicTwo);
    if(secondConvert ==1){
      aceCheck = true;
      aceValid = true;
    }
    ImageIcon secondImage = pictureChoose(secondConvert);
    userPictureTwo.setIcon(secondImage);
    userPictureTwo.setText("");
    if(secondConvert == 1){
      userScore = userScore + 11;
      aceValid = true;
    } else if (secondConvert == 11 || secondConvert == 12 || secondConvert == 13){
      //if its jack queen or king, only add 10 instead of their actual values of 11 12 and 13 respectively
      userScore = userScore + 10;
    } else {
    userScore = userScore + secondConvert;
    }
    //if the socre goes above 21, it checks if theres an ace and if so, subtracts 10 and sets aceValid to false since using the ace to subtract 10 is no longer true
    if(userScore > 21 && aceCheck == true){
      userScore = userScore - 10;
      aceValid = false;
    }
    winLabel.setText(" Score: " + userScore);
  }
  //method to get a random card
  public int randomCard(){
    

    //gets a random number between 0 and 51
    int random_card = (int)(Math.random() * (51 - 0 + 1) + 0);
    //new int created so we can keep the random number and return it while also changing its spot in the array to equal a different number so later on we can "check" if its already been drawn before and if so, ignore it can draw another card
    int card_remove = cards[random_card];
    //using the number "90" as a number that won't be accepted and once a card is drawn, its value in the array is replaced with the value 90 so it wont be drawn again in the future since its already been drawn
    while(card_remove == 90){
      random_card = (int)(Math.random() * (51 - 0 + 1) + 0);
      card_remove = cards[random_card];
    }
    cards[random_card] = 90;
    return card_remove;
  }
  public int convertToThirteen(int a){
  //makes the card 1-13 to make it easier since theres only 13 cards (ace-king)
      if(a > 39){
      a = a - 39;
    } else if(a > 26){
      a = a - 26;
    } else if(a > 13){
      a = a - 13;
    }
    return a;
  }
  public ImageIcon pictureChoose(int b){

    //finds out which number it is then will return the corresponding picture 
    ImageIcon cardPic = null;
    switch(b){
      case 1:
      cardPic = cardAce;
      break;
      case 2:
      cardPic = cardTwo;
      break;
      case 3:
      cardPic = cardThree;
      break;
      case 4:
      cardPic = cardFour;
      break;
      case 5:
      cardPic = cardFive;
      break;
      case 6:
      cardPic = cardSix;
      break;
      case 7:
      cardPic = cardSeven;
      break;
      case 8:
      cardPic = cardEight;
      break;
      case 9:
      cardPic = cardNine;
      break;
      case 10:
      cardPic = cardTen;
      break;
      case 11:
      cardPic = cardJack;
      break;
      case 12:
      cardPic = cardQueen;
      break;
      case 13:
      cardPic = cardKing;
      break;
      
    }return cardPic;
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();
    if(command.equals("reset")){
      //resets deck
      for (int i = 0; i < cards.length; i++){
      cards[i] = i + 1;
      }
      //enable the buttons
      hitButton.setEnabled(true);
      standButton.setEnabled(true);
      //resets the scores
      userScore = 0;
      dealerScore = 0;
      //resets the # of cards in hand
      dealerNumberOfCards = 0;
      numberOfCards = 0;
      aceCheck = false;
      aceValid = false;
      dealerAceCheck = false;
      dealerAceValid = false;
      userPictureOne.setText("card 1");
      userPictureTwo.setText("card 2");
      userPictureThree.setText("card 3");
      userPictureFour.setText("card 4");
      userPictureFive.setText("card 5");
      userPictureSix.setText("card 6");
      userPictureSeven.setText("card 7");
      userPictureEight.setText("card 8");
      userPictureOne.setIcon(null);
      userPictureTwo.setIcon(null);
      userPictureThree.setIcon(null);
      userPictureFour.setIcon(null);
      userPictureFive.setIcon(null);
      userPictureSix.setIcon(null);
      userPictureSeven.setIcon(null);
      userPictureEight.setIcon(null);
      dealerPictureOne.setText("card 1");
      dealerPictureTwo.setText("card 2");
      dealerPictureThree.setText("card 3");
      dealerPictureFour.setText("card 4");
      dealerPictureFive.setText("card 5");
      dealerPictureSix.setText("card 6");
      dealerPictureSeven.setText("card 7");
      dealerPictureEight.setText("card 8");
      dealerPictureOne.setIcon(null);
      dealerPictureTwo.setIcon(null);
      dealerPictureThree.setIcon(null);
      dealerPictureFour.setIcon(null);
      dealerPictureFive.setIcon(null);
      dealerPictureSix.setIcon(null);
      dealerPictureSeven.setIcon(null);
      dealerPictureEight.setIcon(null);
    int randomDealerPicOne = randomCard();
    int firstDealerConvert = convertToThirteen(randomDealerPicOne);
    if(firstDealerConvert == 1){
      dealerAceCheck = true;
    }
    ImageIcon dealerFirstImage = pictureChoose(firstDealerConvert);
    dealerPictureOne.setIcon(dealerFirstImage);
    dealerPictureOne.setText("");
    if(firstDealerConvert == 1){
      dealerScore = dealerScore + 11;
    }else if(firstDealerConvert == 11 || firstDealerConvert == 12 || firstDealerConvert == 13){
      dealerScore = dealerScore + 10;
    }else{
      dealerScore = dealerScore + firstDealerConvert;
    }
    int randomPicOne = randomCard();
    int firstConvert = convertToThirteen(randomPicOne);
    if(firstConvert == 1){
      aceCheck = true;
      aceValid = true;
    }
    ImageIcon firstImage = pictureChoose(firstConvert);
    userPictureOne.setIcon(firstImage);
    userPictureOne.setText("");
    if(firstConvert == 1){
      userScore = userScore + 11;
    }else if(firstConvert == 11 || firstConvert == 12 || firstConvert == 13){
      userScore = userScore + 10;
    }else{
      userScore = userScore + firstConvert;
    }
    int randomPicTwo = randomCard();
    int secondConvert =  convertToThirteen(randomPicTwo);
    if(secondConvert ==1){
      aceCheck = true;
      aceValid = true;
    }
    ImageIcon secondImage = pictureChoose(secondConvert);
    userPictureTwo.setIcon(secondImage);
    userPictureTwo.setText("");
    if(secondConvert == 1){
      userScore = userScore + 11;
      aceValid = true;
    } else if (secondConvert == 11 || secondConvert == 12 || secondConvert == 13){
      userScore = userScore + 10;
    } else {
    userScore = userScore + secondConvert;
    }
    if(userScore > 21 && aceCheck == true){
      userScore = userScore - 10;
      aceValid = false;
    }
    winLabel.setText(" Score: " + userScore);
    }else if(command.equals("hit")){
      //gets a random number
      int randomNum = randomCard();
      //converts it
      int thirdConvert = convertToThirteen(randomNum);
      //if its = 1 thn its an ace, add 11 to the total instead of one, sets acecheck and acevalid to true
      if (thirdConvert == 1){
        userScore = userScore + 11;
        aceCheck = true;
        aceValid = true;
      }else if(thirdConvert == 11 || thirdConvert == 12 || thirdConvert == 13){
        //if its jack queen or king, only add 10 instead of their actual values of 11 12 and 13 respectively
        userScore = userScore + 10;
      }else{
        //if its any card besides ace jack queen or king, adds the value of the number post-convert to thirteen
        userScore = userScore + thirdConvert;
      }
      //calls the method to choose which picture is applicable
      ImageIcon thirdImage = pictureChoose(thirdConvert);
      //adds that picture to whatever label is decided in the array of JLabels created earlier and sets the text in them to nothing
      userCards[numberOfCards].setIcon(thirdImage);
      userCards[numberOfCards].setText("");
      if(userScore <= 21){
        //as long as youre below 21, your score will be displayed in very large words
        winLabel.setText(" Score: " + userScore);
      }
      if(userScore > 21 && aceCheck == true && aceValid == true){
        //if you have one ace and you get above 21 the ace is changed into a 1 instead of an 11, therefore subtracted 10
        userScore = userScore - 10;
        //since the ace was changed, the ace is no longer valid to be changed in the future, so aceValid is set to false
        aceValid = false;
        //shows score
        winLabel.setText(" Score: " + userScore);
      } else if(userScore > 21 && aceCheck == false){
        //if scores above 21 and no ace is drawn to save you, YOU LOSE
       winLabel.setText("  YOU LOSE");
       //disable buttons
       hitButton.setEnabled(false);
       standButton.setEnabled(false);
      } else if(userScore > 21 && aceCheck == true && aceValid == false){
        //safety line for if an ace is drawn but it was already changed, then if you go above 21, YOU LOSE
       winLabel.setText("  YOU LOSE");
       //disable using the buttons after you lose
       hitButton.setEnabled(false);
       standButton.setEnabled(false);
      }
      //adds 1 to the number of cards so it can be used to find out which card # label should be used
      numberOfCards = numberOfCards + 1;

    }else if(command.equals("stand")){
      hitButton.setEnabled(false);
      //all comments here will be the same as when the hit number is pressed, just for the dealer, unless otherwise specified
      while(dealerScore <= userScore){
      int randomDealerNum = randomCard();
      int secondDealerConvert = convertToThirteen(randomDealerNum);
      if(secondDealerConvert == 1){
        dealerScore = dealerScore + 11;
        dealerAceCheck = true;
        dealerAceValid = true;
      }else if(secondDealerConvert == 11 || secondDealerConvert == 12 || secondDealerConvert == 13){
        dealerScore = dealerScore + 10;
      }else{
        dealerScore = dealerScore + secondDealerConvert;
      }
      ImageIcon dealerSecondImage = pictureChoose(secondDealerConvert);
      dealerCards[dealerNumberOfCards].setIcon(dealerSecondImage);
      dealerCards[dealerNumberOfCards].setText("");
      if (dealerScore > 21 && dealerAceCheck == true && dealerAceValid == true){
        //higher then 21 but a chance to et saved by ace so program continues
        dealerScore = dealerScore - 10;
        dealerAceValid = false;
      }else if(dealerScore > 21 && dealerAceCheck == true && dealerAceValid == false){
        //higher then 21 but ace already changed so dealer loses
        winLabel.setText("   YOU WIN");
        hitButton.setEnabled(false);
        standButton.setEnabled(false);
      }else if(dealerScore > 21 && dealerAceCheck == false){
        winLabel.setText("   YOU WIN");
        hitButton.setEnabled(false);
        standButton.setEnabled(false);
      }else if(dealerScore > userScore && dealerScore <= 21){
        winLabel.setText("  YOU LOSE");
        hitButton.setEnabled(false);
        standButton.setEnabled(false);
      }
      //adds another card ot the number of cards each time a card is drawn
      dealerNumberOfCards = dealerNumberOfCards + 1;
     }
    }
   }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
