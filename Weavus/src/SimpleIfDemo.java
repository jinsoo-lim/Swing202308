import java.util.Scanner;

public class SimpleIfDemo {
	
	public static void main(String[] args) {
		data();
		scanner();
		scanner1();
		grade();
		booleanExample();
		//문제 : 반복문, 조건문을 하나의 클래스에 만드세요.
		//문제 : 스캐너를 이용해서, 짝수,홀수가 나오는 조건문을 만드세요. if만으로 하나, if else로 하나.
		//문제 : 스캐너이용, 학점과 점수를 만드세요
		//문제 : 스캐너이용, 불린을 이용해서 짝수,홀수를 나오게 만드세요 (무한질문 만들기... 실패)

	}
	public static void data(){
		Scanner scanner = new Scanner(System.in);
        
        System.out.print("숫자를 입력하세요: ");
        int number = scanner.nextInt();
        
        if (number % 2 == 0) {
            System.out.println(number + "은(는) 짝수입니다.");
        } else {
            System.out.println(number + "은(는) 홀수입니다.");
        }
        
        System.out.println(number + "의 구구단:");
        for (int i = 1; i <= 9; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
	}
	
	
	public static void scanner() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Put the Number.");
		int number = scanner.nextInt(); //키보드에 정수를 입력받는다.
		
		if(number %2 == 0)
			System.out.println("Even짝수");
		
		if(number %2 == 1)
			System.out.println("Odd홀수");
		System.out.println("end");
	}

	public static void scanner1(){
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("Put the Number.");
		int number = scanner1.nextInt(); //키보드에 정수를 입력받는다.
		
		if(number %2 == 0)
			System.out.println("Even짝수");
		else
			System.out.println("Odd홀수");
		System.out.println("end");
	}
	public static void grade() {
		Scanner grade = new Scanner(System.in);
		String stringGrade;
		System.out.println("putTheScore :");
		int score = grade.nextInt();
		
		if(score > 90)
			stringGrade = "A";
		else if(score >=80)
			stringGrade = "B";
		else
			stringGrade = "Pass";
		System.out.println("yourGrade :" + stringGrade);
	}
	public static void booleanExample() {
		Scanner num = new Scanner(System.in);
		System.out.println("putTheNumber");
		int number = num.nextInt();
		boolean isEven = (number % 2 == 0);
//		while (true) {
		if(isEven)
			System.out.println("Even");
		else
			System.out.println("Odd");
//		}
	}
}


