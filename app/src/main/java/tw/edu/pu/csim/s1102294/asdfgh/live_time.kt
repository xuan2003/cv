package tw.edu.pu.csim.s1102294.asdfgh

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import java.util.*

class live_time : AppCompatActivity() {

    lateinit var btntime:Button
    lateinit var txvtimeshow:TextView
    lateinit var btnadd:Button
    lateinit var btnback:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_time)

        val userUid = FirebaseAuth.getInstance().currentUser?.uid // 取得使用者 UID

        val items = listOf("星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日")


        val spinner: Spinner = findViewById(R.id.spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        btntime = findViewById(R.id.btntime)
        btntime.setOnClickListener {
            showTimePickerDialog()
        }
        txvtimeshow = findViewById(R.id.txvtimeshow)
        btnadd = findViewById(R.id.btnadd)

        val name: TextInputEditText = findViewById(R.id.name)
        val live: TextInputEditText = findViewById(R.id.live)
        val db = FirebaseFirestore.getInstance()
        val id = FirebaseAuth.getInstance().currentUser?.uid // 取得使用者 UID


        btnadd.setOnClickListener {
            // 確保使用者已經登入，再執行下列動作
            if (id != null) {
                val user = hashMapOf(
                    "主播名稱" to name.text.toString(),
                    "直播平台" to live.text.toString(),
                    "直播時間" to spinner.selectedItem.toString() + " " + txvtimeshow.text
                )
                db.collection(id) // 將 "user" 改為 "users" 來避免和 "user" 預設的使用者集合名稱混淆
                    .document(name.text.toString()) // 使用使用者 UID 作為文件 ID
                    .set(user)
                    .addOnSuccessListener {
                        Toast.makeText(this, "新增/異動資料成功", Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener { e ->
                        Toast.makeText(this, "新增/異動資料失敗：" + e.toString(), Toast.LENGTH_LONG).show()
                    }
            }
        }

        btnback = findViewById(R.id.btnback)
        btnback.setOnClickListener {
            val intent1 = Intent(this, home::class.java)
            if(userUid != null) {
                intent1.putExtra("userUid", userUid)
            }
            startActivity(intent1)
            finish()
        }
    }
    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { _, selectedHour, selectedMinute ->
            // 在TextView中顯示選擇的時間
            txvtimeshow.text = String.format("%02d:%02d", selectedHour, selectedMinute)
        }, hour, minute, true)

        timePickerDialog.show()
    }
}