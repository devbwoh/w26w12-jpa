package kr.ac.kumoh.s20260000.w26w12_jpa.repository

import kr.ac.kumoh.s20260000.w26w12_jpa.domain.Song
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Repository
import java.util.*
import java.util.concurrent.ConcurrentHashMap

@Repository
@Profile("memory")
class MemorySongRepository : SongRepository {
    private val store = ConcurrentHashMap<UUID, Song>()

    override fun save(song: Song): Song {
        store[song.id] = song
        return song
    }

    override fun findById(id: UUID): Song? = store[id]

    override fun findAll(): List<Song> =
        store.values.sortedByDescending { it.createdAt }

    override fun findAllByUserId(userId: UUID): List<Song> =
        store.values
            .filter { it.userId == userId }
            .sortedByDescending { it.createdAt }

    override fun deleteById(id: UUID): Boolean = store.remove(id) != null
}