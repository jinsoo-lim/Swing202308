
public class ExceptionHandle {
	
	public static void main(String[] args) {
		
//		IndexOutOfBoundsException
		try {
			int[] arr = new int[1];
			System.out.println(arr[99]);
			
		} catch (Exception e) {
			System.out.println("에러 끈다. 이 자식아 ");
			System.out.println("지정한 인덱스 범위를 벗어났습니다!");
		}
		
	}

}
