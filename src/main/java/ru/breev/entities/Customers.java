package ru.breev.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customers")
public class Customers implements Serializable {
    private static final long serialVersionUID = -2750973356670718107L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fio")
    private String fio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String title) {
        this.fio = title;
    }

    public Customers() {
    }

    public Customers(String fio) {
        this.fio = fio;
    }

    @Override
    public String toString() {
        return String.format("Customers [id = %d, fio = %s]", id, fio);
    }
}

