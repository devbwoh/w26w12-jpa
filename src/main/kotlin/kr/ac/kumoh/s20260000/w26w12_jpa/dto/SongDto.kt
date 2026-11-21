package kr.ac.kumoh.s20260000.w26w12_jpa.dto

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import kr.ac.kumoh.s20260000.w26w12_jpa.domain.Song
import java.time.OffsetDateTime
import java.util.*

@Schema(description = "노래 생성 요청")
data class CreateSongRequest(
    @field:Schema(description = "작성자 ID", example = "550e8400-e29b-41d4-a716-446655440000")
    val userId: UUID,

    @field:NotBlank(message = "제목은 필수입니다.")
    @field:Schema(description = "곡 제목", example = "새벽의 편지")
    val title: String,

    @field:NotBlank(message = "아티스트는 필수입니다.")
    @field:Schema(description = "가수명", example = "서하늘")
    val artist: String,

    @field:Min(1) @field:Max(5)
    @field:Schema(description = "평점 (1~5)", example = "4")
    val rating: Int,

    @field:NotBlank(message = "가사는 필수입니다.")
    @field:Schema(description = "가사 내용", example = "차가운 새벽 공기를 지나 너의 창가에 조용히 이 마음을 띄워 보낼게...")
    val lyrics: String
) {
    fun toEntity() = Song(
        userId = userId,
        title = title,
        artist = artist,
        rating = rating,
        lyrics = lyrics
    )
}

@Schema(description = "노래 수정 요청")
data class UpdateSongRequest(
    @field:NotBlank
    @field:Schema(example = "Midnight Waltz")
    val title: String,

    @field:NotBlank
    @field:Schema(example = "LUNATIC")
    val artist: String,

    @field:Min(1) @field:Max(5)
    @field:Schema(example = "3")
    val rating: Int,

    @field:NotBlank
    @field:Schema(example = "별빛이 쏟아지는 이 밤, 너와 나 단둘이 끝없는 춤을 춰...")
    val lyrics: String
)

@Schema(description = "노래 응답")
data class SongResponse(
    val id: UUID,
    val createdAt: OffsetDateTime,
    val userId: UUID,
    val title: String,
    val artist: String,
    val rating: Int,
    val lyrics: String
) {
    companion object {
        fun from(song: Song) = SongResponse(
            id = song.id,
            createdAt = song.createdAt,
            userId = song.userId,
            title = song.title,
            artist = song.artist,
            rating = song.rating,
            lyrics = song.lyrics
        )
    }
}
