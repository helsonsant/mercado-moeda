package br.com.helsonsant.mercadomoeda.outbound;

import br.com.helsonsant.mercadomoeda.domain.Taxa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TaxaH2Repository extends JpaRepository<Taxa, String> {
}
