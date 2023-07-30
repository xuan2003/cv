package tw.edu.pu.csim.s1102294.asdfgh

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class interduce : AppCompatActivity() {
    lateinit var title1: TextView
    lateinit var txv1: TextView
    lateinit var txvlink:TextView
    lateinit var btnhome: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interduce)

        title1 = findViewById(R.id.title1)
        txv1 = findViewById(R.id.txv1)
        txvlink = findViewById(R.id.txvlink)
        btnhome = findViewById(R.id.btnhome)

        txv1.setMovementMethod(ScrollingMovementMethod.getInstance()) //卷軸啟用
        title1.text = "配音演員 CV\n"
        txv1.text = "配音演員是指為影片配上對白的人，其不同於舞臺演員和電影演員。\n他們從聲音上來再現原片（劇）中人物的形象，以聲音作為其表演手段。\n他們在配音前必須對原片的故事、藝術樣式、風格、時代背景等作充分的分析，然後擬定出自己對某一角色的配音方案，也稱之為聲音化妝。除了翻譯影片（包括外國語翻譯和普通話、粵語、方言、少數民族語言之間的互相翻譯）需配音演員配錄臺詞外，在有的影片裡，如果演員嗓音不好、語言不標準或不符合角色性格的要求，都不採用他們本人的聲音，而是在後期錄音時請配音演員為影片配音，現今大多數的配音員都指是廣義上的配音員，配音員的工作種類已經趨向多元化，而非僅限為人物配音。\n其中配音演員分為職業配音演員和非職業配音演員兩種。"
        txvlink.setText("擷取自維基百科：https://zh.wikipedia.org/zh-tw/%E9%85%8D%E9%9F%B3%E5%93%A1")

    }

    fun home(view: View)
    {
        swaphome()
    }

    fun swaphome()
    {
        val intent = Intent(this, home::class.java )
        startActivity(intent)
    }
}