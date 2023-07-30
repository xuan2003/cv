package tw.edu.pu.csim.s1102294.asdfgh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class cvb : AppCompatActivity() {

    lateinit var btncvb1: Button
    lateinit var btncvb2: Button
    lateinit var btncvb3: Button
    lateinit var btncvb4: Button
    lateinit var btncvb5: Button
    lateinit var btncvb6: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cvb)

        val userUid = intent.getStringExtra("userUid")

        btncvb1 = findViewById(R.id.btncvb1)
        btncvb2 = findViewById(R.id.btncvb2)
        btncvb2.setOnClickListener {
            val intent2 = Intent(this, cvb2::class.java)
            if (userUid != null) {
                intent2.putExtra("userUid", userUid)
            }
            startActivity(intent2)
            finish()
        }
        btncvb3 = findViewById(R.id.btncvb3)
        btncvb3.setOnClickListener {
            val intent3 = Intent(this, cvb3::class.java)
            if (userUid != null) {
                intent3.putExtra("userUid", userUid)
            }
            startActivity(intent3)
            finish()
        }
        btncvb4 = findViewById(R.id.btncvb4)
        btncvb4.setOnClickListener {
            val intent4 = Intent(this, cvb4::class.java)
            if (userUid != null) {
                intent4.putExtra("userUid", userUid)
            }
            startActivity(intent4)
            finish()
        }
        btncvb5 = findViewById(R.id.btncvb5)
        btncvb5.setOnClickListener {
            val intent5 = Intent(this, cvb5::class.java)
            if (userUid != null) {
                intent5.putExtra("userUid", userUid)
            }
            startActivity(intent5)
            finish()
        }
        btncvb6 = findViewById(R.id.btncvb6)
        btncvb6.setOnClickListener {
            val intent6 = Intent(this, cvb6::class.java)
            if (userUid != null) {
                intent6.putExtra("userUid", userUid)
            }
            startActivity(intent6)
            finish()
        }
    }

    fun cvb1(view: View) {
        swapcvb1()
    }

    fun swapcvb1() {
        val intent = Intent(this, cvb1::class.java)
        startActivity(intent)
    }
}