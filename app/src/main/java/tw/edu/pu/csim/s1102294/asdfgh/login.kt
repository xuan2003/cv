package tw.edu.pu.csim.s1102294.asdfgh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class login : AppCompatActivity() {

    lateinit var txv2: TextView


    lateinit var editTextEmail: EditText


    lateinit var editTextPassword: EditText


    lateinit var btnIn: Button


    lateinit var firebaseAuth: FirebaseAuth




    private val errorTranslations = mapOf(


        "The email address is badly formatted." to "Email格式不正確",


        "The password is invalid or the user does not have a password." to "密碼錯誤",


        "There is no user record corresponding to this identifier. The user may have been deleted." to "此帳號尚未註冊，請進行註冊"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        txv2 = findViewById(R.id.txv2)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        btnIn = findViewById(R.id.btnIn)

        // 初始化 FirebaseAuth 實例
        firebaseAuth = FirebaseAuth.getInstance()

        // 設置登入按鈕的點擊事件
        btnIn.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                // 呼叫登入方法
                signInUser(email, password)
            } else {
                Toast.makeText(this, "請輸入有效的帳號密碼", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signInUser(email: String, password: String) {
        // 使用 FirebaseAuth 進行登入
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // 登入成功，獲取當前使用者
                    val user = firebaseAuth.currentUser
                    if (user != null) {
                        // 登入成功後的處理，例如跳轉到下一個活動
                        Toast.makeText(this, "登入成功，歡迎 ${user.email}", Toast.LENGTH_SHORT).show()

                        // 舉例: 跳轉到另一個活動
                        val intent = Intent(this, home::class.java)
                        startActivity(intent)
                    }
                } else {
                    // 登入失敗，顯示錯誤訊息
                    val errorMessage = task.exception?.message
                    val translatedError = errorTranslations[errorMessage]
                    val errorMsg = translatedError ?: "登入失敗: $errorMessage"
                    Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
                }
            }
    }
}