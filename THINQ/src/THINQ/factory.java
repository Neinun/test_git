package THINQ;

public class factory {
	
	public user getUser(String userType){  
        if(userType == null){  
         return null;  
        }  
      if(userType.equalsIgnoreCase("thinqer")) {  
             return new thinqer();  
           }   
       else if(userType.equalsIgnoreCase("learner")){ 
    	   learner obj=new learner();
            return obj;  
        }   
  return null;  

}
}