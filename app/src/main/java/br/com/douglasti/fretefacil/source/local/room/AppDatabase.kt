package br.com.douglasti.fretefacil.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.douglasti.fretefacil.source.local.room.dao.FuelConstantDao
import br.com.douglasti.fretefacil.source.local.room.dao.FuelDao
import br.com.douglasti.fretefacil.model.entity.vehicle.Fuel
import br.com.douglasti.fretefacil.model.entity.vehicle.FuelConstant

@Database(entities = [Fuel::class, FuelConstant::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun fuelDao(): FuelDao

    abstract fun fuelConstantDao(): FuelConstantDao
}