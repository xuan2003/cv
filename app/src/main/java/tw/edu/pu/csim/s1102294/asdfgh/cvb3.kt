package tw.edu.pu.csim.s1102294.asdfgh

import android.content.Context
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

class cvb3 : AppCompatActivity(), GestureDetector.OnGestureListener , View.OnTouchListener {
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
        setContentView(R.layout.activity_cvb3)


        gDetector = GestureDetector(this, this)
        webView = findViewById(R.id.webView)
        txvc = findViewById(R.id.txvc)
        txvtitle = findViewById(R.id.txvtitle1)
        txvt1 = findViewById(R.id.txvt1)
        play = findViewById(R.id.play)
        play.setOnClickListener {
            mper.reset()
            mper = MediaPlayer.create(this, R.raw.ai)
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
        val htmlCode = "<iframe width=\"300\" height=\"200\" src=\"https://www.youtube.com/embed/5_NgSmin6po\" title=\"預告短片——「諸苦無隙」｜原神\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
        webView.loadData(htmlCode, "text/html", "utf-8")

        webView.visibility = View.INVISIBLE     //View.VISIBLE顯示，INVISIBLE隱藏
        txvt1.visibility = View.INVISIBLE
        play.visibility = View.INVISIBLE
        stop.visibility = View.INVISIBLE
        txvtitle.text = "\nKinsen\n"
        txvc.text = "中國內地的男性配音演員，奇響天外配音工作室成員，日語配音社朧夜月成員，中文網絡配音社團月聲成員。代表作有《原神》重雲、魈，《食物語》熱乾麵、鬼火綠，《戰雙帕彌什》常羽，《幻書啟世錄》楚辭·陸離、Microsoft Azure AI-云希等。\n" +
                "VirtueSINs原創音樂組成員。\n\n\n\n   < --------左右滑進入聲展-------- >"
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
            txvtitle.text = "\nKinsen\n"
            txvc.text = "中國內地的男性配音演員，奇響天外配音工作室成員，日語配音社朧夜月成員，中文網絡配音社團月聲成員。代表作有《原神》重雲、魈，《食物語》熱乾麵、鬼火綠，《戰雙帕彌什》常羽，《幻書啟世錄》楚辭·陸離、Microsoft Azure AI-云希等。\n" +
                    "VirtueSINs原創音樂組成員。\n\n\n\n   < --------左右滑進入聲展-------- >"
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
            txvt1.text = "Microsoft Azure AI-云希\n"
        }
        return true
    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }
}