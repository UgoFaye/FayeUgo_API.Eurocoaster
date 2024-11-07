package org.ldv.apieurocoasters.DAO

import org.ldv.apieurocoasters.model.entity.Rollercoaster
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository

interface RollercoasterDAO: JpaRepository<Rollercoaster, Long> {
}
