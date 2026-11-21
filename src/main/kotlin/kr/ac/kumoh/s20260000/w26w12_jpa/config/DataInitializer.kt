package kr.ac.kumoh.s20260000.w26w12_jpa.config

import kr.ac.kumoh.s20260000.w26w12_jpa.domain.Song
import kr.ac.kumoh.s20260000.w26w12_jpa.repository.SongRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import java.util.*

@Configuration
@Profile("memory", "h2")
class DataInitializer {

    @Bean
    fun initData(songRepository: SongRepository) = ApplicationRunner {
        if (songRepository.findAll().isNotEmpty()) return@ApplicationRunner

        val sampleUserId = UUID.fromString("550e8400-e29b-41d4-a716-446655440000")

        val initialSongs = listOf(
            Song(
                userId = sampleUserId,
                title = "네온 골목의 고백",
                artist = "달빛유나",
                rating = 5,
                lyrics = "저녁 공기 속에 번지는 너의 이름, 네온 불빛 사이로 마음이 흔들려. 우연처럼 스쳐 간 약속들, 끝내는 내일의 문을 열어 줘."
            ),
            Song(
                userId = sampleUserId,
                title = "비 오는 날의 너",
                artist = "서늘한봄",
                rating = 4,
                lyrics = "떨어지는 빗방울 사이로 너의 웃음이 번져. 젖은 어깨에 남은 온기, 다시 걸을 용기를 줘."
            ),
            Song(
                userId = sampleUserId,
                title = "별빛을 접어",
                artist = "하늘다정",
                rating = 5,
                lyrics = "밤하늘을 천천히 접어 주머니에 넣으면, 너에게 닿을 듯해. 흔들리는 마음도 너로 인해 제자릴 찾아."
            ),
            Song(
                userId = sampleUserId,
                title = "첫눈의 약속",
                artist = "이브닝레인",
                rating = 4,
                lyrics = "첫눈이 내려도 나는 멈추지 않아, 너를 향한 길은 선명해. 작은 떨림이 큰 용기가 돼."
            ),
            Song(
                userId = sampleUserId,
                title = "마음에 새긴 라인",
                artist = "유리정원",
                rating = 3,
                lyrics = "종이 위에 번진 글자들처럼, 너를 떠올릴수록 선이 선명해져. 지워도 남는 건 너의 빛."
            ),
            Song(
                userId = sampleUserId,
                title = "바람의 편지",
                artist = "포근한시우",
                rating = 5,
                lyrics = "바람이 건네는 편지 속에 너의 목소리 담겨 있어. 읽을 때마다 하루가 새로워져."
            ),
            Song(
                userId = sampleUserId,
                title = "달빛에 젖은 계단",
                artist = "밤산책",
                rating = 4,
                lyrics = "한 걸음, 한 숨에 너를 더 가까이. 달빛에 젖은 계단을 오르면 마음이 깨어."
            ),
            Song(
                userId = sampleUserId,
                title = "봄비 속의 너울",
                artist = "봄노트",
                rating = 4,
                lyrics = "봄비가 속삭여, 잊지 말라고. 젖은 길 위로 웃음이 번져가."
            ),
            Song(
                userId = sampleUserId,
                title = "커튼콜의 심장",
                artist = "무대빛나래",
                rating = 5,
                lyrics = "오늘도 무대의 문이 열리면, 내 심장은 먼저 뛰어. 관객이 사라져도 너는 남아."
            ),
            Song(
                userId = sampleUserId,
                title = "파도처럼 번져",
                artist = "해안선율",
                rating = 3,
                lyrics = "너의 한마디가 파도처럼 번져 와. 나는 그 소리에 맞춰 천천히 변해."
            ),
            Song(
                userId = sampleUserId,
                title = "흔들리는 향기",
                artist = "라벤더문",
                rating = 4,
                lyrics = "손끝에 남은 향기가 자꾸만 너를 부르고, 어제의 거리도 오늘의 노래가 돼."
            ),
            Song(
                userId = sampleUserId,
                title = "구름 위의 통화",
                artist = "하루의주파수",
                rating = 5,
                lyrics = "신호가 닿지 않아도 들려, 너의 목소리. 구름 위로 올라가면 마음이 더 환해."
            ),
            Song(
                userId = sampleUserId,
                title = "살짝 웃는 겨울",
                artist = "화이트스노우",
                rating = 4,
                lyrics = "겨울이 와도 마음은 따뜻해져. 너의 웃음이 내 안을 밝혀."
            ),
            Song(
                userId = sampleUserId,
                title = "마지막 페이지의 너",
                artist = "책갈피별",
                rating = 5,
                lyrics = "끝내는 너를 붙잡고 싶어서, 마지막 페이지를 천천히 넘겨. 다음 장은 우리가 만들 거야."
            ),
            Song(
                userId = sampleUserId,
                title = "전봇대 사이로",
                artist = "시내야경",
                rating = 3,
                lyrics = "전봇대 사이로 스치는 빛들이 눈을 감겨. 그 틈에 너의 이름이 살아."
            ),
            Song(
                userId = sampleUserId,
                title = "초록빛 꿈",
                artist = "숲속엔딩",
                rating = 4,
                lyrics = "초록빛 꿈을 펼치면 걱정은 멀어져. 너와 걷는 길은 언제나 새로워."
            ),
            Song(
                userId = sampleUserId,
                title = "손바닥의 별가루",
                artist = "별가루공방",
                rating = 5,
                lyrics = "손바닥에 모은 별가루가 반짝일 때, 너의 마음도 같이 빛나. 오늘은 더 용감해."
            ),
            Song(
                userId = sampleUserId,
                title = "도시의 작은 리듬",
                artist = "리듬골목",
                rating = 4,
                lyrics = "차가운 바람에도 박자는 따뜻해. 도시의 작은 리듬 속에서 너를 만져."
            ),
            Song(
                userId = sampleUserId,
                title = "숨이 닿는 거리",
                artist = "한밤의온도",
                rating = 3,
                lyrics = "숨이 닿는 거리만큼 가까워질 때, 말이 아니라 마음이 먼저 전해져. 오늘은 네가 웃어 줘."
            ),
            Song(
                userId = sampleUserId,
                title = "우리만의 새벽",
                artist = "새벽버스킹",
                rating = 5,
                lyrics = "새벽이 오면 우리는 더 선명해져. 아직 못한 말도 노래로 바꿔, 내일을 같이 비춰줘."
            )
        )

        initialSongs.forEach { songRepository.save(it) }
    }
}