package org.choongang.global.configs;

import lombok.RequiredArgsConstructor;
import org.choongang.member.MemberUtil;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuditorAwareImpl implements AuditorAware<String> {

    private final MemberUtil memberUtil;

    @Override
    public Optional<String> getCurrentAuditor() {
        String email = memberUtil.isLogin() ? memberUtil.getMember().getEmail() : null; // String email = null;

        return Optional.ofNullable(email); // 위의 email 값 연결 | of 보다 ofNullable 을 더 많이 사용하므로 ofNullable 사용
    }
}