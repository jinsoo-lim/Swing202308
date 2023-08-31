// 인터페이스 정의
interface Drawable {
	    void draw(); // 추상 메서드
	}

// 인터페이스를 구현하는 클래스
class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("원을 그립니다.");        //구현
    }
}

class Rectangle implements Drawable {
    @Override
    public void draw() {
        System.out.println("사각형을 그립니다.");    //구현
    }
}

