package org.ldv.apieurocoasters.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name="parcs")

class Parc(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val parcId: Long,
    var nom: String,
    val dateOuverture: Int?,
    var superficie: Int?,

    @ManyToOne
    @JoinColumn(name = "fk_ville_id")
    val ville: Ville?
) {
}