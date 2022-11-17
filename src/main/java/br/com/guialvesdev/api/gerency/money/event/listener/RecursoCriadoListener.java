package br.com.guialvesdev.api.gerency.money.event.listener;

import br.com.guialvesdev.api.gerency.money.event.RecursoCriadoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {


    @Override
    public void onApplicationEvent(RecursoCriadoEvent event) {
        HttpServletResponse response = RecursoCriadoEvent.getResponse();
        Long codigo = RecursoCriadoEvent.getCodigo();

        adicionarHeaderLocation(response, codigo);

    }

    private void adicionarHeaderLocation(HttpServletResponse response, Long codigo){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(codigo).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }




}
