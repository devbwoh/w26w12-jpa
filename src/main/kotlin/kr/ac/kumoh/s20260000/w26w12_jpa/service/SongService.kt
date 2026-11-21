package kr.ac.kumoh.s20260000.w26w12_jpa.service

import kr.ac.kumoh.s20260000.w26w12_jpa.dto.CreateSongRequest
import kr.ac.kumoh.s20260000.w26w12_jpa.dto.SongResponse
import kr.ac.kumoh.s20260000.w26w12_jpa.dto.UpdateSongRequest
import kr.ac.kumoh.s20260000.w26w12_jpa.repository.SongRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional(readOnly = true)
class SongService(
    private val songRepository: SongRepository
) {
    @Transactional
    fun createSong(request: CreateSongRequest): SongResponse {
        val saved = songRepository.save(request.toEntity())
        return SongResponse.from(saved)
    }

    fun getSong(id: UUID): SongResponse {
        val song = songRepository.findById(id)
            ?: throw NoSuchElementException("해당 ID의 곡을 찾을 수 없습니다: $id")
        return SongResponse.from(song)
    }

    fun getAllSongs(): List<SongResponse> =
        songRepository.findAll().map(SongResponse::from)

    @Transactional
    fun updateSong(id: UUID, request: UpdateSongRequest): SongResponse {
        val existing = songRepository.findById(id)
            ?: throw NoSuchElementException("해당 ID의 곡을 찾을 수 없습니다: $id")

        existing.title = request.title
        existing.artist = request.artist
        existing.rating = request.rating
        existing.lyrics = request.lyrics

        return SongResponse.from(songRepository.save(existing))
    }

    @Transactional
    fun deleteSong(id: UUID) {
        if (!songRepository.deleteById(id)) {
            throw NoSuchElementException("삭제할 곡을 찾을 수 없습니다: $id")
        }
    }
}