
public class Trainer 
{
   private String name;
   private int money;
   private Pokemon[] party;
	
   public Trainer() {
      this.name = "";
      this.money = 0;
      this.party = new Pokemon[6];
   }
   
   public Trainer(String n, int m){
      name = n;
      money = m;
      this.party = new Pokemon[6];
   }
	
   public String getName(){
      return name;
   }
	
   public void setName(String n){
      name = n;
   }
	
   public int getMoney(){
      return money;
   }
	
   public void setMoney(int m){
      money = m;
   }
   
   public Pokemon getFirstPokemon() {
      return party[0];
   }
   
   public Pokemon getPokemon(int index) {
      return party[index];
   }
   
   public void setPokemon(int index, Pokemon pokemon) {
      party[index] = pokemon;
   }
   
   public Pokemon[] getParty(){
      return party;  
   }
   
   public boolean canBattle() {
      for(int i = 0; i < 6; i++) {
         if(party[i].getCanBattle()) {
            return true;
         }
      }
      return false;
   }
   
   public boolean hasPokemon(String name) {
      for(int i = 0; i < 6; i++) {
         if(party[i] != null) {
            if(party[i].getName().equals(name)) {
               return true;
            }
         }
      }
      return false;
   }
   
   public String partyToString() {
      String result = "";
      for(int i = 0; i < 6; i++) {
         result += party[i].toString() + " ";
      }
      return result;
   }
   
   public String getTeam(){
      String party_mod = "[";
      if(party != null){
         for(int i = 0; i < party.length; i++){
            if(party[i] != null){
               if(i == 0)
                  party_mod += "0:"+party[i].getName()+" Lv."+party[i].getLevel()+" ("+party[i].getRemHP()+"/"+party[i].getMaxHP()+")";
               else{
                  party_mod += "|"+i+":"+party[i].getName()+" Lv."+party[i].getLevel()+" ("+party[i].getRemHP()+"/"+party[i].getMaxHP()+")";
               }
            } 
         }
      }
      party_mod += "]";
      return party_mod;
   }
   
   public void swap(int index) {
      Pokemon temp = party[0];
      party[0] = party[index];
      party[index] = temp;
   }
   
   public String toString(){
      return name + " " + money + " " + partyToString();
   }
}
