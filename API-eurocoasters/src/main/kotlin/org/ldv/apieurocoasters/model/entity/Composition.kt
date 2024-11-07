package org.ldv.apieurocoasters.model.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.MapsId
import jakarta.persistence.Table
import org.ldv.apieurocoasters.model.id.CompositionId

@Entity
@Table(name = "compositions")
class Composition(
    @EmbeddedId
    val id: CompositionId,

    @ManyToOne
    @MapsId("rollercoasterId")
    @JoinColumn(name = "fk_rollercoaster_id")
    @JsonBackReference
    val rollercoaster: Rollercoaster,

    @ManyToOne
    @MapsId("elementId")
    @JoinColumn(name= "fk_element_id")
    @JsonBackReference
    val element: Element,

    val nombre: Int
) {
}