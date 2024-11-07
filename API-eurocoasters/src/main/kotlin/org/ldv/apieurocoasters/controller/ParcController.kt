package org.ldv.apieurocoasters.controller

import org.ldv.apieurocoasters.DAO.ParcDAO
import org.ldv.apieurocoasters.model.entity.Parc
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/parcs")
class ParcController(val parcDAO:ParcDAO) {

    @GetMapping
    fun getAllParcs(): List<Parc> = parcDAO.findAll()

    @GetMapping("/{id}")
    fun getParcById(@PathVariable id: Long): Optional<Parc> = parcDAO.findById(id)

}