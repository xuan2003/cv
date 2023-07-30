package tw.edu.pu.csim.s1102294.asdfgh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class cvg : AppCompatActivity() {

    lateinit var btncvg1:Button
    lateinit var btncvg2:Button
    lateinit var btncvg3:Button
    lateinit var btncvg4:Button
    lateinit var btncvg5:Button
    lateinit var btncvg6:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cvg)


        val userUid = intent.getStringExtra("userUid")

        btncvg1 = findViewById(R.id.btncvg1)
        btncvg1.setOnClickListener {
            val intent1 = Intent(this, cvg1::class.java)
            if (userUid != null) {
                intent1.putExtra("userUid", userUid)
            }
            startActivity(intent1)
            finish()
        }
        btncvg2 = findViewById(R.id.btncvg2)
        btncvg2.setOnClickListener {
            val intent2 = Intent(this, cvg2::class.java)
            if (userUid != null) {
                intent2.putExtra("userUid", userUid)
            }
            startActivity(intent2)
            finish()
        }
        btncvg3 = findViewById(R.id.btncvg3)
        btncvg3.setOnClickListener {
            val intent3 = Intent(this, cvg3::class.java)
            if (userUid != null) {
                intent3.putExtra("userUid", userUid)
            }
            startActivity(intent3)
            finish()
        }

        btncvg4 = findViewById(R.id.btncvg4)
        btncvg4.setOnClickListener {
            val intent4 = Intent(this, cvg4::class.java)
            if (userUid != null) {
                intent4.putExtra("userUid", userUid)
            }
            startActivity(intent4)
            finish()
        }

        btncvg5 = findViewById(R.id.btncvg5)
        btncvg5.setOnClickListener {
            val intent5 = Intent(this, cvg5::class.java)
            if (userUid != null) {
                intent5.putExtra("userUid", userUid)
            }
            startActivity(intent5)
            finish()
        }

        btncvg6 = findViewById(R.id.btncvg6)
        btncvg6.setOnClickListener {
            val intent6 = Intent(this, cvg6::class.java)
            if (userUid != null) {
                intent6.putExtra("userUid", userUid)
            }
            startActivity(intent6)
            finish()
        }
    }
}