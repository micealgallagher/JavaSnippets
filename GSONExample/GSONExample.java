import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class main {
	public static void main ( String[] args ) {
		
		fromVariableToJson();
		fromJsonToVariable();
	}

	private static void fromVariableToJson() {
		Gson gson = new Gson();
		
		String data = "One string to rule them all";
		String json = gson.toJson(data);
		
		System.out.println("Value: " + json);
		
		int[] integers = new int[] { 1, 1, 3, 5, 8, 13 };
		json = gson.toJson(integers, int[].class);
		
		System.out.println("Value: " + json);
		
		Person person = new Person();
		json = gson.toJson(person, Person.class);
		
		System.out.println("Value: " + json);
		
		ArrayList<Person> people = new ArrayList<Person>();
		people.add( new Person() );
		people.add( new Person() );
		
		Type type = new TypeToken<List<Person>>(){ /**/ }.getType();		
		json = gson.toJson( people, type );
		
		System.out.println("Value: " + json);
	}
	
	private static void fromJsonToVariable() {
		Gson gson = new Gson();
		
		String json = "\"One string to rule them all\"";
		
		String data = gson.fromJson(json, String.class);
		System.out.println("Value: " + data);
		
		json = "[1,1,3,5,8,13]";
		
		int[] integers = gson.fromJson(json, int[].class);
		
		System.out.println("Value: " + integers);
		
		json = "{\"name\":\"Miceal Gallagher\",\"age\":27}";
		Person person = gson.fromJson(json, Person.class);
		
		System.out.println("Value: " + person);
		
		json = "[{\"name\":\"Miceal Gallagher\",\"age\":27},{\"name\":\"Miceal Gallagher\",\"age\":27}]";
		
		Type type = new TypeToken<List<Person>>(){ /**/ }.getType();
		List<Person> people = gson.fromJson(json, type);
		
		System.out.println("Value: " + people);
	}

}

