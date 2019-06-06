import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Paint {
   
   //Methods to draw out graphics
   public static void paintBackground(Graphics g, int background) {
      if(background == 1) {
         g.drawImage(new ImageIcon("Battlebacks/battlebgIndoorA.png").getImage(), 0, 0, 1024, 576, null);   
         g.drawImage(new ImageIcon("Battlebacks/enemybaseIndoorA.png").getImage(), 512, 180, 512, 256, null);
         g.drawImage(new ImageIcon("Battlebacks/playerbaseIndoorA.png").getImage(), 0, 512, 512, 64, null); 
      } else if(background == 2) {
         g.drawImage(new ImageIcon("Battlebacks/battlebgField.png").getImage(), 0, 0, 1024, 576, null);   
         g.drawImage(new ImageIcon("Battlebacks/enemybaseField.png").getImage(), 512, 180, 512, 256, null);
         g.drawImage(new ImageIcon("Battlebacks/playerbaseField.png").getImage(), 0, 512, 512, 64, null); 
      } else if(background == 3) {
         g.drawImage(new ImageIcon("Battlebacks/battlebgMountain.png").getImage(), 0, 0, 1024, 576, null);   
         g.drawImage(new ImageIcon("Battlebacks/enemybaseMountain.png").getImage(), 512, 180, 512, 256, null);
         g.drawImage(new ImageIcon("Battlebacks/playerbaseMountain.png").getImage(), 0, 512, 512, 64, null); 
      } else {
         g.drawImage(new ImageIcon("Battlebacks/battlebgChampion.png").getImage(), 0, 0, 1024, 576, null);   
         g.drawImage(new ImageIcon("Battlebacks/enemybaseChampion.png").getImage(), 512, 180, 512, 256, null);
         g.drawImage(new ImageIcon("Battlebacks/playerbaseChampion.png").getImage(), 0, 512, 512, 64, null); 
      }
      g.drawImage(new ImageIcon("HP_Bar/overlay_message.png").getImage(), 0, 576, 1024, 74, null);
   }
   
   public static void paintHpBar(Graphics g, Trainer trainer1, Trainer trainer2, boolean switching1, boolean switching2, boolean switchFainted) {
      if(trainer1.getFirstPokemon().getCanBattle() && switching1 == false && switchFainted == false) {
         g.drawImage(new ImageIcon("HP_Bar/databox_normal.png").getImage(), 525, 385, 500, 125, null);
         //Draw the HP Bar for Player 1's First Pokemon
         double percent_1 = (double)(trainer1.getFirstPokemon().getRemHP() / (double) trainer1.getFirstPokemon().getMaxHP());
         int HP_bar1 = (int)(185.0 * percent_1);
         if(percent_1 > 0.5)
            g.drawImage(new ImageIcon("HP_Bar/hp_green.png").getImage(), 787, 449, HP_bar1, 11, null);
         else if(percent_1 > 0.25)
            g.drawImage(new ImageIcon("HP_Bar/hp_yellow.png").getImage(), 787, 449, HP_bar1, 11, null);
         else
            g.drawImage(new ImageIcon("HP_Bar/hp_red.png").getImage(), 787, 449, HP_bar1, 11, null);
      }
      //Draw the Pokemon Data Boxes onto the Panel
      if(trainer2.getFirstPokemon().getCanBattle() && switching2 == false) {
         g.drawImage(new ImageIcon("HP_Bar/databox_normal_foe.png").getImage(), 0, 75, 450, 125, null);
      //Draw the HP Bar for Player 2's First Pokemon
         double percent_2 = (double)(trainer2.getFirstPokemon().getRemHP() / (double) trainer2.getFirstPokemon().getMaxHP());
         int HP_bar2 = (int)(167.0 * percent_2);
         if(percent_2 > 0.5)
            g.drawImage(new ImageIcon("HP_Bar/hp_green.png").getImage(), 204, 156, HP_bar2, 12, null);
         else if(percent_2 > 0.25)
            g.drawImage(new ImageIcon("HP_Bar/hp_yellow.png").getImage(), 204, 156, HP_bar2, 12, null);
         else
            g.drawImage(new ImageIcon("HP_Bar/hp_red.png").getImage(), 204, 156, HP_bar2, 12, null);
      }
      //Draw out the 6 Poke Balls to represent Player 1's Pokemon
      int x = 625, y = 520;    //Set starting point for x and 
      if(trainer1.canBattle()) {
         for(int p1 = 0; p1 < 6; p1++) {   //For each tile in the rack length
            if(!trainer1.getPokemon(p1).getCanBattle())
               g.drawImage(new ImageIcon("HP_Bar/icon_ball_faint.png").getImage(), x, y, 50, 50, null); //Print out whatever letter is on the board
            else if(!trainer1.getPokemon(p1).getStatus().equals("none"))
               g.drawImage(new ImageIcon("HP_Bar/icon_ball_status.png").getImage(), x, y, 50, 50, null); //Print out whatever letter is on the board
            else
               g.drawImage(new ImageIcon("HP_Bar/icon_ball.png").getImage(), x, y, 50, 50, null); //Print out whatever letter is on the board 
            x+=60;	
         }
      }
      x = 25;
      y = 205;
      //Draw out the 6 Poke Balls to represent Player 2's Pokemon
      if(trainer2.canBattle()) {
         for(int p2 = 0; p2 < 6; p2++) {   //For each tile in the rack length
            if(!trainer2.getPokemon(p2).getCanBattle())
               g.drawImage(new ImageIcon("HP_Bar/icon_ball_faint.png").getImage(), x, y, 50, 50, null); //Print out whatever letter is on the board
            else if(!trainer2.getPokemon(p2).getStatus().equals("none"))
               g.drawImage(new ImageIcon("HP_Bar/icon_ball_status.png").getImage(), x, y, 50, 50, null); //Print out whatever letter is on the board
            else
               g.drawImage(new ImageIcon("HP_Bar/icon_ball.png").getImage(), x, y, 50, 50, null); //Print out whatever letter is on the board rd 
            x+=60;	
         }
      }
   }
   
   public static void paintOptions(Graphics g, Trainer trainer1, boolean playerCanBattle) {
   //Display Move 1 for Player First Pokemon
      if(playerCanBattle) {
         if(trainer1.getFirstPokemon().getMove1().getType().equals("NORMAL")) {   //NORMAL
            g.drawImage(new ImageIcon("cursor_moves/cursor_normal.png").getImage(), 0, 650, 512, 50, null);
         } else if (trainer1.getFirstPokemon().getMove1().getType().equals("FIRE")) { //FIRE
            g.drawImage(new ImageIcon("cursor_moves/cursor_fire.png").getImage(), 0, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove1().getType().equals("WATER")) {  //wATER
            g.drawImage(new ImageIcon("cursor_moves/cursor_water.png").getImage(), 0, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove1().getType().equals("GRASS")) {  //GRASS
            g.drawImage(new ImageIcon("cursor_moves/cursor_grass.png").getImage(), 0, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove1().getType().equals("ELECTRIC")) {  //ELECTRIC
            g.drawImage(new ImageIcon("cursor_moves/cursor_electric.png").getImage(), 0, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove1().getType().equals("ICE")) { //ICE
            g.drawImage(new ImageIcon("cursor_moves/cursor_ice.png").getImage(), 0, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove1().getType().equals("FIGHTING")) {  //FIGHTING
            g.drawImage(new ImageIcon("cursor_moves/cursor_fighting.png").getImage(), 0, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove1().getType().equals("POISON")) { //POISON
            g.drawImage(new ImageIcon("cursor_moves/cursor_poison.png").getImage(), 0, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove1().getType().equals("GROUND")) { //GROUND
            g.drawImage(new ImageIcon("cursor_moves/cursor_ground.png").getImage(), 0, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove1().getType().equals("FLYING")) { //FLYING
            g.drawImage(new ImageIcon("cursor_moves/cursor_flying.png").getImage(), 0, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove1().getType().equals("PSYCHIC")) {   //PSYCHIC
            g.drawImage(new ImageIcon("cursor_moves/cursor_psychihc.png").getImage(), 0, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove1().getType().equals("BUG")) { //BUG
            g.drawImage(new ImageIcon("cursor_moves/cursor_bug.png").getImage(), 0, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove1().getType().equals("ROCK")) {   //ROCK
            g.drawImage(new ImageIcon("cursor_moves/cursor_rock.png").getImage(), 0, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove1().getType().equals("GHOST")) {  //GHOST
            g.drawImage(new ImageIcon("cursor_moves/cursor_ghost.png").getImage(), 0, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove1().getType().equals("DRAGON")) { //DRAGON
            g.drawImage(new ImageIcon("cursor_moves/cursor_dragon.png").getImage(), 0, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove1().getType().equals("DARK")) {   //DARK
            g.drawImage(new ImageIcon("cursor_moves/cursor_dark.png").getImage(), 0, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove1().getType().equals("STEEL")) {  //STEEL
            g.drawImage(new ImageIcon("cursor_moves/cursor_steel.png").getImage(), 0, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove1().getType().equals("FAIRY")) {  //FAIRY
            g.drawImage(new ImageIcon("cursor_moves/cursor_fairy.png").getImage(), 0, 650, 512, 50, null);
         } else {
            g.drawImage(new ImageIcon("cursor_moves/cursor_none.png").getImage(), 0, 650, 512, 50, null);
         }
      //Display Move 2 for Player First Pokemon
         if(trainer1.getFirstPokemon().getMove2().getType().equals("NORMAL")) {   //NORMAL
            g.drawImage(new ImageIcon("cursor_moves/cursor_normal.png").getImage(), 512, 650, 512, 50, null);
         } else if (trainer1.getFirstPokemon().getMove2().getType().equals("FIRE")) { //FIRE
            g.drawImage(new ImageIcon("cursor_moves/cursor_fire.png").getImage(), 512, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove2().getType().equals("WATER")) {  //wATER
            g.drawImage(new ImageIcon("cursor_moves/cursor_water.png").getImage(), 512, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove2().getType().equals("GRASS")) {  //GRASS
            g.drawImage(new ImageIcon("cursor_moves/cursor_grass.png").getImage(), 512, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove2().getType().equals("ELECTRIC")) {  //ELECTRIC
            g.drawImage(new ImageIcon("cursor_moves/cursor_electric.png").getImage(), 512, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove2().getType().equals("ICE")) { //ICE
            g.drawImage(new ImageIcon("cursor_moves/cursor_ice.png").getImage(), 512, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove2().getType().equals("FIGHTING")) {  //FIGHTING
            g.drawImage(new ImageIcon("cursor_moves/cursor_fighting.png").getImage(), 512, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove2().getType().equals("POISON")) { //POISON
            g.drawImage(new ImageIcon("cursor_moves/cursor_poison.png").getImage(), 512, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove2().getType().equals("GROUND")) { //GROUND
            g.drawImage(new ImageIcon("cursor_moves/cursor_ground.png").getImage(), 512, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove2().getType().equals("FLYING")) { //FLYING
            g.drawImage(new ImageIcon("cursor_moves/cursor_flying.png").getImage(), 512, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove2().getType().equals("PSYCHIC")) {   //PSYCHIC
            g.drawImage(new ImageIcon("cursor_moves/cursor_psychihc.png").getImage(), 512, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove2().getType().equals("BUG")) { //BUG
            g.drawImage(new ImageIcon("cursor_moves/cursor_bug.png").getImage(), 512, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove2().getType().equals("ROCK")) {   //ROCK
            g.drawImage(new ImageIcon("cursor_moves/cursor_rock.png").getImage(), 512, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove2().getType().equals("GHOST")) {  //GHOST
            g.drawImage(new ImageIcon("cursor_moves/cursor_ghost.png").getImage(), 512, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove2().getType().equals("DRAGON")) { //DRAGON
            g.drawImage(new ImageIcon("cursor_moves/cursor_dragon.png").getImage(), 512, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove2().getType().equals("DARK")) {   //DARK
            g.drawImage(new ImageIcon("cursor_moves/cursor_dark.png").getImage(), 512, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove2().getType().equals("STEEL")) {  //STEEL
            g.drawImage(new ImageIcon("cursor_moves/cursor_steel.png").getImage(), 512, 650, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove2().getType().equals("FAIRY")) {  //FAIRY
            g.drawImage(new ImageIcon("cursor_moves/cursor_fairy.png").getImage(), 512, 650, 512, 50, null);
         }  else {
            g.drawImage(new ImageIcon("cursor_moves/cursor_none.png").getImage(), 512, 650, 512, 50, null);
         }
      //Display Move 3 for Player First Pokemon
         if(trainer1.getFirstPokemon().getMove3().getType().equals("NORMAL")) {   //NORMAL
            g.drawImage(new ImageIcon("cursor_moves/cursor_normal.png").getImage(), 0, 700, 512, 50, null);
         } else if (trainer1.getFirstPokemon().getMove3().getType().equals("FIRE")) { //FIRE
            g.drawImage(new ImageIcon("cursor_moves/cursor_fire.png").getImage(), 0, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove3().getType().equals("WATER")) {  //wATER
            g.drawImage(new ImageIcon("cursor_moves/cursor_water.png").getImage(), 0, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove3().getType().equals("GRASS")) {  //GRASS
            g.drawImage(new ImageIcon("cursor_moves/cursor_grass.png").getImage(), 0, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove3().getType().equals("ELECTRIC")) {  //ELECTRIC
            g.drawImage(new ImageIcon("cursor_moves/cursor_electric.png").getImage(), 0, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove3().getType().equals("ICE")) { //ICE
            g.drawImage(new ImageIcon("cursor_moves/cursor_ice.png").getImage(), 0, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove3().getType().equals("FIGHTING")) {  //FIGHTING
            g.drawImage(new ImageIcon("cursor_moves/cursor_fighting.png").getImage(), 0, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove3().getType().equals("POISON")) { //POISON
            g.drawImage(new ImageIcon("cursor_moves/cursor_poison.png").getImage(), 0, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove3().getType().equals("GROUND")) { //GROUND
            g.drawImage(new ImageIcon("cursor_moves/cursor_ground.png").getImage(), 0, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove3().getType().equals("FLYING")) { //FLYING
            g.drawImage(new ImageIcon("cursor_moves/cursor_flying.png").getImage(), 0, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove3().getType().equals("PSYCHIC")) {   //PSYCHIC
            g.drawImage(new ImageIcon("cursor_moves/cursor_psychihc.png").getImage(), 0, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove3().getType().equals("BUG")) { //BUG
            g.drawImage(new ImageIcon("cursor_moves/cursor_bug.png").getImage(), 0, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove3().getType().equals("ROCK")) {   //ROCK
            g.drawImage(new ImageIcon("cursor_moves/cursor_rock.png").getImage(), 0, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove3().getType().equals("GHOST")) {  //GHOST
            g.drawImage(new ImageIcon("cursor_moves/cursor_ghost.png").getImage(), 0, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove3().getType().equals("DRAGON")) { //DRAGON
            g.drawImage(new ImageIcon("cursor_moves/cursor_dragon.png").getImage(), 0, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove3().getType().equals("DARK")) {   //DARK
            g.drawImage(new ImageIcon("cursor_moves/cursor_dark.png").getImage(), 0, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove3().getType().equals("STEEL")) {  //STEEL
            g.drawImage(new ImageIcon("cursor_moves/cursor_steel.png").getImage(), 0, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove3().getType().equals("FAIRY")) {  //FAIRY
            g.drawImage(new ImageIcon("cursor_moves/cursor_fairy.png").getImage(), 0, 700, 512, 50, null);
         } else {
            g.drawImage(new ImageIcon("cursor_moves/cursor_none.png").getImage(), 0, 700, 512, 50, null);
         } 
      //Display Move 4 for Player First Pokemon
         if(trainer1.getFirstPokemon().getMove4().getType().equals("NORMAL")) {   //NORMAL
            g.drawImage(new ImageIcon("cursor_moves/cursor_normal.png").getImage(), 512, 700, 512, 50, null);
         } else if (trainer1.getFirstPokemon().getMove4().getType().equals("FIRE")) { //FIRE
            g.drawImage(new ImageIcon("cursor_moves/cursor_fire.png").getImage(), 512, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove4().getType().equals("WATER")) {  //wATER
            g.drawImage(new ImageIcon("cursor_moves/cursor_water.png").getImage(), 512, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove4().getType().equals("GRASS")) {  //GRASS
            g.drawImage(new ImageIcon("cursor_moves/cursor_grass.png").getImage(), 512, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove4().getType().equals("ELECTRIC")) {  //ELECTRIC
            g.drawImage(new ImageIcon("cursor_moves/cursor_electric.png").getImage(), 512, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove4().getType().equals("ICE")) { //ICE
            g.drawImage(new ImageIcon("cursor_moves/cursor_ice.png").getImage(), 512, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove4().getType().equals("FIGHTING")) {  //FIGHTING
            g.drawImage(new ImageIcon("cursor_moves/cursor_fighting.png").getImage(), 512, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove4().getType().equals("POISON")) { //POISON
            g.drawImage(new ImageIcon("cursor_moves/cursor_poison.png").getImage(), 512, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove4().getType().equals("GROUND")) { //GROUND
            g.drawImage(new ImageIcon("cursor_moves/cursor_ground.png").getImage(), 512, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove4().getType().equals("FLYING")) { //FLYING
            g.drawImage(new ImageIcon("cursor_moves/cursor_flying.png").getImage(), 512, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove4().getType().equals("PSYCHIC")) {   //PSYCHIC
            g.drawImage(new ImageIcon("cursor_moves/cursor_psychihc.png").getImage(), 512, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove4().getType().equals("BUG")) { //BUG
            g.drawImage(new ImageIcon("cursor_moves/cursor_bug.png").getImage(), 512, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove4().getType().equals("ROCK")) {   //ROCK
            g.drawImage(new ImageIcon("cursor_moves/cursor_rock.png").getImage(), 512, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove4().getType().equals("GHOST")) {  //GHOST
            g.drawImage(new ImageIcon("cursor_moves/cursor_ghost.png").getImage(), 512, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove4().getType().equals("DRAGON")) { //DRAGON
            g.drawImage(new ImageIcon("cursor_moves/cursor_dragon.png").getImage(), 512, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove4().getType().equals("DARK")) {   //DARK
            g.drawImage(new ImageIcon("cursor_moves/cursor_dark.png").getImage(), 512, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove4().getType().equals("STEEL")) {  //STEEL
            g.drawImage(new ImageIcon("cursor_moves/cursor_steel.png").getImage(), 512, 700, 512, 50, null);
         } else if(trainer1.getFirstPokemon().getMove4().getType().equals("FAIRY")) {  //FAIRY
            g.drawImage(new ImageIcon("cursor_moves/cursor_fairy.png").getImage(), 512, 700, 512, 50, null);
         } else {
            g.drawImage(new ImageIcon("cursor_moves/cursor_none.png").getImage(), 512, 700, 512, 50, null);
         }
      //Display Pokemon at the bottom of the screen
         int x = 0;
         for(int i = 1; i < 6; i++) {
            if(trainer1.getPokemon(i).getCanBattle()) {
               g.drawImage(new ImageIcon("HP_bar/panel_rect.png").getImage(), x, 750, 205, 50, null);
            } else {
               g.drawImage(new ImageIcon("HP_bar/panel_rect_faint.png").getImage(), x, 750, 205, 50, null);
            }
            x+=205;
         }
      }     
   }
   
   public static void paintPokemon(Graphics g, Trainer trainer1, Trainer trainer2, boolean switching1, boolean switching2, boolean displayClosed, boolean displayOpen) {
      if(displayClosed) {
         g.drawImage(new ImageIcon("Balls/ball_00.png").getImage(), 730, 225, 64, 128, null); //BULBASAUR 001
      } 
      if(displayOpen) {
         g.drawImage(new ImageIcon("Balls/ball_00_open.png").getImage(), 730, 225, 64, 128, null); //BULBASAUR 001
      } 
      if(trainer1.getFirstPokemon().getCanBattle() && switching1 == false) { //Draw the Pokemon for Trainer 1
         if(trainer1.getFirstPokemon().getName().equals("Bulbasaur"))
            g.drawImage(new ImageIcon("Battlers/001b.png").getImage(), 120, 336, 240, 240, null); //BULBASAUR 001
         else if(trainer1.getFirstPokemon().getName().equals("Ivysaur"))
            g.drawImage(new ImageIcon("Battlers/002b.png").getImage(), 120, 336, 240, 240, null); //IVYSAUR 002
         else if(trainer1.getFirstPokemon().getName().equals("Venusaur"))
            g.drawImage(new ImageIcon("Battlers/003b.png").getImage(), 96, 256, 320, 320, null); //VENASAUR 003
         else if(trainer1.getFirstPokemon().getName().equals("Charmander"))
            g.drawImage(new ImageIcon("Battlers/004b.png").getImage(), 120, 336, 240, 240, null); //CHARMANDER 004
         else if(trainer1.getFirstPokemon().getName().equals("Charmeleon"))
            g.drawImage(new ImageIcon("Battlers/005b.png").getImage(), 120, 336, 240, 240, null); //CHARMELEON 005
         else if(trainer1.getFirstPokemon().getName().equals("Charizard"))
            g.drawImage(new ImageIcon("Battlers/006b.png").getImage(), 96, 256, 320, 320, null); //CHARIZARD 006
         else if(trainer1.getFirstPokemon().getName().equals("Squirtle"))
            g.drawImage(new ImageIcon("Battlers/007b.png").getImage(), 120, 336, 240, 240, null); //SQUIRTLE 007
         else if(trainer1.getFirstPokemon().getName().equals("Wartortle"))
            g.drawImage(new ImageIcon("Battlers/008b.png").getImage(), 120, 336, 240, 240, null); //WARTORTLE 008
         else if(trainer1.getFirstPokemon().getName().equals("Blastoise"))
            g.drawImage(new ImageIcon("Battlers/009b.png").getImage(), 96, 256, 320, 320, null); //BLASTOISE 009
         else if(trainer1.getFirstPokemon().getName().equals("Caterpie"))
            g.drawImage(new ImageIcon("Battlers/010b.png").getImage(), 120, 336, 240, 240, null); //CATERPIE 010
         else if(trainer1.getFirstPokemon().getName().equals("Metapod"))
            g.drawImage(new ImageIcon("Battlers/011b.png").getImage(), 120, 336, 240, 240, null); //METAPOD 011
         else if(trainer1.getFirstPokemon().getName().equals("Butterfree"))
            g.drawImage(new ImageIcon("Battlers/012b.png").getImage(), 120, 336, 240, 240, null); //BUTTERFREE 012
         else if(trainer1.getFirstPokemon().getName().equals("Weedle"))
            g.drawImage(new ImageIcon("Battlers/013b.png").getImage(), 120, 336, 240, 240, null); //WEEDLE 013
         else if(trainer1.getFirstPokemon().getName().equals("Kakuna"))
            g.drawImage(new ImageIcon("Battlers/014b.png").getImage(), 120, 336, 240, 240, null); //KAKUNA 014
         else if(trainer1.getFirstPokemon().getName().equals("Beedrill"))
            g.drawImage(new ImageIcon("Battlers/015b.png").getImage(), 96, 256, 320, 320, null); //BEEDRILL 015
         else if(trainer1.getFirstPokemon().getName().equals("Pidgey"))
            g.drawImage(new ImageIcon("Battlers/016b.png").getImage(), 116, 336, 240, 240, null); //PIDGEY 016
         else if(trainer1.getFirstPokemon().getName().equals("Pidgeotto"))
            g.drawImage(new ImageIcon("Battlers/017b.png").getImage(), 120, 336, 240, 240, null); //PIDGEOTTO 017
         else if(trainer1.getFirstPokemon().getName().equals("Pidgeot"))
            g.drawImage(new ImageIcon("Battlers/018b.png").getImage(), 96, 256, 320, 320, null); //PIDGEOT 018
         else if(trainer1.getFirstPokemon().getName().equals("Rattata"))
            g.drawImage(new ImageIcon("Battlers/019b.png").getImage(), 116, 336, 240, 240, null); //RATTATA 019
         else if(trainer1.getFirstPokemon().getName().equals("Raticate"))
            g.drawImage(new ImageIcon("Battlers/020b.png").getImage(), 76, 256, 320, 320, null); //RATICATE 020
         else if(trainer1.getFirstPokemon().getName().equals("Spearow"))
            g.drawImage(new ImageIcon("Battlers/021b.png").getImage(), 120, 336, 240, 240, null); //SPEAROW 021
         else if(trainer1.getFirstPokemon().getName().equals("Fearow"))
            g.drawImage(new ImageIcon("Battlers/022b.png").getImage(), 96, 256, 320, 320, null); //FEAROW 022
         else if(trainer1.getFirstPokemon().getName().equals("Ekans"))
            g.drawImage(new ImageIcon("Battlers/023b.png").getImage(), 116, 336, 240, 240, null); //EKANS 023
         else if(trainer1.getFirstPokemon().getName().equals("Arbok"))
            g.drawImage(new ImageIcon("Battlers/024b.png").getImage(), 96, 256, 320, 320, null); //ARBOK 024
         else if(trainer1.getFirstPokemon().getName().equals("Pikachu"))
            g.drawImage(new ImageIcon("Battlers/025b.png").getImage(), 96, 336, 240, 240, null); //PIKACHU 025
         else if(trainer1.getFirstPokemon().getName().equals("Raichu"))
            g.drawImage(new ImageIcon("Battlers/026b.png").getImage(), 96, 256, 320, 320, null); //RAICHU 026 
         else if(trainer1.getFirstPokemon().getName().equals("Sandshrew"))
            g.drawImage(new ImageIcon("Battlers/027b.png").getImage(), 116, 336, 240, 240, null); //SANDSHREW 027
         else if(trainer1.getFirstPokemon().getName().equals("Sandslash"))
            g.drawImage(new ImageIcon("Battlers/028b.png").getImage(), 96, 256, 320, 320, null); //SANDSLASH 028
         else if(trainer1.getFirstPokemon().getName().equals("Nidoran-F"))
            g.drawImage(new ImageIcon("Battlers/029b.png").getImage(), 140, 336, 240, 240, null); //NIDORAN (F) 029
         else if(trainer1.getFirstPokemon().getName().equals("Nidorina"))
            g.drawImage(new ImageIcon("Battlers/030b.png").getImage(), 140, 336, 240, 240, null); //NIDORINA 030
         else if(trainer1.getFirstPokemon().getName().equals("Nidoqueen"))
            g.drawImage(new ImageIcon("Battlers/031b.png").getImage(), 96, 256, 320, 320, null); //NIDOQUEEN 031
         else if(trainer1.getFirstPokemon().getName().equals("Nidoran-M"))
            g.drawImage(new ImageIcon("Battlers/032b.png").getImage(), 140, 336, 240, 240, null);  //NIDORAN (M) 032
         else if(trainer1.getFirstPokemon().getName().equals("Nidorino"))
            g.drawImage(new ImageIcon("Battlers/033b.png").getImage(), 140, 336, 240, 240, null);  //NIDORINO 033
         else if(trainer1.getFirstPokemon().getName().equals("Nidoking"))
            g.drawImage(new ImageIcon("Battlers/034b.png").getImage(), 96, 256, 320, 320, null); //NIDOKING 034
         else if(trainer1.getFirstPokemon().getName().equals("Clefairy"))
            g.drawImage(new ImageIcon("Battlers/035b.png").getImage(), 140, 336, 240, 240, null);  //CLEFAIRY 035
         else if(trainer1.getFirstPokemon().getName().equals("Clefable"))
            g.drawImage(new ImageIcon("Battlers/036b.png").getImage(), 120, 336, 240, 240, null);  //CLEFABLE 036
         else if(trainer1.getFirstPokemon().getName().equals("Vulpix"))
            g.drawImage(new ImageIcon("Battlers/037b.png").getImage(), 120, 336, 240, 240, null);  //VULPIX 037
         else if(trainer1.getFirstPokemon().getName().equals("Ninetales"))
            g.drawImage(new ImageIcon("Battlers/038b.png").getImage(), 96, 256, 320, 320, null); //NINETALES 038
         else if(trainer1.getFirstPokemon().getName().equals("Jigglypuff"))
            g.drawImage(new ImageIcon("Battlers/039b.png").getImage(), 120, 336, 240, 240, null);  //JIGGLYPUFF 039
         else if(trainer1.getFirstPokemon().getName().equals("Wigglytuff"))
            g.drawImage(new ImageIcon("Battlers/040b.png").getImage(), 96, 256, 320, 320, null); //WIGGLYTUFF 040
         else if(trainer1.getFirstPokemon().getName().equals("Zubat"))
            g.drawImage(new ImageIcon("Battlers/041b.png").getImage(), 140, 336, 240, 240, null);  //ZUBAT 041
         else if(trainer1.getFirstPokemon().getName().equals("Golbat"))
            g.drawImage(new ImageIcon("Battlers/042b.png").getImage(), 96, 256, 320, 320, null); //GOLBAT 042
         else if(trainer1.getFirstPokemon().getName().equals("Crobat"))
            g.drawImage(new ImageIcon("Battlers/169b.png").getImage(), 96, 256, 320, 320, null); //CROBAT 169
         else if(trainer1.getFirstPokemon().getName().equals("Oddish"))
            g.drawImage(new ImageIcon("Battlers/043b.png").getImage(), 120, 336, 240, 240, null);  //ODDISH 043
         else if(trainer1.getFirstPokemon().getName().equals("Gloom"))
            g.drawImage(new ImageIcon("Battlers/044b.png").getImage(), 120, 336, 240, 240, null);  //GLOOM 044
         else if(trainer1.getFirstPokemon().getName().equals("Vileplume"))
            g.drawImage(new ImageIcon("Battlers/045b.png").getImage(), 96, 256, 320, 320, null); //VILEPLUME 045
         else if(trainer1.getFirstPokemon().getName().equals("Bellossom"))
            g.drawImage(new ImageIcon("Battlers/182b.png").getImage(), 96, 256, 320, 320, null); //BELLOSSOM 182
         else if(trainer1.getFirstPokemon().getName().equals("Paras"))
            g.drawImage(new ImageIcon("Battlers/046b.png").getImage(), 120, 336, 240, 240, null);  //PARAS 046
         else if(trainer1.getFirstPokemon().getName().equals("Parasect"))
            g.drawImage(new ImageIcon("Battlers/047b.png").getImage(), 96, 256, 320, 320, null); //PARASECT 047
         else if(trainer1.getFirstPokemon().getName().equals("Venonat"))
            g.drawImage(new ImageIcon("Battlers/048b.png").getImage(), 120, 336, 240, 240, null);  //VENONAT 048
         else if(trainer1.getFirstPokemon().getName().equals("Venomoth"))
            g.drawImage(new ImageIcon("Battlers/049b.png").getImage(), 96, 256, 320, 320, null); //VENOMOTH 049
         else if(trainer1.getFirstPokemon().getName().equals("Diglett"))
            g.drawImage(new ImageIcon("Battlers/050b.png").getImage(), 120, 336, 240, 240, null);  //DIGLETT 050
         else if(trainer1.getFirstPokemon().getName().equals("Dugtrio"))
            g.drawImage(new ImageIcon("Battlers/051b.png").getImage(), 96, 256, 320, 320, null); //DUGTRIO 051
         else if(trainer1.getFirstPokemon().getName().equals("Meowth"))
            g.drawImage(new ImageIcon("Battlers/052b.png").getImage(), 120, 336, 240, 240, null); //MEOWTH 052
         else if(trainer1.getFirstPokemon().getName().equals("Persian"))
            g.drawImage(new ImageIcon("Battlers/053b.png").getImage(), 96, 256, 320, 320, null); //PERSIAN 053
         else if(trainer1.getFirstPokemon().getName().equals("Psyduck"))
            g.drawImage(new ImageIcon("Battlers/054b.png").getImage(), 120, 336, 240, 240, null); //PSYDUCK 054
         else if(trainer1.getFirstPokemon().getName().equals("Golduck"))
            g.drawImage(new ImageIcon("Battlers/055b.png").getImage(), 96, 256, 320, 320, null); //GOLDUCK 055
         else if(trainer1.getFirstPokemon().getName().equals("Mankey"))
            g.drawImage(new ImageIcon("Battlers/056b.png").getImage(), 120, 336, 240, 240, null); //MANKEY 056
         else if(trainer1.getFirstPokemon().getName().equals("Primeape"))
            g.drawImage(new ImageIcon("Battlers/057b.png").getImage(), 96, 256, 320, 320, null); //PRIMEAPE 057
         else if(trainer1.getFirstPokemon().getName().equals("Growlithe"))
            g.drawImage(new ImageIcon("Battlers/058b.png").getImage(), 120, 336, 240, 240, null); //GROWLITHE 058
         else if(trainer1.getFirstPokemon().getName().equals("Arcanine"))
            g.drawImage(new ImageIcon("Battlers/059b.png").getImage(), 96, 256, 320, 320, null); //ARCANINE 059
         else if(trainer1.getFirstPokemon().getName().equals("Poliwag"))
            g.drawImage(new ImageIcon("Battlers/060b.png").getImage(), 120, 336, 240, 240, null); //POLIWAG 060
         else if(trainer1.getFirstPokemon().getName().equals("Poliwhirl"))
            g.drawImage(new ImageIcon("Battlers/061b.png").getImage(), 120, 336, 240, 240, null); //POLIWHIRL 061
         else if(trainer1.getFirstPokemon().getName().equals("Poliwrath"))
            g.drawImage(new ImageIcon("Battlers/062b.png").getImage(), 96, 256, 320, 320, null); //POLIWRATH 062
         else if(trainer1.getFirstPokemon().getName().equals("Politoed"))
            g.drawImage(new ImageIcon("Battlers/186b.png").getImage(), 96, 256, 320, 320, null); //POLITOED 062
         else if(trainer1.getFirstPokemon().getName().equals("Abra"))
            g.drawImage(new ImageIcon("Battlers/063b.png").getImage(), 120, 336, 240, 240, null); //ABRA 063
         else if(trainer1.getFirstPokemon().getName().equals("Kadabra"))
            g.drawImage(new ImageIcon("Battlers/064b.png").getImage(), 96, 256, 320, 320, null); //KADABRA 064
         else if(trainer1.getFirstPokemon().getName().equals("Alakazam"))
            g.drawImage(new ImageIcon("Battlers/065b.png").getImage(), 96, 256, 320, 320, null); //ALAKAZAM 065
         else if(trainer1.getFirstPokemon().getName().equals("Machop"))
            g.drawImage(new ImageIcon("Battlers/066b.png").getImage(), 120, 336, 240, 240, null); //MACHOP 066
         else if(trainer1.getFirstPokemon().getName().equals("Machoke"))
            g.drawImage(new ImageIcon("Battlers/067b.png").getImage(), 96, 256, 320, 320, null); //MACHOKE 067
         else if(trainer1.getFirstPokemon().getName().equals("Machamp"))
            g.drawImage(new ImageIcon("Battlers/068b.png").getImage(), 96, 256, 320, 320, null); //MACHAMP 068
         else if(trainer1.getFirstPokemon().getName().equals("Bellsprout"))
            g.drawImage(new ImageIcon("Battlers/069b.png").getImage(), 120, 336, 240, 240, null); //BELLSPROUT 069
         else if(trainer1.getFirstPokemon().getName().equals("Weepinbell"))
            g.drawImage(new ImageIcon("Battlers/070b.png").getImage(), 120, 336, 240, 240, null); //WEEPINBELL 070
         else if(trainer1.getFirstPokemon().getName().equals("Victreebel"))
            g.drawImage(new ImageIcon("Battlers/071b.png").getImage(), 96, 256, 320, 320, null); //VICTREEBEL 071
         else if(trainer1.getFirstPokemon().getName().equals("Tentacool"))
            g.drawImage(new ImageIcon("Battlers/072b.png").getImage(), 120, 336, 240, 240, null); //TENTACOOL 072
         else if(trainer1.getFirstPokemon().getName().equals("Tentacruel"))
            g.drawImage(new ImageIcon("Battlers/073b.png").getImage(), 96, 256, 320, 320, null); //TENTACRUEL 073
         else if(trainer1.getFirstPokemon().getName().equals("Geodude"))
            g.drawImage(new ImageIcon("Battlers/074b.png").getImage(), 120, 336, 240, 240, null); //GEODUDE 074
         else if(trainer1.getFirstPokemon().getName().equals("Graveler"))
            g.drawImage(new ImageIcon("Battlers/075b.png").getImage(), 120, 336, 240, 240, null); //GRAVELER 075
         else if(trainer1.getFirstPokemon().getName().equals("Golem"))
            g.drawImage(new ImageIcon("Battlers/076b.png").getImage(), 96, 256, 320, 320, null); //GOLEM 076
         else if(trainer1.getFirstPokemon().getName().equals("Ponyta"))
            g.drawImage(new ImageIcon("Battlers/077b.png").getImage(), 120, 336, 240, 240, null); //PONYTA 077
         else if(trainer1.getFirstPokemon().getName().equals("Rapidash"))
            g.drawImage(new ImageIcon("Battlers/078b.png").getImage(), 96, 256, 320, 320, null); //RAPIDASH 078
         else if(trainer1.getFirstPokemon().getName().equals("Slowpoke"))
            g.drawImage(new ImageIcon("Battlers/079b.png").getImage(), 120, 336, 240, 240, null); //SLOWPOKE 079
         else if(trainer1.getFirstPokemon().getName().equals("Slowbro"))
            g.drawImage(new ImageIcon("Battlers/080b.png").getImage(), 96, 256, 320, 320, null); //SLOWBRO 080
         else if(trainer1.getFirstPokemon().getName().equals("Slowking"))
            g.drawImage(new ImageIcon("Battlers/199b.png").getImage(), 96, 256, 320, 320, null); //SLOWKING 080
         else if(trainer1.getFirstPokemon().getName().equals("Magnemite"))
            g.drawImage(new ImageIcon("Battlers/081b.png").getImage(), 120, 336, 240, 240, null); //MAGNEMITE 081
         else if(trainer1.getFirstPokemon().getName().equals("Magneton"))
            g.drawImage(new ImageIcon("Battlers/082b.png").getImage(), 96, 256, 320, 320, null); //MAGNETON 082
         else if(trainer1.getFirstPokemon().getName().equals("Magnezone"))
            g.drawImage(new ImageIcon("Battlers/462b.png").getImage(), 96, 256, 320, 320, null); //MAGNEZONE   
         else if(trainer1.getFirstPokemon().getName().equals("Farfetch'd"))
            g.drawImage(new ImageIcon("Battlers/083b.png").getImage(), 120, 336, 240, 240, null); //FARFETCH'D 083
         else if(trainer1.getFirstPokemon().getName().equals("Doduo"))
            g.drawImage(new ImageIcon("Battlers/084b.png").getImage(), 120, 336, 240, 240, null); //DODUO 084
         else if(trainer1.getFirstPokemon().getName().equals("Dodrio"))
            g.drawImage(new ImageIcon("Battlers/085b.png").getImage(), 96, 256, 320, 320, null); //DODRIO 085
         else if(trainer1.getFirstPokemon().getName().equals("Seel"))
            g.drawImage(new ImageIcon("Battlers/086b.png").getImage(), 120, 336, 240, 240, null); //SEEL 086
         else if(trainer1.getFirstPokemon().getName().equals("Dewgong"))
            g.drawImage(new ImageIcon("Battlers/087b.png").getImage(), 96, 256, 320, 320, null); //DEWGONG 087
         else if(trainer1.getFirstPokemon().getName().equals("Grimer"))
            g.drawImage(new ImageIcon("Battlers/088b.png").getImage(), 120, 336, 240, 240, null); //GRIMER 088
         else if(trainer1.getFirstPokemon().getName().equals("Muk"))
            g.drawImage(new ImageIcon("Battlers/089b.png").getImage(), 96, 256, 320, 320, null); //MUK 089
         else if(trainer1.getFirstPokemon().getName().equals("Shellder"))
            g.drawImage(new ImageIcon("Battlers/090b.png").getImage(), 120, 336, 240, 240, null); //SHELLDER 090
         else if(trainer1.getFirstPokemon().getName().equals("Cloyster"))
            g.drawImage(new ImageIcon("Battlers/091b.png").getImage(), 96, 256, 320, 320, null); //CLOYSTER 091
         else if(trainer1.getFirstPokemon().getName().equals("Gastly"))
            g.drawImage(new ImageIcon("Battlers/092b.png").getImage(), 120, 336, 240, 240, null); //GASTLY 092
         else if(trainer1.getFirstPokemon().getName().equals("Haunter"))
            g.drawImage(new ImageIcon("Battlers/093b.png").getImage(), 96, 256, 320, 320, null); //HAUNTER 093
         else if(trainer1.getFirstPokemon().getName().equals("Gengar"))
            g.drawImage(new ImageIcon("Battlers/094b.png").getImage(), 96, 256, 320, 320, null); //GENGAR 094
         else if(trainer1.getFirstPokemon().getName().equals("Onix"))
            g.drawImage(new ImageIcon("Battlers/095b.png").getImage(), 96, 256, 320, 320, null); //ONIX 095
         else if(trainer1.getFirstPokemon().getName().equals("Steelix"))
            g.drawImage(new ImageIcon("Battlers/208b.png").getImage(), 96, 256, 320, 320, null); //STEELIX 208
         else if(trainer1.getFirstPokemon().getName().equals("Drowzee"))
            g.drawImage(new ImageIcon("Battlers/096b.png").getImage(), 120, 336, 240, 240, null); //DROWZEE 096
         else if(trainer1.getFirstPokemon().getName().equals("Hypno"))
            g.drawImage(new ImageIcon("Battlers/097b.png").getImage(), 96, 256, 320, 320, null); //HYPNO 097
         else if(trainer1.getFirstPokemon().getName().equals("Krabby"))
            g.drawImage(new ImageIcon("Battlers/098b.png").getImage(), 140, 336, 240, 240, null); //KRABBY 098
         else if(trainer1.getFirstPokemon().getName().equals("Kingler"))
            g.drawImage(new ImageIcon("Battlers/099b.png").getImage(), 96, 256, 320, 320, null); //KINGLER 099
         else if(trainer1.getFirstPokemon().getName().equals("Voltorb"))
            g.drawImage(new ImageIcon("Battlers/100b.png").getImage(), 120, 336, 240, 240, null); //VOLTORB 100
         else if(trainer1.getFirstPokemon().getName().equals("Electrode"))
            g.drawImage(new ImageIcon("Battlers/101b.png").getImage(), 96, 256, 320, 320, null); //ELECTRODE 101
         else if(trainer1.getFirstPokemon().getName().equals("Exeggcute"))
            g.drawImage(new ImageIcon("Battlers/102b.png").getImage(), 120, 336, 240, 240, null); //EXEGGCUTE 102
         else if(trainer1.getFirstPokemon().getName().equals("Exeggutor"))
            g.drawImage(new ImageIcon("Battlers/103b.png").getImage(), 96, 256, 320, 320, null); //EXEGGUTOR 103
         else if(trainer1.getFirstPokemon().getName().equals("Cubone"))
            g.drawImage(new ImageIcon("Battlers/104b.png").getImage(), 120, 336, 240, 240, null); //CUBONE 104
         else if(trainer1.getFirstPokemon().getName().equals("Marowak"))
            g.drawImage(new ImageIcon("Battlers/105b.png").getImage(), 96, 256, 320, 320, null); //MAROWAK 105
         else if(trainer1.getFirstPokemon().getName().equals("Hitmonlee"))
            g.drawImage(new ImageIcon("Battlers/106b.png").getImage(), 96, 256, 320, 320, null); //HITMONLEE 106
         else if(trainer1.getFirstPokemon().getName().equals("Hitmonchan"))
            g.drawImage(new ImageIcon("Battlers/107b.png").getImage(), 96, 256, 320, 320, null); //HITMONCHAN 107
         else if(trainer1.getFirstPokemon().getName().equals("Hitmontop"))
            g.drawImage(new ImageIcon("Battlers/237b.png").getImage(), 96, 256, 320, 320, null); //HITMONTOP 237
         else if(trainer1.getFirstPokemon().getName().equals("Lickitung"))
            g.drawImage(new ImageIcon("Battlers/108b.png").getImage(), 96, 256, 320, 320, null); //LICKITUNG 108
         else if(trainer1.getFirstPokemon().getName().equals("Lickilicky"))
            g.drawImage(new ImageIcon("Battlers/463b.png").getImage(), 96, 256, 320, 320, null); //LICKITUNG 108
         else if(trainer1.getFirstPokemon().getName().equals("Koffing"))
            g.drawImage(new ImageIcon("Battlers/109b.png").getImage(), 120, 336, 240, 240, null); //KOFFING 109
         else if(trainer1.getFirstPokemon().getName().equals("Weezing"))
            g.drawImage(new ImageIcon("Battlers/100b.png").getImage(), 96, 256, 320, 320, null); //WEEZING 100
         else if(trainer1.getFirstPokemon().getName().equals("Rhyhorn"))
            g.drawImage(new ImageIcon("Battlers/111b.png").getImage(), 96, 256, 320, 320, null); //RHYHORN 111
         else if(trainer1.getFirstPokemon().getName().equals("Rhydon"))
            g.drawImage(new ImageIcon("Battlers/112b.png").getImage(), 96, 256, 320, 320, null); //RHYDON 112
         else if(trainer1.getFirstPokemon().getName().equals("Rhyperior"))
            g.drawImage(new ImageIcon("Battlers/464b.png").getImage(), 96, 256, 320, 320, null); //RHYPERIOR
         else if(trainer1.getFirstPokemon().getName().equals("Chansey"))
            g.drawImage(new ImageIcon("Battlers/113b.png").getImage(), 96, 256, 320, 320, null); //CHANSEY 113
         else if(trainer1.getFirstPokemon().getName().equals("Blissey"))
            g.drawImage(new ImageIcon("Battlers/242b.png").getImage(), 96, 256, 320, 320, null); //BLISSEY
         else if(trainer1.getFirstPokemon().getName().equals("Tangela"))
            g.drawImage(new ImageIcon("Battlers/114b.png").getImage(), 120, 336, 240, 240, null); //TANGELA 114
         else if(trainer1.getFirstPokemon().getName().equals("Tangrowth"))
            g.drawImage(new ImageIcon("Battlers/465b.png").getImage(), 96, 256, 320, 320, null); //TANGROWTH
         else if(trainer1.getFirstPokemon().getName().equals("Kangaskhan"))
            g.drawImage(new ImageIcon("Battlers/115b.png").getImage(), 96, 256, 320, 320, null); //KANGASKHAN 115
         else if(trainer1.getFirstPokemon().getName().equals("Horsea"))
            g.drawImage(new ImageIcon("Battlers/116b.png").getImage(), 120, 336, 240, 240, null); //HORSEA 116
         else if(trainer1.getFirstPokemon().getName().equals("Seadra"))
            g.drawImage(new ImageIcon("Battlers/117b.png").getImage(), 96, 256, 320, 320, null); //SEADRA 117
         else if(trainer1.getFirstPokemon().getName().equals("Kingdra"))
            g.drawImage(new ImageIcon("Battlers/230b.png").getImage(), 96, 256, 320, 320, null); //KINGDRA
         else if(trainer1.getFirstPokemon().getName().equals("Goldeen"))
            g.drawImage(new ImageIcon("Battlers/118b.png").getImage(), 120, 336, 240, 240, null); //GOLDEEN 118
         else if(trainer1.getFirstPokemon().getName().equals("Seaking"))
            g.drawImage(new ImageIcon("Battlers/119b.png").getImage(), 96, 256, 320, 320, null); //SEAKING 119
         else if(trainer1.getFirstPokemon().getName().equals("Staryu"))
            g.drawImage(new ImageIcon("Battlers/120b.png").getImage(), 120, 336, 240, 240, null); //STARYU 120
         else if(trainer1.getFirstPokemon().getName().equals("Starmie"))
            g.drawImage(new ImageIcon("Battlers/121b.png").getImage(), 96, 256, 320, 320, null); //STARMIE 121
         else if(trainer1.getFirstPokemon().getName().equals("Mr. Mime"))
            g.drawImage(new ImageIcon("Battlers/122b.png").getImage(), 96, 256, 320, 320, null); //MR. MIME 122
         else if(trainer1.getFirstPokemon().getName().equals("Scyther"))
            g.drawImage(new ImageIcon("Battlers/123b.png").getImage(), 96, 256, 320, 320, null); //SCYTHER 123
         else if(trainer1.getFirstPokemon().getName().equals("Scizor"))
            g.drawImage(new ImageIcon("Battlers/212b.png").getImage(), 96, 256, 320, 320, null); //SCIZOR
         else if(trainer1.getFirstPokemon().getName().equals("Jynx"))
            g.drawImage(new ImageIcon("Battlers/124b.png").getImage(), 96, 256, 320, 320, null); //JYNX 124
         else if(trainer1.getFirstPokemon().getName().equals("Electabuzz"))
            g.drawImage(new ImageIcon("Battlers/125b.png").getImage(), 96, 256, 320, 320, null); //ELECTABUZZ 125
         else if(trainer1.getFirstPokemon().getName().equals("Electivire"))
            g.drawImage(new ImageIcon("Battlers/466b.png").getImage(), 96, 256, 320, 320, null); //ELETIVIRE
         else if(trainer1.getFirstPokemon().getName().equals("Magmar"))
            g.drawImage(new ImageIcon("Battlers/126b.png").getImage(), 96, 256, 320, 320, null); //MAGMAR 126
         else if(trainer1.getFirstPokemon().getName().equals("Magmortar"))
            g.drawImage(new ImageIcon("Battlers/467b.png").getImage(), 96, 256, 320, 320, null); //MAGMORTAR
         else if(trainer1.getFirstPokemon().getName().equals("Pinsir"))
            g.drawImage(new ImageIcon("Battlers/127b.png").getImage(), 96, 256, 320, 320, null); //PINSIR 127
         else if(trainer1.getFirstPokemon().getName().equals("Heracross"))
            g.drawImage(new ImageIcon("Battlers/214b.png").getImage(), 96, 256, 320, 320, null); //HERACROSS
         else if(trainer1.getFirstPokemon().getName().equals("Tauros"))
            g.drawImage(new ImageIcon("Battlers/128b.png").getImage(), 96, 256, 320, 320, null); //TAUROS 128
         else if(trainer1.getFirstPokemon().getName().equals("Magikarp"))
            g.drawImage(new ImageIcon("Battlers/129b.png").getImage(), 120, 336, 240, 240, null); //MAGIKARP 129
         else if(trainer1.getFirstPokemon().getName().equals("Gyarados"))
            g.drawImage(new ImageIcon("Battlers/130b.png").getImage(), 96, 256, 320, 320, null); //GYARADOS 130
         else if(trainer1.getFirstPokemon().getName().equals("Lapras"))
            g.drawImage(new ImageIcon("Battlers/131b.png").getImage(), 96, 256, 320, 320, null); //LAPRAS 131
         else if(trainer1.getFirstPokemon().getName().equals("Ditto"))
            g.drawImage(new ImageIcon("Battlers/132b.png").getImage(), 120, 336, 240, 240, null);  //DITTO 132
         else if(trainer1.getFirstPokemon().getName().equals("Eevee"))
            g.drawImage(new ImageIcon("Battlers/133b.png").getImage(), 120, 336, 240, 240, null);  //EEVEE 133
         else if(trainer1.getFirstPokemon().getName().equals("Vaporeon"))
            g.drawImage(new ImageIcon("Battlers/134b.png").getImage(), 120, 336, 240, 240, null); //VAPOREON 134
         else if(trainer1.getFirstPokemon().getName().equals("Jolteon"))
            g.drawImage(new ImageIcon("Battlers/135b.png").getImage(), 120, 336, 240, 240, null); //JOLTEON 135
         else if(trainer1.getFirstPokemon().getName().equals("Flareon"))
            g.drawImage(new ImageIcon("Battlers/120b.png").getImage(), 120, 336, 240, 240, null); //FLAREON 136
         else if(trainer1.getFirstPokemon().getName().equals("Espeon"))
            g.drawImage(new ImageIcon("Battlers/196b.png").getImage(), 120, 336, 240, 240, null); //ESPEON
         else if(trainer1.getFirstPokemon().getName().equals("Umbreon"))
            g.drawImage(new ImageIcon("Battlers/197b.png").getImage(), 120, 336, 240, 240, null); //UMBREON
         else if(trainer1.getFirstPokemon().getName().equals("Glaceon"))
            g.drawImage(new ImageIcon("Battlers/471b.png").getImage(), 120, 336, 240, 240, null); //GLACEON
         else if(trainer1.getFirstPokemon().getName().equals("Leafeon"))
            g.drawImage(new ImageIcon("Battlers/470b.png").getImage(), 120, 336, 240, 240, null); //LEAFEON
         else if(trainer1.getFirstPokemon().getName().equals("Sylveon"))
            g.drawImage(new ImageIcon("Battlers/700b.png").getImage(), 120, 336, 240, 240, null); //SYLVEON
         else if(trainer1.getFirstPokemon().getName().equals("Porygon"))
            g.drawImage(new ImageIcon("Battlers/137b.png").getImage(), 120, 336, 240, 240, null); //PORYGON 137
         else if(trainer1.getFirstPokemon().getName().equals("Porygon2"))
            g.drawImage(new ImageIcon("Battlers/233b.png").getImage(), 120, 336, 240, 240, null); //PORYGON2
         else if(trainer1.getFirstPokemon().getName().equals("Porygon-Z"))
            g.drawImage(new ImageIcon("Battlers/474b.png").getImage(), 120, 336, 240, 240, null); //PORYGON-Z
         else if(trainer1.getFirstPokemon().getName().equals("Omanyte"))
            g.drawImage(new ImageIcon("Battlers/138b.png").getImage(), 120, 336, 240, 240, null); //OMANYTE 138
         else if(trainer1.getFirstPokemon().getName().equals("Omastar"))
            g.drawImage(new ImageIcon("Battlers/139b.png").getImage(), 96, 256, 320, 320, null); //OMASTAR 139
         else if(trainer1.getFirstPokemon().getName().equals("Kabuto"))
            g.drawImage(new ImageIcon("Battlers/140b.png").getImage(), 120, 336, 240, 240, null);  //KABUTO 140
         else if(trainer1.getFirstPokemon().getName().equals("Kabutops"))
            g.drawImage(new ImageIcon("Battlers/141b.png").getImage(), 96, 256, 320, 320, null); //KABUTOPS 141
         else if(trainer1.getFirstPokemon().getName().equals("Aerodactyl"))
            g.drawImage(new ImageIcon("Battlers/142b.png").getImage(), 96, 256, 320, 320, null); //AERODACTYL 142
         else if(trainer1.getFirstPokemon().getName().equals("Snorlax"))
            g.drawImage(new ImageIcon("Battlers/143b.png").getImage(), 96, 256, 320, 320, null); //SNORLAX 143
         else if(trainer1.getFirstPokemon().getName().equals("Articuno"))
            g.drawImage(new ImageIcon("Battlers/144b.png").getImage(), 96, 256, 320, 320, null); //ARTICUNO 144
         else if(trainer1.getFirstPokemon().getName().equals("Zapdos"))
            g.drawImage(new ImageIcon("Battlers/145b.png").getImage(), 96, 256, 320, 320, null); //ZAPDOS 145
         else if(trainer1.getFirstPokemon().getName().equals("Moltres"))
            g.drawImage(new ImageIcon("Battlers/146b.png").getImage(), 96, 256, 320, 320, null); //MOLTRES 146
         else if(trainer1.getFirstPokemon().getName().equals("Dratini"))
            g.drawImage(new ImageIcon("Battlers/147b.png").getImage(), 120, 336, 240, 240, null); //DRATINI 147
         else if(trainer1.getFirstPokemon().getName().equals("Dragonair"))
            g.drawImage(new ImageIcon("Battlers/148b.png").getImage(), 96, 256, 320, 320, null); //DRAGONAIR 148
         else if(trainer1.getFirstPokemon().getName().equals("Dragonite"))
            g.drawImage(new ImageIcon("Battlers/149b.png").getImage(), 96, 256, 320, 320, null); //DRAGONITE 149
         else if(trainer1.getFirstPokemon().getName().equals("Mewtwo"))
            g.drawImage(new ImageIcon("Battlers/150b.png").getImage(), 96, 256, 320, 320, null); //MEWTWO 150
         else if(trainer1.getFirstPokemon().getName().equals("Mew"))
            g.drawImage(new ImageIcon("Battlers/151b.png").getImage(), 120, 336, 240, 240, null);  //MEW 151 
         else
            g.drawImage(new ImageIcon("Battlers/000b.png").getImage(), 96, 256, 320, 320, null); //NULL VALUE 000
      }
      //Draw the Pokemon for Trainer 2
      if(trainer2.getFirstPokemon().getCanBattle() && switching2 == false) {
         if(trainer2.getFirstPokemon().getName().equals("Bulbasaur"))
            g.drawImage(new ImageIcon("Battlers/001.png").getImage(), 600, 100, 320, 320, null); //BULBASAUR 001
         else if(trainer2.getFirstPokemon().getName().equals("Ivysaur"))
            g.drawImage(new ImageIcon("Battlers/002.png").getImage(), 600, 100, 320, 320, null); //IVYSAUR 002
         else if(trainer2.getFirstPokemon().getName().equals("Venusaur"))
            g.drawImage(new ImageIcon("Battlers/003.png").getImage(), 620, 60, 320, 320, null); //VENUSAUR 003
         else if(trainer2.getFirstPokemon().getName().equals("Charmander"))
            g.drawImage(new ImageIcon("Battlers/004.png").getImage(), 600, 100, 320, 320, null); //CHARMANDER 004
         else if(trainer2.getFirstPokemon().getName().equals("Charmeleon"))
            g.drawImage(new ImageIcon("Battlers/005.png").getImage(), 600, 90, 320, 320, null); //CHARMELEON 005
         else if(trainer2.getFirstPokemon().getName().equals("Charizard"))
            g.drawImage(new ImageIcon("Battlers/006.png").getImage(), 610, 25, 320, 320, null); //CHARIZARD 006
         else if(trainer2.getFirstPokemon().getName().equals("Squirtle"))
            g.drawImage(new ImageIcon("Battlers/007.png").getImage(), 600, 100, 320, 320, null); //SQUIRTLE 007
         else if(trainer2.getFirstPokemon().getName().equals("Wartortle"))
            g.drawImage(new ImageIcon("Battlers/008.png").getImage(), 600, 80, 320, 320, null); //WARTORTLE 008
         else if(trainer2.getFirstPokemon().getName().equals("Blastoise"))
            g.drawImage(new ImageIcon("Battlers/009.png").getImage(), 590, 70, 320, 320, null); //BLASTOISE 009
         else if(trainer2.getFirstPokemon().getName().equals("Caterpie"))
            g.drawImage(new ImageIcon("Battlers/010.png").getImage(), 580, 100, 320, 320, null); //CATERPIE 010
         else if(trainer2.getFirstPokemon().getName().equals("Metapod"))
            g.drawImage(new ImageIcon("Battlers/011.png").getImage(), 600, 100, 320, 320, null); //METAPOD 011
         else if(trainer2.getFirstPokemon().getName().equals("Butterfree")) {
            g.drawImage(new ImageIcon("Battlers/object_shadow.png").getImage(), 700, 290, 128, 30, null); //SHADOW
            g.drawImage(new ImageIcon("Battlers/012.png").getImage(), 630, 0, 320, 320, null); //BUTTERFREE 012
         } else if(trainer2.getFirstPokemon().getName().equals("Weedle"))
            g.drawImage(new ImageIcon("Battlers/013.png").getImage(), 600, 100, 320, 320, null); //WEEDLE 013
         else if(trainer2.getFirstPokemon().getName().equals("Kakuna"))
            g.drawImage(new ImageIcon("Battlers/014.png").getImage(), 600, 100, 320, 320, null); //KAKUNA 014
         else if(trainer2.getFirstPokemon().getName().equals("Beedrill")) {
            g.drawImage(new ImageIcon("Battlers/object_shadow.png").getImage(), 700, 290, 128, 30, null); //SHADOW
            g.drawImage(new ImageIcon("Battlers/015.png").getImage(), 570, 0, 320, 320, null); //BEEDRILL 015
         } else if(trainer2.getFirstPokemon().getName().equals("Pidgey"))
            g.drawImage(new ImageIcon("Battlers/016.png").getImage(), 600, 100, 320, 320, null); //PIDGEY 016
         else if(trainer2.getFirstPokemon().getName().equals("Pidgeotto"))
            g.drawImage(new ImageIcon("Battlers/017.png").getImage(), 620, 80, 320, 320, null); //PIDGEOTTO 017
         else if(trainer2.getFirstPokemon().getName().equals("Pidgeot")) {
            g.drawImage(new ImageIcon("Battlers/object_shadow.png").getImage(), 700, 290, 128, 30, null); //SHADOW
            g.drawImage(new ImageIcon("Battlers/018.png").getImage(), 610, 0, 320, 320, null);  //PIDGEOT 018
         } else if(trainer2.getFirstPokemon().getName().equals("Rattata"))
            g.drawImage(new ImageIcon("Battlers/019.png").getImage(), 600, 100, 320, 320, null); //RATTATA 019
         else if(trainer2.getFirstPokemon().getName().equals("Raticate"))
            g.drawImage(new ImageIcon("Battlers/020.png").getImage(), 590, 75, 320, 320, null); //RATICATE 020
         else if(trainer2.getFirstPokemon().getName().equals("Spearow"))
            g.drawImage(new ImageIcon("Battlers/021.png").getImage(), 600, 90, 320, 320, null); //SPEAROW 021
         else if(trainer2.getFirstPokemon().getName().equals("Fearow")) {
            g.drawImage(new ImageIcon("Battlers/object_shadow.png").getImage(), 700, 290, 128, 30, null); //SHADOW
            g.drawImage(new ImageIcon("Battlers/022.png").getImage(), 600, 5, 320, 320, null); //FEAROW 022
         } else if(trainer2.getFirstPokemon().getName().equals("Ekans"))
            g.drawImage(new ImageIcon("Battlers/023.png").getImage(), 610, 100, 320, 320, null); //EKANS 023
         else if(trainer2.getFirstPokemon().getName().equals("Arbok"))
            g.drawImage(new ImageIcon("Battlers/024.png").getImage(), 610, 50, 320, 320, null); //ARBOK 024
         else if(trainer2.getFirstPokemon().getName().equals("Pikachu"))
            g.drawImage(new ImageIcon("Battlers/025.png").getImage(), 610, 60, 320, 320, null); //PIKACHU 025
         else if(trainer2.getFirstPokemon().getName().equals("Raichu"))
            g.drawImage(new ImageIcon("Battlers/026.png").getImage(), 640, 50, 320, 320, null); //RAICHU 026
         else if(trainer2.getFirstPokemon().getName().equals("Sandshrew"))
            g.drawImage(new ImageIcon("Battlers/027.png").getImage(), 600, 90, 320, 320, null); //SANDSHREW 027
         else if(trainer2.getFirstPokemon().getName().equals("Sandslash"))
            g.drawImage(new ImageIcon("Battlers/028.png").getImage(), 590, 80, 320, 320, null); //SANDSLASH 028
         else if(trainer2.getFirstPokemon().getName().equals("Nidoran-F"))
            g.drawImage(new ImageIcon("Battlers/029.png").getImage(), 600, 100, 320, 320, null); //NIDORAN (F) 029
         else if(trainer2.getFirstPokemon().getName().equals("Nidorina"))
            g.drawImage(new ImageIcon("Battlers/030.png").getImage(), 590, 70, 320, 320, null); //NIDORINA 030
         else if(trainer2.getFirstPokemon().getName().equals("Nidoqueen"))
            g.drawImage(new ImageIcon("Battlers/031.png").getImage(), 590, 40, 320, 320, null); //NIDOQUEEN 031
         else if(trainer2.getFirstPokemon().getName().equals("Nidoran-M"))
            g.drawImage(new ImageIcon("Battlers/032.png").getImage(), 600, 90, 320, 320, null); //NIDORAN (M) 032
         else if(trainer2.getFirstPokemon().getName().equals("Nidorino"))
            g.drawImage(new ImageIcon("Battlers/033.png").getImage(), 590, 70, 320, 320, null); //NIDORINO 033
         else if(trainer2.getFirstPokemon().getName().equals("Nidoking"))
            g.drawImage(new ImageIcon("Battlers/034.png").getImage(), 590, 40, 320, 320, null); //NIDOKING 034
         else if(trainer2.getFirstPokemon().getName().equals("Clefairy"))
            g.drawImage(new ImageIcon("Battlers/035.png").getImage(), 590, 90, 320, 320, null); //CLEFAIRY 035
         else if(trainer2.getFirstPokemon().getName().equals("Clefable"))
            g.drawImage(new ImageIcon("Battlers/036.png").getImage(), 610, 70, 320, 320, null); //CLEFABLE 036
         else if(trainer2.getFirstPokemon().getName().equals("Vulpix"))
            g.drawImage(new ImageIcon("Battlers/037.png").getImage(), 600, 80, 320, 320, null); //VULPIX 037
         else if(trainer2.getFirstPokemon().getName().equals("Ninetales"))
            g.drawImage(new ImageIcon("Battlers/038.png").getImage(), 620, 50, 320, 320, null); //NINETALES 038
         else if(trainer2.getFirstPokemon().getName().equals("Jigglypuff"))
            g.drawImage(new ImageIcon("Battlers/039.png").getImage(), 590, 100, 320, 320, null); //JIGGLYPUFF 039
         else if(trainer2.getFirstPokemon().getName().equals("Wigglytuff"))
            g.drawImage(new ImageIcon("Battlers/040.png").getImage(), 600, 60, 320, 320, null); //WIGGLYTUFF 040
         else if(trainer2.getFirstPokemon().getName().equals("Zubat")) {
            g.drawImage(new ImageIcon("Battlers/object_shadow.png").getImage(), 700, 290, 128, 30, null); //SHADOW
            g.drawImage(new ImageIcon("Battlers/041.png").getImage(), 580, 20, 320, 320, null); //ZUBAT 041
         } else if(trainer2.getFirstPokemon().getName().equals("Golbat")) {
            g.drawImage(new ImageIcon("Battlers/object_shadow.png").getImage(), 700, 290, 128, 30, null); //SHADOW
            g.drawImage(new ImageIcon("Battlers/042.png").getImage(), 620, -20, 320, 320, null); //GOLBAT 042
         } else if(trainer2.getFirstPokemon().getName().equals("Crobat")) {
            g.drawImage(new ImageIcon("Battlers/object_shadow.png").getImage(), 700, 290, 128, 30, null); //SHADOW
            g.drawImage(new ImageIcon("Battlers/169.png").getImage(), 610, -20, 320, 320, null); //CROBAT 169
         } else if(trainer2.getFirstPokemon().getName().equals("Oddish"))
            g.drawImage(new ImageIcon("Battlers/043.png").getImage(), 610, 90, 320, 320, null); //ODDISH 043
         else if(trainer2.getFirstPokemon().getName().equals("Gloom"))
            g.drawImage(new ImageIcon("Battlers/044.png").getImage(), 590, 85, 320, 320, null); //GLOOM 044
         else if(trainer2.getFirstPokemon().getName().equals("Vileplume"))
            g.drawImage(new ImageIcon("Battlers/045.png").getImage(), 610, 70, 320, 320, null); //VILEPLUME 045
         else if(trainer2.getFirstPokemon().getName().equals("Bellossom"))
            g.drawImage(new ImageIcon("Battlers/182.png").getImage(), 600, 90, 320, 320, null); //BELLOSSOM 182
         else if(trainer2.getFirstPokemon().getName().equals("Paras"))
            g.drawImage(new ImageIcon("Battlers/046.png").getImage(), 600, 130, 320, 320, null); //PARAS 046
         else if(trainer2.getFirstPokemon().getName().equals("Parasect"))
            g.drawImage(new ImageIcon("Battlers/047.png").getImage(), 600, 80, 320, 320, null); //PARASECT 047
         else if(trainer2.getFirstPokemon().getName().equals("Venonat"))
            g.drawImage(new ImageIcon("Battlers/048.png").getImage(), 600, 60, 320, 320, null); //VENONAT 048
         else if(trainer2.getFirstPokemon().getName().equals("Venomoth")) {
            g.drawImage(new ImageIcon("Battlers/object_shadow.png").getImage(), 700, 290, 128, 30, null); //SHADOW
            g.drawImage(new ImageIcon("Battlers/049.png").getImage(), 610, 0, 320, 320, null); //VENOMOTH 049
         } else if(trainer2.getFirstPokemon().getName().equals("Diglett"))
            g.drawImage(new ImageIcon("Battlers/050.png").getImage(), 610, 110, 320, 320, null); //DIGLETT 050
         else if(trainer2.getFirstPokemon().getName().equals("Dugtrio"))
            g.drawImage(new ImageIcon("Battlers/051.png").getImage(), 600, 90, 320, 320, null); //DUGTRIO 051
         else if(trainer2.getFirstPokemon().getName().equals("Meowth"))
            g.drawImage(new ImageIcon("Battlers/052.png").getImage(), 600, 70, 320, 320, null); //MEOWTH 052
         else if(trainer2.getFirstPokemon().getName().equals("Persian"))
            g.drawImage(new ImageIcon("Battlers/053.png").getImage(), 610, 70, 320, 320, null); //PERSIAN 053
         else if(trainer2.getFirstPokemon().getName().equals("Psyduck"))
            g.drawImage(new ImageIcon("Battlers/054.png").getImage(), 600, 80, 320, 320, null); //PSYDUCK 054
         else if(trainer2.getFirstPokemon().getName().equals("Golduck"))
            g.drawImage(new ImageIcon("Battlers/055.png").getImage(), 590, 60, 320, 320, null); //GOLDUCK 055
         else if(trainer2.getFirstPokemon().getName().equals("Mankey"))
            g.drawImage(new ImageIcon("Battlers/056.png").getImage(), 610, 80, 320, 320, null); //MANKEY 056
         else if(trainer2.getFirstPokemon().getName().equals("Primeape"))
            g.drawImage(new ImageIcon("Battlers/057.png").getImage(), 610, 60, 320, 320, null); //PRIMEAPE 057
         else if(trainer2.getFirstPokemon().getName().equals("Growlithe"))
            g.drawImage(new ImageIcon("Battlers/058.png").getImage(), 610, 70, 320, 320, null); //GROWLITHE 058
         else if(trainer2.getFirstPokemon().getName().equals("Arcanine"))
            g.drawImage(new ImageIcon("Battlers/059.png").getImage(), 610, 30, 320, 320, null); //ARCANINE 059
         else if(trainer2.getFirstPokemon().getName().equals("Poliwag"))
            g.drawImage(new ImageIcon("Battlers/060.png").getImage(), 610, 100, 320, 320, null); //POLIWAG 060
         else if(trainer2.getFirstPokemon().getName().equals("Poliwhirl"))
            g.drawImage(new ImageIcon("Battlers/061.png").getImage(), 600, 80, 320, 320, null); //POLIWHIRL 061
         else if(trainer2.getFirstPokemon().getName().equals("Poliwrath"))
            g.drawImage(new ImageIcon("Battlers/062.png").getImage(), 600, 60, 320, 320, null); //POLIWRATH 062
         else if(trainer2.getFirstPokemon().getName().equals("Politoed"))
            g.drawImage(new ImageIcon("Battlers/186.png").getImage(), 600, 60, 320, 320, null); //POLITOED 169
         else if(trainer2.getFirstPokemon().getName().equals("Abra"))
            g.drawImage(new ImageIcon("Battlers/063.png").getImage(), 590, 90, 320, 320, null); //ABRA 063
         else if(trainer2.getFirstPokemon().getName().equals("Kadabra"))
            g.drawImage(new ImageIcon("Battlers/064.png").getImage(), 600, 60, 320, 320, null); //KADABRA 064
         else if(trainer2.getFirstPokemon().getName().equals("Alakazam"))
            g.drawImage(new ImageIcon("Battlers/065.png").getImage(), 600, 50, 320, 320, null); //ALAKAZAM 065
         else if(trainer2.getFirstPokemon().getName().equals("Machop"))
            g.drawImage(new ImageIcon("Battlers/066.png").getImage(), 600, 60, 320, 320, null); //MACHOP 066
         else if(trainer2.getFirstPokemon().getName().equals("Machoke"))
            g.drawImage(new ImageIcon("Battlers/067.png").getImage(), 600, 45, 320, 320, null); //MACHOKE 067
         else if(trainer2.getFirstPokemon().getName().equals("Machamp"))
            g.drawImage(new ImageIcon("Battlers/068.png").getImage(), 570, 20, 320, 320, null); //MACHAMP 068
         else if(trainer2.getFirstPokemon().getName().equals("Bellsprout"))
            g.drawImage(new ImageIcon("Battlers/069.png").getImage(), 600, 90, 320, 320, null); //BELLSPROUT 069
         else if(trainer2.getFirstPokemon().getName().equals("Weepinbell"))
            g.drawImage(new ImageIcon("Battlers/070.png").getImage(), 620, 80, 320, 320, null); //WEEPINBELL 070
         else if(trainer2.getFirstPokemon().getName().equals("Victreebel"))
            g.drawImage(new ImageIcon("Battlers/071.png").getImage(), 610, 50, 320, 320, null); //VICTREEBEL 071
         else if(trainer2.getFirstPokemon().getName().equals("Tentacool"))
            g.drawImage(new ImageIcon("Battlers/072.png").getImage(), 620, 40, 320, 320, null); //TENTACOOL 072
         else if(trainer2.getFirstPokemon().getName().equals("Tentacruel"))
            g.drawImage(new ImageIcon("Battlers/073.png").getImage(), 620, 50, 320, 320, null); //TENTACRUEL 073
         else if(trainer2.getFirstPokemon().getName().equals("Geodude"))
            g.drawImage(new ImageIcon("Battlers/074.png").getImage(), 600, 80, 320, 320, null); //GEODUDE 074
         else if(trainer2.getFirstPokemon().getName().equals("Graveler"))
            g.drawImage(new ImageIcon("Battlers/075.png").getImage(), 600, 80, 320, 320, null); //GRAVELER 075
         else if(trainer2.getFirstPokemon().getName().equals("Golem"))
            g.drawImage(new ImageIcon("Battlers/076.png").getImage(), 590, 60, 320, 320, null); //GOLEM 076
         else if(trainer2.getFirstPokemon().getName().equals("Ponyta"))
            g.drawImage(new ImageIcon("Battlers/077.png").getImage(), 610, 60, 320, 320, null); //PONYTA 077
         else if(trainer2.getFirstPokemon().getName().equals("Rapidash"))
            g.drawImage(new ImageIcon("Battlers/078.png").getImage(), 620, 30, 320, 320, null); //RAPIDASH 078
         else if(trainer2.getFirstPokemon().getName().equals("Slowpoke"))
            g.drawImage(new ImageIcon("Battlers/079.png").getImage(), 600, 105, 320, 320, null); //SLOWPOKE 079
         else if(trainer2.getFirstPokemon().getName().equals("Slowbro"))
            g.drawImage(new ImageIcon("Battlers/080.png").getImage(), 620, 50, 320, 320, null); //SLOWBRO 080
         else if(trainer2.getFirstPokemon().getName().equals("Slowking"))
            g.drawImage(new ImageIcon("Battlers/199.png").getImage(), 600, 40, 320, 320, null); //SLOWKING 199
         else if(trainer2.getFirstPokemon().getName().equals("Magnemite")) {
            g.drawImage(new ImageIcon("Battlers/object_shadow.png").getImage(), 700, 290, 128, 30, null); //SHADOW
            g.drawImage(new ImageIcon("Battlers/081.png").getImage(), 600, 30, 320, 320, null); //MAGNEMITE 081
         } else if(trainer2.getFirstPokemon().getName().equals("Magneton")) {
            g.drawImage(new ImageIcon("Battlers/object_shadow.png").getImage(), 700, 290, 128, 30, null); //SHADOW
            g.drawImage(new ImageIcon("Battlers/082.png").getImage(), 600, 10, 320, 320, null); //MAGNETON 082
         } else if(trainer2.getFirstPokemon().getName().equals("Magnezone")) {
            g.drawImage(new ImageIcon("Battlers/object_shadow.png").getImage(), 700, 290, 128, 30, null); //SHADOW
            g.drawImage(new ImageIcon("Battlers/462.png").getImage(), 600, 10, 320, 320, null); //MAGNEZONE 462
         } else if(trainer2.getFirstPokemon().getName().equals("Farfetch'd"))
            g.drawImage(new ImageIcon("Battlers/083.png").getImage(), 600, 80, 320, 320, null); //FARFETCH'D 083
         else if(trainer2.getFirstPokemon().getName().equals("Doduo"))
            g.drawImage(new ImageIcon("Battlers/084.png").getImage(), 560, 60, 320, 320, null); //DODUO 084
         else if(trainer2.getFirstPokemon().getName().equals("Dodrio"))
            g.drawImage(new ImageIcon("Battlers/085.png").getImage(), 580, 10, 320, 320, null); //DODRIO 085
         else if(trainer2.getFirstPokemon().getName().equals("Seel"))
            g.drawImage(new ImageIcon("Battlers/086.png").getImage(), 610, 70, 320, 320, null); //SEEL 086
         else if(trainer2.getFirstPokemon().getName().equals("Dewgong"))
            g.drawImage(new ImageIcon("Battlers/087.png").getImage(), 600, 50, 320, 320, null); //DEWGONG 087
         else if(trainer2.getFirstPokemon().getName().equals("Grimer"))
            g.drawImage(new ImageIcon("Battlers/088.png").getImage(), 580, 90, 320, 320, null); //GRIMER 088
         else if(trainer2.getFirstPokemon().getName().equals("Muk"))
            g.drawImage(new ImageIcon("Battlers/089.png").getImage(), 610, 50, 320, 320, null); //MUK 089
         else if(trainer2.getFirstPokemon().getName().equals("Shellder"))
            g.drawImage(new ImageIcon("Battlers/090.png").getImage(), 600, 105, 320, 320, null); //SHELLDER 090
         else if(trainer2.getFirstPokemon().getName().equals("Cloyster"))
            g.drawImage(new ImageIcon("Battlers/091.png").getImage(), 580, 50, 320, 320, null); //CLOYSTER 091
         else if(trainer2.getFirstPokemon().getName().equals("Gastly"))
            g.drawImage(new ImageIcon("Battlers/092.png").getImage(), 600, 30, 320, 320, null); //GASTLY 092
         else if(trainer2.getFirstPokemon().getName().equals("Haunter"))
            g.drawImage(new ImageIcon("Battlers/093.png").getImage(), 600, 30, 320, 320, null); //HAUNTER 093
         else if(trainer2.getFirstPokemon().getName().equals("Gengar"))
            g.drawImage(new ImageIcon("Battlers/094.png").getImage(), 600, 60, 320, 320, null); //GENGAR 094
         else if(trainer2.getFirstPokemon().getName().equals("Onix"))
            g.drawImage(new ImageIcon("Battlers/095.png").getImage(), 580, 30, 320, 320, null); //ONIX 095
         else if(trainer2.getFirstPokemon().getName().equals("Steelix"))
            g.drawImage(new ImageIcon("Battlers/208.png").getImage(), 580, 30, 320, 320, null); //STEELIX 208
         else if(trainer2.getFirstPokemon().getName().equals("Drowzee"))
            g.drawImage(new ImageIcon("Battlers/096.png").getImage(), 580, 60, 320, 320, null); //DROWZEE 096
         else if(trainer2.getFirstPokemon().getName().equals("Hypno"))
            g.drawImage(new ImageIcon("Battlers/097.png").getImage(), 610, 40, 320, 320, null); //HYPNO 097
         else if(trainer2.getFirstPokemon().getName().equals("Krabby"))
            g.drawImage(new ImageIcon("Battlers/098.png").getImage(), 600, 70, 320, 320, null); //KRABBY 098
         else if(trainer2.getFirstPokemon().getName().equals("Kingler"))
            g.drawImage(new ImageIcon("Battlers/099.png").getImage(), 620, 50, 320, 320, null); //KINGLER 099
         else if(trainer2.getFirstPokemon().getName().equals("Voltorb"))
            g.drawImage(new ImageIcon("Battlers/100.png").getImage(), 600, 100, 320, 320, null); //VOLTORB 100
         else if(trainer2.getFirstPokemon().getName().equals("Electrode"))
            g.drawImage(new ImageIcon("Battlers/101.png").getImage(), 600, 65, 320, 320, null); //ELECTRODE 101
         else if(trainer2.getFirstPokemon().getName().equals("Exeggcute"))
            g.drawImage(new ImageIcon("Battlers/102.png").getImage(), 610, 110, 320, 320, null); //EXEGGCUTE 102
         else if(trainer2.getFirstPokemon().getName().equals("Exeggutor"))
            g.drawImage(new ImageIcon("Battlers/103.png").getImage(), 600, 20, 320, 320, null); //EXEGGUTOR 103
         else if(trainer2.getFirstPokemon().getName().equals("Cubone"))
            g.drawImage(new ImageIcon("Battlers/104.png").getImage(), 600, 90, 320, 320, null); //CUBONE 104
         else if(trainer2.getFirstPokemon().getName().equals("Marowak"))
            g.drawImage(new ImageIcon("Battlers/105.png").getImage(), 570, 80, 320, 320, null); //MAROWAK 105
         else if(trainer2.getFirstPokemon().getName().equals("Hitmonlee"))
            g.drawImage(new ImageIcon("Battlers/106.png").getImage(), 610, 50, 320, 320, null); //HITMONLEE 106
         else if(trainer2.getFirstPokemon().getName().equals("Hitmonchan"))
            g.drawImage(new ImageIcon("Battlers/107.png").getImage(), 600, 40, 320, 320, null); //HITMONCHAN 107
         else if(trainer2.getFirstPokemon().getName().equals("Hitmontop"))
            g.drawImage(new ImageIcon("Battlers/237.png").getImage(), 600, 55, 320, 320, null); //HITMONTOP 237
         else if(trainer2.getFirstPokemon().getName().equals("Lickitung"))
            g.drawImage(new ImageIcon("Battlers/108.png").getImage(), 600, 60, 320, 320, null); //LICKITUNG 108
         else if(trainer2.getFirstPokemon().getName().equals("Lickilicky"))
            g.drawImage(new ImageIcon("Battlers/463.png").getImage(), 600, 30, 320, 320, null); //LICKILICKY 463
         else if(trainer2.getFirstPokemon().getName().equals("Koffing")) {
            g.drawImage(new ImageIcon("Battlers/object_shadow.png").getImage(), 700, 290, 128, 30, null); //SHADOW
            g.drawImage(new ImageIcon("Battlers/109.png").getImage(), 610, 0, 320, 320, null); //KOFFING 109
         } else if(trainer2.getFirstPokemon().getName().equals("Weezing")) {
            g.drawImage(new ImageIcon("Battlers/object_shadow.png").getImage(), 700, 290, 128, 30, null); //SHADOW
            g.drawImage(new ImageIcon("Battlers/110.png").getImage(), 580, 0, 320, 320, null); //WEEZING 100
         } else if(trainer2.getFirstPokemon().getName().equals("Rhyhorn"))
            g.drawImage(new ImageIcon("Battlers/111.png").getImage(), 610, 70, 320, 320, null); //RHYHORN 111
         else if(trainer2.getFirstPokemon().getName().equals("Rhydon"))
            g.drawImage(new ImageIcon("Battlers/112.png").getImage(), 600, 40, 320, 320, null); //RHYDON 112
         else if(trainer2.getFirstPokemon().getName().equals("Rhyperior"))
            g.drawImage(new ImageIcon("Battlers/464.png").getImage(), 620, 40, 320, 320, null); //RHYPERIOR
         else if(trainer2.getFirstPokemon().getName().equals("Chansey"))
            g.drawImage(new ImageIcon("Battlers/113.png").getImage(), 600, 70, 320, 320, null); //CHANSEY 113
         else if(trainer2.getFirstPokemon().getName().equals("Blissey"))
            g.drawImage(new ImageIcon("Battlers/242.png").getImage(), 610, 40, 320, 320, null); //BLISSEY
         else if(trainer2.getFirstPokemon().getName().equals("Tangela"))
            g.drawImage(new ImageIcon("Battlers/114.png").getImage(), 600, 80, 320, 320, null); //TANGELA 114
         else if(trainer2.getFirstPokemon().getName().equals("Tangrowth"))
            g.drawImage(new ImageIcon("Battlers/465.png").getImage(), 610, 30, 320, 320, null); //TANGROWTH
         else if(trainer2.getFirstPokemon().getName().equals("Kangaskhan"))
            g.drawImage(new ImageIcon("Battlers/115.png").getImage(), 610, 30, 320, 320, null); //KANGASKHAN 115
         else if(trainer2.getFirstPokemon().getName().equals("Horsea"))
            g.drawImage(new ImageIcon("Battlers/116.png").getImage(), 620, 80, 320, 320, null); //HORSEA 116
         else if(trainer2.getFirstPokemon().getName().equals("Seadra"))
            g.drawImage(new ImageIcon("Battlers/117.png").getImage(), 640, 50, 320, 320, null); //SEADRA 117
         else if(trainer2.getFirstPokemon().getName().equals("Kingdra"))
            g.drawImage(new ImageIcon("Battlers/230.png").getImage(), 610, 20, 320, 320, null); //KINGDRA
         else if(trainer2.getFirstPokemon().getName().equals("Goldeen"))
            g.drawImage(new ImageIcon("Battlers/118.png").getImage(), 610, 80, 320, 320, null); //GOLDEEN 118
         else if(trainer2.getFirstPokemon().getName().equals("Seaking"))
            g.drawImage(new ImageIcon("Battlers/119.png").getImage(), 610, 50, 320, 320, null); //SEAKING 119
         else if(trainer2.getFirstPokemon().getName().equals("Staryu"))
            g.drawImage(new ImageIcon("Battlers/120.png").getImage(), 620, 90, 320, 320, null); //STARYU 120
         else if(trainer2.getFirstPokemon().getName().equals("Starmie"))
            g.drawImage(new ImageIcon("Battlers/121.png").getImage(), 600, 60, 320, 320, null); //STARMIE 121
         else if(trainer2.getFirstPokemon().getName().equals("Mr. Mime"))
            g.drawImage(new ImageIcon("Battlers/122.png").getImage(), 600, 50, 320, 320, null); //MR. MIME 122
         else if(trainer2.getFirstPokemon().getName().equals("Scyther"))
            g.drawImage(new ImageIcon("Battlers/123.png").getImage(), 580, 30, 320, 320, null); //SCYTHER 123
         else if(trainer2.getFirstPokemon().getName().equals("Scizor"))
            g.drawImage(new ImageIcon("Battlers/212.png").getImage(), 600, 50, 320, 320, null); //SCIZOR
         else if(trainer2.getFirstPokemon().getName().equals("Jynx"))
            g.drawImage(new ImageIcon("Battlers/124.png").getImage(), 590, 65, 320, 320, null); //JYNX 124
         else if(trainer2.getFirstPokemon().getName().equals("Electabuzz"))
            g.drawImage(new ImageIcon("Battlers/125.png").getImage(), 610, 50, 320, 320, null); //ELECTABUZZ 125
         else if(trainer2.getFirstPokemon().getName().equals("Electivire"))
            g.drawImage(new ImageIcon("Battlers/466.png").getImage(), 610, 40, 320, 320, null); //ELETIVIRE
         else if(trainer2.getFirstPokemon().getName().equals("Magmar"))
            g.drawImage(new ImageIcon("Battlers/126.png").getImage(), 590, 40, 320, 320, null); //MAGMAR 126
         else if(trainer2.getFirstPokemon().getName().equals("Magmortar"))
            g.drawImage(new ImageIcon("Battlers/467.png").getImage(), 600, 25, 320, 320, null); //MAGMORTAR
         else if(trainer2.getFirstPokemon().getName().equals("Pinsir"))
            g.drawImage(new ImageIcon("Battlers/127.png").getImage(), 590, 40, 320, 320, null); //PINSIR 127
         else if(trainer2.getFirstPokemon().getName().equals("Heracross"))
            g.drawImage(new ImageIcon("Battlers/214.png").getImage(), 600, 50, 320, 320, null); //HERACROSS
         else if(trainer2.getFirstPokemon().getName().equals("Tauros"))
            g.drawImage(new ImageIcon("Battlers/128.png").getImage(), 610, 50, 320, 320, null); //TAUROS 128
         else if(trainer2.getFirstPokemon().getName().equals("Magikarp"))
            g.drawImage(new ImageIcon("Battlers/129.png").getImage(), 610, 50, 320, 320, null); //MAGIKARP 129
         else if(trainer2.getFirstPokemon().getName().equals("Gyarados"))
            g.drawImage(new ImageIcon("Battlers/130.png").getImage(), 600, 30, 320, 320, null); //GYARADOS 130
         else if(trainer2.getFirstPokemon().getName().equals("Lapras"))
            g.drawImage(new ImageIcon("Battlers/131.png").getImage(), 610, 40, 320, 320, null); //LAPRAS 131
         else if(trainer2.getFirstPokemon().getName().equals("Ditto"))
            g.drawImage(new ImageIcon("Battlers/132.png").getImage(), 610, 110, 320, 320, null); //DITTO 132
         else if(trainer2.getFirstPokemon().getName().equals("Eevee"))
            g.drawImage(new ImageIcon("Battlers/133.png").getImage(), 610, 70, 320, 320, null); //EEVEE 133
         else if(trainer2.getFirstPokemon().getName().equals("Vaporeon"))
            g.drawImage(new ImageIcon("Battlers/134.png").getImage(), 590, 60, 320, 320, null); //VAPOREON 134
         else if(trainer2.getFirstPokemon().getName().equals("Jolteon"))
            g.drawImage(new ImageIcon("Battlers/135.png").getImage(), 590, 70, 320, 320, null); //JOLTEON 135
         else if(trainer2.getFirstPokemon().getName().equals("Flareon"))
            g.drawImage(new ImageIcon("Battlers/136.png").getImage(), 610, 60, 320, 320, null); //FLAREON 136 
         else if(trainer2.getFirstPokemon().getName().equals("Espeon"))
            g.drawImage(new ImageIcon("Battlers/196.png").getImage(), 600, 60, 320, 320, null); //ESPEON
         else if(trainer2.getFirstPokemon().getName().equals("Umbreon"))
            g.drawImage(new ImageIcon("Battlers/197.png").getImage(), 620, 70, 320, 320, null); //UMBREON
         else if(trainer2.getFirstPokemon().getName().equals("Glaceon"))
            g.drawImage(new ImageIcon("Battlers/471.png").getImage(), 590, 50, 320, 320, null); //GLACEON
         else if(trainer2.getFirstPokemon().getName().equals("Leafeon"))
            g.drawImage(new ImageIcon("Battlers/470.png").getImage(), 620, 60, 320, 320, null); //LEAFEON
         else if(trainer2.getFirstPokemon().getName().equals("Sylveon"))
            g.drawImage(new ImageIcon("Battlers/700.png").getImage(), 600, 60, 320, 320, null); //SYLVEON
         else if(trainer2.getFirstPokemon().getName().equals("Porygon")) {
            g.drawImage(new ImageIcon("Battlers/object_shadow.png").getImage(), 700, 290, 128, 30, null); //SHADOW
            g.drawImage(new ImageIcon("Battlers/137.png").getImage(), 600, 20, 320, 320, null); //PORYGON
         } else if(trainer2.getFirstPokemon().getName().equals("Porygon2")) {
            g.drawImage(new ImageIcon("Battlers/object_shadow.png").getImage(), 700, 290, 128, 30, null); //SHADOW
            g.drawImage(new ImageIcon("Battlers/233.png").getImage(), 600, 30, 320, 320, null); //PORYGON2
         } else if(trainer2.getFirstPokemon().getName().equals("Porygon-Z")) {
            g.drawImage(new ImageIcon("Battlers/object_shadow.png").getImage(), 700, 290, 128, 30, null); //SHADOW
            g.drawImage(new ImageIcon("Battlers/474.png").getImage(), 600, 0, 320, 320, null); //PORYGON-Z
         } else if(trainer2.getFirstPokemon().getName().equals("Omanyte"))
            g.drawImage(new ImageIcon("Battlers/138.png").getImage(), 600, 90, 320, 320, null); //OMANYTE 138
         else if(trainer2.getFirstPokemon().getName().equals("Omastar"))
            g.drawImage(new ImageIcon("Battlers/139.png").getImage(), 610, 60, 320, 320, null); //OMASTAR 139
         else if(trainer2.getFirstPokemon().getName().equals("Kabuto"))
            g.drawImage(new ImageIcon("Battlers/140.png").getImage(), 610, 100, 320, 320, null); //KABUTO 140
         else if(trainer2.getFirstPokemon().getName().equals("Kabutops"))
            g.drawImage(new ImageIcon("Battlers/141.png").getImage(), 610, 30, 320, 320, null); //KABUTOPS 141
         else if(trainer2.getFirstPokemon().getName().equals("Aerodactyl")) {
            g.drawImage(new ImageIcon("Battlers/object_shadow.png").getImage(), 700, 290, 128, 30, null); //SHADOW
            g.drawImage(new ImageIcon("Battlers/142.png").getImage(), 610, -20, 320, 320, null); //AERODACTYL 142
         } else if(trainer2.getFirstPokemon().getName().equals("Snorlax"))
            g.drawImage(new ImageIcon("Battlers/143.png").getImage(), 600, 50, 320, 320, null); //SNORLAX 143
         else if(trainer2.getFirstPokemon().getName().equals("Articuno")) {
            g.drawImage(new ImageIcon("Battlers/144.png").getImage(), 630, 30, 320, 320, null); //ARTICUNO 144
         } else if(trainer2.getFirstPokemon().getName().equals("Zapdos")) {
            g.drawImage(new ImageIcon("Battlers/object_shadow.png").getImage(), 700, 290, 128, 30, null); //SHADOW
            g.drawImage(new ImageIcon("Battlers/145.png").getImage(), 610, -20, 320, 320, null); //ZAPDOS 145
         } else if(trainer2.getFirstPokemon().getName().equals("Moltres")) {
            g.drawImage(new ImageIcon("Battlers/146.png").getImage(), 610, 25, 320, 320, null); //MOLTRES 146
         } else if(trainer2.getFirstPokemon().getName().equals("Dratini"))
            g.drawImage(new ImageIcon("Battlers/147.png").getImage(), 610, 70, 320, 320, null); //DRATINI 147
         else if(trainer2.getFirstPokemon().getName().equals("Dragonair"))
            g.drawImage(new ImageIcon("Battlers/148.png").getImage(), 580, 30, 320, 320, null); //DRAGONAIR 148
         else if(trainer2.getFirstPokemon().getName().equals("Dragonite"))
            g.drawImage(new ImageIcon("Battlers/149.png").getImage(), 620, 20, 320, 320, null); //DRAGONITE 149
         else if(trainer2.getFirstPokemon().getName().equals("Mewtwo"))
            g.drawImage(new ImageIcon("Battlers/150.png").getImage(), 610, 40, 320, 320, null); //MEWTWO 150
         else if(trainer2.getFirstPokemon().getName().equals("Mew")) {
            g.drawImage(new ImageIcon("Battlers/object_shadow.png").getImage(), 700, 290, 128, 30, null); //SHADOW
            g.drawImage(new ImageIcon("Battlers/151.png").getImage(), 570, 0, 320, 320, null); //MEW 151
         } else { 
            g.drawImage(new ImageIcon("Battlers/000.png").getImage(), 620, 0, 320, 320, null); //NULL VALUE 000
         }
      }
   }
}