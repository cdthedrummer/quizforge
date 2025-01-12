package com.goalforge.domain.model

enum class Attribute {
    STRENGTH,
    DEXTERITY,
    CONSTITUTION,
    INTELLIGENCE,
    WISDOM,
    CHARISMA;

    companion object {
        fun getDescription(attribute: Attribute): String = when (attribute) {
            STRENGTH -> "Raw physical power. Activities that demand muscle and force."
            DEXTERITY -> "Finesse and coordination. Tasks requiring quick reflexes and agile movements."
            CONSTITUTION -> "Body's durability and stamina. Crucial for enduring physical exertion."
            INTELLIGENCE -> "Cognitive abilities. Capacity for learning and problem-solving."
            WISDOM -> "Insight and perception. Improving intuition and awareness."
            CHARISMA -> "Personal allure and social skills. Ability to influence and connect."
        }
    }
}