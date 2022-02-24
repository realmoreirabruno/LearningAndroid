package com.example.appmentoria.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appmentoria.R
import com.example.appmentoria.model.ToDo

class ItemAdapter(
    private val context: Context, //TODO: Verificar se essa variável é necessária
    private val dataset: List<ToDo>
): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    inner class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.text)
        //Faltou colocar a variável para pegar a view do checkbox
        val cbDone: CheckBox = view.findViewById(R.id.checkbox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_items, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = item.name
        //Colocamos a variável para refletir o valor do done
        holder.cbDone.isChecked = item.done
    }

    override fun getItemCount() = dataset.size
}