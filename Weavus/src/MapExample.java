import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample {
	
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("Lee" , "first");
		map.put("Kim" , "firstSeconds");
		map.put("Lim" , "firstSecondsThird");
		
		map.get("Lee");
		map.get("Kim");
		map.get("Lim");
		
		for(String name : map.keySet()) {
			System.out.println(map.get(name));
		}
////////////////////////////////////////////////////////////////////////////////////		
		List<String> oneBanNameList = new ArrayList<String>();
		oneBanNameList.add("일반 일짱");
		oneBanNameList.add("일반 이짱");
		List<String> twoBanNameList = new ArrayList<String>();
		twoBanNameList.add("이반 일짱");
		twoBanNameList.add("이반 이짱");
		
		Map<String, List<String>> banNameListMap = new HashMap<String, List<String>>();
		banNameListMap.put("일반 짱기록부", oneBanNameList);
		banNameListMap.put("이반 짱기록부", twoBanNameList);
		
//		banNameListMap.get(banNameListMap);
		
		for(String ban : banNameListMap.keySet()) {
			for(String banName : banNameListMap.get(ban))
			System.out.println(banName);	
		}	
		
//		Map<String, List<String>> nation = new HashMap<String, List<String>>();
//		nation.put
//		
//		List<String> koreaCityList = new ArrayList<String>();
//		koreaCityList.add("seout");
//		
//		
//		List<String> japanCityList = new ArrayList<String>();
//		koreaCityList.add("tokyo");
//		
//		for(String nation : cityMap.keyset()) {
//			List<String> cityList = cityMap.get(nation){
//				for()
//			}
//		}
	}
}
