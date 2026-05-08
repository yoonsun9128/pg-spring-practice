package com.back.global.initData;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.repository.PostRepository;
import com.back.domain.post.post.service.PostService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

//전체적으로 영향역을 미치는 곳 global 파트로 넣는다
@Configuration
//@AllArgsConstructor //-> 클래스의 모든 필드를 인자로 받는 생성자 자동 생성
@RequiredArgsConstructor // final 필드만 인자로 받는 생성자 자동 생성
public class BaseInitData {
	@Autowired
	@Lazy
	private BaseInitData self;
	private final PostService postService; //RequiredArgsConstructor + final

	/*
	* AllArgsConstructor
	* 을 사용시 밑의 생성자 주입한 부분을 굳이 넣을 필요 없다.
	* 밑의 코드의 내용이 모든걸 입력받은데로 생성하기 때문에 하나의 어노테이션으로 대처할 수 있다.
	* */
////	@Autowired //생성자 주입에서는 해당 어노테이션을 생략할 수 있다.
//	public BaseInitData(PostService postService) {
//		this.postService = postService;
//	}

	@Bean
	ApplicationRunner baseInitDataApplicationRunner() {
		return args -> {
			self.work1();
			self.work2();
			self.work4();

//			new Thread(() -> self.work3()).start(); // 별도의 Thread 를 사용한 이유 : work3 메서드에서 예외가 발생해도 스프링부트가 꺼지지 않도록

		};
	}

	/* Transactional
	내부 호출로는 발동이 되지 않는다
	* */
	@Transactional
	void work1() {
		if (postService.count() > 0) return;

		Post post1 = postService.write("제목 1", "내용 1");
		Post post2 =  postService.write("제목 2", "내용 2");
		System.out.println("기본 데이터가 초기화되었습니다.");
	}

	@Transactional(readOnly = true)
	void work2() {
		Optional<Post> opPost1 = postService.findById(1);
		// SELECT * FROM post WHERE id = 1;
		Post post1 = opPost1.get();

		System.out.println("post1 : " + post1);
	}

	@Transactional
	void work3() {
		Optional<Post> opPost1 = postService.findById(1);
		// SELECT * FROM post WHERE id = 1;
		Post post1 = opPost1.get();
		postService.modify(post1, "제목 수정", "내용수정진행");
		if (true) throw new RuntimeException("work3에서 예외 발생");

		Optional<Post> opPost2 = postService.findById(2);
		Post post2 = opPost2.get();

		postService.modify(post2, "제목 2 수정", "내용 2 수정");
	}

	@Transactional
	void work4() {
		Optional<Post> opPost1 = postService.findById(1);
		Post post1 = opPost1.get();
		postService.modify(post1, "제목 1", "내용 1 수정");
	}
}

/*
 @Configuration : 빈의 일종, 내부에 @Bean 메서드를 가질 수 있다
 @Bean : 메서드는 스프링 부트가 시작할 때 자동으로 실행된다.
 ApplicationRunner : 빈에 등록되면 자동으로 실행되는 성질을 가지고 있다.
* */