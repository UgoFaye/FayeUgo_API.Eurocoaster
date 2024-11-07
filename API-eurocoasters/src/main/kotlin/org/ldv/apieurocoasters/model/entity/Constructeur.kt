package org.ldv.apieurocoasters.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "constructeurs")

class Constructeur(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val constructeurId: Long,
    val nom: String,
    val adresse: String?,
    val urlSiteWeb: String?,
    val urlFacebook: String?,
    val urlInstagram: String?,
    val urlLinkedIn: String?,
    val dateCreation: Int?,

    @ManyToOne
    @JoinColumn(name = "fk_ville_id")
    val ville : Ville?

){
}