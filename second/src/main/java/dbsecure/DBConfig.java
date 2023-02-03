package dbsecure;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Configuration //내가 설정클래스입니다.
@EnableEncryptableProperties // 현재 정보를 application.properties파일에서 사용가능
public class DBConfig {
	
	@Bean("jasyptEncryptor") // 메소드 리턴 객체 주입
	public StringEncryptor stringEncryptor() {
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(System.getenv("DB_PASSWORD"));
        
        config.setAlgorithm("PBEWithMD5AndDES"); // 알고리즘
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        
        System.out.println("=== DBConfig 출력 ===");
        System.out.println(System.getenv("DB_PASSWORD")); //1234
        System.out.println(encryptor.decrypt("GcRK+Ug4SEfL4qMuCeP9BkA1TWWNV0nWEZM9HL3sOT0="));
        System.out.println(encryptor.decrypt("LHDTEKmq2bEVH5GzQKB15LsUAEpS7T35kQqpYoy2BLYn7CFqzWnqmB8xdtVJ4Bgo8NMx+UbYW1KJ1XWiW7bSFgjkw1PHlGWB9Tu2lyq/Tw+NuXuhBOA6AUA7hsPWyenPq//0e2ykdVQ=\r\n"));
        System.out.println(encryptor.decrypt("pwcPG6Hu35Imo6Z7a0bf+T8gRLSQhsVn"));
        System.out.println(encryptor.decrypt("CsxgN8cNx3ehZyG2TshnAYxRgirjYKw0\r\n"));
        return encryptor;
	}
}
