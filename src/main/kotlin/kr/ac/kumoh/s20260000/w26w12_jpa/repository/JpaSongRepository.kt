package kr.ac.kumoh.s20260000.w26w12_jpa.repository

import kr.ac.kumoh.s20260000.w26w12_jpa.domain.Song
import org.springframework.context.annotation.Profile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

interface SpringDataSongRepository : JpaRepository<Song, UUID> {
    fun findAllByOrderByCreatedAtDesc(): List<Song>
    fun findAllByUserIdOrderByCreatedAtDesc(userId: UUID): List<Song>
}

@Repository
@Profile("h2", "supabase")
class JpaSongRepository(
    private val jpaRepository: SpringDataSongRepository
) : SongRepository {

    override fun save(song: Song): Song =
        jpaRepository.save(song)

    override fun findById(id: UUID): Song? =
        jpaRepository.findById(id).orElse(null)

    override fun findAll(): List<Song> =
        jpaRepository.findAllByOrderByCreatedAtDesc()

    override fun findAllByUserId(userId: UUID): List<Song> =
        jpaRepository.findAllByUserIdOrderByCreatedAtDesc(userId)

    override fun deleteById(id: UUID): Boolean {
        if (!jpaRepository.existsById(id)) return false
        jpaRepository.deleteById(id)
        return true
    }
}