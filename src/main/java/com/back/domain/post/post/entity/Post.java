package com.back.domain.post.post.entity;

import jakarta.persistence.*;
import lombok.*;

/*
post를 2개 쓴이유 글 안에 여러개의 글이 있기 때문에
댓글, 게시글 등등
* */

@Entity //밑의 구성대로 DB 테이블이 형성 되어야한다.
@Getter
@Setter
@ToString
//@NoArgsConstructor //사실 제목과 내용은 수정이 가능하니 final의 형식이 맞지는 않는다.

public class Post {
	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
	private final int id;
	private String title;
	@Column(columnDefinition = "TEXT") //필드 수정 char->text : db를 꼭 삭제해야한다
	private String content;

	public Post(String title, String content) {
		this.id = 0; //fianl을 넣을시 초기값에 id의 값을 넣어줘야하는 불편함
		this.title = title;
		this.content = content;
	}
	//인자 없는 생성자
	public Post() {
		this("", "");
	}
}

/*
*jpa는 디폴트 생성자가 필요하다.
* 리플렉션을 써서 final을 사용하고 있지만 외부에서 사용할 수 있게 바꿔준다.
* */