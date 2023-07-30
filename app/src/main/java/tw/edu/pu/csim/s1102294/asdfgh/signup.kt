package tw.edu.pu.csim.s1102294.asdfgh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import java.time.Instant


class signup : AppCompatActivity() {

    lateinit var txv2: TextView
    lateinit var editTextEmailUp: EditText
    lateinit var editTextPasswordUp: EditText
    lateinit var editTextPasswordUpC: EditText
    lateinit var btnUp: Button
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var txv4:TextView

    private val errorTranslations = mapOf(
        "The email address is badly formatted." to "Email格式不正確",
        "The given password is invalid. [ Password should be at least 6 characters ]" to "密碼無效（密碼應至少為6個字符）",
        "The email address is already in use by another account." to "該電子郵件地址已被使用",
        "The given password is too weak." to "密碼太弱"
        // 可根據需要添加其他錯誤消息的翻譯
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val userUid = intent.getStringExtra("userUid")
        txv4 = findViewById(R.id.txv4)
        txv2 = findViewById(R.id.txv2)
        txv2.setOnClickListener {
            val intent6 = Intent(this, MainActivity::class.java)
            if (userUid != null) {
                intent6.putExtra("userUid", userUid)
            }
            startActivity(intent6)
            finish()
        }


        editTextEmailUp = findViewById(R.id.editTextEmailUp)
        editTextPasswordUp = findViewById(R.id.editTextPasswordUp)
        editTextPasswordUpC = findViewById(R.id.editTextPasswordUpC)
        btnUp = findViewById(R.id.btnUp)

        // 初始化 Firebase 身分驗證
        firebaseAuth = FirebaseAuth.getInstance()

        btnUp.setOnClickListener {
            val email = editTextEmailUp.text.toString().trim()
            val password = editTextPasswordUp.text.toString().trim()
            val confirmPassword = editTextPasswordUpC.text.toString().trim()

            if (validateInputs(email, password, confirmPassword)){
                registerUser(email, password)
            }
        }

    }

    private fun validateInputs(email: String, password: String, confirmPassword: String): Boolean {
        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "請輸入帳號和密碼", Toast.LENGTH_SHORT).show()
            return false
        }

        if (password != confirmPassword) {
            Toast.makeText(this, "密碼和確認密碼不相符", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun registerUser(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "註冊成功！請登入帳號", Toast.LENGTH_SHORT).show()
                    clearUserAuthState() // 清除用戶驗證狀態
                    // 執行註冊成功後的相應操作，例如導航到登入畫面
                    navigateToLoginScreen()
                } else {
                    val errorMessage = task.exception?.message
                    val translatedError = errorTranslations[errorMessage]
                    val displayMessage = translatedError ?: "註冊失敗：$errorMessage"
                    Toast.makeText(this, displayMessage, Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun clearUserAuthState() {
        firebaseAuth.signOut()
    }

    private fun navigateToLoginScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}