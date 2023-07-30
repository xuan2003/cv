package tw.edu.pu.csim.s1102294.asdfgh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class cv_first : AppCompatActivity() {

    lateinit var btnboy: Button
    lateinit var btngirl: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cv_first)


        btnboy = findViewById(R.id.btnboy)
        btngirl = findViewById(R.id.btngirl)
    }

    fun cB(view: View) {
        swapboy()
    }

    fun swapboy() {
        var intent = Intent(this, cvb::class.java )
        startActivity(intent)
    }

    fun cG(view: View) {
        swapgirl()
    }

    fun swapgirl() {
        var intent = Intent(this, cvg::class.java )
        startActivity(intent)
    }
}