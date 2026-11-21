package kr.ac.kumoh.s20260000.w26w12_jpa.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import kr.ac.kumoh.s20260000.w26w12_jpa.dto.CreateSongRequest
import kr.ac.kumoh.s20260000.w26w12_jpa.dto.SongResponse
import kr.ac.kumoh.s20260000.w26w12_jpa.dto.UpdateSongRequest
import kr.ac.kumoh.s20260000.w26w12_jpa.service.SongService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@Tag(name = "Songs", description = "노래 관리 API")
@RestController
@RequestMapping("/api/v1/songs")
class SongController(
    private val songService: SongService
) {
    @Operation(summary = "노래 등록")
    @PostMapping
    fun createSong(
        @Valid @RequestBody request: CreateSongRequest
    ): ResponseEntity<SongResponse> =
        ResponseEntity.status(HttpStatus.CREATED).body(songService.createSong(request))

    @Operation(summary = "노래 조회")
    @GetMapping("/{id}")
    fun getSong(@PathVariable id: UUID): ResponseEntity<SongResponse> =
        ResponseEntity.ok(songService.getSong(id))

    @Operation(summary = "전체 조회")
    @GetMapping
    fun getAllSongs(): ResponseEntity<List<SongResponse>> =
        ResponseEntity.ok(songService.getAllSongs())

    @Operation(summary = "노래 수정")
    @PutMapping("/{id}")
    fun updateSong(
        @PathVariable id: UUID,
        @Valid @RequestBody request: UpdateSongRequest
    ): ResponseEntity<SongResponse> =
        ResponseEntity.ok(songService.updateSong(id, request))

    @Operation(summary = "노래 삭제")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteSong(@PathVariable id: UUID) {
        songService.deleteSong(id)
    }
}