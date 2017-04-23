package pagwebjsf;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.io.Serializable;
import java.util.regex.*;


public class servico implements Serializable{
public servico(){
		
	}
	
	

	  public  void consumir () {
		try {
			char[] aCaracteres;
			Client client = Client.create();
			

			WebResource webResource = client
			   .resource("http://api.wunderground.com/api/9d8a36dc6b3ff44f/conditions/q/CA/San_Diego.json");

			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);

			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);
			
			
			
			String palabra = "temperature_string";
			//String texto = "lenguaje sql";
			boolean resultado = output.contains(palabra);
				
			if(resultado){
			    System.out.println("palabra encontrada");
			}else{
			    System.out.println("palabra no encontrada");
			} 
			
			
			String aguja = "temp_c";             //palabra buscada
			String pajar = output;    //texto

			//escapar y agregar limites de palabra completa - case-insensitive
			Pattern regex = Pattern.compile("\\b" + Pattern.quote(aguja) + "\\b", Pattern.CASE_INSENSITIVE);
			Matcher match = regex.matcher(pajar);

			//la palabra está en el texto??
			if (match.find()) {  //si se quiere encontrar todas las ocurrencias: cambiar el if por while
			    System.out.println("Encontrado: '" + match.group() 
			                     + "' dentro de '" + pajar 
			                     + "' en la posición " + match.start());
			    int posicion=match.start();
			   
			     aCaracteres = output.toCharArray();
			    System.out.println("es aca  "+aCaracteres[posicion+8]+aCaracteres[posicion+9]+aCaracteres[posicion+10]+aCaracteres[posicion+11]);
			    
			    
			  
		
			    	
			    
			} else {
			    System.out.println("'" + aguja + "' NO está dentro de '" + pajar);
			    
			}
			
			
			
			
			
			
			

		  } catch (Exception e) {

			e.printStackTrace();

		  }
		
		
		
		
			
		}
	  	
	  	
	  
	  
	  
	  
	}