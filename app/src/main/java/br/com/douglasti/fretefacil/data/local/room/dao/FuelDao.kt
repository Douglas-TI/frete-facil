package br.com.douglasti.fretefacil.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.douglasti.fretefacil.data.model.entity.vehicle.Fuel

@Dao
interface FuelDao {

    @Query("SELECT * FROM fuel")
    fun getAll(): List<Fuel>

    @Insert
    fun insertAll(vararg fuels: Fuel)
}