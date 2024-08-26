package models

enum class RaceType {
    HUMAN, DWARF, ELF, HALFLING, GNOME, HALF_ELF, HALF_ORC, TIEFLING
}

data class Race(
    val name: RaceType,
    val baseAttributes: Map<String, Int>
) {
    companion object {
        fun getRace(name: RaceType): Race {
            return when (name) {
                RaceType.HUMAN -> Race(name, mapOf("Força" to 1, "Constituição" to 1, "Destreza" to 1, "Sabedoria" to 1, "Inteligência" to 1, "Carisma" to 1))
                RaceType.DWARF -> Race(name, mapOf("Força" to 0, "Constituição" to 2, "Destreza" to 0, "Sabedoria" to 1, "Inteligência" to 0, "Carisma" to 0))
                RaceType.ELF -> Race(name, mapOf("Força" to 0, "Constituição" to 0, "Destreza" to 2, "Sabedoria" to 0, "Inteligência" to 0, "Carisma" to 0))
                RaceType.HALFLING -> Race(name, mapOf("Força" to 0, "Constituição" to 0, "Destreza" to 2, "Sabedoria" to 0, "Inteligência" to 0, "Carisma" to 0))
                RaceType.GNOME -> Race(name, mapOf("Força" to 0, "Constituição" to 0, "Destreza" to 1, "Sabedoria" to 0, "Inteligência" to 2, "Carisma" to 0))
                RaceType.HALF_ELF -> Race(name, mapOf("Força" to 0, "Constituição" to 0, "Destreza" to 0, "Sabedoria" to 0, "Inteligência" to 0, "Carisma" to 2))
                RaceType.HALF_ORC -> Race(name, mapOf("Força" to 2, "Constituição" to 1, "Destreza" to 0, "Sabedoria" to 0, "Inteligência" to 0, "Carisma" to 0))
                RaceType.TIEFLING -> Race(name, mapOf("Força" to 0, "Constituição" to 0, "Destreza" to 0, "Sabedoria" to 0, "Inteligência" to 1, "Carisma" to 2))

            }
        }
    }
}
