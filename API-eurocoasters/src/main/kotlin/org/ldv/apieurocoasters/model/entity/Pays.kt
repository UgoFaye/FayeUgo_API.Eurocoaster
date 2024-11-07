package org.ldv.apieurocoasters.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Table
import jakarta.persistence.Id

@Entity
@Table(name = "pays")

class Pays(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val paysId: Long,
    val nom: String

) {

}