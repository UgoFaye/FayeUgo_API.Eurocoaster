package org.ldv.apieurocoasters.controller

import org.ldv.apieurocoasters.DAO.ConstructeurDAO
import org.ldv.apieurocoasters.model.entity.Constructeur
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping


class ConstructeurController(val constructeurDAO: ConstructeurDAO) {

    @GetMapping("/constructeurs")
    fun getAllPays(): List<Constructeur> = constructeurDAO.findAll()

    @GetMapping("/constructeurs/{id}")
    fun getConstructeurById(@PathVariable id: Long): Optional<Constructeur> = constructeurDAO.findById(id)
}