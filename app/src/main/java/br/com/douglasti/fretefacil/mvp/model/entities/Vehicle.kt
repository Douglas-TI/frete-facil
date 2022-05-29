package br.com.douglasti.fretefacil.mvp.model.entities

data class Vehicle(val brand: String,
                   val model: String,
                   val kml: String,
                   val maitenanceCost: Double,
                   val maitenanceCostMonths: Int)
