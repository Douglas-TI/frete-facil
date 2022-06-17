package br.com.douglasti.fretefacil.data.model.entity.vehicle

data class Vehicle(val brand: String,
                   val model: String,
                   val fuels: List<Fuel>,
                   val maitenances: List<Maitenance>)
