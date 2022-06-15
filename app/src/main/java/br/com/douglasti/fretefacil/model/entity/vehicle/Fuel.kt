package br.com.douglasti.fretefacil.model.entity.vehicle

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fuel")
data class Fuel(@PrimaryKey(autoGenerate = true) val id: Int,
                val type: String,
                val kml: Double) {

    constructor(type: String, kml: Double) : this(0, type, kml)
}