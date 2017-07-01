
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CoordinatesClosestFarthest {

	JSONParser parser; // for parsing json
	Coordinates coordInput; // coordinates from user
	List<CoordDist> coordDist; // distances between user specified coordinate and other coordinates
	static Map<String, Coordinates> data; // coordinates data from json
	

	public CoordinatesClosestFarthest() {
		data = new LinkedHashMap<String, Coordinates>();
		data = parseJSON();
		coordDist=new LinkedList<CoordDist>();
		coordInput = coordInput();
		
		for (String key : data.keySet()) {
			Coordinates c2=data.get(key);
			double dist=getDist(coordInput, c2);
			CoordDist c=new CoordDist(key, dist, c2);
			coordDist.add(c);
		}
		
		System.out.println("Given Data");
		for (String key : data.keySet()) {
			System.out.print("id: "+key+" ");
			System.out.println("value: "+data.get(key));
		}
		
		// to sort closest to farthest
		Collections.sort(coordDist, new Comparator<CoordDist>() {

			public int compare(CoordDist o1, CoordDist o2) {
				if(o1.getDist()>o2.getDist()) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		
		System.out.println();
		System.out.println();
		
		Iterator<CoordDist> i=coordDist.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
	}
	
	public void arrangeData() {
		ListIterator<CoordDist> i=coordDist.listIterator();
		while(i.hasNext()) {
			CoordDist cDist=i.next();
			data.get(cDist.getId());
			
		}
	}
	
	// taking coordinates from the user
	public Coordinates coordInput() {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Coordinates");
		System.out.println("Enter x: ");
		double d1=s.nextDouble();
		System.out.println("Enter y: ");
		double d2=s.nextDouble();
		Coordinates coordInput = new Coordinates(d1,d2);
		s.close();
		return coordInput;
	}

	// to parse the json file
	public Map<String, Coordinates> parseJSON() {
		Map<String, Coordinates> parsedData = new LinkedHashMap<String, Coordinates>();
		parser = new JSONParser();
		try {
			
			Object obj = parser.parse(new FileReader("src/main/resources/coordinates.json"));

			JSONArray array = (JSONArray) obj;
			ListIterator i = array.listIterator();
			parsedData = new LinkedHashMap<String, Coordinates>();
			while (i.hasNext()) {

				JSONObject jsonObj = (JSONObject) i.next();
				String s = (String) jsonObj.get("value");
				String string[] = s.split(",");
				Coordinates c = new Coordinates(Integer.parseInt(string[0]), Integer.parseInt(string[1]));

				parsedData.put((String) jsonObj.get("id"), c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return parsedData;
	}
	
	// to get distance between two coordinates
	public double getDist(Coordinates c1, Coordinates c2) {
		double x1 = c1.getX();
		double y1 = c1.getY();
		double x2 = c2.getX();
		double y2 = c2.getY();
		double dist = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
		return dist;
	}

	public static void main(String[] args) {

		new CoordinatesClosestFarthest();

	}

}
