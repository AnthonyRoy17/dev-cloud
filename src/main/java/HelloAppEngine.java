import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.cloud.Timestamp;



@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/hello"}
)

public class HelloAppEngine extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	  System.out.println("test");
	  Random r = new Random();
	   	 DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

	   	 // Create Petition
	   	 
	   	 
	   	 for (int i = 100; i < 110; i++) {	
	   		 Date d = new Date();
	   		 Entity e = new Entity("Petition", new Date().getTime() + "petition"+i); // � am�liorer
	   		 int owner=r.nextInt(1000);
	   		 e.setProperty("Key", d.getTime() + "Petition" + i);
	   		 e.setProperty("Name", "Petition"+i);
	   		 e.setProperty("Owner", "U" + owner);
	   		 e.setProperty("Date", new Date()); //date al�atoire (import java util)
	   		 e.setProperty("Body","test message  "+ i);
	   		 e.setProperty("jour", new SimpleDateFormat("dd/MM/yyyy").format(d));
			 e.setProperty("heure", new SimpleDateFormat("HH:mm").format(d));
	   		 
	   		 // Create random votants
	   		 HashSet<String> fset = new HashSet<String>();
	   		// for (int j=0; j<200; j++){
	   			 fset.add("test" );
	   		 //}
	   		 e.setProperty("votants", fset);
	   		 e.setProperty("nbvotants", fset.size());
	   		 
	   		 // Create random tags
	   		 HashSet<String> ftags = new HashSet<String>();
	   		 while (ftags.size() < 10) {
	   			 ftags.add("T" + r.nextInt(100));
	   		 }
	   		 e.setProperty("tags", ftags);
	   		 
	   		 datastore.put(e);
	   		 response.getWriter().print("<li> created post:" + e.getKey() + "<br>");
	   	 }
	   	 
	   	 
	   	 /*
	   	Date date = new Date();
	   	Entity e = new Entity("Petition");
	   	e.setProperty("jour", new SimpleDateFormat("dd/MM/yyyy").format(date));
	   	e.setProperty("heure", new SimpleDateFormat("HH:mm").format(date));
		datastore.put(e);
		response.getWriter().print("<li> created post:" + e + "<br>");
		*/
	   	
	   	 //Supprime toutes les entit�s du datastore
	   	/*
	   	 Query q = new Query("Petition");
		
		PreparedQuery pq = datastore.prepare(q);
		List<Entity> result = pq.asList(FetchOptions.Builder.withLimit(10000));
		
		for (Entity entity : result) {
			datastore.delete(entity.getKey());
			System.out.println("supresssion de "+ entity.getKey());
		}
		*/
		
  }
  
  
  
  	@ApiMethod(name = "addScore", httpMethod = HttpMethod.GET)
 	public Entity addScore(@Named("score") int score, @Named("name") String name) {

 		Entity e = new Entity("Score", "" + name + score);
 		e.setProperty("name", name);
 		e.setProperty("score", score);

 		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
 		datastore.put(e);
 		 
 		return e;
 	}
 	
  
 /* @ApiMethod(name = "GetValue", httpMethod = HttpMethod.GET)
	public int GetValue() {
	 
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity e = new Entity("Score");
		Entity score = datastore.get(e.getKey());
	}*/
}