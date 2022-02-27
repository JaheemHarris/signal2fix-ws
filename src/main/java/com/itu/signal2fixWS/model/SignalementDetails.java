package com.itu.signal2fixWS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "view_signalementdetails")
public class SignalementDetails {
    @Id
    @Column(name="idsignalement")
    private Long idSignalement;

    @Column(name="idtype")
    private Long idType;

    private String type;

    private String couleur;

    @Column(name="idregion")
    private Long idRegion;

    private String region;

    @Column(name="iduser")
    private Long idUser;

    private String nom;

    private String prenom;

    @Column(name="idstatus")
    private Long idStatus;

    private String status;

    private String description;

    @Column(name="datesignalement")
    private Date dateSignalement;

    @Column(name = "heuresignalement")
    private LocalTime heureSignalement;

    private Double latitude;

    private Double longitude;
}
