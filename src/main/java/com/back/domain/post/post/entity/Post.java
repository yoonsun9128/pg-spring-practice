package com.back.domain.post.post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/*
post를 2개 쓴이유 글 안에 여러개의 글이 있기 때문에
댓글, 게시글 등등
* */

@Entity //밑의 구성대로 DB 테이블이 형성 되어야한다.
@Getter
@Setter
public class Post {
	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
	private int id;
	private String title;
	private String content;
}
