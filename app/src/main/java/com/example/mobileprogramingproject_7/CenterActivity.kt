package com.example.mobileprogramingproject_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileprogramingproject_7.databinding.ActivityCenterBinding
import com.example.mobileprogramingproject_7.databinding.ActivityWheelchairBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CenterActivity : AppCompatActivity() {
    lateinit var binding : ActivityCenterBinding
    lateinit var centerName : String

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

            rvplusBtn.setOnClickListener {
                val intent = Intent(applicationContext, ReviewPopupActivity::class.java)
                intent.putExtra("centerName", centerName)
                intent.putExtra("centerType", "Center")
                startActivity(intent)
            }
        }
    }

    private fun setRecyclerView() {
        //리뷰 Data Class 가져와서 리사이클러뷰 초기화해야함
        val recyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val reviews = ArrayList<DataReview>()

        val db = Firebase.firestore
        db.collection("Centers")
            .document(centerName)
            .collection("userID")
            .whereEqualTo("centerType", "Center")
            .get()
            .addOnSuccessListener {
                for(document in it){
                    val id = document.id
                    val rv = document.getString("reviewString")!!
                    reviews.add(DataReview(UserInfo.userID,rv,id))
                }
            }
            .addOnFailureListener {
                it.printStackTrace()

            }

        val adapter = RevAdapter(reviews)
        recyclerView.adapter = adapter
    }

    private fun setDataLayout() {
        //인텐트로 DataWheelchair객체 넘김
        //val data = intent.getSerializableExtra("center") as DataCenter

        val manager = DataManager()
        Thread.sleep(5000L)
        val data = manager.center[0]

        centerName = data.tfcwkerMvmnCnterNm

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