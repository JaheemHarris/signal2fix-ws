package com.itu.signal2fixWS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="imagesignalement")
public class ImageSignalement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="idsignalement")
    private Long idSignalement;

    @Column(name="imageurl")
    private String imageUrl;

    @Column(name="imagename")
    private String imageName;

    @Column(name="imagetype")
    private String imageType;
}
