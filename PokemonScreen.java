import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.lang.Integer;
import java.io.*;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Color;
import java.util.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

public class PokemonScreen extends JPanel {

   public static Trainer trainer1 = new Trainer();            //Create trainer one of the battle
   public static Trainer trainer2 = new Trainer();            //Create trainer two of the battle
   public static Pokemon[] party1;   // Generate trainer #1's team
   public static Pokemon[] party2;   // Generate trainer #2's team
   public static int background;
   public static int turn_count;                       //Counter whether it's player one or two's turn
   public static boolean battleIsOver;               //There are no more moves and the game is over
   private static int playerR;			//start row for the player
   private static int playerC;			//start col for the player
   public static int index, r2, c2, r3, c3; 
   public static boolean hideOptions;
   public static boolean switching1;
   public static boolean switching2;
   public static boolean switchFainted;
   public static boolean playerCanBattle; 
   
   public static boolean ballClosed;
   public static boolean ballOpen;
     
   protected static int mouseX;			//locations for the mouse pointer
   protected static int mouseY;

   public PokemonScreen() throws IOException {
      background = (int) (Math.random() * 4) + 1;
      ArrayList<Move> moves = importMoves(); // Import the data of the Pokemon Moves
      ArrayList<Pokemon> pokemon = importPokemon(moves); // Import the data of the different Pokemon
      trainer1 = new Trainer("Red", 0);
      trainer2 = new Trainer("Blue", 0);
      generateRandomTeam(pokemon, trainer1, trainer2);
      generateRandomTeam(pokemon, trainer2, trainer1);
      hideOptions = false;
      switching1 = false;
      switching2 = false;
      switchFainted = false;
      playerCanBattle = true;
      ballClosed = false;
      ballOpen = false;
      mouseX = 0;
      mouseY = 0;
   }
   
   public void paintComponent(Graphics g) {
      g.setColor(Color.red);
      super.paintComponent(g);
      Paint.paintBackground(g, background); 
      Paint.paintHpBar(g, trainer1, trainer2, switching1, switching2, switchFainted);
      Paint.paintPokemon(g, trainer1, trainer2, switching1, switching2, ballClosed, ballOpen);					
   }
   
   public Trainer getPlayer() {
      return trainer1;
   }
   
   public Trainer getFoe() {
      return trainer2;
   }
   
   public boolean getSwitching1() {
      return switching1;
   }
   
   public boolean getSwitching2() {
      return switching2;
   }
   
   public boolean getSwitchFainted() {
      return switchFainted;
   }
   
   public void setSwitching1(boolean s1) {
      switching1 = s1;
   }
   
   public void setSwitching2(boolean s2) {
      switching2 = s2;
   }
   
   public void setSwitchFainted(boolean sf) {
      switchFainted = sf;
   }
   
   public boolean getPlayerCanBattle() {
      return playerCanBattle;
   }
   
   public static void checkPlayerCanBattle() {
      boolean pokemon = false;
      for(int i = 0; i < 6; i++) {
         if(trainer1.getPokemon(i).getCanBattle())
            pokemon = true;
      }
      if(pokemon == false)
         playerCanBattle = false;
   }
   
   public static void attack(Pokemon main, Pokemon opp, int move) {
      if (move == 0) { // If the player selects the first move slot
         int damage = damage(main, opp, main.getMove1());
         new Timer(20, 
            new ActionListener() {
               int count = 0;
               int remHP = opp.getRemHP();
               public void actionPerformed(ActionEvent e) {
                  if (count == damage || opp.getRemHP() == 0) {
                     ((Timer)e.getSource()).stop();
                  } else {
                     opp.setRemHP(remHP--);
                     System.out.println(remHP);
                     count++;
                     PokemonBattleDriver.update();
                  }
               }
            }).start();
      } else if (move == 1) { // If the player selects the first move slot
         opp.setRemHP(opp.getRemHP() - damage(main, opp, main.getMove2()));
         if (opp.getRemHP() <= 0) { // Determine if the pokemon has fainted and HP should be 0.
            opp.setRemHP(0);
         }
      } else if (move == 2) { // If the player selects the first move slot
         opp.setRemHP(opp.getRemHP() - damage(main, opp, main.getMove3()));
         if (opp.getRemHP() <= 0) { // Determine if the pokemon has fainted and HP should be 0.
            opp.setRemHP(0);
         }
      }
      else if (move == 3) { // If the player selects the first move slot
         opp.setRemHP(opp.getRemHP() - damage(main, opp, main.getMove4()));
         if (opp.getRemHP() <= 0) { // Determine if the pokemon has fainted and HP should be 0.
            opp.setRemHP(0);
         }
      }
   }

   public static int damage(Pokemon x, Pokemon y, Move m) { // Damage calculator
      int pp = m.getRemPP();
      pp--;
      m.setRemPP(pp);
      double damage = 0;
      if(m.getCategory().equals("Physical")) {
         damage = ((((((2*x.getLevel())/5) + 2)*(m.getPower()*x.getAttack()))/(y.getDefense()))/50) + 2;
      }
      else if(m.getCategory().equals("Special")) 
         damage = (((((2 * x.getLevel())/5 + 2)*(m.getPower()*x.getAttack()))/(y.getDefense()))/50) + 2;
      if (x.getType1().equals(m.getType())) // Damage increase if Pokemon Type and Move Type are same
         damage *= 1.5;
      if (!x.getType2().equals("")) {
         if (x.getType2().equals(m.getType())) // Damage increase if Pokemon Type and Move Type are same
            damage *= 1.5;
      }
      damage *= weakness(y.getType1(), m.getType()) * weakness(y.getType2(), m.getType()); // effectivenes
      return (int) damage;
   }
   
   public static void generateRandomTeam(ArrayList<Pokemon> pokemon_list, Trainer trainer1, Trainer trainer2) {
      for (int i = 0; i < 6; i++) {
         int ran = (int) (Math.random() * pokemon_list.size());
         Pokemon temp = pokemon_list.get(ran);
         while(trainer1.hasPokemon(temp.getName()) || trainer2.hasPokemon(temp.getName())) {
            ran = (int) (Math.random() * pokemon_list.size());
            temp = pokemon_list.get(ran);
         }
         trainer1.setPokemon(i, temp);
      }
   }
   
   public static ArrayList<Move> importMoves() throws IOException { // Import move data from the text file
      int i = 0;
      File file = new File("moves.txt");
      ArrayList<Move> moves = new ArrayList();
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = null;
      while ((line = reader.readLine()) != null) {
         String[] a = line.split(",");
         moves.add(new Move(a[1], a[2], a[3], Integer.parseInt(a[4]), a[5], a[6], Integer.parseInt(a[7]), Integer.parseInt(a[8]), Integer.parseInt(a[9]), Integer.parseInt(a[11]), a[12]));
      }
      reader.close();
      return moves;
   }
   
   public static Move findMove(ArrayList<Move> moves, String name) { // Locates the move to import to the Pokemon move
      for (int i = 0; i < moves.size(); i++) {
         if (moves.get(i).getInternalName().equals(name))
            return moves.get(i);
      }
      return new Move();
   }

   public static ArrayList<Pokemon> importPokemon(ArrayList<Move> moves) throws IOException { // Import pokemon data
      File file = new File("pokemon.txt");
      ArrayList<Pokemon> pokemon = new ArrayList();
      BufferedReader reader = new BufferedReader(new FileReader(file));
      String line = null;
      int count = 0;
      while ((line = reader.readLine()) != null) {
         String[] a = line.split(",");
         if (a.length == 14) {
            pokemon.add(new Pokemon(a[0], Integer.parseInt(a[1]), a[2], a[3], Integer.parseInt(a[4]),
               	Integer.parseInt(a[5]), Integer.parseInt(a[6]), Integer.parseInt(a[7]), Integer.parseInt(a[8]),
               	Integer.parseInt(a[9]), findMove(moves, a[10]), findMove(moves, a[11]), findMove(moves, a[12]),
               	findMove(moves, a[13])));
         }
      }
      reader.close();
      return pokemon;
   }
   
   public static double weakness(String type1, String type2) { // Determine if the Pokemon has any weaknesses
      double weak = 1;
      if (type1 != null) {
         if (type1.equals("GRASS")) { // Grass Type
            if (type2.equals("FIRE") || type2.equals("BUG") || type2.equals("FLYING") || type2.equals("POISON")
            		|| type2.equals("ICE"))
               weak *= 2.0;
            else if (type2.equals("WATER") || type2.equals("ELECTRIC") || type2.equals("GRASS")
            		|| type2.equals("GROUND"))
               weak *= 0.5;
         } else if (type1.equals("FIRE")) { // Fire Type
            if (type2.equals("WATER") || type2.equals("ROCK") || type2.equals("GROUND"))
               weak *= 2;
            else if (type2.equals("FIRE") || type2.equals("GRASS") || type2.equals("ICE") || type2.equals("STEEL")
            		|| type2.equals("FAIRY"))
               weak *= 0.5;
         } else if (type1.equals("WATER")) { // Water type
            if (type2.equals("GRASS") || type2.equals("ELECTRIC"))
               weak *= 2;
            else if (type2.equals("FIRE") || type2.equals("WATER") || type2.equals("ICE") || type2.equals("STEEL"))
               weak *= 0.5;
         } else if (type1.equals("ELECTRIC")) { // Electric Type
            if (type2.equals("GROUND"))
               weak *= 2;
            else if (type2.equals("ELECTRIC") || type2.equals("FLYING") || type2.equals("STEEL"))
               weak *= 0.5;
         } else if (type1.equals("NORMAL")) { // Normal Type
            if (type2.equals("FIGHTING"))
               weak *= 2;
            else if (type2.equals("GHOST"))
               weak *= 0;
         } else if (type1.equals("FLYING")) { // Flying Type
            if (type2.equals("ELECTRIC") || type2.equals("ROCK") || type2.equals("ICE"))
               weak *= 2;
            else if (type2.equals("GRASS") || type2.equals("FIGHTING") || type2.equals("BUG"))
               weak *= 0.5;
            else if (type2.equals("GROUND"))
               weak *= 0;
         } else if (type1.equals("BUG")) { // Bug Type
            if (type2.equals("FIRE") || type2.equals("ROCK") || type2.equals("FLYING"))
               weak *= 2;
            else if (type2.equals("GRASS") || type2.equals("FIGHTING") || type2.equals("GROUND"))
               weak *= 0.5;
         } else if (type1.equals("ROCK")) { // Rock Type
            if (type2.equals("WATER") || type2.equals("GRASS") || type2.equals("FIGHTING") || type2.equals("GROUND")
            		|| type2.equals("STEEL"))
               weak *= 2;
            else if (type2.equals("NORMAL") || type2.equals("FIRE") || type2.equals("POISON")
            		|| type2.equals("FLYING"))
               weak *= 0.5;
         } else if (type1.equals("GROUND")) { // Ground Type
            if (type2.equals("WATER") || type2.equals("GRASS") || type2.equals("ICE"))
               weak *= 2;
            else if (type2.equals("POISON") || type2.equals("ROCK"))
               weak *= 0.5;
            else if (type2.equals("ELECTRIC"))
               weak *= 0;
         } else if (type1.equals("POISON")) { // Poison Type
            if (type2.equals("GROUND") || type2.equals("PSYCHIC"))
               weak *= 2;
            else if (type2.equals("GRASS") || type2.equals("FIGHTING") || type2.equals("POISON")
            		|| type2.equals("BUG") || type2.equals("FAIRY"))
               weak *= 0.5;
         } else if (type1.equals("FIGHTING")) { // Fighting Type
            if (type2.equals("FLYING") || type2.equals("PSYCHIC") || type2.equals("FAIRY") || type2.equals("STEEL"))
               weak *= 2;
            else if (type2.equals("BUG") || type2.equals("ROCK") || type2.equals("DARK"))
               weak *= 0.5;
         } else if (type1.equals("PSYCHIC")) { // Psychic Type
            if (type2.equals("BUG") || type2.equals("GHOST") || type2.equals("DARK"))
               weak *= 2;
            else if (type2.equals("FIGHTING") || type2.equals("PSYCHIC"))
               weak *= 0.5;
         } else if (type1.equals("GHOST")) { // Ghost Type
            if (type2.equals("GHOST") || type2.equals("DARK"))
               weak *= 2;
            else if (type2.equals("POISON") || type2.equals("BUG"))
               weak *= 0.5;
            else if (type2.equals("NORMAL") || type2.equals("FIGHTING"))
               weak *= 0;
         } else if (type1.equals("ICE")) { // Ice Type
            if (type2.equals("FIRE") || type2.equals("FIGHTING") || type2.equals("ROCK") || type2.equals("STEEL"))
               weak *= 2;
            else if (type2.equals("ICE"))
               weak *= 0.5;
         } else if (type1.equals("DRAGON")) { // Dragon Type
            if (type2.equals("ICE") || type2.equals("DRAGON") || type2.equals("FAIRY"))
               weak *= 2;
            else if (type2.equals("GRASS") || type2.equals("FIRE") || type2.equals("WATER") || type2.equals("ELECTRIC"))
               weak *= 0.5;
         } else if (type1.equals("DARK")) { // Dark Type
            if (type2.equals("BUG") || type2.equals("FAIRY") || type2.equals("FIGHTING"))
               weak *= 2;
            else if (type2.equals("GHOST") || type2.equals("DARK"))
               weak *= 0.5;
            else if (type2.equals("PSYCHIC"))
               weak *= 0;
         } else if (type1.equals("STEEL")) { // Steel Type
            if (type2.equals("FIRE") || type2.equals("GROUND") || type2.equals("FIGHTING"))
               weak *= 2;
            else if (type2.equals("NORMAL") || type2.equals("GRASS") || type2.equals("ICE") || type2.equals("FLYING") || type2.equals("PSYCHIC") || type2.equals("BUG") || type2.equals("ROCK") || type2.equals("DRAGON") || type2.equals("STEEL") || type2.equals("FAIRY"))
               weak *= 0.5;
            else if (type2.equals("POISON"))
               weak *= 0;
         } else if (type1.equals("FAIRY")) { // Fairy Type
            if (type2.equals("POISON") || type2.equals("STEEL"))
               weak *= 2;
            else if (type2.equals("FIGHTING") || type2.equals("BUG") || type2.equals("DARK"))
               weak *= 0.5;
            else if (type2.equals("DRAGON"))
               weak *= 0;
         }
      }
      return weak;
   }
   
   public static int switchOppPokemon(Trainer main, Pokemon a) {
      Pokemon[] team = main.getParty();
      for (int i = 0; i < team.length; i++) {
         Pokemon temp = team[i];
         if (temp.getCanBattle() == true) {
            int val2 = i;
            PokemonBattleDriver.setOutputText(main.getName() + " sent out " + team[i].getName());
            new Timer(750, 
                  new ActionListener() {
                     int count = 0;
                     public void actionPerformed(ActionEvent e) {
                        if(count == 0) {
                           ballClosed = true;
                           PokemonBattleDriver.update();
                           count++;
                        } else if(count == 1) { 
                           ballClosed = false;
                           ballOpen = true;
                           PokemonBattleDriver.update();
                           count++;
                        } else if(count == 2) { 
                           ballOpen = false;
                           switching2 = false;
                           main.swap(val2);
                           PokemonBattleDriver.addButtons();
                           PokemonBattleDriver.update();
                           PokemonBattleDriver.setOutputText("<html>What will " + trainer1.getFirstPokemon().getName() + " do?</html>");
                           ((Timer)e.getSource()).stop();
                        } 
                     }
                  }).start();
            return 0;
         }
      }
      return 0;
   }
   
   public static void switchPokemon(int swap) {
      new Timer(500, 
         new ActionListener() {
            int count = 0;
            public void actionPerformed(ActionEvent e) {
               if(count == 0) {
                  PokemonBattleDriver.hideButtons();
                  PokemonBattleDriver.setOutputText("Come back " + trainer1.getFirstPokemon().getName());
                  count++;
               } else if(count == 1) { 
                  switching1 = true;
                  PokemonBattleDriver.update();
                  count++;
               } else if(count == 2) { 
                  PokemonBattleDriver.setOutputText("Go " + trainer1.getPokemon(swap).getName());
                  count++;
               } else if(count == 3) { 
                  trainer1.swap(swap);
                  switching1 = false;
                  count++;
               } else if(count == 4) {
                  PokemonBattleDriver.oppAttack();
                  ((Timer)e.getSource()).stop();
               }
            }
         }).start(); 
   }
   public static void switchFainted(int swap) {
      new Timer(500, 
         new ActionListener() {
            int count = 0;
            public void actionPerformed(ActionEvent e) {
               if(count == 0) { 
                  PokemonBattleDriver.hideButtons();
                  PokemonBattleDriver.setOutputText("Go " + trainer1.getPokemon(swap).getName());
                  count++;
               } else if(count == 1) { 
                  trainer1.swap(swap);
                  switchFainted = false;
                  PokemonBattleDriver.addButtons();
                  PokemonBattleDriver.update();
                  count++;
               } else if(count == 2) {
                  PokemonBattleDriver.setOutputText("<html>What will " + trainer1.getFirstPokemon().getName() + " do?</html>");
                  ((Timer)e.getSource()).stop();
               }  
            }
         }).start(); 
   }
}