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

class cvg4 : AppCompatActivity(), GestureDetector.OnGestureListener , View.OnTouchListener {
    lateinit var gDetector: GestureDetector
    lateinit var webView: WebView
    lateinit var txvc: TextView
    lateinit var txvtitle: TextView
    lateinit var txvt1: TextView
    lateinit var play: Button
    lateinit var stop: Button
    private var count: Int = 1
    var mper = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cvg4)


        gDetector = GestureDetector(this, this)
        webView = findViewById(R.id.webView)
        txvc = findViewById(R.id.txvc)
        txvtitle = findViewById(R.id.txvtitle1)
        txvt1 = findViewById(R.id.txvt1)
        play = findViewById(R.id.play)
        play.setOnClickListener {
            mper.reset()
            mper = MediaPlayer.create(this, R.raw.s8)
            mper.start()
        }
        stop = findViewById(R.id.stop)
        stop.setOnClickListener {
            mper.stop()
        }

        //val webView: WebView = findViewById(R.id.webView)

        // 启用 JavaScript 支持
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // 设置 WebChromeClient，以支持 JavaScript 的弹出窗口等特性
        webView.webChromeClient = WebChromeClient()

        // 加载 YouTube 视频的嵌入式 HTML 代码
        val htmlCode = "<iframe width=\"300\" height=\"200\" src=\"https://www.youtube.com/embed/9HcXakmKusw\" title=\"申鶴角色預告——「孤辰新夢」｜原神\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
        webView.loadData(htmlCode, "text/html", "utf-8")

        webView.visibility = View.INVISIBLE     //View.VISIBLE顯示，INVISIBLE隱藏
        txvt1.visibility = View.INVISIBLE
        play.visibility = View.INVISIBLE
        stop.visibility = View.INVISIBLE
        txvtitle.text = "\n秦紫翼\n"
        txvc.text = "中國內地的女性配音演員、配音導演，海天工作室配音演员，別名：子楚。\n\n代表作有游戏《英雄联盟》虚空之女、《王者荣耀》虞姬、《原神》申鹤/留云借风真君、《余情可待》季侑言等。\n\n\n\n   < --------左右滑進入聲展-------- >"
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
            txvtitle.text = "\n秦紫翼\n"
            txvc.text = "中國內地的女性配音演員、配音導演，海天工作室配音演员。\n\n代表作有游戏《英雄联盟》虚空之女、《王者荣耀》虞姬、《原神》申鹤/留云借风真君、《余情可待》季侑言等。\n\n\n\n   < --------左右滑進入聲展-------- >"
            webView.visibility = View.INVISIBLE
            txvt1.visibility = View.INVISIBLE
            play.visibility = View.INVISIBLE
            stop.visibility = View.INVISIBLE
        } else {
            txvtitle.text = "\n聲音展示"
            txvc.text = ""
            webView.visibility = View.VISIBLE
            txvt1.visibility = View.VISIBLE
            play.visibility = View.VISIBLE
            stop.visibility = View.VISIBLE
            txvt1.text = "子楚版《过往，皆为序章》-秦紫翼\n"
        }
        return true
    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }
}