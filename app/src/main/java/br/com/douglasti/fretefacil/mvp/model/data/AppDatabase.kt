package br.com.douglasti.fretefacil.mvp.model.data

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.douglasti.fretefacil.mvp.iface.dao.FuelConstantDao
import br.com.douglasti.fretefacil.mvp.iface.dao.FuelDao
import br.com.douglasti.fretefacil.mvp.model.data.entities.Fuel
import br.com.douglasti.fretefacil.mvp.model.data.entities.FuelConstant

@Database(entities = [Fuel::class, FuelConstant::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun fuelDao(): FuelDao

    abstract fun fuelConstantDao(): FuelConstantDao
}