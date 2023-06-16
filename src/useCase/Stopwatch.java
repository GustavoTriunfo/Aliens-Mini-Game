package useCase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

import telas.TelaJogo;

public class Stopwatch implements ActionListener{
 
 private static JButton startButton = new JButton("START");
 private JButton resetButton = new JButton("RESET");
 private static JLabel timeLabel = new JLabel();
 private static JLabel numeroOnda = new JLabel();
 private JLabel alien = new JLabel();
 private static JLabel qtdAliens = new JLabel();
 private static int elapsedTime = 0;
 private static  int seconds =0;
 private static int minutes =0;
 private static int hours =0;
 private static boolean started = false;
 private static String seconds_string = String.format("%02d", seconds);
 private static String minutes_string = String.format("%02d", minutes);
 private static String hours_string = String.format("%02d", hours);
 private Random rand = new Random();
 private static GerenciarHorda horda = new GerenciarHorda(timeLabel,startButton,numeroOnda,qtdAliens);
 
 private static AlienThread alienThread = new AlienThread(5,200);
 

 
 static Timer timer = new Timer(1000, new ActionListener() {
  
  public void actionPerformed(ActionEvent e) {
   
   elapsedTime=elapsedTime+1000;
   hours = (elapsedTime/3600000);
   minutes = (elapsedTime/60000) % 60;
   seconds = (elapsedTime/1000) % 60;
   seconds_string = String.format("%02d", seconds);
   minutes_string = String.format("%02d", minutes);
 //  hours_string = String.format("%02d", hours);
   timeLabel.setText(minutes_string+":"+seconds_string);
   
  }
  
 });
 
 
 public Stopwatch(JLabel tempo, JButton start, GerenciarHorda modoHorda, JLabel alienNovo){
  alien = alienNovo;
  horda = modoHorda;
  startButton = start;
  timeLabel = tempo;
  tempo.setText(minutes_string+":"+seconds_string);
//  timeLabel.setBounds(100,100,200,100);
//  timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
//  timeLabel.setBorder(BorderFactory.createBevelBorder(1));
//  timeLabel.setOpaque(true);
//  timeLabel.setHorizontalAlignment(JTextField.CENTER);
  
//  startButton.setBounds(100,200,100,50);
//  startButton.setFont(new Font("Ink Free",Font.PLAIN,20));
//  startButton.setFocusable(false);
  startButton.addActionListener(this);
  
//  resetButton.setBounds(200,200,100,50);
//  resetButton.setFont(new Font("Ink Free",Font.PLAIN,20));
//  resetButton.setFocusable(false);
//  resetButton.addActionListener(this);
  
//  frame.add(startButton);
//  frame.add(resetButton);
//  frame.add(timeLabel);
//  
//  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//  frame.setSize(420,420);
//  frame.setLayout(null);
//  frame.setVisible(true);
 }
 
 @Override
 public void actionPerformed(ActionEvent e) {
  
  if(e.getSource()==startButton) {
   
   if(started==false) {
    started=true;
    startButton.setVisible(false);
  //  startButton.setText("STOP");
    start();
    horda.iniciarHorda();
    System.out.println("Horda iniciada");
   }
   else {
    started=false;
    startButton.setText("START");
    stop();
   // alienThread.stopThread();
   
   }
   
  }
  if(e.getSource()==resetButton) {
   started=false;
   startButton.setText("START");
   reset();
  }
  
 }
 
 public static void start() {
  timer.start();
  alienThread.start();
  TelaJogo.iniciarVerificacaoAlienOnda();
  TelaJogo.iniciarCriacaoMunicao();
  TelaJogo.gerenciarMusicas();
  TelaJogo.criarAliensAndam();
	
 }
 
 public static void stop() {
  timer.stop();
  started=false;
 }
 
 public static void reset() {
  timer.stop();
  elapsedTime=0;
  seconds =0;
  minutes=0;
  hours=0;
  seconds_string = String.format("%02d", seconds);
  minutes_string = String.format("%02d", minutes);
  hours_string = String.format("%02d", hours);       
  timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
 }
 
public static void retornaBotaoStart() {
	 startButton.setVisible(true);
}
}