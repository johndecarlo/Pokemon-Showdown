import java.io.*;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;

public class PokemonBattleDriver {
   
   public static JFrame frame;
   
   public static PokemonScreen screen;					//Game window
   public static JLabel output_text;
   public static JLabel player_pokemon;
   public static JLabel foe_pokemon;
   public static JLabel player_level;
   public static JLabel foe_level; 
   public static JLabel hp;
   
   public static JButton attack_1;
   public static JButton attack_2;
   public static JButton attack_3;
   public static JButton attack_4;
   
   public static JButton pokemon_2;
   public static JButton pokemon_3;
   public static JButton pokemon_4;
   public static JButton pokemon_5;
   public static JButton pokemon_6;
   
   public static Timer damage1_calculator;
   public static Timer player_attackMissed;
   public static Timer opp_attackMissed;
   public static Timer damage1;
   public static Timer damage2;
   public static Timer opp_options1;
   public static Timer opp_options2;
   public static Timer damage2_calculator;
   public static Timer player_options;
   public static Timer player_switch;
   public static Timer weakness;
   
   public static Timer move1;
   public static Timer move2;
   public static Timer move3;
   public static Timer move4;
   
   public static boolean complete = false;
   public static boolean miss = false;
   
   public static int TIME_DELAY;
   public static int d1 = 0;
   public static int d2 = 0;
   public static int accuracy = 100;
   
   public static void main(String[]args) throws Exception {
   
      frame = new JFrame("Pokemon Battle");	//window title
      screen = new PokemonScreen();
      createOptions();
      
      frame.setSize(1025, 840);				//Size of game window
      frame.setLocation(300, 0);				//location of game window on the screen
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(screen);
      frame.setResizable(false);		
      frame.setVisible(true);
   }
   
   public static void createOptions() throws InterruptedException {
      screen.setLayout(null);  
      //Initalize our fonts
      Font f1 = new Font("",Font.BOLD,25);
      Font f2 = new Font("",Font.BOLD,35);
      Font f3 = new Font("",Font.BOLD,15);
      //First Pokemon in party attacks
      if(!screen.getPlayer().getFirstPokemon().getMove1().getDisplayName().equals(""))
         attack_1 = new JButton(screen.getPlayer().getFirstPokemon().getMove1().getDisplayName() + " [" + screen.getPlayer().getFirstPokemon().getMove1().getRemPP() + "/" + screen.getPlayer().getFirstPokemon().getMove1().getPP() + "]"); 
      else
         attack_1 = new JButton();     
      attack_1.setBounds(0, 650, 512, 50);
      attack_1.setFont(f1);
      attack_1.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               hideButtons();
               if(!screen.getPlayer().getFirstPokemon().getMove1().getDisplayName().equals("") && screen.getPlayer().getFirstPokemon().getMove1().getRemPP() > 0) {
                  if(screen.getPlayer().getFirstPokemon().getSpeed() > screen.getFoe().getFirstPokemon().getSpeed())
                     playerAttackFirst(1);
                  else
                     oppAttackFirst(1);
               } else {
                  addButtons();
                  update();
               } 
            } });   
      screen.add(attack_1);
      if(!screen.getPlayer().getFirstPokemon().getMove2().getDisplayName().equals(""))
         attack_2 = new JButton(screen.getPlayer().getFirstPokemon().getMove2().getDisplayName() + " [" + screen.getPlayer().getFirstPokemon().getMove2().getRemPP() + "/" + screen.getPlayer().getFirstPokemon().getMove2().getPP() + "]"); 
      else
         attack_2 = new JButton();              
      attack_2.setBounds(512, 650, 512, 50);
      attack_2.setFont(f1);
      attack_2.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               hideButtons();
               if(!screen.getPlayer().getFirstPokemon().getMove1().getDisplayName().equals("") && screen.getPlayer().getFirstPokemon().getMove2().getRemPP() > 0) {
                  if(screen.getPlayer().getFirstPokemon().getSpeed() > screen.getFoe().getFirstPokemon().getSpeed())
                     playerAttackFirst(2);
                  else
                     oppAttackFirst(2);
               } else {
                  addButtons();
                  update();
               } 
            } });          
      screen.add(attack_2);
      if(!screen.getPlayer().getFirstPokemon().getMove3().getDisplayName().equals(""))
         attack_3 = new JButton(screen.getPlayer().getFirstPokemon().getMove3().getDisplayName() + " [" + screen.getPlayer().getFirstPokemon().getMove3().getRemPP() + "/" + screen.getPlayer().getFirstPokemon().getMove3().getPP() + "]"); 
      else
         attack_3 = new JButton();            
      attack_3.setBounds(0, 700, 512, 50);
      attack_3.setFont(f1);
      attack_3.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               hideButtons();
               if(!screen.getPlayer().getFirstPokemon().getMove1().getDisplayName().equals("") && screen.getPlayer().getFirstPokemon().getMove3().getRemPP() > 0) {
                  if(screen.getPlayer().getFirstPokemon().getSpeed() > screen.getFoe().getFirstPokemon().getSpeed())
                     playerAttackFirst(3);
                  else
                     oppAttackFirst(3);
               } else {
                  addButtons();
                  update();
               } 
            } });          
      screen.add(attack_3);
      if(!screen.getPlayer().getFirstPokemon().getMove4().getDisplayName().equals(""))
         attack_4 = new JButton(screen.getPlayer().getFirstPokemon().getMove4().getDisplayName() + " [" + screen.getPlayer().getFirstPokemon().getMove4().getRemPP() + "/" + screen.getPlayer().getFirstPokemon().getMove4().getPP() + "]"); 
      else
         attack_4 = new JButton();             
      attack_4.setBounds(512, 700, 512, 50);
      attack_4.setFont(f1);
      attack_4.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               hideButtons();
               if(!screen.getPlayer().getFirstPokemon().getMove1().getDisplayName().equals("") && screen.getPlayer().getFirstPokemon().getMove4().getRemPP() > 0) {
                  if(screen.getPlayer().getFirstPokemon().getSpeed() > screen.getFoe().getFirstPokemon().getSpeed())
                     playerAttackFirst(4);
                  else
                     oppAttackFirst(4);
               } else {
                  addButtons();
                  update();
               } 
            } });       
      screen.add(attack_4);
      //Pokemon in party
      pokemon_2 = new JButton(screen.getPlayer().getPokemon(1).getName() + "  Lv." + screen.getPlayer().getPokemon(1).getLevel());             
      pokemon_2.setBounds(0, 750, 205, 50);
      pokemon_2.setFont(f3);
      pokemon_2.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               hideButtons();
               new Timer(500, 
                  new ActionListener() {
                     public void actionPerformed(ActionEvent e) {
                        if(!screen.getSwitchFainted())
                           screen.switchPokemon(1);
                        if(screen.getSwitchFainted())
                           screen.switchFainted(1);
                        ((Timer)e.getSource()).stop(); }
                  }).start(); 
            }
         });
      screen.add(pokemon_2);
      pokemon_3 = new JButton(screen.getPlayer().getPokemon(2).getName() + "  Lv." + screen.getPlayer().getPokemon(2).getLevel());             
      pokemon_3.setBounds(205, 750, 205, 50);
      pokemon_3.setFont(f3);
      pokemon_3.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new Timer(500, 
                  new ActionListener() {
                     public void actionPerformed(ActionEvent e) {
                        if(!screen.getSwitchFainted())
                           screen.switchPokemon(2);
                        if(screen.getSwitchFainted())
                           screen.switchFainted(2);
                        ((Timer)e.getSource()).stop(); }
                  }).start(); }
         });
      screen.add(pokemon_3);
      pokemon_4 = new JButton(screen.getPlayer().getPokemon(3).getName() + "  Lv." + screen.getPlayer().getPokemon(3).getLevel());             
      pokemon_4.setBounds(410, 750, 205, 50);
      pokemon_4.setFont(f3);
      pokemon_4.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new Timer(500, 
                  new ActionListener() {
                     public void actionPerformed(ActionEvent e) {
                        if(!screen.getSwitchFainted())
                           screen.switchPokemon(3);
                        if(screen.getSwitchFainted())
                           screen.switchFainted(3);
                        ((Timer)e.getSource()).stop(); }
                  }).start(); }
         });
      screen.add(pokemon_4);
      pokemon_5 = new JButton(screen.getPlayer().getPokemon(4).getName() + "  Lv." + screen.getPlayer().getPokemon(4).getLevel());             
      pokemon_5.setBounds(615, 750, 205, 50);
      pokemon_5.setFont(f3);
      pokemon_5.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new Timer(500, 
                  new ActionListener() {
                     public void actionPerformed(ActionEvent e) {
                        if(!screen.getSwitchFainted())
                           screen.switchPokemon(4);
                        if(screen.getSwitchFainted())
                           screen.switchFainted(4);
                        ((Timer)e.getSource()).stop(); }
                  }).start(); }
         });
      screen.add(pokemon_5);
      pokemon_6 = new JButton(screen.getPlayer().getPokemon(5).getName() + "  Lv." + screen.getPlayer().getPokemon(5).getLevel());             
      pokemon_6.setBounds(820, 750, 205, 50);
      pokemon_6.setFont(f3);
      pokemon_6.addActionListener(
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               new Timer(500, 
                  new ActionListener() {
                     public void actionPerformed(ActionEvent e) {
                        if(!screen.getSwitchFainted())
                           screen.switchPokemon(5);
                        if(screen.getSwitchFainted())
                           screen.switchFainted(5);
                        ((Timer)e.getSource()).stop(); }
                  }).start(); }
         });
      screen.add(pokemon_6);
      //Initalize each JLabel
      output_text = new JLabel("<html>What will " + screen.getPlayer().getFirstPokemon().getName() + " do?</html>");
      player_pokemon = new JLabel("<html>" + screen.getPlayer().getFirstPokemon().getName() +"</html>");
      foe_pokemon = new JLabel("<html>" + screen.getFoe().getFirstPokemon().getName() +"</html>");
      player_level = new JLabel("<html>Lv." + screen.getPlayer().getFirstPokemon().getLevel() +"</html>");
      foe_level = new JLabel("<html>Lv." + screen.getFoe().getFirstPokemon().getLevel() +"</html>");
      hp = new JLabel(screen.getPlayer().getFirstPokemon().getRemHP() + "/" + screen.getPlayer().getFirstPokemon().getMaxHP());
      //Set the font for each JLabel
      output_text.setFont(f1);
      player_pokemon.setFont(f2);
      foe_pokemon.setFont(f2);
      player_level.setFont(f2);
      foe_level.setFont(f2);
      hp.setFont(f2);
      //Set the bounds for all our JLabel
      output_text.setBounds(50, 585, 600, 50);
      foe_pokemon.setBounds(40, 70, 250, 100);
      player_pokemon.setBounds(625, 370, 250, 100);
      foe_level.setBounds(265, 70, 250, 100);
      player_level.setBounds(865, 370, 250, 100);
      hp.setBounds(825, 435, 200, 100);
      //Add all the new JLabel to the screen
      screen.add(output_text);
      screen.add(player_pokemon);
      screen.add(foe_pokemon);
      screen.add(player_level);
      screen.add(foe_level);
      screen.add(hp);
   }
   
   public static void update() {
      if(screen.getPlayer().getFirstPokemon().getCanBattle()) {
         player_pokemon.setText("<html>" + screen.getPlayer().getFirstPokemon().getName() +"</html>");
         player_level.setText("<html>Lv." + screen.getPlayer().getFirstPokemon().getLevel() +"</html>");
         hp.setText(screen.getPlayer().getFirstPokemon().getRemHP() + "/" + screen.getPlayer().getFirstPokemon().getMaxHP());
      } else {
         player_pokemon.setText("");
         player_level.setText("");
         hp.setText("");
      }
      if(screen.getFoe().getFirstPokemon().getCanBattle()) {
         foe_pokemon.setText("<html>" + screen.getFoe().getFirstPokemon().getName() +"</html>");
         foe_level.setText("<html>Lv." + screen.getFoe().getFirstPokemon().getLevel() +"</html>");
      } else {
         foe_pokemon.setText("");
         foe_level.setText("");
      }
      if(screen.getSwitching1() == true || screen.getSwitchFainted() == true) {
         player_pokemon.setText("");
         player_level.setText("");
         hp.setText("");
      } 
      if (screen.getSwitching2()) {
         foe_pokemon.setText("");
         foe_level.setText("");
      } 
      
      if(!screen.getPlayer().getFirstPokemon().getMove1().getDisplayName().equals(""))
         attack_1.setText(screen.getPlayer().getFirstPokemon().getMove1().getDisplayName() + " [" + screen.getPlayer().getFirstPokemon().getMove1().getRemPP() + "/" + screen.getPlayer().getFirstPokemon().getMove1().getPP() + "]"); 
      else
         attack_1.setText("");
      if(!screen.getPlayer().getFirstPokemon().getMove2().getDisplayName().equals(""))
         attack_2.setText(screen.getPlayer().getFirstPokemon().getMove2().getDisplayName() + " [" + screen.getPlayer().getFirstPokemon().getMove2().getRemPP() + "/" + screen.getPlayer().getFirstPokemon().getMove2().getPP() + "]"); 
      else
         attack_2.setText("");
      if(!screen.getPlayer().getFirstPokemon().getMove3().getDisplayName().equals(""))
         attack_3.setText(screen.getPlayer().getFirstPokemon().getMove3().getDisplayName() + " [" + screen.getPlayer().getFirstPokemon().getMove3().getRemPP() + "/" + screen.getPlayer().getFirstPokemon().getMove3().getPP() + "]"); 
      else
         attack_3.setText("");
      if(!screen.getPlayer().getFirstPokemon().getMove4().getDisplayName().equals(""))
         attack_4.setText(screen.getPlayer().getFirstPokemon().getMove4().getDisplayName() + " [" + screen.getPlayer().getFirstPokemon().getMove4().getRemPP() + "/" + screen.getPlayer().getFirstPokemon().getMove4().getPP() + "]"); 
      else
         attack_4.setText("");
      
      pokemon_2.setText(screen.getPlayer().getPokemon(1).getName() + "  Lv." + screen.getPlayer().getPokemon(1).getLevel());
      if(!screen.getPlayer().getPokemon(1).getCanBattle())
         pokemon_2.setEnabled(false);
      pokemon_3.setText(screen.getPlayer().getPokemon(2).getName() + "  Lv." + screen.getPlayer().getPokemon(2).getLevel());
      if(!screen.getPlayer().getPokemon(2).getCanBattle())
         pokemon_3.setEnabled(false);
      pokemon_4.setText(screen.getPlayer().getPokemon(3).getName() + "  Lv." + screen.getPlayer().getPokemon(3).getLevel());
      if(!screen.getPlayer().getPokemon(3).getCanBattle())
         pokemon_4.setEnabled(false);
      pokemon_5.setText(screen.getPlayer().getPokemon(4).getName() + "  Lv." + screen.getPlayer().getPokemon(4).getLevel());
      if(!screen.getPlayer().getPokemon(4).getCanBattle())
         pokemon_5.setEnabled(false);
      pokemon_6.setText(screen.getPlayer().getPokemon(5).getName() + "  Lv." + screen.getPlayer().getPokemon(5).getLevel());
      if(!screen.getPlayer().getPokemon(5).getCanBattle())
         pokemon_6.setEnabled(false);
         
      if(!screen.getPlayerCanBattle()) {
         attack_1.setText("");
         attack_2.setText("");
         attack_3.setText("");
         attack_4.setText("");
         pokemon_2.setText("");
         pokemon_3.setText("");
         pokemon_4.setText("");
         pokemon_5.setText("");
         pokemon_6.setText(screen.getPlayer().getPokemon(5).getName());
      }
      screen.repaint();
   }
   
   public static void hideButtons() {
      attack_1.setEnabled(false);
      attack_2.setEnabled(false);
      attack_3.setEnabled(false);
      attack_4.setEnabled(false);
      pokemon_2.setEnabled(false);
      pokemon_3.setEnabled(false);
      pokemon_4.setEnabled(false);
      pokemon_5.setEnabled(false);
      pokemon_6.setEnabled(false); 
   }
   
   public static void addButtons() {
      attack_1.setEnabled(true);
      attack_2.setEnabled(true);
      attack_3.setEnabled(true);
      attack_4.setEnabled(true);
      pokemon_2.setEnabled(true);
      pokemon_3.setEnabled(true);
      pokemon_4.setEnabled(true);
      pokemon_5.setEnabled(true);
      pokemon_6.setEnabled(true); 
   }
   
   public static void choosePokemon() {
      if(screen.getPlayer().getPokemon(1).getCanBattle())
         pokemon_2.setEnabled(true);
      pokemon_3.setText(screen.getPlayer().getPokemon(2).getName());
      if(screen.getPlayer().getPokemon(2).getCanBattle())
         pokemon_3.setEnabled(true);
      pokemon_4.setText(screen.getPlayer().getPokemon(3).getName());
      if(screen.getPlayer().getPokemon(3).getCanBattle())
         pokemon_4.setEnabled(true);
      pokemon_5.setText(screen.getPlayer().getPokemon(4).getName());
      if(screen.getPlayer().getPokemon(4).getCanBattle())
         pokemon_5.setEnabled(true);
      pokemon_6.setText(screen.getPlayer().getPokemon(5).getName());
      if(screen.getPlayer().getPokemon(5).getCanBattle())
         pokemon_6.setEnabled(true);
      update();
   }
   
   public static void setOutputText(String text) {
      output_text.setText(text);
   } 
   
   public static void playerAttackFirst(int move) {
      new Timer(500, 
         new ActionListener() {
            int count = 0;
            public void actionPerformed(ActionEvent e) {
               if(!complete) {
                  if(count == 0) {  //State that we are attacking first
                     if(move == 1)
                        output_text.setText(screen.getPlayer().getFirstPokemon().getName() + " used " + screen.getPlayer().getFirstPokemon().getMove1().getDisplayName());
                     else if(move == 2)
                        output_text.setText(screen.getPlayer().getFirstPokemon().getName() + " used " + screen.getPlayer().getFirstPokemon().getMove2().getDisplayName());
                     else if(move == 3)
                        output_text.setText(screen.getPlayer().getFirstPokemon().getName() + " used " + screen.getPlayer().getFirstPokemon().getMove3().getDisplayName());
                     else if(move == 4)
                        output_text.setText(screen.getPlayer().getFirstPokemon().getName() + " used " + screen.getPlayer().getFirstPokemon().getMove4().getDisplayName());
                     count++;
                  } else if (count == 1) {   //Caclulate the attack damage and determine the amount of damage done
                     if(move == 1) {
                        d1 = screen.damage(screen.getPlayer().getFirstPokemon(), screen.getFoe().getFirstPokemon(), screen.getPlayer().getFirstPokemon().getMove1());
                        accuracy = screen.getPlayer().getFirstPokemon().getMove1().getAccuracy() * (screen.getPlayer().getFirstPokemon().getAccuracy()/screen.getFoe().getFirstPokemon().getEvasion());
                     } else if(move == 2) {
                        d1 = screen.damage(screen.getPlayer().getFirstPokemon(), screen.getFoe().getFirstPokemon(), screen.getPlayer().getFirstPokemon().getMove2());
                        accuracy = screen.getPlayer().getFirstPokemon().getMove2().getAccuracy() * (screen.getPlayer().getFirstPokemon().getAccuracy()/screen.getFoe().getFirstPokemon().getEvasion());
                     } else if(move == 3) {
                        d1 = screen.damage(screen.getPlayer().getFirstPokemon(), screen.getFoe().getFirstPokemon(), screen.getPlayer().getFirstPokemon().getMove3());
                        accuracy = screen.getPlayer().getFirstPokemon().getMove3().getAccuracy() * (screen.getPlayer().getFirstPokemon().getAccuracy()/screen.getFoe().getFirstPokemon().getEvasion());
                     } else if(move == 4) {
                        d1 = screen.damage(screen.getPlayer().getFirstPokemon(), screen.getFoe().getFirstPokemon(), screen.getPlayer().getFirstPokemon().getMove4());
                        accuracy = screen.getPlayer().getFirstPokemon().getMove4().getAccuracy() * (screen.getPlayer().getFirstPokemon().getAccuracy()/screen.getFoe().getFirstPokemon().getEvasion());
                     } 
                     int missed = (int)(Math.random() * 100) + 1;
                     if(missed > accuracy && accuracy != 0)
                        miss = true;
                     else {
                        if(d1 > screen.getFoe().getFirstPokemon().getRemHP()) 
                           d1 = screen.getFoe().getFirstPokemon().getRemHP();
                     }
                     update();
                     complete = true;
                  }
               } else {
                  if(miss == true) {
                     player_attackMissed.start();
                     complete = false;
                     ((Timer)e.getSource()).stop();
                  } else { 
                     damage1.start();
                     complete = false;
                     ((Timer)e.getSource()).stop();
                  }
               }
            }
         }).start(); 
      player_attackMissed = new Timer(500, 
         new ActionListener() {
            int count = 0;
            public void actionPerformed(ActionEvent e) {
               if(count == 0) {
                  output_text.setText(screen.getPlayer().getFirstPokemon().getName() + "'s attack missed.");
                  miss = false;
                  count++;
               } else {
                  opp_options1.start();            //Go to option 4 to determine the damage
                  ((Timer)e.getSource()).stop();
               }
            }
         });
      damage1 = new Timer(20, 
         new ActionListener() {
            int count = 0;
            int remHP = screen.getFoe().getFirstPokemon().getRemHP();
            public void actionPerformed(ActionEvent e) {
               if (count == d1 || screen.getFoe().getFirstPokemon().getRemHP() == 0) {
                  complete = false;
                  weakness.start();            //Go to option 4 to determine the damage
                  ((Timer)e.getSource()).stop();
               } else {
                  remHP--;
                  screen.getFoe().getFirstPokemon().setRemHP(remHP);
                  count++;
                  PokemonBattleDriver.update();
               }
            }
         });
      weakness = new Timer(500, 
         new ActionListener() {
            Move mov;
            public void actionPerformed(ActionEvent e) {
               if(move == 1)
                  mov = screen.getPlayer().getFirstPokemon().getMove1();
               else if(move == 2)
                  mov = screen.getPlayer().getFirstPokemon().getMove2();
               else if(move == 3)
                  mov = screen.getPlayer().getFirstPokemon().getMove3();
               else if(move == 4)
                  mov = screen.getPlayer().getFirstPokemon().getMove4();
               if((screen.weakness(screen.getFoe().getFirstPokemon().getType1(), mov.getType()) * screen.weakness(screen.getFoe().getFirstPokemon().getType2(), mov.getType())) >= 2) {
                  output_text.setText("It's super effective!");
               } else if((screen.weakness(screen.getFoe().getFirstPokemon().getType1(), mov.getType()) * screen.weakness(screen.getFoe().getFirstPokemon().getType2(), mov.getType())) <= 0.5) {
                  output_text.setText("It's not very effective!");
               } else if((screen.weakness(screen.getFoe().getFirstPokemon().getType1(), mov.getType()) * screen.weakness(screen.getFoe().getFirstPokemon().getType2(), mov.getType())) == 0) {
                  output_text.setText("It doesn't effect " + screen.getFoe().getFirstPokemon().getName());
               }
               opp_options1.start();            //Go to option 4 to determine the damage
               ((Timer)e.getSource()).stop();
            }
         });
      opp_options1 = new Timer(500, 
         new ActionListener() {
            boolean opp2 = false;
            boolean damage2 = false;
            public void actionPerformed(ActionEvent e) {
               if(!complete) {
                  if(screen.getFoe().getFirstPokemon().getRemHP() <= 0) { //If the foe fainted then we go to option 3
                     screen.getFoe().getFirstPokemon().setCanBattle(false);
                     output_text.setText(screen.getFoe().getFirstPokemon().getName() + " fainted.");
                     update();
                     opp2 = true;
                     complete = true;
                  } else {                            //The foe uses a move themself
                     output_text.setText("The opposing " + screen.getFoe().getFirstPokemon().getName() + " used " + screen.getFoe().getFirstPokemon().getMove1().getDisplayName());
                     damage2 = true;
                     complete = true;
                  }
               } else {
                  if(opp2) {
                     complete = false;
                     opp_options2.start();
                     ((Timer)e.getSource()).stop();
                  } else {
                     complete = false;
                     damage2_calculator.start();            //Go to option 4 to determine the damage
                     ((Timer)e.getSource()).stop();
                  }
               }
            }       
         });
      opp_options2 = new Timer(500, 
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(screen.getFoe().canBattle()) {
                  screen.switchOppPokemon(screen.getFoe(), screen.getPlayer().getFirstPokemon());
                  ((Timer)e.getSource()).stop();
               } else {                            //Opponent has no more Pokemon and is defeated
                  output_text.setText(screen.getPlayer().getName() + " defeated " + screen.getFoe().getName());
                  hideButtons();
                  ((Timer)e.getSource()).stop();
               }
            }       
         });
      damage2_calculator = new Timer(500, 
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(!complete) {
                  d2 = screen.damage(screen.getFoe().getFirstPokemon(), screen.getPlayer().getFirstPokemon(), screen.getFoe().getFirstPokemon().getMove1());
                  if(d2 > screen.getPlayer().getFirstPokemon().getRemHP()) 
                     d2 = screen.getPlayer().getFirstPokemon().getRemHP();
                  update();
                  complete = true;
               }  else {
                  complete = false;
                  damage2.start();       //Go to option 5 to determine if the Pokemon faints
                  ((Timer)e.getSource()).stop();
               }  
            }      
         });
      damage2 = new Timer(20, 
         new ActionListener() {
            int count = 0;
            int remHP = screen.getPlayer().getFirstPokemon().getRemHP();
            public void actionPerformed(ActionEvent e) {
               if (count == d2 || screen.getPlayer().getFirstPokemon().getRemHP() == 0) {
                  complete = false;
                  player_options.start();            //Go to option 4 to determine the damage
                  ((Timer)e.getSource()).stop();
               } else {
                  remHP--;
                  screen.getPlayer().getFirstPokemon().setRemHP(remHP);
                  count++;
                  PokemonBattleDriver.update();
               }
            }
         });
      player_options = new Timer(500, 
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(!complete) {
                  if(screen.getPlayer().getFirstPokemon().getRemHP() <= 0) {
                     screen.getPlayer().getFirstPokemon().setCanBattle(false);
                     output_text.setText(screen.getPlayer().getFirstPokemon().getName() + " fainted.");
                     update();
                     complete = true;
                  } else {
                     addButtons();
                     update();
                     output_text.setText("<html>What will " + screen.getPlayer().getFirstPokemon().getName() + " do?</html>");
                     ((Timer)e.getSource()).stop();
                  }
               } else {
                  complete = false;
                  player_switch.start();
                  ((Timer)e.getSource()).stop();
               }
            }       
         });
      player_switch= new Timer(500, 
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(screen.getPlayer().canBattle()) {
                  screen.setSwitchFainted(true);
                  choosePokemon();
                  output_text.setText("Choose another Pokemon.");
                  ((Timer)e.getSource()).stop();
               } else {
                  output_text.setText(screen.getPlayer().getName() + " lost to " + screen.getFoe().getName());
                  hideButtons();
                  ((Timer)e.getSource()).stop();
               }
            }       
         });
   }
   
   public static void oppAttackFirst(int move) {
      new Timer(500, 
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(!complete) {
                  output_text.setText("The opposing " + screen.getFoe().getFirstPokemon().getName() + " used " + screen.getFoe().getFirstPokemon().getMove1().getDisplayName());
                  d2 = screen.damage(screen.getFoe().getFirstPokemon(), screen.getPlayer().getFirstPokemon(), screen.getFoe().getFirstPokemon().getMove1());
                  accuracy = screen.getFoe().getFirstPokemon().getMove1().getAccuracy() * (screen.getFoe().getFirstPokemon().getAccuracy()/screen.getPlayer().getFirstPokemon().getEvasion());
                  int missed = (int)(Math.random() * 100) + 1;
                  if(missed > accuracy && accuracy != 0)
                     miss = true;
                  else {
                     if(d2 > screen.getPlayer().getFirstPokemon().getRemHP()) 
                        d2 = screen.getPlayer().getFirstPokemon().getRemHP();
                  }
                  update();
                  complete = true;
               }  else {
                  if(miss == true) {
                     opp_attackMissed.start();
                     complete = false;
                     ((Timer)e.getSource()).stop();
                  } else { 
                     damage2.start();
                     complete = false;
                     ((Timer)e.getSource()).stop();
                  }
               }  
            }      
         }).start(); 
      opp_attackMissed = new Timer(500, 
         new ActionListener() {
            int count = 0;
            public void actionPerformed(ActionEvent e) {
               if(count == 0) {
                  output_text.setText("The opposing" + screen.getFoe().getFirstPokemon().getName() + "'s attack missed.");
                  miss = false;
                  count++;
               } else {
                  opp_options1.start();            //Go to option 4 to determine the damage
                  ((Timer)e.getSource()).stop();
               }
            }
         });
      damage2 = new Timer(20, 
         new ActionListener() {
            int count = 0;
            int remHP = screen.getPlayer().getFirstPokemon().getRemHP();
            public void actionPerformed(ActionEvent e) {
               if (count == d2 || screen.getPlayer().getFirstPokemon().getRemHP() == 0) {
                  complete = false;
                  player_options.start();            //Go to option 4 to determine the damage
                  ((Timer)e.getSource()).stop();
               } else {
                  remHP--;
                  screen.getPlayer().getFirstPokemon().setRemHP(remHP);
                  count++;
                  PokemonBattleDriver.update();
               }
            }
         });
      player_options = new Timer(500, 
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(!complete) {
                  if(screen.getPlayer().getFirstPokemon().getRemHP() <= 0) {
                     output_text.setText(screen.getPlayer().getFirstPokemon().getName() + " fainted.");
                     screen.getPlayer().getFirstPokemon().setCanBattle(false);
                     update();
                     complete = true;
                  } else {
                     damage1_calculator.start();
                     ((Timer)e.getSource()).stop();
                  }
               } else {
                  complete = false;
                  player_switch.start();
                  ((Timer)e.getSource()).stop();
               }
            }       
         });
      player_switch= new Timer(500, 
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(screen.getPlayer().canBattle()) {
                  screen.setSwitchFainted(true);
                  choosePokemon();
                  output_text.setText("Choose another Pokemon.");
                  ((Timer)e.getSource()).stop();
               } else {
                  output_text.setText(screen.getPlayer().getName() + " lost to " + screen.getFoe().getName());
                  hideButtons();
                  ((Timer)e.getSource()).stop();
               }
            }       
         });
      damage1_calculator = new Timer(500, 
         new ActionListener() {
            int count = 0;
            public void actionPerformed(ActionEvent e) {
               if(!complete) {
                  if(count == 0) {  //State that we are attacking first
                     if(move == 1)
                        output_text.setText(screen.getPlayer().getFirstPokemon().getName() + " used " + screen.getPlayer().getFirstPokemon().getMove1().getDisplayName());
                     else if(move == 2)
                        output_text.setText(screen.getPlayer().getFirstPokemon().getName() + " used " + screen.getPlayer().getFirstPokemon().getMove2().getDisplayName());
                     else if(move == 3)
                        output_text.setText(screen.getPlayer().getFirstPokemon().getName() + " used " + screen.getPlayer().getFirstPokemon().getMove3().getDisplayName());
                     else if(move == 4)
                        output_text.setText(screen.getPlayer().getFirstPokemon().getName() + " used " + screen.getPlayer().getFirstPokemon().getMove4().getDisplayName());
                     count++;
                  } else if (count == 1) {   //Caclulate the attack damage and determine the amount of damage done
                     if(move == 1) {
                        d1 = screen.damage(screen.getPlayer().getFirstPokemon(), screen.getFoe().getFirstPokemon(), screen.getPlayer().getFirstPokemon().getMove1());
                        accuracy = screen.getPlayer().getFirstPokemon().getMove1().getAccuracy() * (screen.getPlayer().getFirstPokemon().getAccuracy()/screen.getFoe().getFirstPokemon().getEvasion());
                     } else if(move == 2) {
                        d1 = screen.damage(screen.getPlayer().getFirstPokemon(), screen.getFoe().getFirstPokemon(), screen.getPlayer().getFirstPokemon().getMove2());
                        accuracy = screen.getPlayer().getFirstPokemon().getMove2().getAccuracy() * (screen.getPlayer().getFirstPokemon().getAccuracy()/screen.getFoe().getFirstPokemon().getEvasion());
                     } else if(move == 3) {
                        d1 = screen.damage(screen.getPlayer().getFirstPokemon(), screen.getFoe().getFirstPokemon(), screen.getPlayer().getFirstPokemon().getMove3());
                        accuracy = screen.getPlayer().getFirstPokemon().getMove3().getAccuracy() * (screen.getPlayer().getFirstPokemon().getAccuracy()/screen.getFoe().getFirstPokemon().getEvasion());
                     } else if(move == 4) {
                        d1 = screen.damage(screen.getPlayer().getFirstPokemon(), screen.getFoe().getFirstPokemon(), screen.getPlayer().getFirstPokemon().getMove4());
                        accuracy = screen.getPlayer().getFirstPokemon().getMove4().getAccuracy() * (screen.getPlayer().getFirstPokemon().getAccuracy()/screen.getFoe().getFirstPokemon().getEvasion());
                     } 
                     int missed = (int)(Math.random() * 100) + 1;
                     if(missed > accuracy && accuracy != 0)
                        miss = true;
                     else {
                        if(d1 > screen.getFoe().getFirstPokemon().getRemHP()) 
                           d1 = screen.getFoe().getFirstPokemon().getRemHP();
                     }
                     update();
                     complete = true;
                  }
               } else {
                  if(miss == true) {
                     player_attackMissed.start();
                     complete = false;
                     ((Timer)e.getSource()).stop();
                  } else { 
                     damage1.start();
                     complete = false;
                     ((Timer)e.getSource()).stop();
                  }
               }
            }
         }); 
      player_attackMissed = new Timer(500, 
         new ActionListener() {
            int count = 0;
            public void actionPerformed(ActionEvent e) {
               if(count == 0) {
                  output_text.setText(screen.getPlayer().getFirstPokemon().getName() + "'s attack missed.");
                  miss = false;
                  count++;
               } else {
                  opp_options1.start();            //Go to option 4 to determine the damage
                  ((Timer)e.getSource()).stop();
               }
            }
         });
      damage1 = new Timer(20, 
         new ActionListener() {
            int count = 0;
            int remHP = screen.getFoe().getFirstPokemon().getRemHP();
            public void actionPerformed(ActionEvent e) {
               if (count == d1 || screen.getFoe().getFirstPokemon().getRemHP() == 0) {
                  complete = false;
                  weakness.start();            //Go to option 4 to determine the damage
                  ((Timer)e.getSource()).stop();
               } else {
                  remHP--;
                  screen.getFoe().getFirstPokemon().setRemHP(remHP);
                  count++;
                  PokemonBattleDriver.update();
               }
            }
         });
      weakness = new Timer(500, 
         new ActionListener() {
            Move mov;
            public void actionPerformed(ActionEvent e) {
               if(move == 1)
                  mov = screen.getPlayer().getFirstPokemon().getMove1();
               else if(move == 2)
                  mov = screen.getPlayer().getFirstPokemon().getMove2();
               else if(move == 3)
                  mov = screen.getPlayer().getFirstPokemon().getMove3();
               else if(move == 4)
                  mov = screen.getPlayer().getFirstPokemon().getMove4();
               if((screen.weakness(screen.getFoe().getFirstPokemon().getType1(), mov.getType()) * screen.weakness(screen.getFoe().getFirstPokemon().getType2(), mov.getType())) >= 2) {
                  output_text.setText("It's super effective!");
               } else if((screen.weakness(screen.getFoe().getFirstPokemon().getType1(), mov.getType()) * screen.weakness(screen.getFoe().getFirstPokemon().getType2(), mov.getType())) <= 0.5) {
                  output_text.setText("It's not very effective!");
               } else if((screen.weakness(screen.getFoe().getFirstPokemon().getType1(), mov.getType()) * screen.weakness(screen.getFoe().getFirstPokemon().getType2(), mov.getType())) == 0) {
                  output_text.setText("It doesn't effect " + screen.getFoe().getFirstPokemon().getName());
               }
               opp_options1.start();            //Go to option 4 to determine the damage
               ((Timer)e.getSource()).stop();
            }
         });
      opp_options1 = new Timer(500, 
         new ActionListener() {
            boolean opp2 = false;
            boolean damage2 = false;
            public void actionPerformed(ActionEvent e) {
               if(!complete) {
                  if(screen.getFoe().getFirstPokemon().getRemHP() <= 0) { //If the foe fainted then we go to option 3
                     screen.getFoe().getFirstPokemon().setCanBattle(false);
                     output_text.setText(screen.getFoe().getFirstPokemon().getName() + " fainted.");
                     update();
                     opp2 = true;
                     complete = true;
                  } else {                            //The foe uses a move themself
                     addButtons();
                     update();
                     output_text.setText("<html>What will " + screen.getPlayer().getFirstPokemon().getName() + " do?</html>");
                     ((Timer)e.getSource()).stop();
                  }
               } else {
                  if(opp2) {
                     complete = false;
                     opp_options2.start();
                     ((Timer)e.getSource()).stop();
                  } else {
                     complete = false;
                     damage2_calculator.start();            //Go to option 4 to determine the damage
                     ((Timer)e.getSource()).stop();
                  }
               }
            }       
         });
      opp_options2 = new Timer(500, 
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(screen.getFoe().canBattle()) {
                  screen.switchOppPokemon(screen.getFoe(), screen.getPlayer().getFirstPokemon());
                  ((Timer)e.getSource()).stop();
               } else {                            //Opponent has no more Pokemon and is defeated
                  output_text.setText(screen.getPlayer().getName() + " defeated " + screen.getFoe().getName());
                  hideButtons();
                  ((Timer)e.getSource()).stop();
               }
            }       
         });
   }
   
   public static void oppAttack() {
      new Timer(500, 
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(!complete) {
                  output_text.setText("The opposing " + screen.getFoe().getFirstPokemon().getName() + " used " + screen.getFoe().getFirstPokemon().getMove1().getDisplayName());
                  d2 = screen.damage(screen.getFoe().getFirstPokemon(), screen.getPlayer().getFirstPokemon(), screen.getFoe().getFirstPokemon().getMove1());
                  if(d2 > screen.getPlayer().getFirstPokemon().getRemHP()) 
                     d2 = screen.getPlayer().getFirstPokemon().getRemHP();
                  update();
                  complete = true;
               }  else {
                  complete = false;
                  damage2.start();       //Go to option 5 to determine if the Pokemon faints
                  ((Timer)e.getSource()).stop();
               }  
            }      
         }).start();
      damage2 = new Timer(20, 
         new ActionListener() {
            int count = 0;
            int remHP = screen.getPlayer().getFirstPokemon().getRemHP();
            public void actionPerformed(ActionEvent e) {
               if (count == d2 || screen.getPlayer().getFirstPokemon().getRemHP() == 0) {
                  complete = false;
                  player_options.start();            //Go to option 4 to determine the damage
                  ((Timer)e.getSource()).stop();
               } else {
                  remHP--;
                  screen.getPlayer().getFirstPokemon().setRemHP(remHP);
                  count++;
                  PokemonBattleDriver.update();
               }
            }
         });
      player_options = new Timer(500, 
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(!complete) {
                  if(screen.getPlayer().getFirstPokemon().getRemHP() <= 0) {
                     output_text.setText(screen.getPlayer().getFirstPokemon().getName() + " fainted.");
                     screen.getPlayer().getFirstPokemon().setCanBattle(false);
                     update();
                     complete = true;
                  } else {
                     addButtons();
                     update();
                     output_text.setText("<html>What will " + screen.getPlayer().getFirstPokemon().getName() + " do?</html>");
                     ((Timer)e.getSource()).stop();
                  }
               } else {
                  complete = false;
                  player_switch.start();
                  ((Timer)e.getSource()).stop();
               }
            }       
         });
      player_switch= new Timer(500, 
         new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(screen.getPlayer().canBattle()) {
                  screen.setSwitchFainted(true);
                  choosePokemon();
                  output_text.setText("Choose another Pokemon.");
                  ((Timer)e.getSource()).stop();
               } else {
                  output_text.setText(screen.getPlayer().getName() + " lost to " + screen.getFoe().getName());
                  hideButtons();
                  ((Timer)e.getSource()).stop();
               }
            }       
         });
   }
}
   
