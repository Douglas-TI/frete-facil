package br.com.douglasti.fretefacil.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.douglasti.fretefacil.model.entity.FuelConstant

@Dao
interface FuelConstantDao {

    @Query("SELECT * FROM fuel_constant")
    fun getAll(): List<FuelConstant>

    @Insert
    fun insertAll(vararg fuelsConstant: FuelConstant)
}