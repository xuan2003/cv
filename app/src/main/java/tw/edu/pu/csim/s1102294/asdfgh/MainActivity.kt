package tw.edu.pu.csim.s1102294.asdfgh

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        // 檢查使用者是否已登入，如果是，則導航到主畫面
        val currentUser = auth.currentUser
        if (currentUser != null) {
            navigateToHomeScreen(currentUser.uid)
        } else {
            navigateToLogin()
        }

    }

    private fun navigateToHomeScreen(userUid: String) {
        val intent = Intent(this, home::class.java)
        intent.putExtra("userUid", userUid)
        startActivity(intent)
        finish()
    }

    private fun navigateToLogin() {
        val intent = Intent(this, login::class.java)
        startActivity(intent)
        finish()
    }
}