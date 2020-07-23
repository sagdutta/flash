package lambda.sago;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ArrayMap {

	public static void main(String[] args) {
		List<String> newList= new ArrayList<String>();
		newList.add("Sago");
		newList.add("Tuli");
		newList.add("Sago");
		System.out.println("Object: "+newList);
		//Collection.sort method
		Collections.sort(newList);
		System.out.println("Object: "+newList);
		
		
		//useOfArrayList
		String arr[] = new String[6];
		arr[0]="Sago";
		arr[1]="Tuli";
		arr[2]="Sago";
		arr[3]="Rakesh";
		arr[4]="Dona";
		List<String> newList1 =Arrays.asList(arr);
		System.out.println("Object: "+newList1);
		ArrayList<String> newArr= new ArrayList<String>(Arrays.asList(arr));
		System.out.println(newList1.get(4));
		newArr.add("Tuni");
		System.out.println("Object: "+newArr);
		
		//HasMap
		HashMap<String,String> newMap = new HashMap<String, String>();
		newMap.put("Biswas", "Raktim");
		newMap.put("Dutta", "Sagorica");
		newMap.put("Roy", "Priyanka");
		newMap.put("Manna","Arka");
		System.out.println("KeySet: "+newMap.values());
		
		Set<Entry<String,String>> newSet = newMap.entrySet();
		System.out.println("ENtrySet: "+newSet);
		ArrayList<Entry<String,String>> hasArray= new ArrayList<Entry<String,String>>(newSet.size());
		System.out.println("EntrySet1: "+hasArray);
	
		
	}

}
