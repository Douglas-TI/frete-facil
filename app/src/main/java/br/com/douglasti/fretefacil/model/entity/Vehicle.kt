package br.com.douglasti.fretefacil.model.entity

data class Vehicle(val brand: String,
                   val model: String,
                   val fuels: List<Fuel>,
                   val maitenances: List<Maitenance>)
