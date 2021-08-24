package br.com.helsonsant.mercadomoeda.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "service")
public class ServiceConfiguration {
	private final ApplicationInfo applicationInfo = new ApplicationInfo();

	@Data
	public static class ApplicationInfo {
		private final Contact contact = new Contact();
		private String title;
		private String description;
		private String version;

		@Data
		public static class Contact {
			private String name;
			private String email;
			private String url;
		}
	}
}
