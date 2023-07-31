package tw.edu.pu.csim.s1102294.asdfgh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

class home : AppCompatActivity() {

    lateinit var btninterduce: Button
    lateinit var btnstudio: Button
    lateinit var btncv: Button
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var btnlive:Button
    lateinit var btnquery:Button
    lateinit var name:TextInputEditText
    lateinit var textView2:TextView
    lateinit var btndelete:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val userUid = intent.getStringExtra("userUid")
        val db = FirebaseFirestore.getInstance()
        name = findViewById(R.id.name)
        textView2 = findViewById(R.id.textView2)
        textView2.setMovementMethod(ScrollingMovementMethod.getInstance())

        val id = FirebaseAuth.getInstance().currentUser?.uid // 取得使用者 UID

        btnquery = findViewById(R.id.btnquery)
        btnquery.setOnClickListener {
            if (id != null) {
                val query = if (name.text.isNullOrEmpty()) {
                    db.collection(id)
                } else {
                    db.collection(id)
                        .whereEqualTo("主播名稱", name.text.toString())
                }

                query.get()
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            var msg: String = ""
                            for (document in task.result!!) {
                                msg += "主播名稱：" + document.data["主播名稱"] +
                                        "\n直播平台：" + document.data["直播平台"].toString() +
                                        "\n直播時間：" + document.data["直播時間"].toString() + "\n\n"
                            }
                            if (msg.isNotEmpty()) {
                                textView2.text = msg
                            } else {
                                textView2.text = "查無資料"
                            }
                        }
                    }
            }
        }

        btndelete = findViewById(R.id.btndelete)
        btndelete.setOnClickListener {
            if (id != null) {
                db.collection(id)
                    .document(name.text.toString())
                    .delete()
            }
            Toast.makeText(this, "刪除資料", Toast.LENGTH_LONG).show()

        }

        btninterduce = findViewById(R.id.btninterduce)
        btninterduce.setOnClickListener {
            val intent1 = Intent(this, interduce::class.java)
            if (userUid != null) {
                intent1.putExtra("userUid", userUid)
            }
            startActivity(intent1)
            finish()
        }

        btnstudio = findViewById(R.id.btnstudio)
        btnstudio.setOnClickListener {
            val intent2 = Intent(this, studio::class.java )
            if(userUid != null) {
                intent2.putExtra("userUid", userUid)
            }
            startActivity(intent2)
            finish()
        }

        btncv = findViewById(R.id.btncv)
        btncv.setOnClickListener {
            val intent3 = Intent(this, cv_first::class.java)
            if(userUid != null) {
                intent3.putExtra("userUid", userUid)
            }
            startActivity(intent3)
            finish()
        }

        btnlive = findViewById(R.id.btnlive)
        btnlive.setOnClickListener {
            val intent4 = Intent(this, live_time::class.java)
            if(userUid != null) {
                intent4.putExtra("userUid", userUid)
            }
            startActivity(intent4)
            finish()
        }

        lateinit var btnloginout: Button

        btnloginout = findViewById(R.id.btnloginout)
        btnloginout.setOnClickListener {
            logoutUser()
        }

        // 初始化 FirebaseAuth 實例
        firebaseAuth = FirebaseAuth.getInstance()
    }

    private fun logoutUser() {
        // 使用 Firebase 身分驗證進行登出
        firebaseAuth.signOut()
        // 清除使用者登入狀態
        setUserLoggedInState(false)
        // 轉到 Login
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun setUserLoggedInState(loggedIn: Boolean) {
        // 假設 UserPreferences 是一個自定義的類，用於處理使用者登入狀態等偏好設置
        // 此處為示意，請自行定義 UserPreferences 類
        //val userPreferences = UserPreferences(this)
        //userPreferences.userLoggedIn = loggedIn
    }
}