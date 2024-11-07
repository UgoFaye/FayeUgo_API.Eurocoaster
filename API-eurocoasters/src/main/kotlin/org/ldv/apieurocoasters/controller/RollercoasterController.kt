package org.ldv.apieurocoasters.controller

import org.ldv.apieurocoasters.DAO.RollercoasterDAO
import org.ldv.apieurocoasters.model.DTO.CompositionDTO
import org.ldv.apieurocoasters.model.DTO.RollercoasterDTO
import org.ldv.apieurocoasters.model.entity.Rollercoaster
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping
class RollercoasterController(val rollercoasterDAO: RollercoasterDAO) {

    @GetMapping("/rollercoasters")
    fun getAllPays(): List<Rollercoaster> = rollercoasterDAO.findAll()

    @GetMapping("/rollercoasters/{id}")
    fun getRollercoasterById(@PathVariable id: Long): ResponseEntity<RollercoasterDTO> {

        val rollercoaster = rollercoasterDAO.findById(id).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Rollercoaster non trouvé")
        }

        val compositionDTOs = mutableListOf<CompositionDTO>()
        for (composition in rollercoaster.compositions) {
            val compositionDTO = CompositionDTO(
                elementNom = composition.element.nom,
                nombre = composition.nombre
            )
            compositionDTOs.add(compositionDTO)
        }

        val rollercoasterDTO = RollercoasterDTO(
            nom = rollercoaster.nom,
            structure = rollercoaster.structure,
            type = rollercoaster.type,
            dateOuverture = rollercoaster.dateOuverture,
            hauteur = rollercoaster.hauteur,
            constructeur = rollercoaster.constructeur,
            parc = rollercoaster.parc,
            compositions = compositionDTOs
        )
        return ResponseEntity.ok(rollercoasterDTO)
    }




}