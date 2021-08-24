package br.com.helsonsant.mercadomoeda.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "taxa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Taxa {
    @Id
    @Column(name = "segmento", nullable = false)
    private String segmento;
    @Column(name = "taxa", nullable = false)
    private double taxa;
}
