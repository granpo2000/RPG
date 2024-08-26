package models

data class Character(
    var name: String,
    var race: Race,
    var subRace: SubRace?,
    var characterClass: CharacterClass,
    var attributes: MutableMap<String, Int> = mutableMapOf(
        "Força" to 3,
        "Constituição" to 3,
        "Destreza" to 3,
        "Sabedoria" to 3,
        "Inteligência" to 3,
        "Carisma" to 3
    )
) {
    fun applyBonuses() {
        race.baseAttributes.forEach { (key, value) -> attributes[key] = attributes[key]!! + value }

        subRace?.additionalAttributes?.forEach { (key, value) -> attributes[key] = attributes[key]!! + value }

        characterClass.classAttributes.forEach { (key, value) -> attributes[key] = attributes[key]!! + value }
    }
}
