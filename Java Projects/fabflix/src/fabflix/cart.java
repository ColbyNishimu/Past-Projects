package fabflix;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;
public class cart {
	HashMap<String, Integer> movieCart;
	
	public cart(){
		movieCart = new HashMap<>();	
	}
	
	public HashMap<String, Integer> getCart(){
		return movieCart;
	}
	
	public void add(String title){
		if(movieCart.containsKey(title)){
			movieCart.put(title, movieCart.get(title)+1);
		} else{
			movieCart.put(title,  1);
		}
	}
	
	public void remove(String title){
		if(movieCart.containsKey(title)){
			if(movieCart.get(title) == 1){
				movieCart.remove(title);
			} else{
				movieCart.put(title, movieCart.get(title)-1);
			}
		}
	}
	
	public String printCart(){
		Set set = movieCart.entrySet();
		Iterator i = set.iterator();
		String result = "Shopping Cart<br><br>";
		String checkout = "<form action = 'checkout' method='POST'>"+
				"<input type='submit' name='button' value='Checkout'>"+
				"</form><br><br>";
		if(!i.hasNext()){
			return result+"Cart Empty<br><br>"+ checkout;
		}
		while(i.hasNext()){
			Map.Entry j = (Map.Entry)i.next();
			result = result+j.getKey() + ": "+j.getValue()+
					"<form action='cartManager' method='GET'>"+
					"<input type='submit' name='button' value='+'>"+
					"<input type='submit' name='button' value='-'>"+
					"<input type='hidden' name='mtitle' value="+'"'+j.getKey()+'"'+">"+
					"<br>"+
					"</form>";
		}
		return result+checkout;
	}
}
