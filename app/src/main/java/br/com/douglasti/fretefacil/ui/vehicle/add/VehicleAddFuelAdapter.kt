package br.com.douglasti.fretefacil.ui.vehicle.add

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.douglasti.fretefacil.databinding.FuelBodyBinding
import br.com.douglasti.fretefacil.data.model.entity.vehicle.Fuel

@SuppressLint("NotifyDataSetChanged")
class VehicleAddFuelAdapter(val presenter: IVehicleAddContract.Presenter): RecyclerView.Adapter<VehicleAddFuelAdapter.MyViewHolder>() {

    private var fuels:MutableList<Fuel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val bind = FuelBodyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(bind, presenter)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val dto = fuels[position]
        holder.bind(dto)
    }

    override fun getItemCount(): Int = fuels.size

    fun getList(): MutableList<Fuel> = fuels

    fun addFuel(fuel: Fuel) {
        fuels.add(fuel)
        notifyDataSetChanged()
    }

    fun updateList(fuels:MutableList<Fuel>){
        this.fuels = fuels
        notifyDataSetChanged()
    }

    class MyViewHolder(private val bind: FuelBodyBinding, private val presenter: IVehicleAddContract.Presenter) : RecyclerView.ViewHolder(bind.root) {

        fun bind(dto: Fuel) {
            populateBody(dto)
        }

        private fun populateBody(dto: Fuel) {
            bind.tvType.text = dto.type
            bind.tvKml.text = dto.kml.toString()
        }
    }
}