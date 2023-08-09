package com.undeniabledreams.togather_again.main.dto

import java.util.*

class ParentDto {
    var userId: String = ""
        private set
    var firstName: String = ""
        private set
    var middleName: String = ""
        private set
    var familyName: String = ""
        private set
    var parentAge: Int = 0
        private set
    var lastInteractionDate: Date = Date()
        private set
    var totalInteractionTime: Int = 0
        private set
    var relationship: String = ""
        private set
    var notes: String = ""
        private set

    constructor(firstName: String, middleName: String, familyName: String, parentAge: Int, lastInteractionDate: Date, totalInteractionTime: Int, relationship: String, notes: String, ) {
        this.firstName = firstName
        this.middleName = middleName
        this.familyName = familyName
        this.parentAge = parentAge
        this.lastInteractionDate = lastInteractionDate
        this.totalInteractionTime = totalInteractionTime
        this.relationship = relationship
        this.notes = notes
    }
}

