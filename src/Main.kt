import models.*
import utils.InputUtils

fun main() {
    println("Bem-vindo ao Criador de Personagens de RPG!")

    val name = InputUtils.promptUser("Digite o nome do seu personagem")

    val raceOptions = RaceType.values().joinToString { it.name }
    val raceChoice = InputUtils.promptUser("Escolha uma raça dentre as seguintes opções: $raceOptions").uppercase()
    val race = Race.getRace(RaceType.valueOf(raceChoice))

    val subRace: SubRace? = when (race.name) {
        RaceType.DWARF -> {
            val subRaceOptions = listOf(SubRaceType.HILL_DWARF.name, SubRaceType.MOUNTAIN_DWARF.name).joinToString()
            val subRaceChoice = InputUtils.promptUser("Escolha uma sub-raça dentre as seguintes opções: $subRaceOptions").uppercase()
            SubRace.getSubRace(SubRaceType.valueOf(subRaceChoice))
        }
        RaceType.ELF -> {
            val subRaceOptions = listOf(SubRaceType.HIGH_ELF.name, SubRaceType.WOOD_ELF.name, SubRaceType.DARK_ELF.name).joinToString()
            val subRaceChoice = InputUtils.promptUser("Escolha uma sub-raça dentre as seguintes opções: $subRaceOptions").uppercase()
            SubRace.getSubRace(SubRaceType.valueOf(subRaceChoice))
        }
        RaceType.HALFLING -> {
            val subRaceOptions = listOf(SubRaceType.LIGHTFOOT_HALFLING.name, SubRaceType.STOUT_HALFLING.name).joinToString()
            val subRaceChoice = InputUtils.promptUser("Escolha uma sub-raça dentre as seguintes opções: $subRaceOptions").uppercase()
            SubRace.getSubRace(SubRaceType.valueOf(subRaceChoice))
        }
        RaceType.GNOME -> {
            val subRaceOptions = listOf(SubRaceType.FOREST_GNOME.name, SubRaceType.ROCK_GNOME.name).joinToString()
            val subRaceChoice = InputUtils.promptUser("Escolha uma sub-raça dentre as seguintes opções: $subRaceOptions").uppercase()
            SubRace.getSubRace(SubRaceType.valueOf(subRaceChoice))
        }
        else -> null
    }

    val classOptions = ClassType.values().joinToString { it.name }
    val classChoice = InputUtils.promptUser("Escolha uma classe dentre as seguintes opções: $classOptions").uppercase()
    val characterClass = CharacterClass.getCharacterClass(ClassType.valueOf(classChoice))

    val character = Character(name, race, subRace, characterClass)
    character.applyBonuses()

    println("Você tem 6 pontos para distribuir entre seus atributos.")
    var pointsLeft = 6
    while (pointsLeft > 0) {
        println("Atributos atuais: ${character.attributes}")
        val attributeChoice = InputUtils.promptUser("Qual atributo você gostaria de aumentar? (Força, Constituição, Destreza, Sabedoria, Inteligência, Carisma)").capitalize()
        if (character.attributes.containsKey(attributeChoice)) {
            val pointsToAdd = InputUtils.promptUserForInt("Quantos pontos você gostaria de adicionar? (Pontos restantes: $pointsLeft)")
            if (pointsToAdd in 1..pointsLeft) {
                character.attributes[attributeChoice] = character.attributes[attributeChoice]!! + pointsToAdd
                pointsLeft -= pointsToAdd
            } else {
                println("Número de pontos inválido.")
            }
        } else {
            println("Escolha de atributo inválida.")
        }
    }

    val description = InputUtils.promptUser("Digite uma descrição do seu personagem")

    println("\nCriação de Personagem Completa! Aqui estão os detalhes do seu personagem:")
    println("Nome: ${character.name}")
    println("Raça: ${character.race.name}")
    subRace?.let { println("Sub-Raça: ${it.name}") }
    println("Classe: ${character.characterClass.name}")
    println("Atributos: ${character.attributes}")
    println("Descrição: $description")
}
