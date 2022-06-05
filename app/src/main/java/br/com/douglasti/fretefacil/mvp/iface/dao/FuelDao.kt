package br.com.douglasti.fretefacil.mvp.iface.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.douglasti.fretefacil.mvp.model.data.entities.Fuel

@Dao
interface FuelDao {

    @Query("SELECT * FROM fuel")
    fun getAll(): List<Fuel>

    @Insert
    fun insertAll(vararg fuels: Fuel)
}