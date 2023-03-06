package week_project_4.wp4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import week_project_4.wp4.entities.StatoDispositivo;
import week_project_4.wp4.entities.Dispositivo;
import week_project_4.wp4.entities.TipoDispositivo;

@Configuration
public class DispositivoConfig {

	@Bean
	@Scope("prototype")
	public Dispositivo dispositivo(TipoDispositivo tp, StatoDispositivo disp) {
		Dispositivo dispositivo = Dispositivo.builder()
				.tipo(tp)
				.disp(disp)
				.build();
		return dispositivo;
	}
}
