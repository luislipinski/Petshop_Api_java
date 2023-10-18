package com.lipinski.petshop_api.clients;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientsRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private  Long id;
    private String name;
    private String dog_name;
    private String breed;
    private String color;

//    public ClientsRequestDTO(Clients clients) {
//        name = clients.getName();
//        dog_name = clients.getDog_name();
//        breed = clients.getBreed();
//        color = clients.getColor();
//
//    }

    public ClientsRequestDTO(Clients clients) {
        id = clients.getId();
        name = clients.getName();
        dog_name = clients.getDog_name();
        breed = clients.getBreed();
        color = clients.getColor();
    }
}
