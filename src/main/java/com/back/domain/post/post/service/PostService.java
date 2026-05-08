package com.back.domain.post.post.service;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/*
* @Component vs @Service 차이
* @Component : 스프링이 관리하는 객체
* @Service : 비즈니스 로직 계층
* */
@Service
@RequiredArgsConstructor
public class PostService {
	private final PostRepository postRepository; //spring이 자동으로 의존성을 주입

	public long count() {
		return postRepository.count();
	}

	public Post save(Post post) {
		return postRepository.save(post);
	}

	public Optional<Post> findById(int id) {

		return postRepository.findById(id);
	}

//	public void modify(Post post, String title, String content) {
//		post.setTitle(title);
//		post.setContent(content);
//		post.setModifyDate(LocalDateTime.now());
//		postRepository.save(post);
//	}
//	public void modify(Post post, String title, String content) {
//		boolean changed = false;
//		if(!post.getTitle().equals(title)) {
//			post.setTitle(title);
//			changed = true;
//		}
//		if(!post.getContent().equals(content)) {
//			post.setContent(content);
//			changed = true;
//		}
//		if (changed) {
//			post.setModifyDate(LocalDateTime.now());
//		}
//
//		postRepository.save(post);
//	}
	//엔티디변경에 따른 자동 생성일자 변경하는 어노테이션 추가
	public void modify(Post post, String title, String content) {
		post.setTitle(title);
		post.setContent(content);

//		postRepository.save(post);
	}

	public Post write(String title, String content) {
		Post post = new Post(title, content);
		postRepository.save(post);
		return post;
	}
}


//비즈니스 로직을 처리하게 된다
// Controller → Service → Repository
/*
내부 동작 흐름
1. @Component 발견
2. Spring이 객체 생성
3. 컨테이너에 저장
4. @Autowired 있으면 자동 연결
* */