package pagwebjsf;
import pagwebjsf.servico;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean  (name="new")
@ViewScoped	

public class Index implements Serializable{

	public Index(){
		
	}
//	servico call =new servico();
	
	
	public Index(String name) {
		super();
		this.name = name;
	}

	public void fuction (){
		
		
		
		System.out.println("el valor de name es "+ this.name);
	//	call.consumir();
	}
	
	
	
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private String resu ;
	

	
	 public String getResu() {
		return resu;
	}


	public void setResu(String resu) {
		this.resu = resu;
	}

public String resuf(String resu){
		
		return resu; 
	}
	public  String  consumir (String name) {
			try {
				char[] aCaracteres;
				Client client = Client.create();
				
				String uriMain = "https://query.yahooapis.com/v1/public/yql?q=select%20item.condition.temp%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22";
				String path = "%2C%20co%22)%20and%20u%3D%27c%27&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
				String cuidad = name;
				
				
					String uri = uriMain +cuidad +path ;
					
					
				WebResource webResource = client
				   .resource(uri);

				ClientResponse response = webResource.accept("application/json")
		                   .get(ClientResponse.class);

				if (response.getStatus() != 200) {
				   throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
				}

				String output = response.getEntity(String.class);

			//System.out.println("Output from Server .... \n");
			//	System.out.println(output);
				
				
				
				String palabra = "temperature_string";
				//String texto = "lenguaje sql";
				boolean resultado = output.contains(palabra);
					
				if(resultado){
				//    System.out.println("palabra encontrada");
				}else{
				  //  System.out.println("palabra no encontrada");
				} 
				
				
				String aguja = "temp";             //palabra buscada
				String pajar = output;    //texto

				//escapar y agregar limites de palabra completa - case-insensitive
				Pattern regex = Pattern.compile("\\b" + Pattern.quote(aguja) + "\\b", Pattern.CASE_INSENSITIVE);
				Matcher match = regex.matcher(pajar);

				//la palabra está en el texto??
				if (match.find()) {  //si se quiere encontrar todas las ocurrencias: cambiar el if por while
				   // System.out.println("Encontrado: '" + match.group() 
				     //                + "' dentro de '" + pajar 
				       //              + "' en la posición " + match.start());
				    int posicion=match.start();
				  
				     aCaracteres = output.toCharArray();
				    //System.out.println("temp : "+aCaracteres[posicion+8]+aCaracteres[posicion+9]+aCaracteres[posicion+10]+aCaracteres[posicion+11]);
				    //System.out.println(aCaracteres[posicion+10]);
				    resu =String.valueOf(aCaracteres[posicion+8]);
				    resu =resu +String.valueOf(aCaracteres[posicion+9]);
				    resu =resu +String.valueOf(aCaracteres[posicion+10]);
				    resu =resu +String.valueOf(aCaracteres[posicion+11]);
				    System.out.println("temp = "+resu);
				    
				    
				    resuf(resu);
				    
				} else {
				    System.out.println("error");
				    
				}
				
				
				
				
				
				
				

			  } catch (Exception e) {

				e.printStackTrace();

			  }
			
			return resu;
			
			
				
			}
	
	
	
	
	
	
}
