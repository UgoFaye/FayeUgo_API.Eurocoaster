package org.ldv.apieurocoasters.model.entity

import jakarta.persistence.*

@Entity
@Table(name= "rollercoasters")

class Rollercoaster(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val rollercoasterId: Long,

    val nom: String,
    val structure: String?,
    val type: String?,
    val dateOuverture: Int,
    val hauteur: Float?,

    @ManyToOne
    @JoinColumn(name = "fk_constructeur_id")
    val constructeur: Constructeur?,

    @ManyToOne
    @JoinColumn(name = "fk_parc_id")
    val parc: Parc?,

    @OneToMany(mappedBy = "rollercoaster")
    val compositions: List<Composition> = emptyList()
){
}