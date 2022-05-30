package com.example.mobileprogramingproject_7

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.example.mobileprogramingproject_7.databinding.FavRowBinding


class FavAdapter(val favs : ArrayList<String>) : RecyclerView.Adapter<FavAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FavRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    //클릭시 해당 기관 정보 POPUP 띄우기 > onclick구현
    //fav 디비에서 centerName 검색 > centerType 가져와서 해당 타입 디비에서 다시 검색 > centerData 객체 인텐트로 넘기기 & 팝업

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = favs[position]
    }

    override fun getItemCount(): Int = favs.size

    inner class ViewHolder(val binding: FavRowBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.favName
    }

}
