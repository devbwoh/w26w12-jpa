package kr.ac.kumoh.s20260000.w26w12_jpa.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.OffsetDateTime
import java.util.*

@Entity
@Table(name = "songs")
class Song(
    @Id
    val id: UUID = UUID.randomUUID(),
    val createdAt: OffsetDateTime = OffsetDateTime.now(),
    val userId: UUID,
    var title: String,
    var artist: String,
    var rating: Int,

    @Column(columnDefinition = "TEXT")
    var lyrics: String
)