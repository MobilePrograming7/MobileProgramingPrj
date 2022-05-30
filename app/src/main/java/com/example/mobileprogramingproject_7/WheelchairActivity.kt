package com.example.mobileprogramingproject_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileprogramingproject_7.databinding.ActivityMainBinding
import com.example.mobileprogramingproject_7.databinding.ActivityWheelchairBinding

class WheelchairActivity : AppCompatActivity() {
    lateinit var binding: ActivityWheelchairBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWheelchairBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setDataLayout()
        setRecyclerView()
        setOnClick()

    }

    private fun setOnClick() {
        binding.apply {
            startBtn.setOnClickListener {

            }

            favBtn.setOnClickListener {
                TODO("즐겨찾기구현필요")

            }

            arriveBtn.setOnClickListener {

            }
        }
    }

    private fun setRecyclerView() {
        //리뷰 Data Class 가져와서 리사이클러뷰 초기화해야함
        val recyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //리뷰 디비 구현하기 - 센터명 같은 데이터로 리스트 넘김
        val reviews = ArrayList<DataReview>()
        reviews.add(DataReview("사용자이름1", "리뷰내용", "센터"))
        reviews.add(DataReview("사용자이름2", "리뷰내용", "센터"))
        reviews.add(DataReview("사용자이름3", "리뷰내용", "센터"))

        val adapter = RevAdapter(reviews)
        recyclerView.adapter = adapter

    }

    private fun setDataLayout() {
        //인텐트로 DataWheelchair객체 넘김
//        val data = intent.getSerializableExtra("wheelchair") as DataWheelchair

        //테스트용객체
        val manager = DataManager()
        Thread.sleep(3000L)
        val data = manager.wheelchair[0]

        binding.apply {
            TitleView.text = data.fcltyNm
            AddrView.text = data.rdnmadr
            PhoneView.text = data.institutionPhoneNumber
            instlView.text =  data.instlLcDesc

            var timestr = "평  일 "+data.weekdayOperOpenHhmm+" ~ "+data.weekdayOperColseHhmm+"\n"
            timestr+="토요일 "+data.satOperOperOpenHhmm+" ~ "+data.satOperCloseHhmm+"\n"
            timestr+="공휴일 "+data.holidayOperOpenHhmm+" ~ "+data.holidayCloseOpenHhmm

            timeView.text = timestr
        }

    }




}