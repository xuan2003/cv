package tw.edu.pu.csim.s1102294.asdfgh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.TextView

class cvg2 : AppCompatActivity(), GestureDetector.OnGestureListener , View.OnTouchListener {
    lateinit var gDetector: GestureDetector
    lateinit var webView: WebView
    lateinit var webView2: WebView
    lateinit var txvc: TextView
    lateinit var txvtitle: TextView
    private var count: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cvg2)


        gDetector = GestureDetector(this, this)
        webView = findViewById(R.id.webView)
        webView2 = findViewById(R.id.webView2)
        txvc = findViewById(R.id.txvc)
        txvtitle = findViewById(R.id.txvtitle1)

        //val webView: WebView = findViewById(R.id.webView)

        // 启用 JavaScript 支持
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // 设置 WebChromeClient，以支持 JavaScript 的弹出窗口等特性
        webView.webChromeClient = WebChromeClient()

        // 加载 YouTube 视频的嵌入式 HTML 代码
        val htmlCode1 = "<iframe width=\"300\" height=\"200\" src=\"https://www.youtube.com/embed/9hc9i4sNUq8\" title=\"角色展示-「納西妲：無垠無憂」｜原神\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
        webView.loadData(htmlCode1, "text/html", "utf-8")


        val webSettings2: WebSettings = webView2.settings
        webSettings2.javaScriptEnabled = true

        webView2.webChromeClient = WebChromeClient()

        val htmlCode2 = "<iframe width=\"300\" height=\"200\" src=\"https://www.youtube.com/embed/MkSiBUWzMDE\" title=\"《原神》可莉角色PV-「太阳逃跑的夜晚」\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
        webView2.loadData(htmlCode2, "text/html", "utf-8")

        webView.visibility = View.INVISIBLE     //View.VISIBLE顯示，INVISIBLE隱藏
        webView2.visibility = View.INVISIBLE
        txvtitle.text = "\n花玲\n"
        txvc.text = "本名林敏，藝名花玲，中國大陸的配音演員、歌手，奇響天外成員。音線多為蘿莉音或少女音。\n\n代表作：《碧藍航線》長春、《崩壞3》《崩壞學園2》德麗莎，《英雄聯盟》佐伊、《工作細胞》血小板、《戰雙帕彌什》卡列尼娜、《原神》可莉、納西妲、《霧境序列》克萊奧、《崩壞：星穹鐵道》符玄等。\n\n\n\n    < --------左右滑進入聲展-------- >"
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
            txvtitle.text = "\n花玲\n"
            txvc.text = "本名林敏，藝名花玲，中國大陸的配音演員、歌手，奇響天外成員。音線多為蘿莉音或少女音。\n" +
                    "\n" +
                    "代表作：《碧藍航線》長春、《崩壞3》《崩壞學園2》德麗莎，《英雄聯盟》佐伊、《工作細胞》血小板、《戰雙帕彌什》卡列尼娜、《原神》可莉、納西妲、《霧境序列》克萊奧、《崩壞：星穹鐵道》符玄等。\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "    < --------左右滑進入聲展-------- >"
            webView.visibility = View.INVISIBLE
            webView2.visibility = View.INVISIBLE
        } else{
            txvtitle.text = "\n聲音展示"
            txvc.text = ""
            webView.visibility = View.VISIBLE
            webView2.visibility = View.VISIBLE
        }
        return true
    }

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }
}