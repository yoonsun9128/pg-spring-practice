package com.back.domain.post.post.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/*
post를 2개 쓴이유 글 안에 여러개의 글이 있기 때문에
댓글, 게시글 등등
* */

@Entity //밑의 구성대로 DB 테이블이 형성 되어야한다.
@Getter
@Setter
@RequiredArgsConstructor //final 붙은 애들만 초기 셋팅 값으로 지정한다.
public class Post {
	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
	private int id;
	private final String title;
	@Column(columnDefinition = "TEXT") //필드 수정 char->text : db를 꼭 삭제해야한다
	private final String content;
}
