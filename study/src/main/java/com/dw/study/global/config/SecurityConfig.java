package com.dw.study.global.config;


import com.dw.study.global.jwt.JwtAuthenticationFilter;
import com.dw.study.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity // 기본적인 Web보안을 활성화하는 어노테이션
public class SecurityConfig  {
    @Autowired
    private final MemberRepository memberRepository;
    @Autowired
    private final CorsFilter corsFilter;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션을 STATELESS 시켜주는 코드다. SpringSecurity는 기본적으로 쿠키, 세션을 지원하고 있는데, 우리는 JWT를 사용할 것이기 때문에 세션을 사용하지 않기 위해 STATELESS 시켜주었다.
                .and()// @CrossOrigin 인증되면 x , 아니면 시큐리티필터에 등록 인증 o
                .formLogin().disable()
                .httpBasic().disable()
                .apply(new MyCustomDsl())
                .and()
                .authorizeHttpRequests()
                .antMatchers("/member/join", "/member/login").permitAll()
                .antMatchers("/member").hasRole("USER")
                .anyRequest().permitAll();

    }
    public class MyCustomDsl extends AbstractHttpConfigurer<MyCustomDsl , HttpSecurity> {
        @Override
        public void configure(HttpSecurity builder) throws Exception {
            AuthenticationManager authenticationManager =
                    builder.getSharedObject(AuthenticationManager.class);
            builder.addFilter(corsFilter)
                    .addFilter(new JwtAuthenticationFilter(authenticationManager))
                    .addFilter(new JwtAuthorizationFilter(authenticationManager, memberRepository));
            super.configure(builder);
        }
    }

}