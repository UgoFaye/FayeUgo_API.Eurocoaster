package org.ldv.apieurocoasters.controller

import org.ldv.apieurocoasters.DAO.PaysDAO
import org.ldv.apieurocoasters.model.entity.Pays
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping


class PaysController(val paysDao: PaysDAO) {

    @GetMapping("/pays")
    fun getAllPays(): List<Pays> = paysDao.findAll()

    @GetMapping("/pays/{id}")
    fun getPaysById(@PathVariable id: Long): Optional<Pays> = paysDao.findById(id)
}