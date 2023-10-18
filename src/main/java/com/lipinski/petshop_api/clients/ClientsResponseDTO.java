package com.lipinski.petshop_api.clients;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ClientsResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String dog_name;
    private String breed;
    private String color;

    public ClientsResponseDTO(Clients clients) {
        id = clients.getId();
        name = clients.getName();
        dog_name = clients.getDog_name();
        breed = clients.getBreed();
        color = clients.getColor();

    }
}
