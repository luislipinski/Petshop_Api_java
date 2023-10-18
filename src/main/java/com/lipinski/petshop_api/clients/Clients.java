package com.lipinski.petshop_api.clients;

import lombok.*;

import javax.persistence.*;

@Table(name = "clients")
@Entity(name = "clients")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Clients {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dog_name;
    private String breed;
    private String color;

    public Clients(ClientsRequestDTO clients) {
        this.name = clients.getName();
        this.dog_name = clients.getDog_name();
        this.breed = clients.getBreed();
        this.color = clients.getColor();
    }

}
