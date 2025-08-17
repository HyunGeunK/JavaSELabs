package mylab.book.entity;

public class Magazine extends Publication {
    private String publishPeriod;

    // 생성자
    public Magazine(String title, String publishDate, int page, int price, String publishPeriod) {
        super(title, publishDate, page, price); // 부모 생성자 호출
        this.publishPeriod = publishPeriod;
    }

    // Getter 및 Setter
    public String getPublishPeriod() {
        return publishPeriod;
    }

    public void setPublishPeriod(String publishPeriod) {
        this.publishPeriod = publishPeriod;
    }

    // toString() 오버라이드
    @Override
    public String toString() {
        return super.toString() + " [잡지] 발행주기:" + publishPeriod + ", " + getPage() + "쪽, " 
               + getPrice() + "원, 출판일:" + getPublishDate();
    }
}