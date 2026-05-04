package com.back.domain.post.post.service;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component //이 클래스를 Spring이 관리해줘
public class PostService {
	@Autowired
	private PostRepository postRepository; //spring이 자동으로 의존성을 주입

	public long count() {
		return postRepository.count();
	}

	public Post save(Post post) {
		return postRepository.save(post);
	}

	public Optional<Post> findById(int id) {
		return postRepository.findById(id);
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