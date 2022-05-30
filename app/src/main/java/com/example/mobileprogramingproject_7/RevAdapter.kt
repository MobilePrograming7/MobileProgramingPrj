package com.example.mobileprogramingproject_7

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.mobileprogramingproject_7.databinding.ActivityWheelchairBinding
import com.example.mobileprogramingproject_7.databinding.RevRowBinding


class RevAdapter(
    val reviews : ArrayList<DataReview>
) : RecyclerView.Adapter<RevAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            RevRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = reviews[position].userID
        holder.review.text = reviews[position].review
    }

    override fun getItemCount(): Int = reviews.size

    inner class ViewHolder(val binding: RevRowBinding) : RecyclerView.ViewHolder(binding.root) {
        val id = binding.revId
        val review = binding.revStr
    }

}
