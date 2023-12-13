package com.example.practicafinal

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UniversityAdapter(private val context: Context) : RecyclerView.Adapter<UniversityAdapter.ViewHolder>() {

    private var universities: List<University> = emptyList()

    fun setData(newData: List<University>) {
        universities = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_university, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val university = universities[position]

        holder.nameTextView.text = university.name
        holder.countryTextView.text = university.country

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("university", university)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return universities.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val countryTextView: TextView = itemView.findViewById(R.id.countryTextView)

    }
}
