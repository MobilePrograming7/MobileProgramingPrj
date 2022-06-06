package com.example.mobileprogramingproject_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobileprogramingproject_7.UserInfo.db
import com.example.mobileprogramingproject_7.UserInfo.userID
import com.example.mobileprogramingproject_7.databinding.ActivityMainBinding
import com.example.mobileprogramingproject_7.databinding.ActivityWheelchairBinding
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class WheelchairActivity : AppCompatActivity() {
    lateinit var binding: ActivityWheelchairBinding
    lateinit var centerName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWheelchairBinding.inflate(layoutInflater)
        setContentView(binding.root)
        UserInfo.getListdata()
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
                intent.putExtra("centerType", "Wheelchair")
                startActivity(intent)
            }
        }
    }

    private fun setRecyclerView() {

        val recyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        val reviews = ArrayList<DataReview>()


        db.collection("Centers")
            .document(centerName)
            .collection("userID")
            .get()
            .addOnSuccessListener {
                for(document in it){
                    val uid = document.id
                    val rv = document.getString("reviewString")!!
                    reviews.add(DataReview(uid,rv,centerName))
                    Log.d("logger", "id: $uid, rv: $rv")
                }
                val adapter = RevAdapter(reviews)
                recyclerView.adapter = adapter
            }
            .addOnFailureListener {
                it.printStackTrace()
            }

    }


    private fun setDataLayout() {
        //인텐트로 DataWheelchair객체 넘김
//        val data = intent.getSerializableExtra("wheelchair") as DataWheelchair

        //테스트용객체
        val manager = DataManager()
        Thread.sleep(5000L)
        val data = manager.wheelchair[0]

        centerName = "Center1"


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