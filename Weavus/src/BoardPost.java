public class BoardPost {
    private String title;
    private String content;
    private boolean isAdmin;

    public BoardPost(String title, String content, boolean isAdmin) {
        this.title = title;     
        this.content = content;
        this.isAdmin = isAdmin;
    }
								//클래스 데이터타입 정의 -> 생성자생성(초기화) 
								//->굵은 title (파라메터와 같다는 의미), this.title은 필드와 같다.는 의미
	
    public String getTitle() {
        return title;
    }

    public String getContent(boolean currentUserIsAdmin) {
        if (currentUserIsAdmin || !isAdmin) { 		//관리자인 경우, 또는, 아닌 경우
													//이 두 조건 중 하나만 참이라도 전체 조건은 참
        											//왼쪽이 참이므로, 오른쪽은 보지도 않음.																											
            return content; 
        } else {
            return "권한이 없습니다.";
        }
    }
    public static void main(String[] args) {
        // 사용자의 권한을 가정하여 객체 생성
        boolean currentUserIsAdmin = true; // true 또는 false로 사용자 권한 설정
        BoardPost post = new BoardPost("제목입니다.", "내용입니다.", currentUserIsAdmin);

		/*String result = post.getTitle();
		String result1 = post.getContent(currentUserIsAdmin);
		
		System.out.println("Title is" result);
		System.out.println("Content is" result1);*/
//-----------------------------결과값은 같다-------------------------------------
        System.out.println("제목: " + post.getTitle());
        System.out.println("내용: " + post.getContent(currentUserIsAdmin));
    }
}