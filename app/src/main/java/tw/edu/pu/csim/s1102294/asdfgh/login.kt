package tw.edu.pu.csim.s1102294.asdfgh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

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
        val userUid = intent.getStringExtra("userUid")
        txv2 = findViewById(R.id.txv2)
        txv2.setOnClickListener {
            val intent6 = Intent(this, signup::class.java)
            if (userUid != null) {
                intent6.putExtra("userUid", userUid)
            }
            startActivity(intent6)
            finish()
        }

        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        btnIn = findViewById(R.id.btnIn)

        // Initialize FirebaseAuth instance
        firebaseAuth = FirebaseAuth.getInstance()

        // Set click listener for the login button
        btnIn.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Call the login method
                signInUser(email, password)
            } else {
                Toast.makeText(this, "請輸入有效的帳號密碼", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signInUser(email: String, password: String) {
        // Use FirebaseAuth for login
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Login successful, get the current user
                    val user = firebaseAuth.currentUser
                    if (user != null) {
                        // Handle successful login, e.g., navigate to the next activity
                        Toast.makeText(this, "登入成功，歡迎 ${user.email}", Toast.LENGTH_SHORT).show()

                        // Example: Navigate to another activity
                        val intent = Intent(this, home::class.java)
                        startActivity(intent)
                    }
                } else {
                    // Login failed, display error message
                    val errorMessage = task.exception?.message
                    val translatedError = errorTranslations[errorMessage]
                    val errorMsg = translatedError ?: "登入失敗: $errorMessage"
                    Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
                }
            }
    }
}