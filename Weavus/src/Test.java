import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		
		try {
			String[] arr = new String[5];
			System.out.println(arr[-1]);
			
			List<String> list = null;
			for(String str : list) {
				System.out.println(str);
			}
			
			System.out.println(8/0);
			
		} catch (IndexOutOfBoundsException ie) {
			System.out.println("인덱스를 벗어난 경우는 처리가 불가능합니다.");
		} catch (ArithmeticException ae) {
			System.out.println("0으로는 나눌 수 없습니다.");
		} catch (NullPointerException ne) {
			System.out.println("null의 리스트가 존재합니다.");
		}
	}
}
