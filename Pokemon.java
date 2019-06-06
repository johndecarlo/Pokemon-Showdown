public class Pokemon 
{
   private String name;
   private int level;
   private String type1;
   private String type2;
   private boolean canBattle;
   private int hp;
   private int atk;
   private int def;
   private int spatk;
   private int spdef;
   private int spd;
   private String status;
   private Move[] moveset = new Move[4];
   private int maxHP;
   private int remHP;
   private int evasion;
   private int accuracy;
	
   public Pokemon(){
      name = "";
      level = 1;
      type1 = "";
      type2 = "";
      canBattle = true;
      hp = 10;
      atk = 10;
      def = 10;
      spatk = 10;
      spdef = 10;
      spd = 10;
      status = "none";
      moveset[0] = new Move();
      moveset[1] = new Move();
      moveset[2] = new Move();
      moveset[3] = new Move();
      maxHP = ((((hp) * 2)*level)/100) + level + 10;  //Max HP of Pokemon
      remHP = maxHP;                                  //HP that remain
      evasion = 100;
      accuracy = 100;
   }
   
   public Pokemon(String name){
      this.name = name;
      level = 1;
      type1 = "";
      type2 = "";
      canBattle = true;
      hp = 10;
      atk = 10;
      def = 10;
      spatk = 10;
      spdef = 10;
      spd = 10;
      status = "none";
      moveset[0] = new Move();
      moveset[1] = new Move();
      moveset[2] = new Move();
      moveset[3] = new Move();
      maxHP = ((((hp) * 2)*level)/100) + level + 10;  //Max HP of Pokemon
      remHP = maxHP;                                  //HP that remain
      evasion = 100;
      accuracy = 100;
   }
   
   public Pokemon(String n, int l, String t1, String t2, int h, int a, int d, int sa, int sd, int sp, Move m1, Move m2, Move m3, Move m4){
      name = n;
      int rand = (int) (Math.random() * 10) + 1;
      level = l + rand;
      type1 = t1;
      type2 = t2;
      canBattle = true;
      hp = h;
      atk = a;
      def = d;
      spatk = sa;
      spdef = sd;
      spd = sp;
      status = "none";
      moveset[0] = m1;
      moveset[1] = m2;
      moveset[2] = m3;
      moveset[3] = m4;
      maxHP = ((((hp)*2)*level)/100)+level+10;
      remHP = maxHP;
      evasion = 100;
      accuracy = 100;
   }
	
   public String getName(){
      return name;
   }
	
   public void setName(String n){
      name = n;
   }
	
   public int getLevel(){
      return level;
   }
	
   public void setLevel(int l){
      level = l;
   }
	
   public String getType1(){
      return type1;
   }
	
   public void setType1(String t1){
      type1 = t1;
   }
	
   public String getType2(){
      return type2;
   }
	
   public void setType2(String t2){
      type2 = t2;
   }
   
   public boolean getCanBattle(){
      return canBattle;
   }
   
   public void setCanBattle(boolean cb){
      canBattle = cb;
   }
	
   public int getHP(){
      return hp;
   }
	
   public void setHP(int h){
      hp = h;
   }
	
   public int getAttack(){
      return atk;
   }
	
   public void setAttack(int a){
      atk = a;
   }
	
   public int getDefense(){
      return def;
   }
	
   public void setDefense(int d){
      def = d;
   }
	
   public int getSpAttack(){
      return spatk;
   }
	
   public void setSpAttack(int sa){
      spatk = sa;
   }
	
   public int getSpDefense(){
      return spdef;
   }
	
   public void setSpDefense(int sd){
      spdef = sd;
   }
	
   public int getSpeed(){
      return spd;
   }
	
   public void setSpeed(int sp){
      spd = sp;
   }
   
   public String getStatus() {
      return status;
   }
   
   public void setStatus(String s) {
      status = s;
   }
   
   public int getMaxHP(){
      return maxHP;
   }
	
   public void setMaxHP(int m){
      maxHP = m;
   }
   
   public int getRemHP(){
      return remHP;
   }
	
   public void setRemHP(int r){
      remHP = r;
   }
   
   public int getEvasion(){
      return evasion;
   }
	
   public void setEvasion(int e){
      evasion = e;
   }
   
   public int getAccuracy(){
      return accuracy;
   }
	
   public void setAccuracy(int a){
      accuracy = a;
   }
   
   public String showMoves(){
      String moves = "";
      for(int i = 0; i < moveset.length; i++){
         if(moveset[i] != null){
            moves += "Move #" + i +": " + moveset[i].getInternalName() + " ";
         }
         else
            moves += "Move #" + i +": " + "*Empty Slot* ";
      }
      return moves;
   }
   
   public Move getMove1(){
      return moveset[0];
   }
   
   public Move getMove2(){
      return moveset[1];
   }
   
   public Move getMove3(){
      return moveset[2];
   }
   
   public Move getMove4(){
      return moveset[3];
   }
   
   public String toString()
   {
      return "Name: " + name + "|Level: " + level + "|Type #1: " + type1 + "|Type #2: " + type2 + "|Base HP: " + hp 
         + "|Base Attack: " + atk + "|Base Defense: " + def + "|Base Sp. Attack: " + spatk + "|Base Sp. Defense: " + spdef
         + "|Speed: " + spd;
   }
   
   public String battle(){
      return name + " " + remHP + "/" + maxHP;
   }
}


