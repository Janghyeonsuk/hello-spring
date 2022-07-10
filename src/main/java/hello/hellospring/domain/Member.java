package hello.hellospring.domain;

public class Member {
    //고객을 구분하기 위한 시스템에서 저장하는 id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
