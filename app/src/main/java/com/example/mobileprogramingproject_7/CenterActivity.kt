package com.example.mobileprogramingproject_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileprogramingproject_7.databinding.ActivityCenterBinding
import com.example.mobileprogramingproject_7.databinding.ActivityWheelchairBinding

class CenterActivity : AppCompatActivity() {
    lateinit var binding : ActivityCenterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCenterBinding.inflate(layoutInflater)
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


            }

            arriveBtn.setOnClickListener {

            }
        }
    }

    private fun setRecyclerView() {
        //리뷰 Data Class 가져와서 리사이클러뷰 초기화해야함
        val recyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //리뷰 디비 구현하기 - 센터명같은 리뷰 찾아서 가져오기
        val reviews = ArrayList<DataReview>()
        reviews.add(DataReview("사용자이름1", "리뷰내용", "센터"))
        reviews.add(DataReview("사용자이름2", "리뷰내용", "센터"))
        reviews.add(DataReview("사용자이름3", "리뷰내용", "센터"))

        val adapter = RevAdapter(reviews)
        recyclerView.adapter = adapter
    }

    private fun setDataLayout() {
        //인텐트로 DataWheelchair객체 넘김
        //val data = intent.getSerializableExtra("center") as DataCenter

        val manager = DataManager()
        Thread.sleep(3000L)
        val data = manager.center[0]

        binding.apply {
            TitleView.text = data.tfcwkerMvmnCnterNm
            AddrView.text = data.rdnmadr
            PhoneView.text = data.phoneNumber
            trgetView.text = data.useTrget
            chargeView.text = data.useCharge

            var rtime = "평   일 "+data.weekdayRceptOpenHhmm+" ~ "+data.weekdayRceptColseHhmm+"\n"
            rtime+="주  말 "+data.wkendRceptOpenHhmm+" ~ "+data.wkendRceptCloseHhmm
            rcepttimeView.text = rtime

            var timestr = "평  일 "+data.weekdayOperOpenHhmm+" ~ "+data.weekdayOperColseHhmm+"\n"
            timestr+="주  말 "+data.wkendOperOpenHhmm+" ~ "+data.wkendOperCloseHhmm
            timeView.text = timestr

            var areastr = "관내 " +data.outsideOpratArea+"\n관외 "+data.insideOpratArea
            areaView.text = areastr
        }

    }

}