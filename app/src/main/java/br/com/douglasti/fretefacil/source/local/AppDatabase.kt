package br.com.douglasti.fretefacil.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.douglasti.fretefacil.source.local.dao.FuelConstantDao
import br.com.douglasti.fretefacil.source.local.dao.FuelDao
import br.com.douglasti.fretefacil.model.entity.Fuel
import br.com.douglasti.fretefacil.model.entity.FuelConstant

@Database(entities = [Fuel::class, FuelConstant::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun fuelDao(): FuelDao

    abstract fun fuelConstantDao(): FuelConstantDao
}