package br.com.douglasti.fretefacil.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.douglasti.fretefacil.model.entity.Fuel

@Dao
interface FuelDao {

    @Query("SELECT * FROM fuel")
    fun getAll(): List<Fuel>

    @Insert
    fun insertAll(vararg fuels: Fuel)
}