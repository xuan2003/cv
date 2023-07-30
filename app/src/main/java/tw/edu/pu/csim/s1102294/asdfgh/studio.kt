package tw.edu.pu.csim.s1102294.asdfgh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class studio : AppCompatActivity() {

    lateinit var txvstudio1: TextView
    lateinit var txvstudio2: TextView
    lateinit var txvlink1: TextView
    lateinit var txvlink2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_studio)

        txvstudio1 = findViewById(R.id.txvstudio1)
        txvstudio2 = findViewById(R.id.txvstudio2)
        txvlink1 = findViewById(R.id.txvlink1)
        txvlink2 = findViewById(R.id.txvlink2)

        txvstudio1.text = "奇響天外文化傳播有限公司位於上海，註冊於2016年1月，秉承「傳遞聲音的力量」這一理念。\n目前已完成《唐山葬》《崩壞3》《原神》《諾亞幻想》《無限世界》等多部遊戲、有聲漫畫及動漫的配音。"
        txvlink1.setText("本文引自萌娘百科：https://zh.moegirl.org.cn/zh-tw/%E5%A5%87%E5%93%8D%E5%A4%A9%E5%A4%96")

        txvstudio2.text = "海天工作室於2019年初建立，業務範圍包括遊戲、動畫、譯製片等領域。核心理念：悅於耳·銘於心。\n創始人為原勝利之音工作室創始人洪海天，核心成員秦紫翼，馬洋，熊風等。"
        txvlink2.setText("本文引自萌娘百科：https://zh.moegirl.org.cn/%E6%B5%B7%E5%A4%A9%E5%B7%A5%E4%BD%9C%E5%AE%A4")
    }
    fun home1(view: View)
    {
        swaphome()
    }
    fun swaphome()
    {
        val intent = Intent(this, home::class.java )
        startActivity(intent)
    }
}