package com.example.mobileprogramingproject_7

import android.content.ContentValues
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.mobileprogramingproject_7.UserInfo.db
import com.example.mobileprogramingproject_7.UserInfo.userID
import com.example.mobileprogramingproject_7.databinding.ActivityReviewPopupBinding

class ReviewPopupActivity : AppCompatActivity() {
    lateinit var binding : ActivityReviewPopupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_popup)

        initLayout()

    }

    private fun initLayout() {
        val centerName = intent.getStringExtra("centerName")!!
        val centerType = intent.getStringExtra("centerType")!!
        db.collection("Centers").document(centerName)
            .collection("userID")
            .document(userID)
            .get()
            .addOnSuccessListener {
                if(it!=null){
                    binding.titleView.text = "리뷰 수정하기"
                    binding.reviewText.setText(it.getString("reviewString"))
                }
            }


        binding.apply {
            saveBtn.setOnClickListener {
                //db에 저장 or 수정
                if(reviewText.length()<1){
                    Toast.makeText(applicationContext,"리뷰는 한 글자 이상 작성해주세요", Toast.LENGTH_SHORT).show()
                }
                else{
                    val reviewStr = reviewText.text.toString()
                    val review = hashMapOf( //저장할 데이터 정의
                        "centerType" to centerType,
                        "reviewString" to reviewStr
                    )

                    //user DB에 저장
                    db.collection("Users").document(UserInfo.userID)
                        .collection("review")
                        .document(centerName)
                        .set(review)
                        .addOnSuccessListener {
                            Log.d("logger", "review saved to user DB")
                        }
                        .addOnFailureListener { e ->
                            Log.w("logger", "Error adding document", e)
                        }

                    db.collection("Centers").document(centerName)
                        .collection("userID")
                        .document(UserInfo.userID)
                        .set(review)
                        .addOnSuccessListener {
                            Log.d("logger", "review saved to center DB")
                        }
                        .addOnFailureListener { e ->
                            Log.w("logger", "Error adding document", e)
                        }

                    finish()
                }
            }
            cancelBtn.setOnClickListener {
                finish()
            }
        }
    }
}