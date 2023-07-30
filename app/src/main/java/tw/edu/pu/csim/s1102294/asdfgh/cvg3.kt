package tw.edu.pu.csim.s1102294.asdfgh

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView

class cvg3 : AppCompatActivity(), GestureDetector.OnGestureListener , View.OnTouchListener {
    lateinit var gDetector: GestureDetector
    lateinit var webView: WebView
    lateinit var txvc: TextView
    lateinit var txvtitle: TextView
    lateinit var txvt1: TextView
    lateinit var play: Button
    lateinit var stop: Button
    lateinit var txvt2: TextView
    lateinit var play2: Button
    lateinit var stop2: Button
    private var count: Int = 1
    var mper = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cvg3)


        gDetector = GestureDetector(this, this)
        webView = findViewById(R.id.webView)
        txvc = findViewById(R.id.txvc)
        txvtitle = findViewById(R.id.txvtitle1)
        txvt1 = findViewById(R.id.txvt1)
        play = findViewById(R.id.play)
        play.setOnClickListener {
            mper.reset()
            mper = MediaPlayer.create(this, R.raw.s7)
            mper.start()
        }
        stop = findViewById(R.id.stop)
        stop.setOnClickListener {
            mper.stop()
        }
        txvt2 = findViewById(R.id.txvt2)
        play2 = findViewById(R.id.play2)
        play2.setOnClickListener {
            mper.reset()
            mper = MediaPlayer.create(this, R.raw.s6)
            mper.start()
        }
        stop2 = findViewById(R.id.stop2)
        stop2.setOnClickListener {
            mper.stop()
        }

        //val webView: WebView = findViewById(R.id.webView)

        // 启用 JavaScript 支持
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // 设置 WebChromeClient，以支持 JavaScript 的弹出窗口等特性
        webView.webChromeClient = WebChromeClient()

        // 加载 YouTube 视频的嵌入式 HTML 代码
        val htmlCode = "<iframe width=\"300\" height=\"200\" src=\"https://www.youtube.com/embed/jXTo3G7_310\" title=\"八重神子角色預告—「狐之所愛」｜原神\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
        webView.loadData(htmlCode, "text/html", "utf-8")

        webView.visibility = View.INVISIBLE     //View.VISIBLE顯示，INVISIBLE隱藏
        txvt1.visibility = View.INVISIBLE
        play.visibility = View.INVISIBLE
        stop.visibility = View.INVISIBLE
        txvtitle.text = "\n杜冥鴉\n"
        txvc.text = "中國內地的女性配音演員，響天外配音演員，網絡配音導演、策劃，推金幣愛好者，投籃機小能手，烤魚火鍋推崇分子，標準天蠍座。2005年進入網配圈，聲線多變，音色清冷。\n\n代表作：凝光、八重神子《原神》、安娜·貝爾《諾亞幻想》、八重櫻《崩壞3》、林厭《我親愛的法醫小姐、楚非宸《純屬意外》。\n\n\n\n   < --------左右滑進入聲展-------- >"
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        gDetector.onTouchEvent(event)
        return true
    }

    override fun onDown(p0: MotionEvent): Boolean {
        return true
    }

    override fun onShowPress(p0: MotionEvent) {
    }

    override fun onSingleTapUp(p0: MotionEvent): Boolean {

        return true
    }

    override fun onScroll(e1: MotionEvent, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
        return true
    }

    override fun onLongPress(p0: MotionEvent) {

    }

    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        if (e1.x <= e2.x){
            count++
            if(count > 2) {
                count = 1
            }
        }
        else{
            count--
            if(count < 1) {
                count = 2
            }
        }
        var res:Int = getResources().getIdentifier("cv" + count.toString(),
            "drawable", getPackageName())
        if (count == 1){
            txvtitle.text = "\n杜冥鴉\n"
            txvc.text = "中國內地的女性配音演員，響天外配音演員，網絡配音導演、策劃，推金幣愛好者，投籃機小能手，烤魚火鍋推崇分子，標準天蠍座。2005年進入網配圈，聲線多變，音色清冷。\n\n代表作：凝光、八重神子《原神》、安娜·貝爾《諾亞幻想》、八重櫻《崩壞3》、林厭《我親愛的法醫小姐、楚非宸《純屬意外》。\n\n\n\n   < --------左右滑進入聲展-------- >"
            webView.visibility = View.INVISIBLE
            txvt1.visibility = View.INVISIBLE
            play.visibility = View.INVISIBLE
            stop.visibility = View.INVISIBLE
            txvt2.visibility = View.INVISIBLE
            play2.visibility = View.INVISIBLE
            stop2.visibility = View.INVISIBLE
        } else {
            txvtitle.text = "\n聲音展示"
            txvc.text = ""
            webView.visibility = View.VISIBLE
            txvt1.visibility = View.VISIBLE
            play.visibility = View.VISIBLE
            stop.visibility = View.VISIBLE
            txvt2.visibility = View.VISIBLE
            play2.visibility = View.VISIBLE
            stop2.visibility = View.VISIBLE
            txvt1.text = "廣播劇聲展\n"
            txvt2.text = "《你是人間四月天》林徽因-杜冥鴉"
        }
        return true
    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }
}