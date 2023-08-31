import java.util.ArrayList;
import java.util.List;

public class Loop {

	public static void main(String[] args) {
		int[] num = new int[100];  //numArr ,numList변수명확인
        
		for(int i = 0; i<num.length; i++) {
			num[i] = i+1;
			System.out.println(num[i]);
		}
//		for(numnum:num) {
//			System.out.println(numnum);
//		}
		//동적 배열이니까, size를 쓰면 "0"이 되버림.
		List<Integer> numArr = new ArrayList<Integer>();
		for(int j = 0; j < 100; j++) {
			numArr.add(j+1);
		}
		for(int j = 0; j < numArr.size(); j++) {
			System.out.println(numArr.get(j));
		}
		
		
		String date = "20230816";
		Stirng yyyy = date.substring(0,4);
		
		String aa = "5";
		int aaa = Integer.valueOf(aa);

		
		
		
		
	}

}
