package com.back.global.initData;

import com.back.domain.post.post.entity.Post;
import com.back.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
@RequiredArgsConstructor
public class TestInitData {
	@Autowired
	@Lazy
	private TestInitData self;
	private final PostService postService;

	@Bean
	ApplicationRunner testInitDataApplicationRunner() {
		return args -> {
			if (postService.count() >= 4) return;

			Post post1 = postService.write("제목3", "내용3");
			Post post2 = postService.write("제목4", "내용4");

			System.out.println("테스트용 데이터가 초기화되었습니다.");
		};
	}

}

