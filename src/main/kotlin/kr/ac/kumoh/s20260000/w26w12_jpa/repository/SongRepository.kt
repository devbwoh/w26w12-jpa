package kr.ac.kumoh.s20260000.w26w12_jpa.repository

import kr.ac.kumoh.s20260000.w26w12_jpa.domain.Song
import java.util.*

interface SongRepository {
    fun save(song: Song): Song
    fun findById(id: UUID): Song?
    fun findAll(): List<Song>
    fun findAllByUserId(userId: UUID): List<Song>
    fun deleteById(id: UUID): Boolean
}