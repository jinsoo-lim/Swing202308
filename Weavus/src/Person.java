class Person {
    private String name; // private으로 멤버 변수 캡슐화
    private int age;     // private으로 멤버 변수 캡슐화

    // 생성자
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter 메서드
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setter 메서드
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age >= 0) { // 나이는 음수가 될 수 없도록 제한
            this.age = age;
        }
    }

    // 메서드
    public void introduce() {
        System.out.println("안녕하세요, 저는 " + name + "이고, " + age + "살입니다.");
    }
}
