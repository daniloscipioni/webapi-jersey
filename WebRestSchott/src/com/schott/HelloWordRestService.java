package com.schott;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.schott.dao.TestrestDAO;
import com.schott.object.UserProfile;


@Path("/helloWorld")
public class HelloWordRestService {
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("{name}")
		public String getGreeting(@Context HttpHeaders httpHeaders, @PathParam("name") String name){
			String greeting = "Hello " + name;
			
			return greeting;
		}
		
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/teste")
		public String createUserProfile(UserProfile userProfile) {
		    
			TestrestDAO dao = new TestrestDAO();
			
			//we can make use of UserProfile now
		    String value1 = userProfile.getFirstName();
		    String value2 = userProfile.getLastName();
		    
		    dao.InsertPost(value1, value2);
		    
		   // And when we are done we can return user profile back
		    return "Valores Inseridos Com Sucesso: " + value1 +" e "+ value2;
		}
		
}

//ENVIAR DESTA FORMA POR POST
//{
//	 "firstName":"Danilo",
//	 "lastName":"Eduardo"
//}