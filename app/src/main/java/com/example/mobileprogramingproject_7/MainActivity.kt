package com.example.mobileprogramingproject_7

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mobileprogramingproject_7.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val dm: DataManager = DataManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Thread.sleep(3000L) //coroutine끝날때까지 3초 대기
    }
}







/* DB사용법 - https://firebase.google.com/docs/firestore/quickstart?hl=ko
val db = Firebase.firestore //종속돼있는 DB오픈
binding.apply {
    submitBtn.setOnClickListener {
        val user = hashMapOf( //저장할 데이터 정의
            "id" to userID.text.toString(),
            "pw" to userPW.text.toString()
        )
        db.collection("users").document(userID.text.toString()) //컬렉션에 데이터 추가
            .set(user)
            .addOnSuccessListener {
                Log.d(ContentValues.TAG, "DocumentSnapshot successfully written")
            }
            .addOnFailureListener { e ->
                Log.w(ContentValues.TAG, "Error adding document", e)
            }
    }
}
db.collection("users") //users컬렉션 데이터 가져오기
.get()
.addOnSuccessListener { result ->
    for (document in result) {
        Log.d(ContentValues.TAG, "${document.id} => ${document.data}")
    }
}
.addOnFailureListener { exception ->
    Log.w(ContentValues.TAG, "Error getting documents.", exception)
} */