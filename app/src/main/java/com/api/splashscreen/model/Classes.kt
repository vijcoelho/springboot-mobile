package com.api.splashscreen.model

class Classes {

    private var id: Int? = null
    private var className: String = ""
    private var professorName: String = ""

    fun getId(): Int? {
        return this.id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getClassName(): String {
        return this.className
    }

    fun setClassName(className: String) {
        this.className = className
    }

    fun getProfessorName(): String {
        return this.professorName
    }

    fun setProfessorName(professorName: String) {
        this.professorName = professorName
    }
}