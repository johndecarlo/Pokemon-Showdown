
public class Move 
{
   private String internal_name;
   private String display_name;
   private String function_code;
   private int base_power;
   private String type;
   private String category;
   private int accuracy;
   private int pp;
   private int effect;
   private int priority;
   private String flags;
   private int remPP;
   
	
   public Move(){
      this.internal_name = "";
      this.display_name = "";
      this.function_code = "";
      this.base_power = 0;
      this.type = "";
      this.category = "";
      this.accuracy = 0;
      this.pp = 0;
      this.effect = 0;
      this.priority = 0;
      this.flags = "";
      this.remPP = pp;
   }
   
   public Move(String i_n, String d_n, String f_c, int pow, String t, String c, int a, int pp, int e, int p, String f) {
      this.internal_name = i_n;
      this.display_name = d_n;
      this.function_code = f_c;
      this.base_power = pow;
      this.type = t;
      this.category = c;
      this.accuracy = a;
      this.pp = pp;
      this.effect = e;
      this.priority = p;
      this.flags = f;
      this.remPP = pp;
   }
	
   public String getInternalName(){
      return internal_name;
   }
	
   public void setInternalName(String internal_name){
      this.internal_name = internal_name;
   }
   
   public String getDisplayName(){
      return display_name;
   }
	
   public void setDisplayName(String display_name){
      this.display_name = display_name;
   }
   
   public String getFunctionCode(){
      return function_code;
   }
	
   public void setFunctionCode(String function_code){
      this.function_code = function_code;
   }
   
   public int getPower(){
      return base_power;
   }
	
   public void setPower(int base_power){
      this.base_power = base_power;
   }
	
   public String getType(){
      return type;
   }
	
   public void setType(String t){
      type = t;
   }
	
   public String getCategory(){
      return category;
   }
	
   public void setCategory(String c){
      category = c;
   }
	
   public int getAccuracy(){
      return accuracy;
   }
	
   public void setAccuracy(int a){
      accuracy = a;
   }
	
   public int getPP(){
      return pp;
   }
	
   public void setPP(int p){
      pp = p;
   }
   
   public int getRemPP(){
      return remPP;
   }
	
   public void setRemPP(int rem){
      remPP = rem;
   }
   
   public int getEffect(){
      return effect;
   }
   
   public void setEffect(int e){
      effect = e;
   }
   
   public int getPriority(){
      return priority;
   }
   
   public void setPriority(int priority){
      this.priority = priority;
   }
   
   public String getFlags(){
      return flags;
   }
	
   public void setFlags(String flags){
      this.flags = flags;
   }
}

