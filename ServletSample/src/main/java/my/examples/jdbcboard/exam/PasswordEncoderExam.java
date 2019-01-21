package my.examples.jdbcboard.exam;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderExam {
    public static void main(String[] args){
        PasswordEncoder passwordEncoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();

        // 암호화 하는 코드
        String encode = passwordEncoder.encode("1234");
        System.out.println(encode);
        // {bcrypt}$2a$10$Upx1/nb0FqmYTpAKpzbQr.ndA/p51pWKrP809xxJS8eOb1DENHiES
        // {bcrypt}$2a$10$x71Ji7LylauiKKHCh1RRle7dWif71UEzUmocWwxCZFmuwlZjZnoeq

        // 암호와 일치하는지 확인
        boolean matches = passwordEncoder.matches("1234", encode);
        System.out.println(matches);
    }
}
